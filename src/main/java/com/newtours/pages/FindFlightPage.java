package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {

    private WebDriver drvier;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement firstSubmitBtn;

    @FindBy(name = "buyFlights")
    private WebElement secondSubmitBtn;

    public FindFlightPage(WebDriver driver){
        this.drvier=driver;
        this.wait = new WebDriverWait(driver,60);
        PageFactory.initElements(driver, this);
    }

    public void submitFindFlightPage(){
        wait.until(ExpectedConditions.elementToBeClickable(firstSubmitBtn));
        firstSubmitBtn.click();
    }

    public void goToFlightConfirmationPage(){
        wait.until(ExpectedConditions.elementToBeClickable(secondSubmitBtn));
        secondSubmitBtn.click();
    }
}
