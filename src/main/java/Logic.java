import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Logic {


    public  Student[] filterDataNarodg(Student[] student, LocalDate dataNarog) {
        Student[] temp = new Student[student.length];
        int b = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i].getDataNarodg().isAfter(dataNarog)) {
                temp[b++] = student[i];
            }
        }
        return Arrays.copyOf(temp, b);
    }

    public Student[] printGroupStudent(Student[] student, String grupa) {
        Student[] temp = new Student[student.length];
        int b = 0;
        for (Student value : student) {
            if (Objects.equals(value.getGrupa(), grupa)) {
                temp[b++] = value;
            }
        }

        temp = Arrays.copyOf(temp, b);
        Arrays.sort(temp, Comparator.comparing(Student::getFamil).thenComparing(Student::getImy));
        return temp;
    }

    public Student [] printStudent(Student[] student) {
        for (Student value : student) {
            System.out.println(value);
        }
        return student;
    }

    public  Student[] filterFakultStudent(Student[] student, String fakul) {
        Student[] temp = new Student[student.length];
        int b = 0;
        for (Student value : student) {
            if (Objects.equals(value.getFakul(), fakul)) {
                temp[b++] = value;
            }
        }
      return Arrays.copyOf(temp, b);
    }

}
