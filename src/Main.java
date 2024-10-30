import Enums.TryResult;
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

        if (choice == 1)
        {
            NumberGame game = new NumberGame();
            int targetNumber = game.getGameData();
            ConsoleSource<Integer> consoleSource = new ConsoleSource<Integer>();
            HumanPlayer<Integer> player = new HumanPlayer<Integer>(1, "Игрок");

            System.out.println("Добро пожаловать в игру 'Угадай число'!");
            playGame(player, consoleSource, targetNumber);

        }
        else if (choice == 2)
        {
            StringGame game = new StringGame(5);
            String targetString = game.getGameData();
            ConsoleSource<String> consoleSource = new ConsoleSource<String>();
            HumanPlayer<String> player = new HumanPlayer<String>(1, "Игрок");

            System.out.println("Добро пожаловать в игру 'Угадай строку'!");
            playGame(player, consoleSource, targetString);
        }
        else
        {
            System.out.println("Неверный выбор игры.");
        }
    }

    private static <T> void playGame(HumanPlayer<T> player, ConsoleSource<T> consoleSource, T targetData)
    {
        TryResult result;
        do
        {
            result = player.tryGuess(consoleSource, targetData);
            switch (result)
            {
                case SUCCESS:
                    System.out.println("Поздравляю! Вы угадали!");
                    break;
                case TOO_HIGH:
                    System.out.println("Ваше значение слишком велико!");
                    break;
                case TOO_LOW:
                    System.out.println("Ваше значение слишком мало!");
                    break;
            }
        } while (result != TryResult.SUCCESS);
    }
}
