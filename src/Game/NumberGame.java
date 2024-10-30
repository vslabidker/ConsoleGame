package Game;

import java.util.Random;

public class NumberGame implements Game<Integer>
{

    private final int targetNumber;

    public NumberGame()
    {
        Random random = new Random();
        this.targetNumber = random.nextInt(100) + 1;
    }

    @Override
    public Integer getGameData() {
        return targetNumber;
    }
}
