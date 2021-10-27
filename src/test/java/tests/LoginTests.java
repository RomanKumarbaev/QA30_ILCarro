package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

@Test
    public void test(){

    String email = "wew@gmail.com";
    String password = "Ar12345$";

    app.getUserHelper().click(By.xpath("//a[@class='navigation-link'][normalize-space()='Log in']"));
    app.getUserHelper().fillLoginForm(email,password);
    app.getUserHelper().click(By.xpath("//button[contains(text(),'Y’alla!')]"));




}



}
