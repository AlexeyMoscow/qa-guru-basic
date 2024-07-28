package tests.allure;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TestsWithLambdaSteps {

    private static final String REPOSITORY = "AlexeyMoscow";

    @Test
    public void lambdaStepTest() {
        step("Открытие страницы", () -> Selenide.open("https://www.github.com"));
        step("Поиск репозитория в поисковой строке", () ->
        {
            $(".search-input").click();
            $("#query-builder-test").setValue(REPOSITORY).submit();
        });
        step("Открыть вкладку 'Issues'", () -> $(withText("Issues")).click());
        step("Проверить количество Issue", () -> $(withText("Your search did not match any issues")));
    }
}
