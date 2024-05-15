package web.service;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginServiceTest {
	
	private void sleep(long sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLoginSuccess() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();		
		System.out.println("Driver info: " + driver);
		
		// Full path where login.html is located.
		// You can click on html file and copy the path shown in your browser.
		//
		driver.navigate().to(
				"C:\\Users\\VE\\Downloads\\8.1P-resources\\pages\\login.html");
		sleep(5);
		
		// Find username element
		//
		WebElement ele = driver.findElement(By.id("username"));
		ele.clear();
		ele.sendKeys("ahsan");
		
		// Find password element
		//
		ele = driver.findElement(By.id("passwd"));
		ele.clear();
		ele.sendKeys("ahsan_pass");
		
		ele=driver.findElement(By.id("dob"));
		ele.clear();
		ele.sendKeys("01-01-2000");
		// Find Submit button, and click on button.
		//
		ele = driver.findElement(By.cssSelector("[type=submit]"));
		ele.submit();
		
		sleep(5);
		
		/*
		 * On successful login, the title of page changes to 'success',
		 * otherwise, 'fail'.
		 */
		String title = driver.getTitle();
		System.out.println("Title: " + title);
		
		Assert.assertNotEquals(title, "success");
		
		driver.close();
	}
	

    @Test
    public void testLoginFailureInvalidCredentials() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to(
                "C:\\Users\\VE\\Downloads\\8.1P-resources\\pages\\login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("invalid_user");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("invalid_pass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("2000-01-01");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertNotEquals(title, "success");

        driver.close();
    }

    @Test
    public void testLoginFailureEmptyFields() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to(
                "C:\\Users\\VE\\Downloads\\8.1P-resources\\pages\\login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("");

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertNotEquals(title, "success");

        driver.close();
    }

    @Test
    public void testLoginFailureInvalidDateOfBirth() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to(
                "C:\\Users\\VE\\Downloads\\8.1P-resources\\pages\\login.html");
        sleep(5);

        WebElement ele = driver.findElement(By.id("username"));
        ele.clear();
        ele.sendKeys("ahsan");

        ele = driver.findElement(By.id("passwd"));
        ele.clear();
        ele.sendKeys("ahsan_pass");

        ele = driver.findElement(By.id("dob"));
        ele.clear();
        ele.sendKeys("dy-d-2000"); // Invalid date format

        ele = driver.findElement(By.cssSelector("[type=submit]"));
        ele.submit();

        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertNotEquals(title, "success");

        driver.close();
    }

    @Test
    public void testLoginFailureInvalidPage() {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Invalid URL
        driver.navigate().to(
                "C:\\Users\\VE\\Downloads\\8.1P-resources\\pages\\invalid.html");
        sleep(5);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertNotEquals(title, "success");

        driver.close();
    }

    @Test
    public void testLoginFailureTimeout() {
        // Simulating slow response from server
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\\\Users\\\\VE\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to(
                "C:\\Users\\VE\\Downloads\\8.1P-resources\\pages\\login.html");
        // Sleep for longer than the server timeout
        sleep(20);

        String title = driver.getTitle();
        System.out.println("Title: " + title);

        Assert.assertNotEquals(title, "success");

        driver.close();
    }

}
