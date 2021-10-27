package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void fillLoginForm(String email, String password){


        type(By.xpath("//input[@id='email']"),email);

        type(By.xpath("//input[@id='password']"),password);

    }


    public boolean isLogInPresent() {

        return isElementPresent(By.xpath("//a[text()=' Log in ']"));

    }

    public void logOut() {
        click(By.xpath("//a[text()=' Logout ']"));

    }
}

