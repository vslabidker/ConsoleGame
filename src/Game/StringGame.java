package Game;

public class StringGame implements Game<String>
{
    private final String _targetString;

    public StringGame(int length)
    {
        this._targetString = "a".repeat(length) ;
    }

    @Override
    public String getGameData()
    {
        return _targetString;
    }
}
