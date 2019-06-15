package net.balsoftware.attendance.model;

public abstract class Person<T extends Person> extends Model<T> {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public T withFirstName(String firstName) {
        this.firstName = firstName;
        return (T) this;
    }

    public T withLastName(String lastName) {
        this.lastName = lastName;
        return (T) this;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
