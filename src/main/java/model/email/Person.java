package model.email;

/**
 * Represent a person
 */
public class Person {

    private String firstName;
    private String lastName;
    private String email;

    /**
     * Create a person
     * @param firstName
     * @param lastName
     * @param email
     */
    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
    }

    /**
     * Create a person with only email
     * @param email
     */
    public Person(String email) {
        this.email = email;
    }

    /**
     * Return firstname
     * @return firstname
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Return lastname
     * @return lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Return email
     * @return email
     */
    public String getEmail() {
        return email;
    }
}
