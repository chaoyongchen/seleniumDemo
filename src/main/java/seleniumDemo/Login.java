package seleniumDemo;

import org.openqa.selenium.WebDriver;

import pageobj.loginPage;

import org.openqa.selenium.By;

public class Login {

    loginPage loginPage;
    WebDriver driver;

    /**
     * @param driver ��ʼ����ִ��driver�ĳ�ʼ��
     */
    public Login(WebDriver driver) {
        loginPage = new loginPage(driver);
        this.driver = driver;
    }

    /**
     * �����¼�����Ϣ��ִ�е�¼
     */
    public void userLogin(String username, String password, String validateCode) {
        // �ҵ��û�������������û���
        loginPage.getUsernameInput().clear();
        loginPage.getUsernameInput().sendKeys(username);
        // �ҵ���������������û�����
        loginPage.getPasswordInput().clear();
        loginPage.getPasswordInput().sendKeys(password);
        // �ҵ���֤�������������֤��
        loginPage.getCodeInput().clear();
        loginPage.getCodeInput().sendKeys(validateCode);
        //�ȴ�������֤��
        //Thread.sleep(10000);
        //�����¼��ť���ȴ���¼�ɹ�
        loginPage.getLogButton().click();

    }

    /**
     * ����URL������ҳ
     */
    public void openUrl(String url) {
        driver.get(url);
    }

    /**
     * �ǳ�ϵͳ
     */
    public void logOut() {
        driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[1]/div/div/a[2]/span")).click();
    }

    /**
     * @return ���ص���������ʾ����
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
     * @return �������������ʾ����
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
     * @return �����û���������ʾ����
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
