import java.io.FileWriter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;


public class IOFile {


    public void writeFile(String filename, Student[] students ) {

        try (FileWriter fileWriter = new FileWriter(filename);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            for (Student student : students) {
                writer.write(student.toString());
                writer.newLine();
            }



        } catch (IOException ex) {
            System.out.println("An error occurred: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    public Student[] readFromFile(String file) {
        Student[] students = new Student[100];
        int i = 0;

        Path path = Paths.get(file);

        try {
            Scanner scanner = new Scanner(path);

                while (scanner.hasNext()) {
                    String str = scanner.nextLine();
                    students[i] = Student.parse(str);

                    i++;
                }

            scanner.close();
        } catch (IOException ignored) {
        }

        students = (Student []) Arrays.copyOf(students, i);
        return students;
    }

//    public Student[] readerFile (String file){
//        Student[] students = new Student[100];
//        try (Scanner in = new Scanner(file)) {
//            String lines;
//
//                while (in.hasNext())
//                    lines= (in.nextLine());
//            }
//        return students;
//    }


}
