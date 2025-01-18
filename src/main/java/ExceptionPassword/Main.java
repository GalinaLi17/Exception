package ExceptionPassword;
import java.util.Scanner;

public class Main {
    private static final String ADMIN_LOGIN = "ADMIN_LiGalina_1707@gmail.com";
    private static final String ADMIN_PASSWORD = "22221111";
    private static final String USER_LOGIN = "USER_ALENA_DUB_@gmail.com";
    private static final String USER_PASSWORD = "12345678";
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Введите логин или команду exit для выхода");
            String login = scanner.nextLine();

            if ("exit".equalsIgnoreCase(login)) {
                System.out.println("Выход из программы.");
                break;
            }

            System.out.println("Введите пароль:");
            String password = scanner.nextLine();

            if ("exit".equalsIgnoreCase(password)) {
                System.out.println("Выход из программы.");
                break;
            }

            try {
                Role role = userCheck(login, password);

                if (role != null) {
                    showMenu(role);
                    break;
                }
            } catch (WrongLoginException | WrongPasswordException e) {
                System.out.println("Ошибка: " + e.getMessage());
                System.out.println("Попробуйте снова.");
            }
        }
    }


    public static Role userCheck(String login, String password) throws WrongLoginException, WrongPasswordException {
        if (!login.matches("[A-Za-z0-9@._-]{20,}")) {
            throw new WrongLoginException("Логин должен содержать не менее 20 символов: буквы, цифры и @._-");
        }

        // Проверка пароля
        if (!password.matches("[A-Za-z0-9{}\\[\\](),.&;?!-+]{8,}")) {
            throw new WrongPasswordException("Пароль должен содержать не менее 8 символов: буквы, цифры и {}[](),.&;?!_-+");
        }

        // Сравнение с предопределёнными значениями
        if (ADMIN_LOGIN.equals(login) && ADMIN_PASSWORD.equals(password)) {
            return Role.ADMIN;
        } else if (USER_LOGIN.equals(login) && USER_PASSWORD.equals(password)) {
            return Role.USER;
        }

        return null;
    }

    public static void showMenu(Role role) {
        switch (role) {
            case ADMIN:
                System.out.println("ADMIN:\n" +
                        "1. File\n" +
                        "2. Create new user\n" +
                        "3. exit");
                break;
            case USER:
                System.out.println("USER:\n" +
                        "1. File\n" +
                        "2. Get play list\n" +
                        "3. exit");
                break;
        }
    }


}
