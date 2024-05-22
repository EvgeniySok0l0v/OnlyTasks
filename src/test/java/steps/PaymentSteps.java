package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentSteps {

    private final WebDriver driver;
    private final String selectedItem = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[";

    public PaymentSteps(WebDriver webDriver){
        this.driver = webDriver;
    }

    @Step("Assert text: expected={expected}, actual={actual}")
    public void assertText(String expected, String actual) {
        Assertions.assertEquals(expected, actual);
    }

    @Step("Assert button text: expected={expected}, actual={actual}")
    public void assertButtonText(String expected, String actual) {
        Assertions.assertEquals(expected, actual);
    }

    @Step("Enter phone number: {number}")
    public void enterPhoneNumber(String number) {
        WebElement phone = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phone.click();
        phone.clear();
        phone.sendKeys(number);
    }

    @Step("Enter sum: {sum}")
    public void enterSum(String sum) {
        WebElement sumElement = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sumElement.click();
        sumElement.clear();
        sumElement.sendKeys(sum);
    }

    @Step("Enter email: {email}")
    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        emailElement.click();
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    @Step("Click pay button")
    public void clickPayButton() {
        WebElement but = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        but.click();
    }

    @Step("Wait for payment iframe")
    public WebElement waitForFrame(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bepaid-iframe")));
    }

    @Step("Wait for span element inside iframe")
    public WebElement waitForSpanElementInsideIframe(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div")));
    }

    @Step("Wait for button element inside iframe")
    public WebElement waitForButtonElementInsideIframe(WebDriverWait wait) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button")));
    }

    @Step("Click on base dropdown")
    public void clickBaseDropDown(WebDriverWait wait) {
        String baseDropDown = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button/span[2]";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(baseDropDown))).click();
    }

    @Step("Hover over Home Internet")
    public void hoverOverHomeInternet() {
        Actions action = new Actions(driver);
        WebElement homeInternet = driver.findElement(By.xpath(selectedItem + 2 + "]/p"));
        action.moveToElement(homeInternet).perform();
    }

    @Step("Get placeholder by element ID: {id}")
    public String getPlaceholderById(String id) {
        return driver.findElement(By.id(id)).getAttribute("placeholder");
    }

    @Step("Assert placeholder: expected={expected}, actual={actual}")
    public void assertPlaceholder(String expected, String actual) {
        Assertions.assertEquals(expected, actual);
    }

    @Step("Hover over Installment")
    public void hoverOverInstallment() {
        Actions action = new Actions(driver);
        WebElement installment = driver.findElement(By.xpath(selectedItem + 3 + "]/p"));
        action.moveToElement(installment).perform();
    }

    @Step("Hover over Debt")
    public void hoverOverDebt() {
        Actions action = new Actions(driver);
        WebElement installment = driver.findElement(By.xpath(selectedItem + 4 + "]/p"));
        action.moveToElement(installment).perform();
    }
}
