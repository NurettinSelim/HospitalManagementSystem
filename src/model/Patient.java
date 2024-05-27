package model;

public class Patient {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String contactInformation;
    private String gender;
    private String doctorCategory;

    public Patient(int id, String name, String surname, int age, String contactInformation, String gender, String doctorCategory) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.contactInformation = contactInformation;
        this.gender = gender;
        this.doctorCategory = doctorCategory;
    }

    // Getters and setters for new fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDoctorCategory() {
        return doctorCategory;
    }

    public void setDoctorCategory(String doctorCategory) {
        this.doctorCategory = doctorCategory;
    }


    public String toText(String separator) {
        return "Patient Id: " + id + separator +
                "Name: " + name + separator +
                "Surname: " + surname + separator +
                "Age: " + age + separator +
                "Contact Information: " + contactInformation + separator +
                "Gender: " + gender + separator +
                "Doctor Category: " + doctorCategory;
    }
}
