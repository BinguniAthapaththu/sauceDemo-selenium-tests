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

        // Test Case 2: AddToCartButton Verification
        addToCart(driver);

        // Test Case 3: RemoveFromCart Verification
        removeFromCart(driver);

        // Test Case 4: Logout Verification
        logout(driver);

        driver.close();
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

    public static void addToCart(WebDriver driver){
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();

        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));

        if(cartBadge.getText().equals("1")){
            System.out.println("Test Case 2 Pass");
        }
        else {
            System.out.println("Test Case 2 Fail");
        }
    }

    public static void removeFromCart(WebDriver driver){
        WebElement removeButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeButton.click();

        boolean isCartBadgePresent = driver.findElements(By.className("shopping_cart_badge")).isEmpty();

        if(isCartBadgePresent){
            System.out.println("Test Case 3 Pass");
        }
        else {
            System.out.println("Test Case 3 Fail");
        }
    }

    public static void logout(WebDriver driver){
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        menuButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));

        WebElement logOutButton = driver.findElement(By.id("logout_sidebar_link"));
        logOutButton.click();

        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/")){
            System.out.println("Test Case 4 Pass");
        }
        else {
            System.out.println("Test Case 4 Fail");
        }
    }
}
