package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UploadDocPage {


    public UploadDocPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    public static final String SelectCourseMSG= "//h1[contains(text(), 'Select the course you want to upload')]";
    @FindBy(how = How.XPATH, using = SelectCourseMSG)
    public WebElement SelectCourseMSG_P;

    public static final String InputCourseName= "//input[@placeholder='Enter course name']";
    @FindBy(how = How.XPATH, using = InputCourseName)
    public WebElement InputCourseName_P;

    public static final String CourseName= "//span[contains(text(), '01_QA Automation')]";
    @FindBy(how = How.XPATH, using = CourseName)
    public WebElement CourseName_P;

    public static final String SelectFileMSG= "//span[contains(text(), 'Select your files')]";
    @FindBy(how = How.XPATH, using = SelectFileMSG)
    public WebElement SelectFileMSG_P;

    public static final String Upload= "//span[contains(text(), 'or browse files here')]";
    @FindBy(how = How.XPATH, using = Upload)
    public WebElement Upload_P;

    public static final String Drag_Drop= "//div[contains(text(), 'Drag & drop files here to upload')]";
    @FindBy(how = How.XPATH, using = Drag_Drop)
    public WebElement Drag_Drop_P;


    public static final String InputFileName= "//input[@placeholder='Enter document name']";
    @FindBy(how = How.XPATH, using = InputFileName)
    public WebElement InputFileName_P;

    public static final String InputFileDescription= "//input[@placeholder='Add description']";
    @FindBy(how = How.XPATH, using = InputFileDescription)
    public WebElement InputFileDescription_P;

    public static final String InputFileProfessor= "//input[@placeholder='Add professor (optional)']";
    @FindBy(how = How.XPATH, using = InputFileProfessor)
    public WebElement InputFileProfessor_P;

    public static final String SelectSemester= "//input[@placeholder='Select semester']";
    @FindBy(how = How.XPATH, using = SelectSemester)
    public WebElement SelectSemester_P;

    public static final String OptionsSemester= "//*[@id='vs1__listbox']//child::li";
    @FindBy(how = How.XPATH, using = OptionsSemester)
    public WebElement OptionsSemester_P;


    public static final String SelectDocType= "//input[@placeholder='Select document type']";
    @FindBy(how = How.XPATH, using = SelectDocType)
    public WebElement SelectDocType_P;

    public static final String OptionsDocType= "//*[@id='vs2__listbox']//child::li";
    @FindBy(how = How.XPATH, using = OptionsDocType)
    public WebElement OptionsDocType_P;


    public static final String UploadAnonymously= "//label[contains(text(), 'Upload anonymously')]";
    @FindBy(how = How.XPATH, using = UploadAnonymously)
    public WebElement UploadAnonymously_P;


    public static final String FinishUploadButton= "//button[contains(.,'Finish upload')]";
    @FindBy(how = How.XPATH, using = FinishUploadButton )
    public WebElement FinishUploadButton_P;

    public static final String SuccessUploadMSG= "//div[contains(.,'Upload completed')]";
    @FindBy(how = How.XPATH, using = SuccessUploadMSG )
    public WebElement SuccessUploadMSG_P;

    public static final String OpenDocUploaded= "//a[contains(.,'Open document')]";
    @FindBy(how = How.XPATH, using = OpenDocUploaded )
    public WebElement OpenDocUploaded_P;





}
