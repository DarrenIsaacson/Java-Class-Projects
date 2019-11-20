package itecCourseManagement;

import java.util.ArrayList;
import java.util.List;

public class ITECCourse {

    String name;
    int code;
    List<String> students;
    int maxStudents;

    // Constructor
    public ITECCourse(String name, int code, int maxStudents){
        this.name = name;
        this.code = code;
        this.maxStudents = maxStudents;


        this.students = new ArrayList<>();
    }

    public void addStudent(String studentsName){
        if (students.size() < maxStudents){
            students.add(studentsName);
            System.out.println(studentsName + " was added.");
        }else {
            System.out.println("Can't add " + studentsName + " to the class, the class is full.");
        }
    }

    public int getNumberOfStudents(){
            return students.size();

    }

    boolean removeStudents(String studentName) {
        if (students.contains(studentName)){
            students.remove(studentName);
            System.out.println(studentName + " was removed.");
            return true;
        } else {
            System.out.println(studentName + " is not in the class.");
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }
}
