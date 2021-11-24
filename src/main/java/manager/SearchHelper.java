package manager;

import models.Car;
import models.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDate;

public class SearchHelper extends HelperBase {
    public SearchHelper(WebDriver wd) {
        super(wd);
    }


    public void fillSearchForm(String city, String from, String to) {

        fillInputCity(city);
        selectPeriod(from, to);

    }

    private void selectPeriod(String from, String to) {

        String[] dataFrom = from.split("/");
        String[] dataTo = to.split("/");

        int diffStart = 0;
        int diff = 0;

        click(By.id("dates"));

        if ((LocalDate.now().getYear() == Integer.parseInt(dataFrom[2])) && (LocalDate.now().getYear() == Integer.parseInt(dataTo[2]))) {

            if (LocalDate.now().getMonthValue() != Integer.parseInt(dataFrom[0])) {

                diffStart = Integer.parseInt(dataFrom[0]) - LocalDate.now().getMonthValue();
            }

            if (Integer.parseInt(dataFrom[0]) != Integer.parseInt(dataTo[0])) {

                diff = Integer.parseInt(dataTo[0]) - Integer.parseInt(dataFrom[0]);
            }

            for (int i = 0; i < diffStart; i++) {

                click(By.xpath("//button[@aria-label='Next month']"));

            }
            String locator = String.format("//div[.=' %s ']", dataFrom[1]);
            click(By.xpath(locator));

            for (int i = 0; i < diff; i++) {

                click(By.xpath("//button[@aria-label='Next month']"));

            }
            String locator2 = String.format("//div[.=' %s ']", dataTo[1]);

            click(By.xpath(locator2));
        }

        if ((Integer.parseInt(dataFrom[2]) == Integer.parseInt(dataTo[2])) && (Integer.parseInt(dataFrom[2]) != LocalDate.now().getYear())) {

            diffStart = (12 - LocalDate.now().getMonthValue()) + Integer.parseInt(dataFrom[0]);

            for (int i = 0; i < diffStart; i++) {

                click(By.xpath("//button[@aria-label='Next month']"));

            }
            String locator = String.format("//div[.=' %s ']", dataFrom[1]);
            click(By.xpath(locator));

            diff = Integer.parseInt(dataTo[0]) - Integer.parseInt(dataFrom[0]);

            for (int i = 0; i < diff; i++) {

                click(By.xpath("//button[@aria-label='Next month']"));

            }
            String locator2 = String.format("//div[.=' %s ']", dataTo[1]);

            click(By.xpath(locator2));
        }

        if ((Integer.parseInt(dataFrom[2]) == LocalDate.now().getYear()) && (Integer.parseInt(dataTo[2]) != LocalDate.now().getYear())) {

            diffStart = Integer.parseInt(dataFrom[0]) - LocalDate.now().getMonthValue();

            for (int i = 0; i < diffStart; i++) {

                click(By.xpath("//button[@aria-label='Next month']"));

            }
            String locator = String.format("//div[.=' %s ']", dataFrom[1]);
            click(By.xpath(locator));

            diff = (12 - Integer.parseInt(dataFrom[0])) + Integer.parseInt(dataTo[0]);

            for (int i = 0; i < diff; i++) {

                click(By.xpath("//button[@aria-label='Next month']"));

            }
            String locator2 = String.format("//div[.=' %s ']", dataTo[1]);

            click(By.xpath(locator2));

        }


    }

    public void fillSearchCarForm(Search rent) {

        typeLocationCarSearch(rent.getCity());

        click(By.id("dates"));
        new Actions(wd).sendKeys(Keys.ESCAPE).perform();
        new Actions(wd).sendKeys(Keys.CONTROL + "A").perform();
        type(By.id("dates"), rent.getDateFrom() + " - " + rent.getDateTo());
        new Actions(wd).sendKeys(Keys.ESCAPE).perform();


    }

    private void typeLocationCarSearch(String address) {

        type(By.id("city"), address);
        click(By.cssSelector("div.pac-item"));
        pause(1000);

    }

    private void fillInputCity(String city) {
        type(By.id("city"), city);
        click(By.cssSelector("div.pac-item"));
        pause(500);
    }

    public boolean isListOfCarsAppeared() {
        if (wd.findElements(By.xpath("//div[@class='cars-container ng-star-inserted']")).size() > 0) {
            return true;
        } else return false;
    }
}
