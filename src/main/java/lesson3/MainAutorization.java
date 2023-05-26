package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MainAutorization {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://experience.tripster.ru");

        WebElement webElement1 = driver.findElement(By.cssSelector("*[data-test=\"login-link\"]"));

        webElement1.click();



        WebElement webElement2 = driver.findElement(By.cssSelector("*[data-test=\"email\"]"));

        webElement2.click();
        WebElement webElement3 = driver.findElement(By.cssSelector("*[data-test=\"email\"]"));

        webElement3.sendKeys("agbmu@mailto.plus");
        WebElement webElement4 = driver.findElement(By.cssSelector("*[data-test=\"password\"]"));

        webElement4.sendKeys("XXC922XX");

        WebElement webElement5 = driver.findElement(By.xpath("//*[@class='checkbox']"));
        webElement5.click();

        webElement5.click();

        WebElement webElement6 = driver.findElement(By.cssSelector("*[data-test=\"submit\"]"));
        webElement6.click();

        //Завершаем работу с ресурсом
        driver.quit();
    }
}

