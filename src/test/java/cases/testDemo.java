package cases;

import junit.framework.TestCase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import seleniumDemo.Login;

import java.net.MalformedURLException;
import java.net.URL;

public class testDemo extends TestCase {

    WebDriver driver;
    Login login;
    @Test
    public void testA() {
        try {
            WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),
                    DesiredCapabilities.firefox());
            login = new Login(driver);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
    login.openUrl("http://www.baidu.com");
    }
}
