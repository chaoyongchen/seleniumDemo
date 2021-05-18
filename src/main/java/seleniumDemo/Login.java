package seleniumDemo;

import org.openqa.selenium.WebDriver;

import pageobj.loginPage;

import org.openqa.selenium.By;

public class Login {

    loginPage loginPage;
    WebDriver driver;

    /**
     * @param driver 初始化并执行driver的初始化
     */
    public Login(WebDriver driver) {
        loginPage = new loginPage(driver);
        this.driver = driver;
    }

    /**
     * 输入登录相关信息，执行登录
     */
    public void userLogin(String username, String password, String validateCode) {
        // 找到用户名输入框并输入用户名
        loginPage.getUsernameInput().clear();
        loginPage.getUsernameInput().sendKeys(username);
        // 找到密码输入框并输入用户密码
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        // 找到验证码输入框并输入验证码
        loginPage.getCodeInput().clear();
        loginPage.getCodeInput().sendKeys(validateCode);
        //等待输入验证码
        //Thread.sleep(10000);
        //点击登录按钮，等待登录成功
        loginPage.getLogButton().click();

    }

    /**
     * 输入URL，打开网页
     */
    public void openUrl(String url) {
        driver.get(url);
    }

    /**
     * 登出系统
     */
    public void logOut() {
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[1]/div/div/a[2]/span")).click();
    }

    /**
     * @return 返回弹窗错误提示文字
     */
    public String getErrorText() {
        String Error = "";
        try {
            Error = loginPage.getErrorWindow().getText();
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("getErrorText failed");
        }

        return Error;
    }

    /**
     * @return 返回密码错误提示文字
     */
    public String getPasswordErrorText() {
        String Error = "";
        try {
            Error = loginPage.getPasswordError().getText();
        } catch (Exception e) {
            //.printStackTrace();
            System.out.println("getPasswordError failed");
        }
        return Error;
    }

    /**
     * @return 返回用户名错误提示文字
     */
    public String getUsernameErrorText() {
        String Error = "";
        try {
            Error = loginPage.getUsernameError().getText();
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("getUsernameError failed");
        }
        return Error;
    }

}
