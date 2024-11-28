package GameProcessing;

import Enums.TryResult;
import Source.Source;

public class StringGameProcessing implements GameProcessing<String> {

    @Override
    public TryResult tryGuess(Source<String> source, String targetData) {
        String guess = source.get();

        if (targetData.equals(guess)) {
            return TryResult.SUCCESS;
        } else if (guess.length() < targetData.length()) {
            System.out.println("Ваша строка занадто коротка.");
        } else if (guess.length() > targetData.length()) {
            System.out.println("Ваша строка занадто довга.");
        } else {
            int matchingChars = countMatchingChars(guess, targetData);
            System.out.println("Кількість співпадаючих символів: " + matchingChars);
        }

        return TryResult.TOO_LOW;
    }

    private int countMatchingChars(String guess, String target) {
        int count = 0;
        for (int i = 0; i < Math.min(guess.length(), target.length()); i++) {
            if (guess.charAt(i) == target.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
