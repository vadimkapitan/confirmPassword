import ExceptionCore.WrongLoginException;
import ExceptionCore.WrongPasswordException;

public class Main {
    final private static String pattern = "^[a-zA-Z0-9_]";

    public static void main(String[] args) {
        boolean isValid = getAccess("logJ*n123_2", "qwerty123", "qwerty123");
        System.out.println(isValid);
    }

    public static boolean getAccess(String login, String password, String confirmPassword) {
        try {
            if (!login.matches(pattern)) {
                throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания.");
            }
            if (login.length() > 20) {
                throw new WrongLoginException("Логин должен быть равным или меньше 20 символов.");
            }
            if (!password.matches(pattern)) {
                throw new WrongPasswordException("Пароль должен сожержать только латинские буквы, цифры и знак подчеркивания.");
            }
            if (password.length() > 20) {
                throw new WrongPasswordException("Пароль должен содержать меньше 20 символов.");
            }
            if (password.length() != confirmPassword.length()) {
                throw new WrongLoginException("Пароли не равны");
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            return false;
        }
    }
}
