package Source;

import java.util.Scanner;

public class ConsoleSource<T> implements Source<T>
{
    private final Scanner scanner;

    public ConsoleSource()
    {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public T get()
    {
        System.out.print("Введите значение: ");
        String input = scanner.nextLine();

        if (input.matches("\\d+"))
        {
            return (T) Integer.valueOf(input);
        }
        else
        {
            return (T) input;
        }
    }
}
