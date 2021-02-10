package Helpers;

import Base.BaseUtile;
import Configuration.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShadowDom  extends BaseUtile {

    private BaseUtile base;

    public ShadowDom(BaseUtile base) {
        this.base = base;
        this.driver = base.driver;
    }


    public static WebElement expandRootElement(WebElement element) {
        WebElement ele = (WebElement) ((JavascriptExecutor)driver).executeScript("return arguments[0].shadowRoot", element);
        return ele;
    }
    public  static  void  AcceptCookies(){
        WebDriverWait wait = new WebDriverWait(driver, Config.TimeOut);

        System.out.println("wait for cookies popup 1");
        WebElement root = driver.findElement(By.xpath("//*[@id='usercentrics-root']")); // root element or shadowHost
        WebElement shadowRoot = expandRootElement(root);
        WebElement h1 = shadowRoot.findElement(By.cssSelector("div[data-testid='uc-container']"));
        WebElement h2 = h1.findElement(By.cssSelector("div[data-testid='uc-tcf-first-layer']"));
        WebElement h3 = h2.findElement(By.cssSelector("footer"));
        WebElement h4 = h3.findElement(By.cssSelector("div[data-testid='uc-footer']"));
        WebElement h5 = h4.findElement(By.cssSelector("div[class='sc-biBrSq fUrceT']"));
        WebElement h6 = h5.findElement(By.cssSelector("div[class='sc-hzMMCg kRzfai']"));
        WebElement h7 = h6.findElement(By.cssSelector("button[data-testid='uc-accept-all-button']"));
        h7.click();
    }

}
