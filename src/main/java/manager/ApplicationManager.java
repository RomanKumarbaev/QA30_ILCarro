package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    WebDriver wd;
    UserHelper userHelper;
    CarHelper car;
    SearchHelper search;
    String browser;
    Properties properties;
    public ApplicationManager() {

        properties = new Properties();

    }


    public void init() throws IOException {
        wd = new ChromeDriver();
String target = System.getProperty("target","config");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

        logger.info("Tests start on Chrome Driver");
        wd.manage().window().maximize();
       // wd.navigate().to("https://ilcarro.xyz/search");

        wd.navigate().to(properties.getProperty("web.baseURL"));

        wd.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        userHelper = new UserHelper(wd);
        car = new CarHelper(wd);

        search = new SearchHelper(wd);

    }

    public void stop() {
        logger.info("Test passed");
wd.quit();
    }


    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CarHelper getCar(){return car;}

    public SearchHelper getSearch() {
        return search;
    }

    public String email(){
        return properties.getProperty("web.email");
    }

    public String password(){
        return properties.getProperty("web.password");
    }


}

