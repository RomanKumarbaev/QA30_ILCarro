package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void fillLoginForm(String email, String password) {


        type(By.xpath("//input[@id='email']"), email);

        type(By.xpath("//input[@id='password']"), password);

    }

    public void fillLoginForm(User user) {


        type(By.xpath("//input[@id='email']"), user.getEmail());

        type(By.xpath("//input[@id='password']"), user.getPassword());

    }


    public boolean isLogInPresent() {

        return isElementPresent(By.xpath("//a[text()=' Log in ']"));

    }

    public void logOut() {
        click(By.xpath("//a[text()=' Logout ']"));

    }

    public void openLogInForm() {

        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void submitForm() {
        //click(By.xpath("//button[@type='submit']"));
        WebElement submit = wd.findElement(By.xpath("//button[@type='submit']"));
        submit.submit();
    }

    public boolean isLoggedSuccess() {
        WebDriverWait wait = new WebDriverWait(wd,10);

        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));

        return wd.findElement(By.cssSelector(".dialog-container h2")).getText().contains("success");

    }

    public void clickOkButton() {

        if(isElementPresent(By.xpath("//button[text()='Ok']"))){
            click(By.xpath("//button[text()='Ok']"));
        }

                }
}

