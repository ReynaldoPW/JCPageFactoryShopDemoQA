import com.juaracoding.LoginPage;
import com.juaracoding.ProductPage;
import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLogin {
    public static WebDriver driver;
    public LoginPage loginPage;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
    }

    @Test
    public void testLogin(){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        driver.get("https://shop.demoqa.com");
        // Click the dismiss button
        loginPage.clickDismissButton();

        // Click the My Account link
        loginPage.clickMyAccountLink();

        js.executeScript("window.scrollBy(0,500");
        //Login using registered account
        loginPage.Login("reypau","formeonly123");

        // Verify that the user is logged in
        Assert.assertTrue(driver.getPageSource().contains("Logout"));
    }
    @AfterClass
    public void quitBrowser(){
        delay(3);
        DriverSingleton.closeObjectInstance();
    }
    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
