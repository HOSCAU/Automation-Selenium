package loginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class Introduction {

    public static void main(String[] args) {

        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased wait time

        // Define credentials and search term
        String email = "adityars1673@gmail.com";
        String password = "Aditya789@";
        String searchTerm = "Frontend";

        try {
            // Open login page
            driver.get("https://www.intervue.io/login");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Enter email
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Work email']")));
            emailField.sendKeys(email);

            // Enter password
            WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            passwordField.sendKeys(password);

            // Click login button using JavaScript to avoid interception
            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

            // Wait for the correct URL or element after login
            wait.until(ExpectedConditions.urlContains("profile/interviews"));

            // Handle any modal or overlay if present
            try {
                WebElement modalCloseBtn = driver.findElement(By.xpath("//button[contains(@class,'close-modal')]"));
                if (modalCloseBtn.isDisplayed()) {
                    modalCloseBtn.click();
                    System.out.println("Modal closed successfully.");
                }
            } catch (Exception e) {
                System.out.println("No modal found, continuing...");
            }

            // Wait for and click "Request Interview" button
            WebElement requestInterviewBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(., 'Request Interview')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", requestInterviewBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", requestInterviewBtn);
            System.out.println("✅ Clicked 'Request Interview' button.");

            // Wait for the search box to appear
            WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search profile']")));
            searchBox.sendKeys(searchTerm);
            System.out.println("✅ Entered search term: " + searchTerm);

            // Click the search button
            WebElement searchButton = driver.findElement(By.xpath("//button[@type='button']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton);
            System.out.println("✅ Search button clicked successfully.");

            // Output mail, password, and search term
            System.out.println("✅ Email: " + email);
            System.out.println("✅ Password: " + password);
            System.out.println("✅ Search Term: " + searchTerm);

        } catch (Exception e) {
            System.out.println("❗An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
