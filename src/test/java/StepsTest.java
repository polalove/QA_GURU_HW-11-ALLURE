import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest extends TestBase {

    public static final String REPOSITORY = "polalove/QA_GURU_HW-3";
    public static final int ISSUES = 1;

    @Test
    void LambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главуню страницу GitHub", () -> {
            open("");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });

        step("Кликаем по ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем таб Issues " + REPOSITORY, () -> {
            $("#issues-tab").click();
        });

        step("Проверям наличие Issues с номером " + ISSUES, () -> {
            $(withText("#" + ISSUES)).should(Condition.exist);
        });
    }

    @Test
    public void annotatedStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUES);
    }
}