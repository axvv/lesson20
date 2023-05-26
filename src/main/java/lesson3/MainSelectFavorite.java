package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class MainSelectFavorite {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://experience.tripster.ru");
//        перемещаемся вниз на 700 пикселей
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,700);");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        выбираем направление тура

        WebElement webElement1 = driver.findElement(By.xpath("//*[@data-test=\'destinations\']"));

        webElement1.click();


//        выбираем из списка Калугу
        WebElement webElement2 = driver.findElement(By.xpath("//a[contains(text(),'Калуга')]"));
        webElement2.click();

//        перемещаемся вниз на 314 пикселей

        js.executeScript("window.scrollTo(0,314);");

//        выбираем экскурсию
        WebElement webElement3 = driver.findElement(By.cssSelector(".swiper-slide-next .header use"));
        webElement3.click();
//      перемещаемся в начало страницы и пауза
        js.executeScript("window.scrollTo(0,0);");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//      клик по иконке избранное на слайде
        WebElement webElement4 = driver.findElement(By.cssSelector(".favorites .icon use"));
        webElement4.click();
//      клик по иконке Мзбранное в хедере
        WebElement webElement5 = driver.findElement(By.cssSelector(".city:nth-child(1) .header use"));
        webElement5.click();
//      клик по иконке Мзбранное на слайде
        WebElement webElement6 = driver.findElement(By.cssSelector(".logo-img:nth-child(3)"));
        webElement6.click();

        //Завершаем работу с ресурсом
        driver.quit();
    }
}


