package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandPage {


    public LandPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public static final String HelloUser= "//h1[contains(text(),'Hey QA Auto,')]";
    @FindBy(how = How.XPATH, using = HelloUser)
    public WebElement HelloUser_P;

    public static final String Buttonadd= "//*[@id='add-button']/span";
    @FindBy(how = How.XPATH, using = Buttonadd)
    public WebElement Buttonadd_P;

    public static final String CreateDoc= "//a[@href='/file-upload']";
    @FindBy(how = How.XPATH, using = CreateDoc)
    public WebElement CreateDoc_P;






}
