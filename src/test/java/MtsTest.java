import io.github.bonigarcia.wdm.WebDriverManager;

import io.qameta.allure.*;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PaymentSteps;

import java.time.Duration;



public class MtsTest {

    private WebDriver driver;
    private static final String URL = "https://www.mts.by";
    private PaymentSteps paymentSteps;
    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        paymentSteps = new PaymentSteps(driver);

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
        paymentSteps.enterPhoneNumber("297777777");
        paymentSteps.enterSum("1");
        paymentSteps.enterEmail("123@mail.ru");
        paymentSteps.clickPayButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        WebElement frameElement = paymentSteps.waitForFrame(wait);
        driver.switchTo().frame(frameElement);

        WebElement spanElementInsideIframe = paymentSteps.waitForSpanElementInsideIframe(wait);
        WebElement butElementInsideIframe = paymentSteps.waitForButtonElementInsideIframe(wait);

        String actual = spanElementInsideIframe.getText();
        String expected = "1.00 BYN";

        String actualButText = butElementInsideIframe.getText();
        String expectedButText = "Оплатить 1.00 BYN";

        paymentSteps.assertText(expected, actual);
        paymentSteps.assertButtonText(expectedButText, actualButText);
    }

    @Test
    @Epic("Communication Services")
    @Feature("Placeholder Verification")
    @Story("Check Communication Services Placeholders")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test checks if the placeholders for the communication services form are displayed correctly.")
    void checkCommunicationServicesPlaceholders() {
        String actualPhone = paymentSteps.getPlaceholderById("connection-phone");
        String actualSum = paymentSteps.getPlaceholderById("connection-sum");
        String actualEmail = paymentSteps.getPlaceholderById("connection-email");

        paymentSteps.assertPlaceholder("Номер телефона", actualPhone);
        paymentSteps.assertPlaceholder("Сумма", actualSum);
        paymentSteps.assertPlaceholder("E-mail для отправки чека", actualEmail);
    }

    @Test
    @Epic("Internet")
    @Feature("Home Internet")
    @Story("Check Home Internet Placeholders")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test checks if the placeholders for the home internet form are displayed correctly.")
    void checkHomeInternetPlaceholders() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        paymentSteps.clickBaseDropDown(wait);
        paymentSteps.hoverOverHomeInternet();

        String actualPhone = paymentSteps.getPlaceholderById("internet-phone");
        String actualSum = paymentSteps.getPlaceholderById("internet-sum");
        String actualEmail = paymentSteps.getPlaceholderById("internet-email");

        paymentSteps.assertPlaceholder("Номер абонента", actualPhone);
        paymentSteps.assertPlaceholder("Сумма", actualSum);
        paymentSteps.assertPlaceholder("E-mail для отправки чека", actualEmail);
    }

    @Test
    @Epic("Installments")
    @Feature("Placeholder Verification")
    @Story("Check Installment Placeholders")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test checks if the placeholders for the installment form are displayed correctly.")
    void checkInstallmentPlaceholders() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        paymentSteps.clickBaseDropDown(wait);
        paymentSteps.hoverOverInstallment();

        String actualScore = paymentSteps.getPlaceholderById("score-instalment");
        String actualSum = paymentSteps.getPlaceholderById("instalment-sum");
        String actualEmail = paymentSteps.getPlaceholderById("instalment-email");

        paymentSteps.assertPlaceholder("Номер счета на 44", actualScore);
        paymentSteps.assertPlaceholder("Сумма", actualSum);
        paymentSteps.assertPlaceholder("E-mail для отправки чека", actualEmail);
    }

    @Test
    @Epic("Debts")
    @Feature("Placeholder Verification")
    @Story("Check Debts Placeholders")
    @Severity(SeverityLevel.NORMAL)
    @Description("This test checks if the placeholders for the debts form are displayed correctly.")
    void checkВebtPlaceholders(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        paymentSteps.clickBaseDropDown(wait);
        paymentSteps.hoverOverDebt();

        String actualScore = paymentSteps.getPlaceholderById("score-arrears");
        String actualSum = paymentSteps.getPlaceholderById("arrears-sum");
        String actualEmail = paymentSteps.getPlaceholderById("arrears-email");

        paymentSteps.assertPlaceholder("Номер счета на 2073", actualScore);
        paymentSteps.assertPlaceholder("Сумма", actualSum);
        paymentSteps.assertPlaceholder("E-mail для отправки чека", actualEmail);
    }
}
