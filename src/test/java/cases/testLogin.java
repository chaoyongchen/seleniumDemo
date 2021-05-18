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
     * ����ִ��ǰ��ʼ��driver
     */
    @BeforeMethod
    protected void setUp() {
        // TODO �Զ����ɵķ������
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
        // �򿪹���ƽ̨��ַ
        login.openUrl("http://113.57.110.66:8091/greatwall_admin/login");
    }

    /**
     * �ṩ��������
     *
     * @return
     */
    @DataProvider(name = "user")
    public Object[][] Users() {
        return new Object[][]{
                {"1", "1", "�û�������/�������"},
                {"1", "", "��������������"},
                {"", "1", "�����������û���"}

        };
    }

    /**
     * ��¼���ܲ���
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
        //��֤�˺�����ʧ����ʾ��Ϣ
        System.out.println("testFailed:" + exceptString + "\nError:" + ErrorInfo);

    }


    @Test
    public void testLogSuccessCase() {
        //System.out.println("loginTestCase");
        // ���õ�¼��������ɵ�¼����
        login.userLogin("admin", "admin123", "1234");
        // ��ȡ��¼����û��������жϵ�¼���
        String userInfo = driver.findElement(By.xpath("/html/body/div/nav/div[2]/div[1]/ul/li[1]/div/div/p")).getText();
        System.out.println("��¼�û���Ϊ��" + userInfo);
        assertEquals(userInfo, "admin");
        login.logOut();
    }

    /**
     * ����ִ����ɺ��˳������
     */
    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }

}
