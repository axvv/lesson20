package lesson3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainAboutProject {

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
//      клик по кнопке О проекте
        WebElement webElement1 = driver.findElement(By.cssSelector(".menu-link"));

        webElement1.click();

//        перемещаемся вниз на 4000 пикселей
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,4000);");
//        пауза
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//      клик по кнопке Показать больше вопросов
        WebElement webElement2 = driver.findElement(By.xpath("//*[@class=\"js-more-about-faq button-line_gray\"]"));

        webElement2.click();


        //Завершаем работу с ресурсом
        driver.quit();
    }
}