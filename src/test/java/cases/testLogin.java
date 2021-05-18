/*
  chenyc
  2021.04.19
  logintest
 */
package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import junit.framework.TestCase;
import seleniumDemo.Login;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author CYC
 */

public class testLogin extends TestCase {

    WebDriver driver;
    Login login;

    /**
     * 用例执行前初始化driver
     */
    @BeforeMethod
    protected void setUp() {
        // TODO 自动生成的方法存根
       // System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
       // System.setProperty("webdriver.firefox.bin", "D:/firefox/firefox.exe");
      //  driver = new FirefoxDriver();
       // login = new Login(driver);
        try {
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),
                    DesiredCapabilities.firefox());
            login = new Login(driver);
        } catch (
                MalformedURLException e) {
            e.printStackTrace();
        }
        // 打开管理平台地址
        login.openUrl("http://113.57.110.66:8091/greatwall_admin/login");
    }

    /**
     * 提供测试数据
     *
     * @return
     */
    @DataProvider(name = "user")
    public Object[][] Users() {
        return new Object[][]{
                {"1", "1", "用户不存在/密码错误"},
                {"1", "", "请输入您的密码"},
                {"", "1", "请输入您的用户名"}

        };
    }

    /**
     * 登录功能测试
     */
    @Test(dataProvider = "user")
    public void testLogFailedCase(String username, String password, String exceptString) {
        login.userLogin(username, password, "1234");
        String ErrorInfo = login.getErrorText();
        if (ErrorInfo == "") {
            ErrorInfo = login.getPasswordErrorText();
            if (ErrorInfo == "") {
                ErrorInfo = login.getUsernameErrorText();
            }
        }
        assertEquals(ErrorInfo, exceptString);
        //验证账号密码失败提示信息
        System.out.println("testFailed:" + exceptString + "\nError:" + ErrorInfo);

    }


    @Test
    public void testLogSuccessCase() {
        //System.out.println("loginTestCase");
        // 调用登录方法，完成登录操作
        login.userLogin("admin", "admin123", "1234");
        // 获取登录后的用户名，并判断登录结果
        String userInfo = driver.findElement(By.xpath("/html/body/div/nav/div[2]/div[1]/ul/li[1]/div/div/p")).getText();
        System.out.println("登录用户名为：" + userInfo);
        assertEquals(userInfo, "admin");
        login.logOut();
    }

    /**
     * 用例执行完成后退出浏览器
     */
    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }

}
