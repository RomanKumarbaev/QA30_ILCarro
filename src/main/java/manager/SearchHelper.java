package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class SearchHelper extends HelperBase{
    public SearchHelper(WebDriver wd) {
        super(wd);
    }


    public void fillSearchForm(String city, String from, String to) {

        fillInputCity(city);
        selectPeriod(from,to);

    }

    private void selectPeriod(String from, String to) {
      //11/25/2021","12/30/2021"

     String [] dataFrom = from.split("/");
     String [] dataTo = to.split("/");

     click(By.id("dates"));

     int diffStart = 0;

     if(LocalDate.now().getMonthValue()!= Integer.parseInt(dataFrom[0])){

         diffStart = Integer.parseInt(dataFrom[0])-LocalDate.now().getMonthValue();
     }

     int diff=0;
      if(Integer.parseInt(dataFrom[0]) != Integer.parseInt(dataTo[0]) ){

          diff = Integer.parseInt(dataTo[0])-Integer.parseInt(dataFrom[0]);
      }

        for (int i = 0; i < diffStart; i++) {

            click(By.xpath("//button[@aria-label='Next month']"));

        }
        String locator = String.format("//div[.=' %s ']",dataFrom[1]);
        click(By.xpath(locator));

        for (int i = 0; i < diff; i++) {

            click(By.xpath("//button[@aria-label='Next month']"));

        }
        String locator2 = String.format("//div[.=' %s ']",dataTo[1]);

        click(By.xpath(locator2));



    }

    private void fillInputCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector("div.pac-item"));
        pause(500);
    }

    public boolean isListOfCarsAppeared() {
        if(wd.findElements(By.xpath("//div[@class='cars-container ng-star-inserted']")).size()>0){
            return true;
        } else return false;
    }
}
