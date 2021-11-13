package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        if (!app.getUserHelper().isLogInPresent()) {
            app.getUserHelper().logOut();
        }


    }


    @Test
    public void loginSuccess() {

        User user = new User().withEmail("wew@gmail.com").withPassword("Ar12345$");

        String email = "wew@gmail.com";
        String password = "Ar12345$";


        logger.info("Test Login Success starts with email>>>>"+ email);
        logger.info("Test Login Success starts with password>>>>"+password);

        app.getUserHelper().openLogInForm();

        //app.getUserHelper().fillLoginForm(email, password);

        app.getUserHelper().fillLoginForm(user);

        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());

    }

    @Test
    public void loginSuccess2() {

        String email = "wew@gmail.com";
        String password = "Ar12345$";

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
