import java.io.IOException;

/**
 * Интерфейс для записи данных пользователя в файл.
 */
interface IUserDataFileWriter {
    void write(UserData userData) throws IOException;
}
