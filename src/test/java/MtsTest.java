import com.google.common.base.Supplier;
import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class MtsTest {

    private WebDriver driver;
    private static final String URL = "https://www.mts.by";

    private final String baseDropDown = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button/span[2]";
    private final String selectedItem = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[";
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement cookieBut = driver.findElement(By.id("cookie-agree"));
        cookieBut.click();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    @Epic("Payments")
    @Feature("Payment Processing")
    @Story("Check Sum After Continue")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test checks if the sum after clicking continue is displayed correctly.")
    void checkSumAfterContinue(){
        enterPhoneNumber("297777777");
        enterSum("1");
        enterEmail("123@mail.ru");
        clickPayButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement frameElement = waitForFrame(wait);
        driver.switchTo().frame(frameElement);

        WebElement spanElementInsideIframe = waitForSpanElementInsideIframe(wait);
        WebElement butElementInsideIframe = waitForButtonElementInsideIframe(wait);

        String actual = spanElementInsideIframe.getText();
        String expected = "1.00 BYN";

        String actualButText = butElementInsideIframe.getText();
        String expectedButText = "1.00 BYN";

        assertText(expected, actual);
        assertButtonText(expectedButText, actualButText);
    }


    @Step("Assert text: expected={expected}, actual={actual}")
    private void assertText(String expected, String actual) {
        Assertions.assertEquals(expected, actual);
    }

    @Step("Assert button text: expected={expected}, actual={actual}")
    private void assertButtonText(String expected, String actual) {
        Assertions.assertEquals(expected, actual);
    }
    @Step("Enter phone number: {number}")
    private void enterPhoneNumber(String number) {
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phone.click();
        phone.clear();
        phone.sendKeys(number);
    }

    @Step("Enter sum: {sum}")
    private void enterSum(String sum) {
        WebElement sumElement = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sumElement.click();
        sumElement.clear();
        sumElement.sendKeys(sum);
    }

    @Step("Enter email: {email}")
    private void enterEmail(String email) {
        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        emailElement.click();
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    @Step("Click pay button")
    private void clickPayButton() {
        WebElement but = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        but.click();
    }

    @Step("Wait for payment iframe")
    private WebElement waitForFrame(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));
    }

    @Step("Wait for span element inside iframe")
    private WebElement waitForSpanElementInsideIframe(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div")));
    }

    @Step("Wait for button element inside iframe")
    private WebElement waitForButtonElementInsideIframe(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button")));
    }
    @Test
    void checkCommunicationServicesPlaceholders(){
        String actualPhone = driver
                .findElement(By.xpath("//*[@id=\"connection-phone\"]")).getAttribute("placeholder");

        String actualSum = driver
                .findElement(By.xpath("//*[@id=\"connection-sum\"]")).getAttribute("placeholder");

        String actualEmail = driver
                .findElement(By.xpath("//*[@id=\"connection-email\"]")).getAttribute("placeholder");

        String expectedPhone = "Номер телефона";
        String expectedSum = "Сумма";
        String expectedEmail = "E-mail для отправки чека";

        Assertions.assertEquals(expectedPhone,actualPhone);
        Assertions.assertEquals(expectedSum,actualSum);
        Assertions.assertEquals(expectedEmail,actualEmail);
    }

    @Test
    void checkHomeInternetPlaceholders(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(baseDropDown))).click();

        Actions action = new Actions(driver);

        WebElement homeInternet = driver.findElement(By.xpath(
                selectedItem + 2 + "]/p"));

        action.moveToElement(homeInternet);
        action.perform();

        String actualPhone = driver
                .findElement(By.xpath("//*[@id=\"internet-phone\"]")).getAttribute("placeholder");

        String actualSum = driver
                .findElement(By.xpath("//*[@id=\"internet-sum\"]")).getAttribute("placeholder");

        String actualEmail = driver
                .findElement(By.xpath("//*[@id=\"internet-email\"]")).getAttribute("placeholder");

        String expectedPhone = "Номер абонента";
        String expectedSum = "Сумма";
        String expectedEmail = "E-mail для отправки чека";

        Assertions.assertEquals(expectedPhone,actualPhone);
        Assertions.assertEquals(expectedSum,actualSum);
        Assertions.assertEquals(expectedEmail,actualEmail);
    }

    @Test
    void checkInstallmentPlaceholders(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(baseDropDown))).click();

        Actions action = new Actions(driver);

        WebElement homeInternet = driver.findElement(By.xpath(
                selectedItem + 3 + "]/p"));

        action.moveToElement(homeInternet);
        action.perform();

        String actualScore = driver
                .findElement(By.xpath("//*[@id=\"score-instalment\"]")).getAttribute("placeholder");

        String actualSum = driver
                .findElement(By.xpath("//*[@id=\"instalment-sum\"]")).getAttribute("placeholder");

        String actualEmail = driver
                .findElement(By.xpath("//*[@id=\"instalment-email\"]")).getAttribute("placeholder");

        String expectedScore = "Номер счета на 44";
        String expectedSum = "Сумма";
        String expectedEmail = "E-mail для отправки чека";

        Assertions.assertEquals(expectedScore,actualScore);
        Assertions.assertEquals(expectedSum,actualSum);
        Assertions.assertEquals(expectedEmail,actualEmail);
    }

    @Test
    void checkВebtPlaceholders(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(baseDropDown))).click();

        Actions action = new Actions(driver);

        WebElement homeInternet = driver.findElement(By.xpath(
                selectedItem + 4 + "]/p"));

        action.moveToElement(homeInternet);
        action.perform();

        String actualScore = driver
                .findElement(By.xpath("//*[@id=\"score-arrears\"]")).getAttribute("placeholder");

        String actualSum = driver
                .findElement(By.xpath("//*[@id=\"arrears-sum\"]")).getAttribute("placeholder");

        String actualEmail = driver
                .findElement(By.xpath("//*[@id=\"arrears-email\"]")).getAttribute("placeholder");

        String expectedScore = "Номер счета на 2073";
        String expectedSum = "Сумма";
        String expectedEmail = "E-mail для отправки чека";

        Assertions.assertEquals(expectedScore,actualScore);
        Assertions.assertEquals(expectedSum,actualSum);
        Assertions.assertEquals(expectedEmail,actualEmail);
    }
}
