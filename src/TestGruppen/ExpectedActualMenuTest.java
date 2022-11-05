package TestGruppen;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ExpectedActualMenuTest extends GenelWebDriver {
    @Test
    void menuValidation(){
        List<String> menuExpectedList=new ArrayList<>();
        menuExpectedList.add("KADIN");
        menuExpectedList.add("ERKEK");
        menuExpectedList.add("ANNE & ÇOCUK");
        menuExpectedList.add("EV & MOBILYA");
        menuExpectedList.add("SÜPERMARKET");
        menuExpectedList.add("KOZMETIK");
        menuExpectedList.add("AYAKKABI & ÇANTA");
        menuExpectedList.add("SAAT & AKSESUAR");
        menuExpectedList.add("ELEKTRONIK");
        menuExpectedList.add("SPOR&OUTDOOR");

        By menuFinder= By.cssSelector("li[class=\"tab-link\"]>a[class=\"category-header\"]");
        List<WebElement> menuActualList=driver.findElements(menuFinder);

        Tools.compareToList(menuExpectedList,menuActualList);
    }
}
