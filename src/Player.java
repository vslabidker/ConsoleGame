/**
  Клас Player:
  Реалізує інтерфейс ComputerInteraction для взаємодії з комп'ютером.
  Містить метод tryNumber(int guessedNumber), який використовує метод checkGuess класу Computer
  для перевірки спроби гравця вгадати число.
 */

public class Player implements ComputerInteraction
{
    private final Computer computer;

    public Player(Computer computer)
    {
        this.computer = computer;
    }

    @Override
    public TryResult tryNumber(int guessedNumber)
    {
        return computer.checkGuess(guessedNumber);
    }
}
