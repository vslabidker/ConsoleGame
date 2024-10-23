/**
 Клас Player:
 Взаємодіє з комп'ютером через інтерфейс IComputerInteraction.
 Містить метод tryNumber для перевірки спроби гравця вгадати число.
 */

public class Player
{
    private final IComputerInteraction computerInteraction;

    public Player(IComputerInteraction computerInteraction)
    {
        this.computerInteraction = computerInteraction;
    }

    public TryResult tryNumber(int guessedNumber)
    {
        return computerInteraction.tryNumber(guessedNumber);
    }
}
