package Elements;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavbarElementFetcher {

    public static void main(String[] args) {
        
        // Initialize Chrome browser
        WebDriver driver = new ChromeDriver();

        try {
            // Open the target website
            driver.get("https://www.intervue.io/");

            // Maximize the window
            driver.manage().window().maximize();

            // Page load wait
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));

            // Explicit wait for elements to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> navbarElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("span")));

            // Iterate through elements and fetch required values
            for (int i = 0; i < navbarElements.size(); i++) {
                try {
                    // Refetch element to avoid stale element
                    WebElement element = navbarElements.get(i);
                    String text = element.getText();

                    // Check and print matching elements
                    if (text.equals("Products") || text.equals("Solutions") ||
                        text.equals("Pricing") || text.equals("Resources") ||
                        text.equals("Contact us")) {
                        System.out.println("Element Found: " + text);
                    }
                } catch (org.openqa.selenium.StaleElementReferenceException e) {
                    System.out.println("Stale element encountered. Refetching the element...");
                    navbarElements = driver.findElements(By.tagName("span"));  // Refetch elements
                    i--; // Retry the same index
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

