package tests;

import manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {


   protected static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);


    @BeforeSuite

    public void setUp() throws IOException {
        app.init();


    }

    @AfterSuite

    public void tearDown() {
        app.stop();
    }
}
