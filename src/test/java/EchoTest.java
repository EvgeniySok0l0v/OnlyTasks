import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class EchoTest {

    private static final String URL = "https://postman-echo.com";
    private ResponseSpecification responseSpecification;
    @BeforeEach
    void setup() {
        RestAssured.baseURI = URL;
        responseSpecification = createBaseResponseSpec();
    }

    @Test
    void getTest() {
        String endPointName = "/get";

        given()
                .when()
                .get(endPointName)
                .then().log().body()
                .assertThat()
                .spec(responseSpecification);
    }

    @Test
    void postRawTextTest() {
        String endPointName = "/post";

        given()
                .log().body().contentType("text/plain")
                .body("{\n" +
                        "    \"test\": \"value\"\n" +
                        "}")
                .when()
                .post(endPointName)
                .then().log().body()
                .assertThat()
                .spec(responseSpecification)
                .and()
                .body("data", equalTo("{\n    \"test\": \"value\"\n}"))
                .body("files", notNullValue())
                .body("form", notNullValue())
                .body("json", equalTo(null));
    }

    @Test
    void postFormDataTest() {
        String endPointName = "/post";

        given()
                .contentType("application/x-www-form-urlencoded")
                .config(RestAssured.config().encoderConfig(
                        EncoderConfig.encoderConfig().defaultCharsetForContentType(
                                StandardCharsets.UTF_8, "application/x-www-form-urlencoded")
                ))
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post(endPointName)
                .then()
                .log().all()
                .assertThat()
                .spec(responseSpecification)
                .and()
                .body("data", equalTo(""))
                .body("files", notNullValue())
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"));
    }

    @Test
    void testRequestWithMethod() {
        performRequestWithMethod("PUT", "/put");
        performRequestWithMethod("PATCH", "/patch");
        performRequestWithMethod("DELETE", "/delete");
    }

    /**
     * Method for perform request with methods(PUT,PATCH,DELETE)
     *
     * @param method - method name
     * @param endPointName - endpoint name
     */
    private void performRequestWithMethod(String method, String endPointName) {
        ResponseSpecification localResponseSpec = createBaseResponseSpec();
        localResponseSpec = addUrl(endPointName, localResponseSpec);
        localResponseSpec = addBodyForPutPatchDelete(localResponseSpec);

        requestSpecificationForPutPatchDelete()
                .when()
                .request(method, endPointName)
                .then()
                .log().all()
                .assertThat()
                .spec(localResponseSpec);
    }

    /**
     * Method with return request specification
     * @return RequestSpecification
     */
    private RequestSpecification requestSpecificationForPutPatchDelete() {
        return given()
                .log().body().contentType("application/json")
                .body("This is expected to be sent back as part of response body.");
    }

    /**
     * Method for create base response specification
     * @return base ResponseSpecification
     */
    private ResponseSpecification createBaseResponseSpec() {
        return expect()
                .statusCode(HttpStatus.SC_OK)
                .body("args", notNullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.user-agent", notNullValue())
                .body("headers.accept", equalTo("*/*"));
    }

    /**
     * Method add url for specification
     *
     * @param name - endpoint name
     * @param responseSpecification - current response specification
     * @return updated ResponseSpecification
     */
    private ResponseSpecification addUrl(String name, ResponseSpecification responseSpecification) {
        return responseSpecification
                .body("url", equalTo(URL + name));
    }

    /**
     * Method add body for PUT,PATCH,DELETE methods in specification
     *
     * @param responseSpecification - current response specification
     * @return updated ResponseSpecification
     */
    private ResponseSpecification addBodyForPutPatchDelete(ResponseSpecification responseSpecification) {
        return responseSpecification
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
}
