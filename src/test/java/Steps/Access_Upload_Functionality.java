package Steps;

import Base.BaseUtile;
import Configuration.Config;
import Helpers.Json_Helpers;
import PageObjects.MainPage;
import PageObjects.LandPage;
import PageObjects.UploadDocPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import javax.json.JsonObject;
import static Helpers.ShadowDom.AcceptCookies;



public class Access_Upload_Functionality extends BaseUtile {

    LandPage LP;
    MainPage MP;
    UploadDocPage UP;
    BaseUtile base;
    public Access_Upload_Functionality(BaseUtile base){
        this.base= base;
        this.driver=base.driver;
        MP = new MainPage(base.driver);
        UP = new UploadDocPage(base.driver);
        LP = new LandPage(base.driver);

    }

    @Given("^I'm a registered user$")
    public void i_m_a_registered_user()  {


            try{
                System.out.println(System.getProperty("user.dir"));
                JsonObject Users= Json_Helpers.fileToJSONObject(System.getProperty("user.dir")+Config.RegisteredUsersFilePath);
                System.out.println("check if the email exists");
                Assert.assertEquals( Config.email ,Users.getString("email"));
                }
            catch (Exception e){
                System.out.println(e.fillInStackTrace());
            }
    }


    @When("^I log in$")
    public void i_log_in() {
       WebDriverWait wait = new WebDriverWait(base.driver, Config.TimeOut);
       AcceptCookies();
       System.out.println("wait for login");
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MainPage.Login)));
       MP.Login_P.click();

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MainPage.InputEmail)));
       MP.InputEmail_P.click();
       MP.InputEmail_P.clear();
       MP.InputEmail_P.sendKeys(Config.email);
       MP.InputPassword_P.sendKeys(Config.password);
       MP.LoginButton_P.click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandPage.HelloUser)));

    }

    @Then("^I can access to the upload functionality via the button$")
    public void i_can_access_to_the_upload_functionality_via_the_button() {

        WebDriverWait wait = new WebDriverWait(base.driver, Config.TimeOut);
        LP.Buttonadd_P.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LandPage.CreateDoc)));
        LP.CreateDoc_P.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UploadDocPage.SelectCourseMSG)));
        UP.InputCourseName_P.clear();
        UP.InputCourseName_P.click();
        UP.InputCourseName_P.sendKeys(Config.CourseName);
        UP.CourseName_P.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UploadDocPage.SelectFileMSG)));
        Assert.assertEquals(driver.getCurrentUrl(),Config.Upload_url);
        Assert.assertTrue((driver.findElement(By.xpath(UploadDocPage.Upload))).isEnabled());

    }

    @Then("^I can access to the upload functionality via the upload link$")
    public void i_can_access_to_the_upload_functionality_via_the_upload_link(){
        WebDriverWait wait = new WebDriverWait(base.driver, Config.TimeOut);
        driver.get(Config.Upload_url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UploadDocPage.SelectCourseMSG)));
        UP.InputCourseName_P.clear();
        UP.InputCourseName_P.click();
        UP.InputCourseName_P.sendKeys(Config.CourseName);
        UP.CourseName_P.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UploadDocPage.SelectFileMSG)));
        Assert.assertEquals(driver.getCurrentUrl(),Config.Upload_url);
        Assert.assertTrue((driver.findElement(By.xpath(UploadDocPage.Upload))).isEnabled());




    }



}
