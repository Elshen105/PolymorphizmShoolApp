import java.util.Arrays;

public class Classroom {

    public int uniqueId;
    public Teacher teacher;
    public Student[] students;


    public Classroom() {
    }

    public Classroom(int uniqueId, Teacher teacher, Student[] students) {
        this.uniqueId = uniqueId;
        this.teacher = teacher;
        this.students = students;
    }


    @Override
    public String toString() {
        return "Classroom{" +
                "uniqueId=" + uniqueId +
                ", teacher=" + teacher +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
