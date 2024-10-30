package Game;

import Player.*;
import Source.*;

public interface Game<T>
{
    T getGameData();
    void play(Player player, Source<T> source, T targetData);
}
