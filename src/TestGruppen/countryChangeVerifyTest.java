package TestGruppen;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class countryChangeVerifyTest extends GenelWebDriver {

    @Test
    public void countryChangeVerify() {
        // çerez kabul
        WebElement cookiesAcceptButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookiesAcceptButton.click();

        //ülke değiştirme butonuna scroll yapma ve tıklama
        WebElement countryChange = driver.findElement(By.cssSelector("button[class='footer__wrapper--countrywrapper']"));
        scrollToElement(countryChange);
        countryChange.click();

        //select menüden ülke seçme
        WebElement countrySelect = driver.findElement(By.cssSelector("div[class='country-select']>select"));
        wait.until(ExpectedConditions.elementToBeClickable(countrySelect));
        Select country = new Select(countrySelect);
        country.selectByVisibleText("Italy");

        //select butona tıklama
        WebElement selectButton = driver.findElement(By.cssSelector("div[class='country-actions']"));
        wait.until(ExpectedConditions.elementToBeClickable(selectButton));
        selectButton.click();

        //sayfada ülkenin seçildiğini doğrulama
        WebElement verifyItaly = driver.findElement(By.cssSelector("span[class='selected-country-code']"));
        wait.until(ExpectedConditions.visibilityOf(verifyItaly));
        Assert.assertEquals(verifyItaly.getText(), "IT");


    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
}
