import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest extends TestBase {

    @Test
    void issueSearchTest() {
        open("");
        $(".search-input").click();
        $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUES)).should(Condition.exist);
    }
}