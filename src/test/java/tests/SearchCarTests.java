package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{

    @BeforeMethod
    public void precondition(){

        if (app.getUserHelper().isLogInPresent()) {
            app.getUserHelper().login(new User().withEmail("wew@gmail.com").withPassword("Ar12345$"));
        }


    }

    @Test
    public void searchCarPositiveTest(){

      Car rent = Car.builder()
              .address("Ulan-Ude")
              .rentDay("11/20/2021 - 11/24/2021")
              .build();

      app.getCar().openSearchForm();
      app.getCar().fillSearchCarForm(rent);
//      app.getCar().pause(2000);

      app.getCar().touchSabmit();

      app.getCar().pause(5000);

      Assert.assertTrue(app.getCar().isCarSearch());


    }

}
