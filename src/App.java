import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            String userDataInput;
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения(dd.mm.yyyy) номер_телефона(только цифры с кодом страны) пол(\"m\" или \"f\")");
                userDataInput = scanner.nextLine();
            }
            IUserDataInputParser inputParser = new DefaultUserDataInputParser();
            UserData userData = inputParser.parse(userDataInput);
            IUserDataFileWriter dataWriter = new DefaultUserDataFileWriter();
            dataWriter.write(userData);            
            System.out.println("Данные успешно записаны в файл.");
        } catch (InvalidDataFormatException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}