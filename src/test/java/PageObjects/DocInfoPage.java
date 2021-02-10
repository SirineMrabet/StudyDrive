package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DocInfoPage {
    public DocInfoPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public static final String HelloUser= "//h1[contains(text(),'')]";
    @FindBy(how = How.XPATH, using = HelloUser)
    public WebElement HelloUser_P;

}
