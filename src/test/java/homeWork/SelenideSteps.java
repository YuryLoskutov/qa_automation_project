package homeWork;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideSteps {
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

    private void closeWebDriver() {
    }

    @Test
    void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        $("[data-test-selector='nav-search-input']").click();
        $("[data-test-selector='nav-search-input']").sendKeys(REPOSITORY);
        $("[data-test-selector='nav-search-input']").submit();

        $(byLinkText("YuryLoskutov/qa_automation_project")).click();

        $(By.partialLinkText("Issue")).click();

    }
}
