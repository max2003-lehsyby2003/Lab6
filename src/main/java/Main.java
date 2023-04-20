import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        UserInterface userInterface = new UserInterface();
        IOFile ioFile = new IOFile();
        Logic logic = new Logic();
        UserInterface userInterface1 = new UserInterface();
        Student [] students ;
        Scanner input = new Scanner(System.in);
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        String file, group, fakul;

        LocalDate date;

        while (choice != 7) {
            System.out.println("Выберите один из пунктов меню:");
            System.out.println("1. Створення/перевірка на існування файла, виведення данних файлу");
            System.out.println("2. Запис данних до файлу");
            System.out.println("3. список студентів заданого факультету;");
            System.out.println("4. список студентів, які народились після заданого року;");
            System.out.println("5. список навчальної групи в порядку алфавіту;");
            System.out.println("6. список студентів упорядкований за алфавітом назви факультету, а для студентів одного" +
                    "факультету – за датою народження");
            System.out.println("7. Вихід з програми");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Вы выбрали пункт 1");
                    userInterface.enterNameFile(input);

                    break;
                case 2:
                    System.out.println("Вы выбрали пункт 2");
                    System.out.println("Введіть назву файлу");
                    file = sc.next();

                    students = userInterface1.fillStudentArray();

                    ioFile.writeFile(file , students);
                    break;
                case 3:

                    System.out.println("Вы выбрали пункт 3");
                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readFromFile(file);
//                    System.out.println("Введіть назву факультету");
//                    fakul = sc.next();
                    System.out.println("------Студенти факультету Програмна інженерія----");

                    logic.printStudent(logic.filterFakultStudent(students, "Програмна інженерія"));

                    break;
                case 4:

                    System.out.println("Вы выбрали пункт 4");

                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readFromFile(file);
//                    System.out.println("Введіть дату");
//                    date = LocalDate.parse(sc.next());

                    logic.printStudent(logic.filterDataNarodg(students, LocalDate.of(2000, 1, 1)));

                    break;
                case 5:
                    System.out.println("Вы выбрали пункт 5");

                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readFromFile(file);

//                    System.out.println("Введіть назву группи");
//                    group = sc.get();

                    logic.printStudent(logic.printGroupStudent(students, "1147"));

                    break;
                case 6:
                    System.out.println("введіть назву файлу");
                    file = sc.next();
                    students = ioFile.readFromFile(file);

                    Arrays.sort(students, Comparator.comparing(Student:: getFakul).thenComparing(Student::getDataNarodg));
                    logic.printStudent(students);
                    break;
                case 7:
                    System.out.println("Выход из программы");
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    }

