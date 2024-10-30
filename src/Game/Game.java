package Game;

import Player.HumanPlayer;
import Source.ConsoleSource;

public interface Game<T>
{
    T getGameData();
    void play(HumanPlayer<T> player, ConsoleSource<T> source, T targetData);
}
