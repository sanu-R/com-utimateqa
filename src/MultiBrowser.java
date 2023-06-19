import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    static String browser = "edge";
    static String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        //1 Setup multi browser

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Invalid Input");
        }
        //2. Open URL
        driver.get(baseUrl);

        //Maximize screen
        driver.manage().window().maximize();

        //Implicit wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Print the title of the page
        System.out.println("Page title is : " + driver.getTitle());

        //4. Print  the current url
        System.out.println("Current url is ; " + driver.getCurrentUrl());

        //5. Print the page source
        System.out.println("Page source is : " + driver.getPageSource());

        //6.Enter the email to email field
        // find the email element
        WebElement emailField = driver.findElement(By.name("user[email]"));

        // Action is to type email
        emailField.sendKeys("rell123@gmail.com");

        //7. Enter the password to password field
        // Find the password element
        WebElement passwordField = driver.findElement(By.id("user[password]"));

        //Action is to type password
        passwordField.sendKeys("rail123");

        //Hold Screen
        Thread.sleep(2000);

        //8. Close the browser
        driver.close();


    }
}
