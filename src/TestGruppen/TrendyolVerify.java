package TestGruppen;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class TrendyolVerify extends GenelWebDriver {


    @Test
    public void Verify() {

        WebElement cookiesAcceptButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookiesAcceptButton.click();

        WebElement link = driver.findElement(By.xpath("//a[text()='Kurumsal Hediye Çeki']"));
        wait.until(ExpectedConditions.elementToBeClickable(link));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", link);

        link.click();

        WebElement homePageVerify = driver.findElement(By.xpath("(//a[text()='Kadın'])[1]"));

        // Linkde hata olduğu için anasayfaya yönlendiriliyor. Burada hatayı verify ediyoruz.

        if (homePageVerify.isDisplayed()){

            System.out.println(" Defect : Link doesn't work, It is directly going homepage ");

        }else {

            System.out.println(" There is no defect , it is working regular ");
        }
    }

}
