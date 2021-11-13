package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    WebDriver wd;
    UserHelper userHelper;
    CarHelper car;

    public void init() {
        wd = new ChromeDriver();

        logger.info("Tests start on Chrome Driver");
        wd.manage().window().maximize();
        wd.navigate().to("https://ilcarro.xyz/search");
        wd.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        car = new CarHelper(wd);

    }

    public void stop() {
        logger.info("Test passed");
wd.quit();
    }


    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CarHelper getCar(){return car;}

}

