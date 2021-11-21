package tests;

import manager.MyDataProvider;
import manager.NgListener;
import models.User;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Listeners(NgListener.class)

public class LoginTests extends TestBase {


    @BeforeMethod
    public void precondition() {
        if (!app.getUserHelper().isLogInPresent()) {
            app.getUserHelper().logOut();
        }


    }


    @Test (dataProvider = "loginModel", dataProviderClass = MyDataProvider.class)
    public void loginSuccess(User user) {

        //User user = new User().withEmail("wew@gmail.com").withPassword("Ar12345$");

//        String email = "wew@gmail.com";
//        String password = "Ar12345$";
//
//
//        logger.info("Test Login Success starts with email>>>>" + email);
//        logger.info("Test Login Success starts with password>>>>" + password);

        app.getUserHelper().openLogInForm();

        //app.getUserHelper().fillLoginForm(email, password);

        app.getUserHelper().fillLoginForm(user);

        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());

    }




    @Test(dataProvider = "loginDto",dataProviderClass = MyDataProvider.class)
    public void loginSuccess2(String email, String password) {

//        String email = "wew@gmail.com";
//        String password = "Ar12345$";

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
