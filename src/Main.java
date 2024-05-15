import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static School school = new School();
    static Classroom[] classrooms;
    public static void main(String[] args) {

        schoolApp();


    }

    public static void schoolApp () {
        while (true) {
            showMenu();
            System.out.print("Please make a selection : ");
            int choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    getAllClassroom();
                    break;

                case 2:
                    getAllTeacher();
                    break;

                case 3:
                    getAllStudent();
                    break;

                case 4:
                    enterStudentWithClassId();
                    break;
                case 5:
                    addToSchoolClassroom();
                    break;


            }

        }
    }


    public static void showMenu() {
        System.out.println("\t\t Menu");
        System.out.println("1. Butun Sinifleri gor.");
        System.out.println("2. Butun Mellimleri gor.");
        System.out.println("3. Butun Telebeleri gor");
        System.out.println("4. ClassId-ye gore sinifdeki telebeleri gor.");
        System.out.println("5. Mektebe sinif elave et.");
    }

    public static void getAllClassroom() {
        System.out.println("Butun sinfler: ");

        if (classrooms != null) {
            for (Classroom classroom : classrooms) {
                System.out.println("Classroom ID: " + classroom.uniqueId);
            }
        }
    }


    public static void getAllTeacher() {
        System.out.println("Butun Muellimler : ");

        if (classrooms != null) {
            for (Classroom classroom : classrooms) {
                if (classroom.teacher != null)
                    System.out.println(classroom.teacher);
            }
        }

    }

    public static void getAllStudent() {
        System.out.println("Butun Sagirdler : ");

        if (classrooms != null) {
            for (Classroom classroom : classrooms) {
                if (classroom.students != null)
                    for (Student student : classroom.students) {
                        System.out.println(student);
                    }
            }
        }

    }


    public static void addToSchoolClassroom() {
        System.out.print("Nece sinif elave etmek isteyirsiniz : ");

        int count = new Scanner(System.in).nextInt();
        classrooms = new Classroom[count];
        for (int i = 0; i < classrooms.length; i++) {
            classrooms[i] = creatClassroom();
            classrooms[i].teacher = (Teacher) creatTeacher();
            classrooms[i].students = (Student[]) addToClassroomStudents();
        }

    }

    public static Classroom creatClassroom() {
        System.out.print("Enter uniqueId for Classroom : ");
        int uniqueId = new Scanner(System.in).nextInt();
        Classroom classroom = new Classroom();

        classroom.uniqueId = uniqueId;
        return classroom;
    }


    public static Human creatTeacher() {
        System.out.print("Enter Teacher name : ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Enter Teacher surname : ");
        String surname = new Scanner(System.in).nextLine();
        System.out.print("Enter Teacher age : ");
        int age = new Scanner(System.in).nextInt();
        System.out.print("Enter Teacher salary : ");
        double salary = new Scanner(System.in).nextDouble();

        return new Teacher(name, surname, age, salary);

    }

    public static Human[] addToClassroomStudents() {
        System.out.print("Nece Telebe elave etmek isteyirsiniz : ");
        int count = new Scanner(System.in).nextInt();
        Student[] students = new Student[count];
        for (int i = 0; i < students.length; i++) {
            students[i] = (Student) createStudent();
        }
        return students;
    }

    public static Human createStudent() {
        System.out.print("Student Name daxil edin: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Student Surname daxil edin: ");
        String surname = new Scanner(System.in).nextLine();
        System.out.print("Student Age daxil edin: ");
        int age = new Scanner(System.in).nextInt();
        System.out.print("Student Point daxil edin: ");
        int point = new Scanner(System.in).nextInt();

        return new Student(name, surname, age, point);

    }

    public static void enterStudentWithClassId() {
        System.out.print("Enter ClassroomId : ");
        int classId = new Scanner(System.in).nextInt();
        if (school.classrooms != null) {
            for (Classroom classroom : school.classrooms) {
                if (classId == classroom.uniqueId) {
                    if (classroom.students != null) {
                        for (Student student : classroom.students) {
                            System.out.println(student);
                        }
                    } else {
                        System.out.println("No students in this classroom.");
                    }
                    return;
                }
            }
        }
        System.out.println("Classroom with ID " + classId + " not found.");
    }

}



