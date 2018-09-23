package com.masteringselenium.tests;
import com.masteringselenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import static org.junit.Assert.assertNotNull;
import java.util.concurrent.TimeUnit;

public class dragAndDropWD extends DriverFactory 
{
    @Test
    public void automateJavaScriptDragAndDrop() throws Exception 
    {
        WebDriver driver = getDriver();

        driver.get("https://jqueryui.com/droppable/");
        
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);
        
        Actions advancedActions = new Actions(driver);  
        WebElement iFrame = driver.findElement(By.cssSelector("#content > iframe"));                
        WebElement draggableBox = driver.switchTo().frame(iFrame).findElement(By.cssSelector("#draggable"));
        WebElement droppableBox = driver.findElement(By.cssSelector("#droppable"));
     
        /* Pay attenton to the methods available to test the drag and drop functionality. 
         * You can also use advancedActions.dragAndDrop(draggableBox, droppableBox).perform(); */
        advancedActions.clickAndHold(draggableBox)
                .moveToElement(droppableBox)
                .release()
                .perform(); 
    }


   @Test
    public void automateJavaScriptDragAndDropWithOffsetsStep1() throws Exception 
    {
        WebDriver driver = getDriver();

        driver.get("https://jqueryui.com/droppable/");

        Actions advancedActions = new Actions(driver);  
        WebElement iFrame = driver.findElement(By.cssSelector("#content > iframe"));                
        WebElement draggableBox = driver.switchTo().frame(iFrame).findElement(By.cssSelector("#draggable"));
        WebElement droppableBox = driver.findElement(By.cssSelector("#droppable"));

        /* advancedActions.moveToElement() has been used along with .moveByOffset() in order to
         * offset the cursor from the centre by 40 pixels to the left of the draggableBox. Note 
         * that offsets do not work with clickAndHold(). The default offset position differs depending
         * on the method used*/
        advancedActions.moveToElement(draggableBox)
                .moveByOffset(-40, 0)
                .clickAndHold()
                .moveToElement(droppableBox)
                .release()
                .perform();

        assertNotNull(droppableBox);
    }
   

    @Test
    public void automateJavaScriptDragAndDropWithOffsetsStep4() throws Exception {
        WebDriver driver = getDriver();

        driver.get("https://jqueryui.com/droppable/");

        Actions advancedActions = new Actions(driver);  
        WebElement iFrame = driver.findElement(By.cssSelector("#content > iframe"));                
        WebElement draggableBox = driver.switchTo().frame(iFrame).findElement(By.cssSelector("#draggable"));
        WebElement droppableBox = driver.findElement(By.cssSelector("#droppable"));

        /* Moving the mouse to the top-left corner the <div> element Moving it 1 pixel to the right and 
         * 1 pixel down. Clicking and holding down the left mouse button */
        advancedActions.moveToElement(draggableBox, 1, 1)
                .clickAndHold()
                .moveToElement(droppableBox)
                .release()
                .perform();

    }

 /*//this test is useful fo when you have a <span> overlaying the centre of the element
  	@Test
    public void automateJavaScriptDragAndDropWithOffsetsStep5() throws Exception {
        WebDriver driver = getDriver();

        driver.get("https://jqueryui.com/droppable/");
        
        Actions advancedActions = new Actions(driver);  
        WebElement iFrame = driver.findElement(By.cssSelector("#content > iframe"));                
        WebElement draggableBox = driver.switchTo().frame(iFrame).findElement(By.cssSelector("#draggable"));
        WebElement draggableBoxText = driver.findElement(By.cssSelector("#one > span"));
        WebElement droppableBox = driver.findElement(By.cssSelector("#droppable"));
        

        CalculateOffsetPosition op = new 
        		CalculateOffsetPosition(draggableBox, draggableBoxText, 
        				CalculateOffsetPosition.CursorPosition.CENTER);

        advancedActions.moveToElement(draggableBox)
                .moveByOffset(op.getXOffset(), op.getYOffset())
                .clickAndHold()
                .moveToElement(droppableBox)
                .release()
                .perform();
    } */
}
