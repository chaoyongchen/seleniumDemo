package pageobj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class loginPage {

    WebDriver driver;

    /**
     * ��ʼ��
     */
    public loginPage(WebDriver driver) {
        // TODO �Զ����ɵĹ��캯�����
        this.driver = driver;
    }

    /**
     * ���ص�¼ҳ���û��������λ
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
     * ���ص�¼ҳ�����������λ
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
     * ������֤�������λ
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
     * ���ص�¼��ť��λ
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
     * ���ؼ�סѡ���λ
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
     * ���ص�¼ҳ�滶ӭ�ﶨλ
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
     * @return ���ش�����ʾ���ڶ�λ
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
     * �������������ʾ��λ
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
     * �����˺Ŵ�����ʾ��λ
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
