import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс для записи данных пользователя в файл.
 */
class DefaultUserDataFileWriter implements IUserDataFileWriter {
    @Override
    public void write(UserData userData) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userData.lastName + ".txt", true))) {
            writer.write(userData.lastName + " " + userData.firstName + " " + userData.middleName + " " +
                    userData.birthDate + " " + userData.phoneNumber + " " + userData.gender + "\n");
        }
    }
}