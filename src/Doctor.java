import java.io.*;
import java.util.*;

class Doctor {
    private String id;
    private String fullName;
    private String specialty;

    public Doctor(String id, String fullName, String specialty){
        this.id = id;
        this.fullName = fullName;
        this.specialty = specialty;

    }
    public String getId(){
        return id;
    }
    public String getFullName(){
        return fullName;
    }
    public String getSpecialty(){
        return specialty;
    }
    @Override
    public String toString(){
        return id + "," + fullName + "," + specialty;
    }
}