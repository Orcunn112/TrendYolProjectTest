package TestGruppen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class POMCodes_112 {

    public POMCodes_112(WebDriver driver) {PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//button[text()='KABUL ET']")
    public WebElement clickcokieaccept;

    @FindBy(css = "[class='component-list component-small-list']")
    public WebElement Allimagines;

    @FindBy(xpath = "//*[@class='component-item']")
    public List<WebElement> counttheelements;


}

