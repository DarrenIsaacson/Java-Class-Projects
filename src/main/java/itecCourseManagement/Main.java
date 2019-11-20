package itecCourseManagement;

public class Main {

    public static void main(String[] args) {

        ITECCourse java = new ITECCourse("Java Programming", 2545, 24);
        ITECCourse sdp = new ITECCourse("Software Development projects", 2903, 24);


        java.addStudent("Beyonce");
        java.addStudent("Taylor Swift");
        java.addStudent("Kanye West");

        sdp.addStudent("Gus");
        sdp.addStudent("Harry");
        sdp.addStudent("Izzy");
        sdp.addStudent("Homie");

        System.out.println(java.getNumberOfStudents());
        System.out.println(sdp.getNumberOfStudents());


        ITECCourse test = new ITECCourse("Test Couse", 2369, 3);

        test.addStudent("Bangarang");
        test.addStudent("Yeetster");
        test.addStudent("Dat boi");
        test.addStudent("DibbaDude");



    }




}
