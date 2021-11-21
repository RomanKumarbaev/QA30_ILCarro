package tests;

import models.Car;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{

//    @BeforeMethod
//    public void precondition(){
//
//        if (app.getUserHelper().isLogInPresent()) {
//            app.getUserHelper().login(new User().withEmail("wew@gmail.com").withPassword("Ar12345$"));
//        }
//
//
//    }

    @Test
    public void searchWithSendKeyCarPositiveTest(){

      Car rent = Car.builder()
              .address("Ulan-Ude")
              .rentDay("11/22/2021 - 11/24/2021")
              .build();

      app.getCar().openSearchForm();
      app.getCar().fillSearchCarForm(rent);


      app.getCar().touchSabmit();

      app.getCar().pause(5000);

      Assert.assertTrue(app.getCar().isCarSearch());
    }

    @Test
    public void searchTest(){
        app.getSearch().fillSearchForm("Haifa","11/25/2021","12/30/2021");


        app.getUserHelper().submitForm();

        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @AfterMethod
    public void returnToMainPage(){

        app.getSearch().click(By.xpath("//div[@class='header']//img[@alt='logo']"));
    }

}
