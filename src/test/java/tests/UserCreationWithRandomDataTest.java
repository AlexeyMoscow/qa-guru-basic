package tests;

import models.User;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CreatedUserFrom;

import static pages.enums.Gender.MALE;

public class UserCreationWithRandomDataTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    CreatedUserFrom createdUserFrom = new CreatedUserFrom();

    @Test
    public void userRegistrationWithMinimumData() {
        User user = User.getUserWithMinimumData();
        registrationPage
                .openPage();
        registrationPage
                .fillRegistrationFormWithMinimumData(user);
        createdUserFrom
                .verifyCreatedUserData("Student Name", user.getFirstName() + " " + user.getLastName())
                .verifyCreatedUserData("Gender", user.getGender())
                .verifyCreatedUserData("Mobile", user.getPhone());
    }

    @Test
    public void userRegistrationWithAllData() {
        User user = User.getUserWithFullData();
        registrationPage.openPage();

        registrationPage
                .fillRegistrationFormWitFullData(user);
        createdUserFrom
                .verifyCreatedUserData("Student Name", user.getFirstName() + " " + user.getLastName())
                .verifyCreatedUserData("Student Email", user.getEmail())
                .verifyCreatedUserData("Gender", user.getGender())
                .verifyCreatedUserData("Mobile", user.getPhone())
                .verifyCreatedUserData("Date of Birth", user.getBirthDay() + " " + user.getBirthMonth() + "," + user.getBirthYear())
                .verifyCreatedUserData("Subjects", user.getUserSubject())
                .verifyCreatedUserData("Hobbies", user.getHobby())
                .verifyCreatedUserData("Picture", user.getPicture())
                .verifyCreatedUserData("Address", user.getAddress())
                .verifyCreatedUserData("State and City", user.getCity());
    }

    @Test
    public void userRegistrationMissingRequiredField() {
        registrationPage
                .openPage();
        registrationPage
                .setLastName("Petrov")
                .setGender(MALE)
                .setPhone("1234567890")
                .submitForm();
        registrationPage.verifyFormFieldsValidated();
        createdUserFrom.nonSuccessRegistration();
    }

}
