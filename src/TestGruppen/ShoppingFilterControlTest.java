package TestGruppen;

import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;


public class ShoppingFilterControlTest extends GenelWebDriver {

    @Test
    void shoppingFilterControlTest(){

        // çerez kabul
        WebElement cookiesAcceptButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookiesAcceptButton.click();


        // Çok satanlara tıklama
        WebElement cokSatanlar = driver.findElement(By.linkText("Sen De Al!"));
        cokSatanlar.click();


        // Çok satanlara göre sırala
        WebElement menu=driver.findElement(By.cssSelector("div[class='sort-fltr-cntnr'] select"));
        Select ddmenu=new Select(menu);

        ddmenu.selectByIndex(4);


        //Filtrelerden hızlı teslimatı, kargo bedava, 9 puan ve üzeriyi seç
        List<WebElement> sacmalik = driver.findElements(By.cssSelector("div[class='overlay']"));
        if (sacmalik.size()>0){
            sacmalik.get(0).click();
        }

        WebElement hizliTeslimat = driver.findElement(By.linkText("Uygula"));
        hizliTeslimat.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div[class='slctd-fltr-item']"),1));

        WebElement dokuzPuanUzeriSaticilar = driver.findElement(By.xpath("//div[text()='9 Puan Üzeri Satıcılar']"));
        dokuzPuanUzeriSaticilar.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div[class='slctd-fltr-item']"),2));

        WebElement kargoBedava = driver.findElement(By.xpath("//div[text()='Kargo Bedava']"));
        kargoBedava.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("div[class='slctd-fltr-item']"),3));


        // İlk 4 ürünü sepete ekle
        int urunSayisiInt=0;
        for (int i = 1; i <= 4; i++) {
            WebElement sepeteEkle = driver.findElement(By.xpath("(//div[@class='btn-basket']//div[@class='add-to-bs-tx'])["+i+"]"));
            sepeteEkle.click();
            //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[class='go-to-basket-button visible']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='go-to-basket-button visible']")));
            urunSayisiInt=i;
        }


        // Sepete git
        String urunSayisi=Integer.toString(urunSayisiInt);
        wait.until(ExpectedConditions.textToBe(By.cssSelector("div[class='basket-item-count-container visible']"),urunSayisi));

        WebElement sepeteTikla = driver.findElement(By.xpath("(//p[text()='Sepetim'])[1]"));
        sepeteTikla.click();


        // Seçilen filtreleri kontrol et
        List<WebElement> sacmalik2 = driver.findElements(By.cssSelector("div[class='onboarding-overlay']"));
        if (sacmalik2.size()>0){
            sacmalik2.get(0).click();
        }

        int uygun=0;
        List<WebElement> magazaPuanlari = driver.findElements(By.cssSelector("div[class='pb-merchant-point']"));
        for (int i = 0; i < magazaPuanlari.size(); i++) {
            String magazaPuanStr=magazaPuanlari.get(i).getText();
            int magazaPuanInt=Integer.parseInt(magazaPuanStr.substring(0,1));
            if (magazaPuanInt==9){
                uygun +=1;
            }
        }

        if (magazaPuanlari.size()==uygun){
            System.out.println("<---------------------------------------------------------------->");
            System.out.println("Secilen ürünlerin satıcıları 9 Puan Üzeri Satıcılardan oluşuyor.");
            System.out.println("<---------------------------------------------------------------->");
        }else{
            System.out.println("<--------------------------------------------->");
            System.out.println("HATA: 9 mağaza puanın altında olan satıcı var.");
            System.out.println("<--------------------------------------------->");
        }


        int onay=0;
        List<WebElement> bedavaKargo = driver.findElements(By.xpath("//p[text()='Kargo Bedava!']"));
        for (int i = 0; i < bedavaKargo.size(); i++) {
            String bedavaKargoStr=bedavaKargo.get(i).getText();
            if (bedavaKargoStr.equals("Kargo Bedava!")){
                onay +=1;
            }
        }

        if (bedavaKargo.size()==onay){
            System.out.println("<----------------------------------------------->");
            System.out.println("Sepetteki ürünlerin hepsinin kargosu BEDAVA`dır.");
            System.out.println("<----------------------------------------------->");
        }else{
            System.out.println("<---------------------------------------------------------------------->");
            System.out.println("HATA: Sepetteki ürünlerin arasında bedava kargo olmayan secenekler var.");
            System.out.println("<---------------------------------------------------------------------->");
        }


        int onay2=0;
        List<WebElement> hizliTeslimad = driver.findElements(By.xpath("span[class='pb-rush-delivery']"));
        for (int i = 0; i < hizliTeslimad.size(); i++) {
            String hizliTeslimadStr=bedavaKargo.get(i).getText();
            if (hizliTeslimadStr.equals("Hızlı Teslimat:")){
                onay2 +=1;
            }
        }

        if (hizliTeslimad.size()==onay2){
            System.out.println("<-------------------------------------------------------->");
            System.out.println("Sepetteki ürünlerin hepsi Hızlı Teslimat olan ürünlerdir.");
            System.out.println("<-------------------------------------------------------->");
        }else{
            System.out.println("<----------------------------------------------------------------------->");
            System.out.println("HATA: Sepetteki ürünlerin arasında Hızlı Teslimat olmayan secenekler var.");
            System.out.println("<----------------------------------------------------------------------->");
        }


    }

}
