
package lab2.serializators;

import lab2.models.Person;
import lab2.models.Teacher;
import lab2.models.wrappers.PersonList;

import java.io.*;
import java.util.ArrayList;

public class PersonSerialization {
    public void Serialization(File path, Person obj) {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(obj);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    public void Deserialization(File folder) {
        try {
            // Reading the object from a file
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    listFilesForFolder(fileEntry);
                } else {
                    FileInputStream file = new FileInputStream(fileEntry);
                    ObjectInputStream in = new ObjectInputStream(file);
                    Person obj = (Person) in.readObject();

                    in.close();
                    file.close();

                    System.out.println("Object has been deserialized ");
                    System.out.println("name = " + obj.getName());
                    System.out.println("surname = " + obj.getSurname());
                    System.out.println("age = " + obj.getAge());
                    System.out.println("id = " + obj.getId());
                }
            }
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }

    public void listFilesForFolder(final File folder) {

    }
}
  /*for (final File fileEntry : f.listFiles()) {
        System.out.println(fileEntry.getName());
        }*/
