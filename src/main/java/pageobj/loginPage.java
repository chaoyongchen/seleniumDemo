package pageobj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class loginPage {

    WebDriver driver;

    /**
     * 初始化
     */
    public loginPage(WebDriver driver) {
        // TODO 自动生成的构造函数存根
        this.driver = driver;
    }

    /**
     * 返回登录页面用户名输入框定位
     */
    public WebElement getUsernameInput() {
        WebElement webElement = new RemoteWebElement();
        try {
            webElement = driver.findElement(By.name("username"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }

    /**
     * 返回登录页面密码输入框定位
     */
    public WebElement getPasswordInput() {
        WebElement webElement = new RemoteWebElement();
        try {
            webElement = driver.findElement(By.name("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;

    }

    /**
     * 返回验证码输入框定位
     */
    public WebElement getCodeInput() {
        WebElement webElement = new RemoteWebElement();
        try {
            webElement = driver.findElement(By.name("validateCode"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;
    }

    /**
     * 返回登录按钮定位
     */
    public WebElement getLogButton() {
        WebElement webElement = new RemoteWebElement();
        try {
            webElement = driver.findElement(By.id("btnSubmit"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;

    }

    /**
     * 返回记住选择框定位
     */
    public WebElement getRemeberme() {
        WebElement webElement = new RemoteWebElement();
        try {
            webElement = driver.findElement(By.id("rememberme"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webElement;

    }

    /**
     * 返回登录页面欢迎语定位
     */

    public WebElement getIndexText() {
        WebElement webElement = new RemoteWebElement();
        try {
            webElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/h2"));
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return webElement;
    }

    /**
     * @return 返回错误提示窗口定位
     */
    public WebElement getErrorWindow() {
        WebElement webElement = new RemoteWebElement();
        try {
            webElement = driver.findElement(By.className("layui-layer-content"));
        } catch (Exception e) {
           // e.printStackTrace();
        }
        return webElement;
    }

    /**
     * 返回密码错误提示定位
     *
     * @return
     */
    public WebElement getPasswordError() {
        WebElement webElement = new RemoteWebElement();
        try {
            webElement = driver.findElement(By.id("password-error"));
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return webElement;
    }

    /**
     * 返回账号错误提示定位
     *
     * @return
     */
    public WebElement getUsernameError() {
        WebElement webElement = new RemoteWebElement();
        try {
            webElement = driver.findElement(By.id("username-error"));
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return webElement;
    }

}
