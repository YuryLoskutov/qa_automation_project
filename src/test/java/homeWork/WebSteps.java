package homeWork;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;


public class WebSteps {
    @Step("Find repo {repo}")
    public void searchForRepository(String repo) {
        $("[data-test-selector='nav-search-input']").click();
        $("[data-test-selector='nav-search-input']").sendKeys(repo);
        $("[data-test-selector='nav-search-input']").submit();
    }

    @Step("Open repo {repo}")
    public void openRepository(String repo) {
        $(byLinkText(repo)).click();
    }

    @Step("Open the Issue tab")
    public void openIssueTab(String repo) {
        $(By.partialLinkText(repo)).click();
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
