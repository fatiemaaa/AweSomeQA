package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static drivers.DriverFactory.getNewInstance;
import static drivers.DriverHolder.getDriver;
import static drivers.DriverHolder.setDriver;

public class TestBase {
    static WebDriver driver;

    @BeforeTest
    public void setupDriver(){
        setDriver(getNewInstance(""));
        driver=getDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://awesomeqa.com/ui/");
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }
}
