package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class TripsterMainPageTest extends AbstractTest {
    @Test
//    test-1
    void mainAboutProjectTest() throws InterruptedException {
        TripsterMainPage tripsterMainPage = new TripsterMainPage(getWebDriver());
        tripsterMainPage
                .clickButtonAboutProject()
                .scrollToBottom(4000)
                .clickButtonShowMoreQuestions();
        // проверяем, что открылась требуемая страница
        Assertions.assertEquals("Помощь путешественникам", getWebDriver().getTitle(), "Не та страница");
    }

    @Test
//    test-2
    void mainAuthorizationTest() throws InterruptedException {
        TripsterMainPage tripsterMainPage = new TripsterMainPage(getWebDriver());
        tripsterMainPage
                .clickButtonEnter()
                .clickPlaceEmail()
                .enterPlaceEmail()
                .enterPlacePassword()
                .clickCheckboxRemember()
                .clickCheckboxRemember()
                .clickButtonSubmit();
        // проверяем, что на странице есть элемент авторизации пользователя
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//*[@class=\"user-menu__name\"]")), "Элемент не найден на странице");
    }

    @Test
//    test-3
    void mainSelectFavoriteTest() throws InterruptedException {
        TripsterMainPage tripsterMainPage = new TripsterMainPage(getWebDriver());
        tripsterMainPage
                .scrollToBottom(700)
                .clickButtonViewAllCities()
                .clickChoiceKaluga()
                .scrollToBottom(300)
                .clickSlideTour()
                .scrollToBottom(0)
                .clickIconFavoriteSlide()
                .clickIconFavoriteHeader();

// проверяем, что в избранном пусто
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//*[@class=\"description\"][contains(text(),\"пока пуст\")]")), "Элемент не найден на странице");
    }

    @Test
        //    test-4
    void mainSurfingReviewsTest() throws InterruptedException {
        TripsterMainPage tripsterMainPage = new TripsterMainPage(getWebDriver());
        tripsterMainPage
                .scrollToBottom(4000)
                .clickIconNext()
                .clickIconNext()
                .clickIconNext()
                .clickIconNext()
                .clickIconNext()
                .clickIconPrev()
                .clickIconPrev()
                .clickIconPrev()
                .clickIconPrev()
                .clickIconPrev()
                .clickIconPrev();

// проверяем, что открыт нужный блок
        Assertions.assertNotNull(getWebDriver().findElement(By.xpath("//*[@class=\"welcome-title\"][contains(text(),'Отзывы путешественников')]")), "Элемент не найден на странице");

    }

    @Test
        //    test-5
    void mainBecomeGuideTest() throws InterruptedException {
        TripsterMainPage tripsterMainPage = new TripsterMainPage(getWebDriver());
        tripsterMainPage
                .scrollToBottom(4000)
                .clickButtonSendRequest()
                .scrollToBottom(5500)
                .clickButtonOfferTour()
                .clickButtonRegister();

        // проверяем, что открыта страница Регистрация
        Assertions.assertEquals("Регистрация", getWebDriver().getTitle(), "Не та страница");
    }
    @Test
        //    test-6
    void mainJumpToForbsTest() throws InterruptedException {
        TripsterMainPage tripsterMainPage = new TripsterMainPage(getWebDriver());
        tripsterMainPage
                .scrollToBottom(3500)
                .clickButtonFORBS()
                .changeWindow();

        // проверяем, что открыта страница Forbs
        Assertions.assertEquals("Нестандартный маршрут: как сервис Tripster зарабатывает на гидах-любителях | Forbes.ru", getWebDriver().getTitle(), "Не та страница");

    }
}

