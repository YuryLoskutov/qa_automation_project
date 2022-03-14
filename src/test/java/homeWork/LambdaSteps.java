package homeWork;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaSteps {
    private static final String REPOSITORY = "YuryLoskutov/qa_automation_project";

    @BeforeAll
    static void beforeAll() {
        baseUrl = "https://github.com";
    }

    @BeforeEach
    void beforeEach() {
        open(baseUrl);
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

    @Test
    public void lambdaSteps() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open the main page", () -> {
            open(baseUrl);
        });

        step("Search for repo " + REPOSITORY, () -> {
            $("[data-test-selector='nav-search-input']").click();
            $("[data-test-selector='nav-search-input']").sendKeys(REPOSITORY);
            $("[data-test-selector='nav-search-input']").submit();
        });

        step("Open repo " + REPOSITORY, () -> {
            $(byLinkText("YuryLoskutov/qa_automation_project")).click();
        });

        step("Checking for the Issue tab", () -> {
            $(By.partialLinkText("Issue")).click();
            Allure.addAttachment("Page Source", "text/html", WebDriverRunner.source(), "html");
        });

    }
}
