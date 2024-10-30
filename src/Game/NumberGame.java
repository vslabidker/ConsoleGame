package Game;

import Enums.TryResult;
import Player.*;
import Source.*;

public class NumberGame implements Game<Integer>
{
    private final int targetNumber;

    public NumberGame()
    {
        this.targetNumber = generateRandomNumber();
    }

    @Override
    public Integer getGameData()
    {
        return targetNumber;
    }

    @Override
    public void play(Player player, Source<Integer> source, Integer targetData)
    {
        TryResult result;
        do
        {
            result = player.tryGuess(source, targetData);
            switch (result)
            {
                case SUCCESS:
                    System.out.println("Поздравляю! Вы угадали число!");
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

    private int generateRandomNumber()
    {
        return (int) (Math.random() * 100) + 1;
    }
}
