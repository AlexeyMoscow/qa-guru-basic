package pages.enams;

public enum Gender {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String title;

    Gender(String gender) {
        this.title = gender;
    }

    public String getTitle() {
        return title;
    }

}
