import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        // Пошук користувача за id
        Optional<User> userById = userRepository.findUserById(1);
        userById.ifPresentOrElse(
                user -> System.out.println("Знайдено користувача: " + user),
                () -> System.out.println("Користувача з таким id не знайдено.")
        );

        // Пошук користувача за email
        Optional<User> userByEmail = userRepository.findUserByEmail("bob@example.com");
        userByEmail.ifPresentOrElse(
                user -> System.out.println("Знайдено користувача: " + user),
                () -> System.out.println("Користувача з таким email не знайдено.")
        );

        // Отримання списку всіх користувачів
        Optional<List<User>> allUsers = userRepository.findAllUsers();
        allUsers.ifPresentOrElse(
                users -> System.out.println("Кількість користувачів: " + users.size()),
                () -> System.out.println("Список користувачів порожній.")
        );
    }
}
