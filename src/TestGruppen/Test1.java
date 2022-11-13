package TestGruppen;

import Utils.GenelWebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test1 extends GenelWebDriver {


    @Test(priority = 1)
    void test1() {

        Actions actions=new Actions(GenelWebDriver.driver);
        SoftAssert sft=new SoftAssert();

        POMCodes_112 elements = new POMCodes_112(driver);
        elements.clickcokieaccept.click();

        System.out.println("sayısı="+elements.counttheelements.size());


        actions.moveToElement(elements.Allimagines).build().perform();

        for (int i = 0; i <elements.counttheelements.size(); i++) {
            scrollToIntoMiddle(elements.counttheelements.get(i));
            wait.until(ExpectedConditions.elementToBeClickable(elements.counttheelements.get(i)));
//            wait.until(ExpectedConditions.visibilityOf(elements.counttheelements.get(i)));
            actions.moveToElement(elements.counttheelements.get(i)).build().perform();
            Assert.assertTrue(elements.Allimagines.getText().contains(elements.counttheelements.get(i).getText()));
            System.out.println(elements.counttheelements.get(i).getText());

        }
        System.out.println("the test passed");






    }
    public void scrollToIntoMiddle(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        js.executeScript(scrollElementIntoMiddle, element);

    }
}




