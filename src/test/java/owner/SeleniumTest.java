package owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import owner.config.WebDriverProvider;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTest {

    private WebDriver driver = new WebDriverProvider().get();

    @Test
    public void testGithubTitle() {

        //Код выполнения теста
        String title = driver.getTitle();
        assertEquals(title, "GitHub: Where the world builds software · GitHub");
        driver.quit();
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }
}
