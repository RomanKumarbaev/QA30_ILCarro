package tests;

import manager.MyDataProvider;
import manager.NgListener;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(NgListener.class)

public class LoginTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        if (!app.getUserHelper().isLogInPresent()) {
            app.getUserHelper().logOut();
        }


    }


    @Test(dataProvider = "loginModel", dataProviderClass = MyDataProvider.class)
    public void loginSuccess(User user) {

        app.getUserHelper().openLogInForm();
        app.getUserHelper().fillLoginForm(user);

        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());

    }


    @Test(dataProvider = "loginDto", dataProviderClass = MyDataProvider.class)
    public void loginSuccess2(String email, String password) {

        app.getUserHelper().openLogInForm();

        app.getUserHelper().fillLoginForm(email, password);

        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());

    }

    @AfterMethod
    public void postCondition() {

        app.getUserHelper().clickOkButton();


    }


}
