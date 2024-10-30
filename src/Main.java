import Game.NumberGame;
import Game.StringGame;
import Player.HumanPlayer;
import Source.ConsoleSource;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя: ");
        String name = scanner.nextLine();
        System.out.println("Выберите игру: 1 - Угадай число, 2 - Угадай строку");
        int choice = scanner.nextInt();

        if (choice == 1)
        {
            NumberGame game = new NumberGame();
            ConsoleSource<Integer> consoleSource = new ConsoleSource<Integer>();
            HumanPlayer<Integer> player = new HumanPlayer<Integer>(name);

            System.out.println("Добро пожаловать в игру 'Угадай число', " + player.getName());
            game.play(player, consoleSource, game.getGameData());

        }
        else if (choice == 2)
        {
            StringGame game = new StringGame(5);
            ConsoleSource<String> consoleSource = new ConsoleSource<String>();
            HumanPlayer<String> player = new HumanPlayer<String>(name);

            System.out.println("Добро пожаловать в игру 'Угадай строку', " + player.getName());
            game.play(player, consoleSource, game.getGameData());
        }
        else
        {
            System.out.println("Неверный выбор игры.");
        }
    }
}
