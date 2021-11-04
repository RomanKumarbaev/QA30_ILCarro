package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {

    @BeforeMethod
    public void precondition() {

        if (app.getUserHelper().isLogInPresent()) {
            app.getUserHelper().login(new User().withEmail("wew@gmail.com").withPassword("Ar12345$"));
        }


    }


    @Test
    public void addNewCarTestPositive() {

        int i=(int)((System.currentTimeMillis()/1000)%3600);

        Car car = Car.builder()
                .address("Tel Aviv")
                .make("BMW")
                .model("M5")
                .year("2020")
                .engine("2.3")
                .fuel("Petrol")
                .gear("MT")
                .wD("RWD")
                .doors("5")
                .seats("4")
                .clasS("c")
                .fuelConsumption("6.5")
                .carRegNumber("100-55-"+i)
                .price("65")
                .distanceIncluded("500")
                .typeFeature("type of")
                .about("Very nice Car")
                .build();
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachedPhoto("C:\\QA30\\QA30_ILCarro\\auto.jpeg");
       app.getUserHelper().submitForm();
        Assert.assertTrue(app.getCar().isCarAdded());


    }


    @Test
    public void addNewCarTestPositive2() {

        int i=(int)((System.currentTimeMillis()/1000)%3600);

        Car car = Car.builder()
                .address("Ulan-Ude")
                .make("Lada")
                .model("OKA")
                .year("1992")
                .engine("1.4")
                .fuel("Petrol")
                .gear("SMT")
                .wD("AWD")
                .doors("5")
                .seats("5")
                .clasS("cheap")
                .fuelConsumption("6.5")
                .carRegNumber("100-55-"+i)
                .price("10")
                .distanceIncluded("100")
                .typeFeature("type of")
                .about("Good car")
                .build();
        app.getCar().openCarForm();
        app.getCar().fillCarForm(car);
        app.getCar().attachedPhoto("C:\\QA30\\QA30_ILCarro\\5052746996.jpg");
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getCar().isCarAdded());


    }

    @AfterMethod
    public void postConditions(){
        app.getUserHelper().logOutAfterTest();
    }





}
