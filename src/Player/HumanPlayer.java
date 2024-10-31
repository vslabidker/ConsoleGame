package Player;

public class HumanPlayer implements Player
{
    private int id = 0;
    private final String name;

    public HumanPlayer(String name)
    {
        ++this.id;
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
