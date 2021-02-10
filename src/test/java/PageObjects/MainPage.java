package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public static final String AcceptButton= "//button[contains(text(),'Accept all')]";
    @FindBy(how = How.XPATH, using = AcceptButton )
    public WebElement AcceptButton_P;

    public static final String Login= "//button[contains(text(),'Log in')]";
    @FindBy(how = How.XPATH, using = Login )
    public WebElement Login_P;


    public static final String InputEmail= "//input[@type='email']";
    @FindBy(how = How.XPATH, using = InputEmail )
    public WebElement InputEmail_P;

    public static final String InputPassword= "//input[@type='password']";
    @FindBy(how = How.XPATH, using = InputPassword )
    public WebElement InputPassword_P;

    public static final String LoginButton= "//button[@class='w-full btn btn-cta-surfaced btn-md']";
    @FindBy(how = How.XPATH, using = LoginButton )
    public WebElement LoginButton_P;







}
