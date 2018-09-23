package com.masteringselenium.tests;
import com.masteringselenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class cssMenuWD extends DriverFactory
{
    @Test
    public void automateCSSMenu() throws Exception 
    {
        WebDriver driver = getDriver();

        driver.get("https://www.w3schools.com/css/css_dropdowns.asp");
                
        /* a basic actions object that we can use to chain a series of actions
         * which accepts a driver object in the constructor */
        Actions advancedActions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5, 100);

        WebElement servicesMenuOption = 
        		driver.findElement(By.cssSelector("#main > div.w3-row > div:nth-child(2) > div > button"));
        WebElement webDevelopmentSubMenuOption = 
        		driver.findElement(By.cssSelector("#main > div.w3-row > div:nth-child(2) > div > div > a:nth-child(2)"));

        advancedActions.moveToElement(servicesMenuOption)
        		.perform();

        wait.until(ExpectedConditions.visibilityOf(webDevelopmentSubMenuOption));

        advancedActions.moveToElement(webDevelopmentSubMenuOption)
                .click()
                .perform();

    }
}
