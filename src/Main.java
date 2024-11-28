import Game.NumberGame;
import Game.StringGame;
import Player.ComputerPlayer;
import Player.HumanPlayer;
import Source.ConsoleSource;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите игру: 1 - Угадай число, 2 - Угадай строку");
        int gameChoice = scanner.nextInt();
        scanner.nextLine();

        if (gameChoice == 1) {
            System.out.println("Режим игры: 1 - Человек против компьютера, 2 - Компьютер сам с собой");
            int modeChoice = scanner.nextInt();
            scanner.nextLine();

            if (modeChoice == 1) {

                System.out.println("Введите ваше имя:");
                String name = scanner.nextLine();
                HumanPlayer humanPlayer = new HumanPlayer(name);

                NumberGame game = new NumberGame();
                ConsoleSource<Integer> consoleSource = new ConsoleSource<Integer>();

                System.out.println("Добро пожаловать в игру 'Угадай число', " + humanPlayer.getName());
                game.play(consoleSource, game.getGameData());
            } else if (modeChoice == 2) {

                System.out.println("Выберите стратегию для компьютера: 1 - Рандомная, 2 - Смарт");
                int strategy = scanner.nextInt();

                ComputerPlayer computer = new ComputerPlayer(strategy == 1 ? ComputerPlayer.Strategy.RANDOM : ComputerPlayer.Strategy.SMART);

                NumberGame game = new NumberGame();
                int targetNumber = game.getGameData();

                System.out.println("Компьютер начинает угадывать число...");
                boolean guessed = false;

                while (!guessed) {

                    int guess = computer.guess();
                    System.out.println("Компьютер угадывает: " + guess);
                    if (guess == targetNumber) {
                        System.out.println("Компьютер угадал число!");
                        guessed = true;
                    }
                }
            } else {
                System.out.println("Неверный выбор режима игры.");
            }

        } else if (gameChoice == 2) {
            System.out.println("Режим игры: 1 - Человек против компьютера, 2 - Компьютер сам с собой");
            int modeChoice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Введите длину строки для угадывания:");
            int length = scanner.nextInt();
            scanner.nextLine();

            if (modeChoice == 1) {

                System.out.println("Введите ваше имя:");
                String name = scanner.nextLine();
                HumanPlayer humanPlayer = new HumanPlayer(name);

                StringGame game = new StringGame(length);
                ConsoleSource<String> consoleSource = new ConsoleSource<String>();

                System.out.println("Добро пожаловать в игру 'Угадай строку', " + humanPlayer.getName());
                game.play(consoleSource, game.getGameData());
            } else if (modeChoice == 2) {

                System.out.println("Выберите стратегию для компьютера: 1 - Рандомная, 2 - Смарт");
                int strategy = scanner.nextInt();

                ComputerPlayer computer = new ComputerPlayer(strategy == 1 ? ComputerPlayer.Strategy.RANDOM : ComputerPlayer.Strategy.SMART);

                StringGame game = new StringGame(length);
                String targetString = game.getGameData();

                System.out.println("Компьютер начинает угадывать строку...");
                boolean guessed = false;

                while (!guessed) {

                    String guess = computer.guessString(length);
                    System.out.println("Компьютер угадывает: " + guess);
                    if (guess.equals(targetString)) {
                        System.out.println("Компьютер угадал строку!");
                        guessed = true;
                    }
                }
            } else {
                System.out.println("Неверный выбор режима игры.");
            }
        } else {
            System.out.println("Неверный выбор игры.");
        }
    }
}
