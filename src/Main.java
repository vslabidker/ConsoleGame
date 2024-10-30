import Game.NumberGame;
import Game.StringGame;
import Player.HumanPlayer;
import Source.ConsoleSource;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите игру: 1 - Угадай число, 2 - Угадай строку");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Чтобы очистить буфер после nextInt()

        if (choice == 1) {
            NumberGame game = new NumberGame(); // Игра с числом
            ConsoleSource<Integer> consoleSource = new ConsoleSource<Integer>();
            HumanPlayer<Integer> player = new HumanPlayer<Integer>(1, "Игрок");

            System.out.println("Добро пожаловать в игру 'Угадай число'!");
            game.play(player, consoleSource, game.getGameData()); // Используем game.play()

        } else if (choice == 2) {
            StringGame game = new StringGame(5); // Игра со строкой длиной 5 символов
            ConsoleSource<String> consoleSource = new ConsoleSource<String>();
            HumanPlayer<String> player = new HumanPlayer<String>(1, "Игрок");

            System.out.println("Добро пожаловать в игру 'Угадай строку'!");
            game.play(player, consoleSource, game.getGameData()); // Используем game.play()
        } else {
            System.out.println("Неверный выбор игры.");
        }
    }
}
