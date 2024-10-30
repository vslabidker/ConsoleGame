package Player;

import Enums.TryResult;
import Source.Source;

public class HumanPlayer<T> implements Player<T>
{
    private final int id;
    private final String name;

    public HumanPlayer(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public TryResult tryGuess(Source<T> source, T targetData)
    {
        T guess = source.get();

        if (targetData instanceof Integer && guess instanceof Integer)
        {
            int targetNumber = (Integer) targetData;
            int guessedNumber = (Integer) guess;
            if (guessedNumber == targetNumber)
            {
                return TryResult.SUCCESS;
            }
            else if (guessedNumber > targetNumber)
            {
                return TryResult.TOO_HIGH;
            }
            else
            {
                return TryResult.TOO_LOW;
            }
        }
        else if (targetData instanceof String && guess instanceof String)
        {
            if (targetData.equals(guess))
            {
                return TryResult.SUCCESS;
            }
            else
            {
                return TryResult.TOO_LOW;
            }
        }

        throw new IllegalArgumentException("Unsupported data type");
    }


    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
