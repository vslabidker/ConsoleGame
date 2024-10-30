package Player;

import Enums.TryResult;
import Source.Source;

public interface Player<T>
{
    TryResult tryGuess(Source<T> source, T targetData);
    int getId();
    String getName();
}
