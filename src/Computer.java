import java.util.Random;

/**
 Клас Computer:
 Реалізує логіку гри "Вгадай число" через інтерфейс IComputerInteraction.
 Комп'ютер загадав випадкове число, і він перевіряє спроби гравця.
 */

public class Computer implements IComputerInteraction
{
    private final int secretNumber;

    public Computer()
    {
        Random random = new Random();
        this.secretNumber = random.nextInt(100) + 1; // Число від 1 до 100
    }

    public TryResult tryNumber(int guessedNumber)
    {
        if (guessedNumber == secretNumber)
        {
            return TryResult.SUCCESS;
        }
        else if (guessedNumber > secretNumber)
        {
            return TryResult.TOO_HIGH;
        }
        else
        {
            return TryResult.TOO_LOW;
        }
    }

    public String getHint(TryResult result)
    {
        return (result == TryResult.TOO_HIGH ? "Ваше число більше загадано" : "Ваше число менше загадано");
    }
}
