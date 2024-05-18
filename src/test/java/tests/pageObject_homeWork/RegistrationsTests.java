package tests.pageObject_homeWork;

import org.junit.jupiter.api.Test;
import pages.components.CreatedUserFrom;
import pages.RegistrationPage;
import tests.BaseTest;

import static pages.enums.Gender.MALE;

public class RegistrationsTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();
    CreatedUserFrom createdUserFrom = new CreatedUserFrom();

    @Test
    public void userRegistrationWithMinimumData() {
        registrationPage
                .openPage();
        registrationPage
                .setFirstName("Alex")
                .setLastName("Petrov")
                .setGender(MALE)
                .setPhone("1234567890")
                .submitForm();
        createdUserFrom
                .verifyCreatedUserData("Student Name", "Alex Petrov")
                .verifyCreatedUserData("Gender", MALE.getTitle())
                .verifyCreatedUserData("Mobile", "1234567890");
    }

    @Test
    public void userRegistrationWithAllData() {
        registrationPage.openPage();

        registrationPage
                .setFirstName("Alex")
                .setLastName("Petrov")
                .setEmail("xxx@mail.com")
                .setGender(MALE)
                .setPhone("1234567890")
                .setDateOfBirth("3", "May", "1990")
                .setSubject("English")
                .setHobbies("Music")
                .uploadPicture("feelLikeSir.jpeg")
                .setAddress("Moscow, Tverskya, 1")
                .setState("NCR")
                .setCity("Delhi")
                .submitForm();
        createdUserFrom
                .verifyCreatedUserData("Student Name", "Alex Petrov")
                .verifyCreatedUserData("Student Email", "xxx@mail.com")
                .verifyCreatedUserData("Gender", MALE.getTitle())
                .verifyCreatedUserData("Mobile", "1234567890")
                .verifyCreatedUserData("Date of Birth", "3 May,1990")
                .verifyCreatedUserData("Subjects", "English")
                .verifyCreatedUserData("Hobbies", "Music")
                .verifyCreatedUserData("Picture", "feelLikeSir.jpeg")
                .verifyCreatedUserData("Address", "Moscow, Tverskya, 1")
                .verifyCreatedUserData("State and City", "Delhi");
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
