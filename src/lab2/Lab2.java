//https://github.com/DmitriiLevchenko
package lab2;

import lab2.models.Person;
import lab2.models.Student;
import lab2.models.Teacher;
import lab2.models.wrappers.PersonList;
import lab2.serializators.PersonSerialization;

import java.io.*;

public class Lab2 {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("alex1", "surname1", 21,1);
        Teacher teacher2 = new Teacher("alex2", "surname2", 21,2);
        Teacher teacher3 = new Teacher("alex", "surname3", 21,3);
        Student student1 = new Student("alex", "ale", 21,4);
        Student student2 = new Student("alex", "ale", 21,5);
        Student student3 = new Student("alex", "ale", 21,6);
        PersonList personList = new PersonList();
        personList.Add(teacher1);
        personList.Add(teacher2);
        personList.Add(teacher3);
        personList.Add(student1);
        personList.Add(student2);
        personList.Add(student3);
        final File folder = new File("/home/you/Desktop");
        PersonSerialization personSerialization = new PersonSerialization();
        final String rootFolder = "D:\\фтл\\Labs241\\"; //your root dir
        // Serialization
        for (Person person : personList.getPersonList()){
            if(person instanceof Teacher){
               personSerialization.Serialization(new File(rootFolder + "students" + '\\' + person.getName() + person.getId() + ".ser"),person);
            }
            if(person instanceof Student){
                personSerialization.Serialization(new File( rootFolder + "teachers" + '\\' + person.getName() + person.getId() + ".ser"),person);
            }
        }
        //Deserialization
        personSerialization.Deserialization(new File(rootFolder + "students"));
        personSerialization.Deserialization(new File(rootFolder + "teachers"));


    }



}

