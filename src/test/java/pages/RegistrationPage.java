package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;
import pages.enams.Gender;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    Calendar calendar = new Calendar();
    private final SelenideElement registrationFrom = $("#userForm");
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderRadioButton = $("#genterWrapper");
    private final SelenideElement phoneInput = $("#userNumber");
    private final SelenideElement calendarInput = $("#dateOfBirthInput");
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbies = $("#hobbiesWrapper");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateDropDown = $("#state");
    private final SelenideElement cityDropDown = $("#city");
    private final SelenideElement submitButton = $("#submit");

    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        registrationFrom.shouldBe(visible);
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage setGender(Gender sex) {
        genderRadioButton.$(byText(sex.getTitle())).click();
        return this;
    }

    public RegistrationPage setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbie) {
        hobbies.$(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage uploadPicture(String picture) {
        uploadPicture.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage setState(String state) {
        stateDropDown.click();
        stateDropDown.$(byText(state)).click();
        return this;
    }

    public RegistrationPage setCity(String city) {
        cityDropDown.click();
        cityDropDown.$(byText(city)).click();
        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public void verifyFormFieldsValidated() {
       registrationFrom.shouldHave(attribute("class", "was-validated"));
    }

}
