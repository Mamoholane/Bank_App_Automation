package StepsDef;

import Pages.AccountPage;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class MyStepdefs {
    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    AccountPage accountPage;

    @Given("User is on login page")
    public void userIsOnLoginPage()  {
        loginPage = new LoginPage(driver);
        accountPage = new AccountPage(driver);
        driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
    }

//step definition file, it contains the actual implementation of what the feature steps should do.
    @When("User click customer login")
    public void userClickCustomerLogin() {
        loginPage.clickOnCustomerLoginButton();
    }

    @And("User select customer name")
    public void userSelectCustomerName()  {
     loginPage.selectOnCustomerName();

    }

    @And("User clicks on login button")
    public void userClicksOnLoginButton() {
     loginPage.clickOnLoginButton();
    }


    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully()  {
       loginPage.successMessage();

    }

    @Given("User is on account page")
    public void userIsOnAccountPage() {

    }

    @When("User select deposit")
    public void userSelectDeposit() {
      accountPage.clickOnDepositTab();
    }

    @And("User enter amount")
    public void userEnterAmount() {
      accountPage.enterDepositAmount();
        accountPage.clickOnDepositButton();
    }

    @Then("User deposit successfully")
    public void userDepositSuccessfully() {
        accountPage.successMessage();
    }


    @Then("User deposit money to different accounts")
    public void userDepositMoneyToDifferentAccounts() {
        accountPage.depositOnEachAccount();
    }
}
