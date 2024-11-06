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
import java.util.ArrayList;
import java.util.List;

public class AccountPage {
    WebDriver driver;
    @FindBy(xpath = "//button[@ng-class='btnClass2'][contains(.,'Deposit')]")
    public WebElement depositTab;

    @FindBy(xpath = "//input[contains(@type,'number')]")
    public WebElement amountField;

    @FindBy(xpath = "//button[@type='submit'][contains(.,'Deposit')]")
    public WebElement depositButton;
    @FindBy(xpath = "//span[@class='error ng-binding'][contains(.,'Deposit Successful')]")
    public WebElement successMessageText;

    @FindBy(id = "accountSelect")
    public WebElement accountsSelect;
    private String accountType;


    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickOnDepositTab() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(depositTab));
        depositTab.click();
    }

    public void enterDepositAmount(String amount) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(amountField));
        amountField.sendKeys(amount);
    }

    public  void clickOnDepositButton(){

        depositButton.click();
    }

    public void successMessage(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(successMessageText)).click();
        successMessageText.isDisplayed();
    }

    public void depositOnEachAccount(String amount) throws InterruptedException {
        // Wait for the accounts dropdown to be clickable and click it
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(accountsSelect)).click();

        // Fetch all account dropdowns (update the locator as necessary)
        List<WebElement> accountsList = driver.findElements(By.id("accountSelect")); // Replace with the correct selector
        List<Select> dropdowns = new ArrayList<>();

        // Create Select objects for each dropdown
        for (WebElement dropdownElement : accountsList) {
            Select dropdown = new Select(dropdownElement);
            dropdowns.add(dropdown);
        }

        // Iterate through each Select object and select each option
        for (Select dropdown : dropdowns) {
            List<WebElement> options = dropdown.getOptions();
            for (WebElement option : options) {
                // Select the option by its visible text
                dropdown.selectByVisibleText(option.getText());
                Thread.sleep(1000);

                // Perform the deposit operations
                clickOnDepositTab();
                enterDepositAmount(amount);
                Thread.sleep(2000);
                clickOnDepositButton();
                successMessage();
            }
        }
    }

    public void selectAccount(String accountType) {
        this.accountType = accountType;
    }
}
