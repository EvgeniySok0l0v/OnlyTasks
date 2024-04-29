import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;


public class MtsTest {

    private WebDriver driver;
    private static final String URL = "https://www.mts.by";
    private final String baseElement = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div";

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
    void blockNameTest() {
        String actual = driver
                .findElement(By.xpath(baseElement+ "/h2")).getText();
        String expected = "Онлайн пополнение\nбез комиссии";

        Assertions.assertEquals(expected,actual);
    }

    @Test
    void checkLogosTest(){
        List<WebElement> logos = driver
                .findElements(By.xpath(baseElement + "/div[2]/ul/li"));

        List<String> actual = logos.stream()
                .map(l -> l.findElement(By.cssSelector("img")).getAttribute("alt"))
                .collect(Collectors.toList());

        List<String> expected = List.of(
                "Visa",
                "Verified By Visa",
                "MasterCard",
                "MasterCard Secure Code",
                "Белкарт",
                "МИР");

        Assertions.assertEquals(expected,actual);
    }


    @Test
    void checkLinkAboutServiceTest(){
        WebElement linkAboutService = driver
                .findElement(By.xpath(baseElement + "/a"));
        linkAboutService.click();

        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        //driver.navigate().back();
        Assertions.assertEquals(expectedLink,actualLink);
    }

    @Test
    void checkContinueButTest() {
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phone.click();
        phone.clear();
        phone.sendKeys("297777777");

        WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sum.click();
        sum.clear();
        sum.sendKeys("1");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        email.click();
        email.clear();
        email.sendKeys("123@mail.ru");

        WebElement but = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        but.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement frameElement = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));

        driver.switchTo().frame(frameElement);
        WebElement spanElementInsideIframe = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                        "/html/body/app-root/div/div/div/app-payment-container/section/div/div/span")));

        String actual = spanElementInsideIframe.getText();
        String expected = "Оплата: Услуги связи Номер:375297777777";

        Assertions.assertEquals(expected,actual);
    }
}
