package Steps;

import Base.BaseUtile;
import Configuration.Config;
import Helpers.BrowserUtilities;
import Helpers.ListsUtilities;
import Helpers.ScreenShots;
import PageObjects.LandPage;
import PageObjects.MainPage;
import PageObjects.UploadDocPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;


public class Upload_Files extends BaseUtile {

    LandPage LP;
    MainPage MP;
    UploadDocPage UP;
    BaseUtile base;

    public Upload_Files(BaseUtile base) {
        this.base = base;
        this.driver = base.driver;
        MP = new MainPage(base.driver);
        UP = new UploadDocPage(base.driver);
        LP = new LandPage(base.driver);

    }

    @Then("^I can upload one file with ([^\"]*)$")
    public void i_can_upload_one_file_with(String FileName) throws Exception {
        WebDriverWait wait = new WebDriverWait(base.driver, Config.TimeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UploadDocPage.Upload)));
        System.out.println(System.getProperty("user.dir") + Config.ResourcesPDFPath + FileName);
        UP.Upload_P.click();
        Robot robot = new Robot();
        Thread.sleep(1000);
        StringSelection stringSelect = new StringSelection(System.getProperty("user.dir") + Config.ResourcesPDFPath + FileName);
        Thread.sleep(1000);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelect, null);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.setAutoDelay(Config.TimeOut * 10);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.setAutoDelay(Config.TimeOut * 5);

    }



    @Then("^Name is set to ([^\"]*)$")
    public void name_is_set_to_FileName(String FileName) {
        //Call take screenshot function
        ScreenShots.takeSnapShot(System.getProperty("user.dir") + Config.ScreenshotsPath + "St.png");
//        System.out.println(ScreenShots.checkIMGContainTxt(System.getProperty("user.dir")+Config.ScreenshotsPath+"St.png",FileName));
//        Assert.assertTrue(ScreenShots.checkIMGContainTxt(System.getProperty("user.dir")+Config.ScreenshotsPath+"St.png",FileName));

    }

    @Then("^we can set ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*)$")
    public void we_can_set_description_professor_doctype_and_semester(String Desc, String Prof, String DocType, String Semester) throws Exception {
        UP.InputFileDescription_P.click();
        UP.InputFileDescription_P.sendKeys(Desc);
        UP.InputFileProfessor_P.click();
        UP.InputFileProfessor_P.sendKeys(Prof);

        UP.SelectDocType_P.click();
        ListsUtilities.SelectItem(DocType,UploadDocPage.OptionsDocType);
        Thread.sleep(1000);
        UP.SelectSemester_P.click();
        ListsUtilities.SelectItem(Semester,UploadDocPage.OptionsSemester);


    }

    @And("set the ([^\"]*)")
    public void setTheUploadType(String UploadType) {
        if (UploadType == "anonymously"){
            UP.UploadAnonymously_P.click();

        }
        UP.FinishUploadButton_P.click();
    }

    @Then("^open file with ([^\"]*) and ([^\"]*) in the corresponding course$")
    public void open_file_with_information(String FileName, String Semester) throws Exception {
        WebDriverWait wait = new WebDriverWait(base.driver, Config.TimeOut);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UploadDocPage.SuccessUploadMSG)));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(UploadDocPage.OpenDocUploaded)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(UploadDocPage.OpenDocUploaded)));
        ScreenShots.takeSnapShot(System.getProperty("user.dir") + Config.ScreenshotsPath + "St1.png");
        UP.OpenDocUploaded_P.click();
        BrowserUtilities.ChangeToNextTab();
        ScreenShots.takeSnapShot(System.getProperty("user.dir") + Config.ScreenshotsPath + "St2.png");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'"+FileName+"')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+Config.CourseName+"')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+Semester+"')]")));


    }

}
