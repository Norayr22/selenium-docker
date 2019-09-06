package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(name = "email")
    private WebElement usernameTxt;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "register")
    private WebElement submitBtn;

    public RegisterationPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        driver.get("http://newtours.demoaut.com/mercuryregister.php");
        wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
    }

    public void enterUserDetails(String firstName, String lastName){
        firstNameTxt.sendKeys(firstName);
        lastNameTxt.sendKeys(lastName);
    }

    public void enterUserCredentials(String username,String password){
        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);
        confirmPasswordTxt.sendKeys(password);
    }

    public void submit(){
        submitBtn.click();
    }
}
