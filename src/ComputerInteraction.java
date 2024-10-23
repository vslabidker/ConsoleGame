/**
  Інтерфейс ComputerInteraction:
  Визначає метод взаємодії між гравцем і комп'ютером у грі.
  Містить метод tryNumber(int guessedNumber), який реалізується класом Player.
  Цей метод використовується для перевірки спроби гравця вгадати число.
*/

public interface ComputerInteraction
{
    TryResult tryNumber(int guessedNumber);
}
