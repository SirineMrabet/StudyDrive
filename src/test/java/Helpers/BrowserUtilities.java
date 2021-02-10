package Helpers;


import Base.BaseUtile;
import Configuration.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.WebDriver;


import java.util.concurrent.TimeUnit;

public class BrowserUtilities extends BaseUtile {

    private BaseUtile base;

    public BrowserUtilities(BaseUtile base) {
        this.base = base;
        this.driver = base.driver;
    }




    public static void Execute( String browser) {

        // Set Browsers
        if(browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            driver = new FirefoxDriver(options);
        }

        else if (browser.equalsIgnoreCase("chrome")) {


            WebDriverManager.chromedriver().version("88.0.4324.96").setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--allowed-ips");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);

        }

        else if (browser.equalsIgnoreCase("ie")) {

            WebDriverManager.iedriver().setup();
            InternetExplorerOptions options = new InternetExplorerOptions();
            options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            driver = new InternetExplorerDriver(options);
        }


        // Implicit Wait and Maximize browser
        driver.manage().timeouts().implicitlyWait(Config.TimeOut, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Navigate to URL
        driver.get(Config.url);

        System.out.println("2 "+driver.getCurrentUrl());


    }
    public static void ChangeToNextTab(){

        String currentTabHandle = driver.getWindowHandle();
        String newTabHandle = driver.getWindowHandles()
                .stream()
                .filter(handle -> !handle.equals(currentTabHandle ))
                .findFirst()
                .get();
        driver.switchTo().window(newTabHandle);

    }

}
