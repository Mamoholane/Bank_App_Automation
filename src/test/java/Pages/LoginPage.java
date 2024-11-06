package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    //how we identify the elemnts
    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg'][contains(.,'Customer Login')]")
    public WebElement customerLoginButton;

    @FindBy(id = "userSelect")
    public WebElement customerName;

    @FindBy(xpath = "//button[@class='btn btn-default'][contains(.,'Login')]")
    public WebElement loginButton;
    @FindBy(xpath = "//strong[contains(.,'Welcome Hermoine Granger !!')]")
    public WebElement actualText;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
     // This method click on the button
    public void clickOnCustomerLoginButton() {
       new WebDriverWait(driver, Duration.ofSeconds(10))
       .until(ExpectedConditions.elementToBeClickable(customerLoginButton)).click();
        customerLoginButton.click();
    }

    public void selectOnCustomerName()  {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(customerName)).click();
        customerName.click();

        Select dropdown = new Select(customerName);
        dropdown.selectByVisibleText("Hermoine Granger");

    }

    public  void clickOnLoginButton(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        loginButton.click();
    }

    public void successMessage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(actualText)).click();
        actualText.isDisplayed();
    }

}
