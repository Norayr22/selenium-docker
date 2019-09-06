package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {

    private WebDriver drvier;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(),'Confirmation')]")
    private WebElement flightConfirmationHeader;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOffLink;

    public FlightConfirmationPage(WebDriver driver){
        this.drvier=driver;
        this.wait = new WebDriverWait(driver,60);
        PageFactory.initElements(driver, this);
    }

    public String getPrice(){
        wait.until(ExpectedConditions.visibilityOf(flightConfirmationHeader));
        System.out.println(flightConfirmationHeader.getText());
        System.out.println(prices.get(1).getText());
        String price = prices.get(1).getText();
        signOffLink.click();
        return price;
    }
}
