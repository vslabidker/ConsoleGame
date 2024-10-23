import java.util.Scanner;

/**
 Основний клас GuessNumberGame:
 Реалізує гру "Вгадай число".
 Гравець взаємодіє з комп'ютером через інтерфейс.
 */

public class GuessNumberGame
{
    public static void main(String[] args)
    {
        Computer computer = new Computer();
        Player player = new Player(computer);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Комп'ютер загадав число від 1 до 100. Спробуйте відгадати!");

        while (true)
        {
            System.out.print("Введіть ваше число: ");
            int guessedNumber = scanner.nextInt();

            TryResult result = player.tryNumber(guessedNumber);

            if (result == TryResult.SUCCESS)
            {
                System.out.println("Вітаємо! Ви відгадали число!");
                break;
            }
            else
            {
                System.out.println(computer.getHint(result));
            }
        }
        scanner.close();
    }
}
