package lab2.models;

import lab2.models.Person;

import java.io.Serializable;
import java.util.concurrent.TimeoutException;

public class Student extends Person implements Serializable {

    private Teacher teacher;
    public Student(String name, String surname, int age,int id) {
        super(name, surname, age,id);
    }
    public Student(String name, String surname, int age, Teacher teacher,int id) {
        super(name, surname, age,id);
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
