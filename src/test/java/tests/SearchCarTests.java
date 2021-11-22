package tests;

import models.Search;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase {


    @Test
    public void searchWithSendKeyCarPositiveTest() {

        Search rent = Search.builder()
                .city("Ulan-Ude")
                .dateFrom("12/02/2021")
                .dateTo("12/24/2021")
                .build();
        app.getSearch().fillSearchCarForm(rent);
        app.getUserHelper().submitForm();

        app.getUserHelper().pause(5000);

        Assert.assertTrue(app.getCar().isCarSearch());
    }

    @Test
    public void searchTest() {

        app.getSearch().fillSearchForm("Haifa", "11/30/2021", "06/30/2022");
        app.getUserHelper().submitForm();

        app.getSearch().pause(5000);

        Assert.assertTrue(app.getSearch().isListOfCarsAppeared());
    }

    @AfterMethod
    public void returnToMainPage() {

        app.getSearch().click(By.cssSelector(".logo"));
    }

}
