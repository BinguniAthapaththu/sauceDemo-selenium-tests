import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumDemo {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "D:\\Downloads\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();

        // Test Case 1: Login Verification
        validLogin(driver, "standard_user", "secret_sauce");

    }

    public static void validLogin(WebDriver driver, String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordFeild = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys(username);
        passwordFeild.sendKeys(password);
        loginButton.click();

        if(driver.getTitle().equals("Swag Labs")){
            System.out.println("Test Case 1 Pass");
        }
        else{
            System.out.println("Test Case 1 Fail");
        }
    }


}
