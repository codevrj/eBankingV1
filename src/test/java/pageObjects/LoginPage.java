package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    public WebDriver driver;

//    @FindBy(name = "uid")
//    WebElement userName;
//
//    @FindBy(name = "password")
//    WebElement passWord;
//
//    @FindBy(name = "btnLogin")
//    WebElement Login;

    By userName = By.name("uid");
    By passWord = By.name("password");
    By Login = By.name("btnLogin");
    By Logout = By.linkText("Log out");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void setUserName(String uname){
        driver.findElement(userName).sendKeys(uname);
    }
    public void setPassWord(String pwd){
        driver.findElement(passWord).sendKeys(pwd);
    }
    public void clickLogin(){
        driver.findElement(Login).click();
    }
    public void clickLogout(){
        driver.findElement(Logout).click();
    }
}
