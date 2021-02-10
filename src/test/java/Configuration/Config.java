package Configuration;

import Base.BaseUtile;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Cookie;

public class Config  {

    public Config(
            WebDriver driver){ PageFactory.initElements(driver, this);

    }

    public static final String url= "https://www.studydrive.net";
    public static final String Upload_url= "https://www.studydrive.net/en/file-upload";
    public static final String email= "autoqa86@gmail.com";
    public static final String password= "HA9I4NVyfC";
    public static final String CourseName= "01_QA Automation";
    public static final int TimeOut= 60;
    public static final String RegisteredUsersFilePath = "\\src\\test\\resources\\RegisteredUsers\\RegisteredUsers.json";
    public static final String ResourcesPDFPath = "\\src\\test\\resources\\FileToUpload\\pdf\\";
    public static final String ScreenshotsPath = "\\src\\test\\resources\\Screenshots\\";
    public static final String TessDataPath = "\\src\\test\\resources\\TessData";
    /*
    browser can take:
            chrome
            firefox
            ie
     */
    public static final String browser= "chrome";














}
