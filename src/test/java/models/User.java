package models;

import utils.RandomUtils;

public class User {
    private String firstName;
    private String lastName;
    private String phone;
    private String gender;

    private String email;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String userSubject;
    private String hobby;
    private String address;
    private String state;
    private String city;
    private String picture;

    public User(String firstName, String lastName, String phone, String gender, String email, String birthDay, String birthMonth, String birthYear, String userSubject, String hobby, String address, String state, String city, String picture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.gender = gender;
        this.email = email;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.userSubject = userSubject;
        this.hobby = hobby;
        this.address = address;
        this.state = state;
        this.city = city;
        this.picture = picture;
    }

    public User(String firstName, String lastName, String phoneNumber, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phoneNumber;
        this.gender = gender;
    }

    public static User getUserWithMinimumData(){
        return new User(
                RandomUtils.getFirstName(),
                RandomUtils.getLastName(),
                RandomUtils.getMobileNumber(),
                RandomUtils.getGender());
    }

    public static User getUserWithFullData(){
        return new User(
                RandomUtils.getFirstName(),
                RandomUtils.getLastName(),
                RandomUtils.getMobileNumber(),
                RandomUtils.getGender(),
                RandomUtils.getEmail(),
                RandomUtils.getBirthDay(),
                RandomUtils.getBirthMonth(),
                RandomUtils.getBirthYear(),
                RandomUtils.getSubject(),
                RandomUtils.getHobby(),
                RandomUtils.getAddress(),
                RandomUtils.getState(),
                RandomUtils.getCity(),
                RandomUtils.getPicture()
        );
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getUserSubject() {
        return userSubject;
    }

    public String getHobby() {
        return hobby;
    }

    public String getAddress() {
        return address;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getPicture() {
        return picture;
    }
}
