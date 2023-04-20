import java.io.File;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {

//    public void createFile() {
//        System.out.println("Введіть ім'я нового файла");
//        Scanner scanner = new Scanner(System.in);
//        String filename = scanner.nextLine();
//        Logic logic = new Logic();
//        File file = new File(filename);
//
//        if (file.exists()) {
//            System.out.println("Файл існує");
//
//            return;
//        }
//
//        try {
//            boolean created = file.createNewFile();
//            if (created) {
//                System.out.println("створення файла: " + file.getAbsolutePath());
//            } else {
//                System.out.println("Файл не вдалось створити");
//            }
//        } catch (IOException ex) {
//            System.out.println("An error occurred: " + ex.getMessage());
//            ex.printStackTrace();
//        }
//    }

    public String enterNameFile(Scanner scanner){
        String filename;
        File file;

    do {
        System.out.print("Введіть ім'я файлу: ");

        filename = scanner.next();

        file = new File(filename);
        if (!file.exists()) {
            System.out.println("Такого файлу не існує, введіть іншу назву");

        }


    } while (!file.exists() );
    return filename;
    }

    public Student[] fillStudentArray() {
        return new Student[]{
                new Student( "Циноборенко", "Артем", "Русланович", LocalDate.of(2001, 3, 3), "пр Центральний 28", "Програмна інженерія", "1148", "01384562", 1),
                new Student( "Стрельченко", "Ерік", "Сергійович", LocalDate.of(1998, 2, 23), "Корабельна 12", "Комп'ютерні технологіі", "1147", "03254956", 1),
                new Student( "Василишина", "Юлія", "Михайлівна", LocalDate.of(2002, 1, 23), "Соборна 20", "Програмна інженерія", "1148", "02389465", 1),
                new Student( "Жевак", "Олександр", "Олександрович", LocalDate.of(2001, 5, 5), "ПГУ 32", "Комп'ютерні технологіі", "1147", "0632595", 1),
                new Student( "Макогон", "Олексій", "Едуардович", LocalDate.of(1999, 7, 15), "ПГУ2", "Системний аналіз", "1147", "03258951", 1)
        };
    }
}
