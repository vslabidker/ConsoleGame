package GameProcessing;

import Enums.TryResult;
import Source.Source;

public class StringGameProcessing implements GameProcessing<String>
{

    @Override
    public TryResult tryGuess(Source<String> source, String targetData)
    {
        String guess = source.get();
        if (targetData.equals(guess))
        {
            return TryResult.SUCCESS;
        }
        else
        {
            return TryResult.TOO_LOW;
        }
    }
}
