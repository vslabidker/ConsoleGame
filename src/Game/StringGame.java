package Game;

import Enums.TryResult;
import Player.*;
import Source.*;

import java.util.Random;

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
    public void play(Player player, Source<String> source, String targetData)
    {
        TryResult result;
        do
        {
            result = player.tryGuess(source, targetData);
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
