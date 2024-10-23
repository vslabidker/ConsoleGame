import java.util.Random;

/**
 Клас Computer:
 Описує логіку роботи комп'ютера у грі "Вгадай число".
 - Загадав випадкове число від 1 до 100 при створенні об'єкта.
 - Метод checkGuess(int guessedNumber) перевіряє спробу гравця:
    Повертає результат через TryResult (SUCCESS, TOO_HIGH, TOO_LOW).
 - Метод getHint(TryResult result) дає підказку, чи більше або менше введене число за загадане.
 */

public class Computer
{
    private final int secretNumber;

    public Computer()
    {
        Random random = new Random();
        this.secretNumber = random.nextInt(100) + 1;
    }

    public TryResult checkGuess(int guessedNumber)
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
        return (result == TryResult.TOO_HIGH?  "Ваше число більше згаданного" :"Ваше число меньше згаданного");
    }
}
