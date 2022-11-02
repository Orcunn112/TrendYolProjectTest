package TestGruppen;

import Utils.GenelWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class TestAssertCertificate extends GenelWebDriver {

    @Test
    void assertCertificate() {

        // çerez kabul
        WebElement cookiesAcceptButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookiesAcceptButton.click();

        // karekod tıklama
        WebElement etbisKareKodIcon = driver.findElement(By.cssSelector("[target='_blank'] img[src$='png']"));
        etbisKareKodIcon.click();

        // yeni açılan pencereye geçme (eticaret.gov.tr)
        String anaSayfaId = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String ChildWindow : allWindowHandles) {
            if (!anaSayfaId.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }
        }

        // eticaret.gov.tr 'deki kaydı doğrulama
        WebElement eTicaretDogrulamaMesaji = driver.findElement(By.xpath("//small[@class='color-blueviolet']"));
        System.out.println(eTicaretDogrulamaMesaji.getText());
        Assert.assertTrue(eTicaretDogrulamaMesaji.getText().equalsIgnoreCase("Elektronik Ticaret Bilgi Sistemi'nde kaydı doğrulanmış bir sitedir"));

        // ana sayfaya geri dönme ve doğrulama
        driver.switchTo().window(anaSayfaId);
        System.out.println(driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.trendyol.com"));
    }
}
