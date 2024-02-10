import java.time.LocalDate;

/**
 * Класс для обработки ввода данных пользователя.
 */
class DefaultUserDataInputParser implements IUserDataInputParser {
    @Override
    public UserData parse(String input) throws InvalidDataFormatException {
        String[] userDataArray = input.split(" ");
        if (userDataArray.length != 6) {
            throw new InvalidDataFormatException("Вы ввели неполные данные");
        }

        String lastName = userDataArray[0];
        String firstName = userDataArray[1];
        String middleName = userDataArray[2];
        LocalDate birthDate = parseDate(userDataArray[3]);
        long phoneNumber = parsePhoneNumber(userDataArray[4]);
        char gender = parseGender(userDataArray[5]);

        return new UserData(lastName, firstName, middleName, birthDate, phoneNumber, gender);
    }
    
    LocalDate parseDate(String dateString) throws InvalidDataFormatException {
        try {
            return LocalDate.parse(dateString, java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            throw new InvalidDataFormatException("Неверный формат даты рождения: " + dateString);
        }
    }

    long parsePhoneNumber(String phoneNumberString) throws InvalidDataFormatException {
        try {
            return Long.parseLong(phoneNumberString);
        } catch (NumberFormatException e) {
            throw new InvalidDataFormatException("Неверный формат номера телефона: " + phoneNumberString);
        }
    }

    char parseGender(String genderString) throws InvalidDataFormatException {
        if (genderString.length() != 1 || (!genderString.equalsIgnoreCase("m") && !genderString.equalsIgnoreCase("f"))) {
            throw new InvalidDataFormatException("Неверный формат пола: " + genderString);
        }
        return genderString.toLowerCase().charAt(0);
    }
}
