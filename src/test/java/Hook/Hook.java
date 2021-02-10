package Hook;

import Base.BaseUtile;
import Configuration.Config;
import Helpers.BrowserUtilities;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;


public class Hook extends BaseUtile {

    private BaseUtile base;

    public Hook(BaseUtile base) {
        this.base = base;
        this.driver = base.driver;
    }
    @Before
    public void InitializeTest(Scenario scenario){

        System.out.println("Before ... ");
        PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\Log4j\\log4j.properties");
        //Instantiate Driver
        try {
            BrowserUtilities.Execute(Config.browser);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }



    @Test
    public void test() {

        System.out.println("navigation started ... ");

    }
    @After
    public void TearDownTest(Scenario scenario) {

        if (scenario.isFailed()) {
            System.out.println(scenario.getName() + " has been failed ");
        }
        System.out.println("Ending test");
        base.driver.quit();

    }


}
