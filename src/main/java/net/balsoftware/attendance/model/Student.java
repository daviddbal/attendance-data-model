package net.balsoftware.attendance.model;

public class Student extends Person<Student> {
    private int createdById;

    public int getCreatedById() {
        return createdById;
    }

    public void setCreatedById(int createdById) {
        this.createdById = createdById;
    }

    public Student withCreatedById(int createdById) {
        this.createdById = createdById;
        return this;
    }

    @Override
    public String toString() {
        return "Student{" +
                "createdById=" + createdById +
                '}' + super.toString();
    }
}
