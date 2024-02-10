/**
 * Интерфейс для обработки ввода данных пользователя.
 */
interface IUserDataInputParser {
    UserData parse(String input) throws InvalidDataFormatException;
}
