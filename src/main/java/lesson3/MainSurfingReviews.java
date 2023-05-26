package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MainSurfingReviews {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.get("https://experience.tripster.ru");
        //        перемещаемся вниз на 4000 пикселей
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,4000);");
//        пауза
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      клик по кнопке Вперёд слайдера отзывов
        WebElement webElement1 = driver.findElement(By.cssSelector(".welcome-reviews-slider > .slick-next > svg"));

        webElement1.click();
        webElement1.click();
        webElement1.click();
        webElement1.click();
        webElement1.click();
        webElement1.click();
        webElement1.click();
//      клик по кнопке Назад слайдера отзывов
        WebElement webElement2 = driver.findElement(By.cssSelector(".welcome-reviews-slider > .slick-prev > svg"));

        webElement2.click();
        webElement2.click();
        webElement2.click();
        webElement2.click();
        webElement2.click();
        webElement2.click();
        webElement2.click();

        //Завершаем работу с ресурсом
        driver.quit();
    }
}

