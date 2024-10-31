package Game;

import Enums.TryResult;
import GameProcessing.StringGameProcessing;
import Source.*;

public class StringGame implements Game<String>
{
    private final String targetString;

    public StringGame(int length)
    {
        this.targetString = "a".repeat(length);
    }

    @Override
    public String getGameData()
    {
        return targetString;
    }

    @Override
    public void play(Source<String> source, String targetData)
    {
        StringGameProcessing stringGameProcessing = new StringGameProcessing();
        TryResult result;
        do
        {
            result = stringGameProcessing.tryGuess(source, targetData);
            switch (result)
            {
                case SUCCESS:
                    System.out.println("Поздравляю! Вы угадали строку!");
                    break;
                case TOO_LOW:
                    System.out.println("Неправильная строка. Попробуйте снова.");
                    break;
            }
        } while (result != TryResult.SUCCESS);
    }
}
