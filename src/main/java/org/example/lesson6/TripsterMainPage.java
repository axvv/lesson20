package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;


public class TripsterMainPage extends AbstractPage {
    private JavascriptExecutor js;

    @FindBy(css = ".menu-link")
    private WebElement buttonAboutProject;
    @FindBy(css = "body")
    private WebElement page;
    @FindBy(xpath = "//*[@class=\"js-more-about-faq button-line_gray\"]")
    private WebElement buttonShowMoreQuestions;

    @FindBy(css = "*[data-test=\"login-link\"]")
    private WebElement buttonEnter;
    @FindBy(css = "*[data-test=\"email\"]")
    private WebElement placeEmail;
    @FindBy(css = "*[data-test=\"password\"]")
    private WebElement placePassword;
    @FindBy(xpath = "//*[@class='checkbox']")
    private WebElement checkboxRemember;
    @FindBy(css = "*[data-test=\"submit\"]")
    private WebElement buttonSubmit;
    @FindBy(xpath = "//*[@data-test=\"destinations\"]")
    private WebElement buttonViewAllCities;
    @FindBy(xpath = "//a[contains(text(),'Калуга')]")
    private WebElement choiceKaluga;
    @FindBy(css = ".swiper-slide-next .header use")
    private WebElement slideTour;
    @FindBy(css = ".favorites .icon use")
    private WebElement iconFavoriteSlide;
    @FindBy(css = ".city:nth-child(1) .header use")
    private WebElement iconFavoriteHeader;
    @FindBy(css = ".welcome-reviews-slider > .slick-next > svg")
    private WebElement iconNext;
    @FindBy(css = ".welcome-reviews-slider > .slick-prev > svg")
    private WebElement iconPrev;
    @FindBy(css = ".welcome-howitworks-block:nth-child(1) .azure-link")
    private WebElement buttonSendRequest;
    @FindBy(css = ".white-line .new-button_green")
    private WebElement buttonOfferTour;
    @FindBy(css = ".js-submit-btn")
    private WebElement buttonRegister;
    @FindBy(css = ".welcome-press-block:nth-child(2) > .welcome-press-block__img")
    private WebElement buttonFORBS;


    public TripsterMainPage(WebDriver driver) {
        super(driver);
        this.js = (JavascriptExecutor) driver;


    }


    public TripsterMainPage clickButtonAboutProject() {
        //      клик по кнопке О проекте
        buttonAboutProject.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://experience.tripster.ru/about/"));
        return this;

    }

    public TripsterMainPage scrollToBottom(int scrollPixels) throws InterruptedException {
        // перемещаемся вниз на 4000 пикселей
        js.executeScript("window.scrollTo(0," + scrollPixels + ");", page);
        //        пауза
        Thread.sleep(1000);
        return this;
    }

    public TripsterMainPage clickButtonShowMoreQuestions() {
        //      клик по кнопке Показать больше вопросов
        buttonShowMoreQuestions.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://experience.tripster.ru/help_center/travelers/"));
        return this;
    }

    public TripsterMainPage clickButtonEnter() {
        //      клик по кнопке Войти
        buttonEnter.click();
        return this;
    }

    public TripsterMainPage clickPlaceEmail() {
        //      клик по полю email
        placeEmail.click();
        return this;
    }

    public TripsterMainPage enterPlaceEmail() {
        //      ввод почты в поле email
        placeEmail.sendKeys("agbmu@mailto.plus");
        return this;
    }

    public TripsterMainPage enterPlacePassword() {
        //      ввод пароля в поле password
        placePassword.sendKeys("XXC922XX");
        return this;
    }

    public TripsterMainPage clickCheckboxRemember() {
        //      клик по чекбоксу Запомнить
        checkboxRemember.click();
        return this;
    }

    public TripsterMainPage clickButtonSubmit() {
        //      клик по кнопке Отправить
        buttonSubmit.click();
        return this;
    }

    public TripsterMainPage clickButtonViewAllCities() {
        //      клик по кнопке Посмотреть все города
        buttonViewAllCities.click();
        return this;
    }

    public TripsterMainPage clickChoiceKaluga() {
        //      клик по Калуга
        choiceKaluga.click();
        return this;
    }

    public TripsterMainPage clickSlideTour() {
        //      клик по слайду с экскурсией
        slideTour.click();
        return this;
    }

    public TripsterMainPage clickIconFavoriteSlide() {
        //      клик по иконке Избранное на слайде
        iconFavoriteSlide.click();
        return this;
    }

    public TripsterMainPage clickIconFavoriteHeader() {
        //      клик по иконке Избранное на хедере
        iconFavoriteHeader.click();
        return this;
    }

    public TripsterMainPage clickIconNext() {
        //      клик по иконке Следующий на слайде Отзывы
        iconNext.click();
        return this;
    }

    public TripsterMainPage clickIconPrev() {
        //      клик по иконке Предыдущий на слайде Отзывы
        iconPrev.click();
        return this;
    }

    public TripsterMainPage clickButtonSendRequest() {
        //      клик по кнопке Оставьте заявку
        buttonSendRequest.click();
        return this;
    }

    public TripsterMainPage clickButtonOfferTour() {
        //      клик по кнопке Предложить экскурсию
        buttonOfferTour.click();
        return this;
    }

    public TripsterMainPage clickButtonRegister() {
        //      клик по кнопке Зарегистрироваться
        buttonRegister.click();
        return this;
    }

    public TripsterMainPage clickButtonFORBS() {
        //        клик по кнопке Forbs
        buttonFORBS.click();
        return this;
    }

    public TripsterMainPage changeWindow() {
        // Получаем текущий идентификатор окна
        String currentWindowHandle = getDriver().getWindowHandle();
        // Получаем список идентификаторов всех открытых окон
        Set<String> allWindowHandles = getDriver().getWindowHandles();
// Проходим по списку идентификаторов и переключаемся на окно Forbs
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                getDriver().switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }
}
