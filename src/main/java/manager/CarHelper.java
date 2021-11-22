package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CarHelper extends HelperBase{


    public CarHelper(WebDriver wd) {
        super(wd);
    }


    public void openCarForm() {
        click(By.id("1"));
    }

    public void fillCarForm(Car car) {
       if (isCarCreationFormPresent()){

        typeLocation(car.getAddress());
        type(By.id("make"),car.getMake());
        type(By.id("model"),car.getModel());
        type(By.id("year"),car.getYear());
        type(By.id("engine"),car.getEngine());


        select(By.id("fuel"),car.getFuel());
        select(By.id("gear"),car.getGear());
        select(By.id("wheelsDrive"),car.getWD());

        type(By.id("doors"), car.getDoors());
        type(By.id("seats"), car.getSeats());
        type(By.id("class"), car.getClasS());
        type(By.id("fuelConsumption"),car.getFuelConsumption());
        type(By.id("serialNumber"), car.getCarRegNumber());
        type(By.id("price"), car.getPrice());
        type(By.id("distance"),car.getDistanceIncluded());
        type(By.cssSelector(".feature-input"), car.getTypeFeature());
        type(By.id("about"), car.getAbout());

       }

    }

    public void select(By locator, String option) {

        new Select(wd.findElement(locator)).selectByValue(option);


    }

    private void typeLocation(String address) {
        type(By.id("pickUpPlace"),address);
        click(By.cssSelector("div.pac-item"));
        pause(1000);

    }

    private boolean isCarCreationFormPresent() {

        Boolean isForm = new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .textToBePresentInElement(wd.findElement(By.cssSelector("h2")), "Write some details about your car to rent it out"));

        return isForm;

    }

    public void attachedPhoto(String link) {
        wd.findElement(By.id("photos"))
                .sendKeys("C:\\QA30\\QA30_ILCarro\\5052746996.jpg");
    }

    public boolean isCarAdded() {
        pause(5000);
        return wd.findElements(By.xpath("//h1[.='Car added']")).size() > 0;

    }




    public boolean isCarSearch() {
        if(wd.findElements(By.xpath("//div[@class='cars-container ng-star-inserted']")).size()>0){
            return true;
        } else return false;
    }
}
