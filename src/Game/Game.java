package Game;

import Source.*;

public interface Game<T>
{
    T getGameData();
    void play(Source<T> source, T targetData);
}
