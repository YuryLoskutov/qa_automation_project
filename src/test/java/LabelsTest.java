import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Owner("Tester")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Задачи в репозитории")
    @Story("Создание новой задачи")
    @DisplayName("Проверка создания Issue для авторизированного пользователя")
    @Description(
            "Этот тест делает штуки...."
    )
    @Link(value = "Testing", url = "https://github.com")
    public void testAnnotatedLabels() {

    }

    @Test
    public void testDynamicLabels() {
        Allure.label("owner", "Tester");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.getLifecycle().updateTestCase(testCase -> testCase.setName("Проверка удаления Issue для авторизированного пользователя"));
        Allure.feature("Задачи в репозитории");
        Allure.story("Удаление новой задачи");
        Allure.description("Этот тест делает штуки....");
    }

    @Test
    public void testParameters() {
        Allure.parameter("Регион", "MO");
        Allure.parameter("Город", "Москва");
    }

}
