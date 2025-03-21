package Logout;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginLogoutTest {

    public static void main(String[] args) {

        // ✅ Set up ChromeDriver with WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // ✅ Open the login page
            driver.get("https://www.intervue.io/login");
            driver.manage().window().maximize();
            System.out.println("🔗 Navigated to Intervue.io login page");

            // ✅ Initialize WebDriverWait with 30 seconds timeout
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // ✅ Add a small delay to ensure the page is fully loaded
            Thread.sleep(3000);

            // ✅ Wait for the email field to be visible
            WebElement emailField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Work email']")));
            emailField.sendKeys("adityars1673@gmail.com");

            // ✅ Find and enter password
            WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            passwordField.sendKeys("Aditya789@");

            // ✅ Wait for the login button and scroll to it
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(normalize-space(),'Login with email')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);

            // ✅ Click using JavaScript to avoid interception
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
            System.out.println("✅ Login successful!");

            // ✅ Wait for the profile button (Aditya r s) to appear after login
            WebElement profileButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Aditya r s')]")));
            profileButton.click();
            System.out.println("👤 Profile dropdown clicked!");

            // ✅ Wait for the logout button and click it
            WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/logout')]")));
            logoutButton.click();
            System.out.println("🚪 Logout successful!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ✅ Quit the driver after execution
            driver.quit();
        }
    }
}
