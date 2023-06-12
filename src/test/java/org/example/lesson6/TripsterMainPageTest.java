package lesson6;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import net.bytebuddy.build.Plugin;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;
import java.util.Set;

public class TripsterMainPageTest extends AbstractTest {
    @Test
    @DisplayName("Тест перехода в раздел О проекте")
    @Description("Тест скроллит до кнопки Переход в раздел Помощь путешественникам и кликает на неё с проверкой открывшейся страницы")
    @Link("https://experience.tripster.ru")
    @Severity(SeverityLevel.NORMAL)

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
    @DisplayName("Тест авторизации на сайте Трипстер")
    @Description("Тест кликает на кнопку Войти, заполняет поле логин и пароль, ставит и снимает отметку в чекбоксе Запомнить и кликает на кнопку Отправить. Выполняется проверка элемента авторизации на странице.")
    @Link("https://experience.tripster.ru")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Тест функционала Избранное")
    @Description("Тест скроллит до кнопки Показать все города, кликает на неё, выбирает город Калуга, скроллит до слайдов с экскурсиями, кликает на слайд, кликает на иконку Избранное на слайде, затем на иконку Избранное на хедере, проверяется что в избранном нет элементов")
    @Link("https://experience.tripster.ru")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Тест серфинга по отзывам туристов")
    @Description("Тест скроллит до блока Отзывы туристов, кликает на кнопку Следующий 5 раз, затем на кнопку Предыдущий 5 раз, проверяется что открыт блок Отзывы путешественников")
    @Link("https://experience.tripster.ru")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Тест раздела Стань гидом")
    @Description("Тест скроллит до блока Стань гидом, кликает на кнопку Отправить запрос, затем скроллит до кнопки Предложить тур, после клика на неё проверяется что открыта страница Регистрации")
    @Link("https://experience.tripster.ru")
    @Severity(SeverityLevel.NORMAL)
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
    @DisplayName("Тест перехода на сторонний сайт, ссылка на публикацию в Forbs")
    @Description("Тест скроллит до блока Публикации, кликает на кнопку FORBS, затем переходит в окно новой страницы, проверяется что открыта страница с публикацией в Forbs")
    @Link("https://experience.tripster.ru")
    @Severity(SeverityLevel.NORMAL)
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
    @Test
    @DisplayName("Логи браузера")
    @Description("Создаем логи")
    @Link("https://experience.tripster.ru")
    @Severity(SeverityLevel.MINOR)
    void testLogs(){
        LogEntries browserLogs = getWebDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
             if (allLogRows.size() > 0 ) {
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });

        }
    }
}

