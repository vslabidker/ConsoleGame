package GameProcessing;

import Enums.TryResult;
import Source.Source;

public interface GameProcessing<T>
{
    TryResult tryGuess(Source<T> source, T targetData);

}
