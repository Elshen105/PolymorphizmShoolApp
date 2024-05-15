import java.util.Arrays;

public class School {
    public Classroom[] classrooms;


    public School() {
    }

    public School(Classroom[] classrooms) {
        this.classrooms = classrooms;
    }

    @Override
    public String toString() {
        return "School{" +
                "classrooms=" + Arrays.toString(classrooms) +
                '}';
    }
}
