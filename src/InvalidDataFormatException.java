/**
 * Исключение для обработки неверного формата введенных данных.
 */
class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException(String message) {
        super(message);
    }
}