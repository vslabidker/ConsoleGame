package GameProcessing;

import Enums.TryResult;
import Source.Source;

public class NumberGameProcessing implements GameProcessing<Integer>
{

    @Override
    public TryResult tryGuess(Source<Integer> source, Integer targetData)
    {
        int guessedNumber = source.get();
        if (guessedNumber == targetData)
        {
            return TryResult.SUCCESS;
        }
        else if (guessedNumber > targetData)
        {
            return TryResult.TOO_HIGH;
        }
        else
        {
            return TryResult.TOO_LOW;
        }
    }
}
