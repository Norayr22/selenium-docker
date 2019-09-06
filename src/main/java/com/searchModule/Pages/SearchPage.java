package com.searchModule.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchTxt;

    @FindBy(id = "search_button_homepage")
    private WebElement searchBtn;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(xpath = "//div[contains(@class,'tile--vid')]")
    private List<WebElement> allvideos;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 60);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        driver.get("https://duckduckgo.com");
    }

    public void doSearch(String keyword){
        wait.until(ExpectedConditions.visibilityOf(searchTxt));
        searchTxt.sendKeys(keyword);
        searchBtn.click();
    }

    public void goTovideos(){
        wait.until(ExpectedConditions.visibilityOf(videosLink));
        videosLink.click();
    }

    public int getResult(){
        By by = By.xpath("//div[contains(@class,'tile--vid')]");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println(allvideos.size());
        return allvideos.size();
    }
}
