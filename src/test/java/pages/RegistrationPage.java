package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.User;
import pages.components.Calendar;
import pages.enums.Gender;

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

    @Step("Открыть главную страницу")
    public void openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        registrationFrom.shouldBe(visible);
    }
    @Step("Заполнение формы - только обязательные поля")
    public void fillRegistrationFormWithMinimumData(User user) {
        setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setGenderFromRandom(user.getGender())
                .setPhone(user.getPhone())
                .submitForm();
    }
    @Step("Заполнение формы - все поля")
    public void fillRegistrationFormWitFullData(User user) {
        setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setGenderFromRandom(user.getGender())
                .setPhone(user.getPhone())
                .setDateOfBirth(user.getBirthDay(), user.getBirthMonth(), user.getBirthYear())
                .setSubject(user.getUserSubject())
                .setHobbies(user.getHobby())
                .uploadPicture(user.getPicture())
                .setAddress(user.getAddress())
                .setState(user.getState())
                .setCity(user.getCity())
                .submitForm();
    }


    @Step("Заполнение поля Имя - {firstName}")
    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }
    @Step("Заполнение поля Фамилия - {lastName}")
    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }
    @Step("Заполнение поля Email - {email}")
    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }
    @Step("Заполнение поля Пол - {sex}")
    public RegistrationPage setGender(Gender sex) {
        genderRadioButton.$(byText(sex.getTitle())).click();
        return this;
    }
    @Step("Заполнение поля Пол - {sex}")
    public RegistrationPage setGenderFromRandom(String sex) {
        genderRadioButton.$(byText(sex)).click();
        return this;
    }
    @Step("Заполнение поля Телефон - {phone}")
    public RegistrationPage setPhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }
    @Step("Заполнение поля DOB")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendar.setDate(day, month, year);
        return this;
    }
    @Step("Заполнение поля subject - {subject}")
    public RegistrationPage setSubject(String subject) {
        subjectInput.setValue(subject).pressEnter();
        return this;
    }
    @Step("Заполнение поля Хобби - {hobbie}")
    public RegistrationPage setHobbies(String hobbie) {
        hobbies.$(byText(hobbie)).click();
        return this;
    }
    @Step("Загрузка картинки")
    public RegistrationPage uploadPicture(String picture) {
        uploadPicture.uploadFromClasspath(picture);
        return this;
    }
    @Step("Заполнение поля Адрес - {address}")
    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);
        return this;
    }
    @Step("Заполнение поля state - {state}")
    public RegistrationPage setState(String state) {
        stateDropDown.click();
        stateDropDown.$(byText(state)).click();
        return this;
    }
    @Step("Заполнение поля город - {city}")
    public RegistrationPage setCity(String city) {
        cityDropDown.click();
        cityDropDown.$(byText(city)).click();
        return this;
    }
    @Step("Нажать кнопку - Submit")
    public void submitForm() {
        submitButton.click();
    }

    public void verifyFormFieldsValidated() {
       registrationFrom.shouldHave(attribute("class", "was-validated"));
    }

}
