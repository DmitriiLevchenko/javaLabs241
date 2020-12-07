package lab2.models;

import lab2.enums.AcademicDegree;
import lab2.models.Person;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {
    private AcademicDegree academicDegree;

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(AcademicDegree academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Teacher(String name, String surname, int age,int id) {
        super(name, surname, age,id);
    }

    public Teacher(String name, String surname, int age, AcademicDegree academicDegree,int id) {
        super(name, surname, age,id);
        this.academicDegree = academicDegree;
    }

    @Override
    public String toString() {
        return super.toString()
                + "academicDegree='" + academicDegree;

    }
}
