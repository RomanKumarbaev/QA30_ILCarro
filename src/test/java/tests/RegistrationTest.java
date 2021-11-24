package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @Test (dataProvider = "regestrationCsv", dataProviderClass = MyDataProvider.class)
    public void registrationPositiveTest(User user) {

        app.getUserHelper().openRegistrationForm();

        app.getUserHelper().fillRegistrationForm(user);

        app.getUserHelper().checkPolicy();

        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getUserHelper().isRegistered());
    }


//    @Test
//    public void registrationNegativeTest() {
//
//        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
//
//
//        User user = new User().withName("Lis")
//                .withLastname("Show")
//                .withEmail("shr" + i + "@gmail.com")
//                .withPassword("Df12");
//
//
//        app.getUserHelper().openRegistrationForm();
//        app.getUserHelper().fillRegistrationForm(user);
//        app.getUserHelper().checkPolicy();
//        app.getUserHelper().submitForm();
//
//        // Assert.assertTrue(app.getUserHelper().isRegistered());
//
//
//    }

    @AfterMethod
    public void postCondition() {

        app.getUserHelper().clickOkButton();
         app.getUserHelper().logOut();

    }


}
