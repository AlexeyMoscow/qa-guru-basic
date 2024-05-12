package pages.components;

import com.codeborne.selenide.SelenideElement;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreatedUserFrom extends BaseTest {
    private final SelenideElement createdUserData = $(".table-responsive");

    public CreatedUserFrom verifyCreatedUserData(String key, String value) {
        createdUserData.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public void nonSuccessRegistration (){
        createdUserData.shouldNotBe(visible);
    }
}
