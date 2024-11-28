package Player;

public class HumanPlayer implements Player
{
    private static int idCounter = 0;
    private final int id;
    private final String name;

    public HumanPlayer(String name)
    {
        this.id = ++idCounter;
        this.name = name;
    }

    @Override
    public int getId()
    {
        return id;
    }

    @Override
    public String getName()
    {
        return name;
    }
}
