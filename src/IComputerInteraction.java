/**
 Інтерфейс IComputerInteraction:
 Визначає метод взаємодії між гравцем і комп'ютером у грі.
 Містить метод tryNumber(int guessedNumber), який реалізується комп'ютером.
 */

public interface IComputerInteraction
{
    TryResult tryNumber(int guessedNumber);
}
