package Player;

import Enums.TryResult;
import java.util.HashSet;
import java.util.Random;

public class ComputerPlayer implements Player {
    private static int idCounter = 0;
    private final int id;
    private final String name;
    private final Random random;
    private final HashSet<Integer> triedNumbers;
    private final HashSet<String> triedStrings;
    private final Strategy strategy;

    public enum Strategy {
        RANDOM,
        SMART
    }

    public ComputerPlayer(Strategy strategy) {
        this.id = ++idCounter;
        this.name = "Computer " + id;
        this.random = new Random();
        this.triedNumbers = new HashSet<>();
        this.triedStrings = new HashSet<>();
        this.strategy = strategy;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public int guess() {
        if (strategy == Strategy.RANDOM) {
            return randomGuess();
        } else if (strategy == Strategy.SMART) {
            return smartGuess();
        }
        return -1;
    }

    public String guessString(int length) {
        if (strategy == Strategy.RANDOM) {
            return randomGuessString(length);
        } else if (strategy == Strategy.SMART) {
            return smartGuessString(length);
        }
        return "";
    }

    private int randomGuess() {
        int guess;
        do {
            guess = random.nextInt(100) + 1;
        } while (triedNumbers.contains(guess));
        triedNumbers.add(guess);
        return guess;
    }

    private int smartGuess() {
        for (int i = 1; i <= 100; i++) {
            if (!triedNumbers.contains(i)) {
                triedNumbers.add(i);
                return i;
            }
        }
        throw new IllegalStateException("Не осталось чисел для угадывания");
    }

    private String randomGuessString(int length) {
        String guess;
        do {
            StringBuilder sb = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                sb.append((char) (random.nextInt(26) + 'a'));
            }
            guess = sb.toString();
        } while (triedStrings.contains(guess));
        triedStrings.add(guess);
        return guess;
    }

    private String smartGuessString(int length) {
        StringBuilder guess = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                StringBuilder sb = new StringBuilder(guess);
                sb.append(c);
                String tempGuess = sb.toString();
                if (!triedStrings.contains(tempGuess)) {
                    triedStrings.add(tempGuess);
                    guess.append(c);
                    break;
                }
            }
        }
        return guess.toString();
    }

    public void receiveFeedback(int guessedNumber, TryResult result) {
        triedNumbers.add(guessedNumber);
    }

    public void receiveFeedbackString(String guessedString, TryResult result) {
        triedStrings.add(guessedString);
    }
}
