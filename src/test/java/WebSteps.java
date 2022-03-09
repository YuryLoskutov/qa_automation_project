import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Отрываем главную страницую")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий + {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Открываем репозиторий {repo}")
    public void openRepository(String repo) {
        $(By.linkText(repo)).click();
    }

    @Step("Переходим в таб Issues")
    public void openIssueTab() {
        $(By.partialLinkText("Issues")).click();

    }

    @Step("Проверяем, что существует Issue с номером {num}")
    public void shouldSeeIssueWithNumber(int num) {
        $(withText("#68")).should(Condition.exist);
    }
}
