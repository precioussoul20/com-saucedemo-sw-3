package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //1.1 Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        //1.2 Enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");
        //1.3 Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //1.4 Verify the text “PRODUCTS”
        verifyText("Products",getTextFromElement(By.xpath("//span[contains(text(),'Products')]")));

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //2.1 Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        //2.2 Enter “secret_sauce” password
        sendTextToElement(By.id("password"),"secret_sauce");
        //2.3 Click on ‘LOGIN’ button
        clickOnElement(By.id("login-button"));
        //2.4 Verify that six products are displayed on page
        List<WebElement> productsDisplayed = driver.findElements(By.className("inventory_item"));
        int number = productsDisplayed.size();
        System.out.println("Number of Products Displayed on Page : " + number);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
