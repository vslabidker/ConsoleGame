package Source;

import java.util.Random;

public class RandomSource implements Source<Integer> {

    private final Integer random;

    public RandomSource() {
        Random randomInt = new Random();
        this.random = randomInt.nextInt(100)+1;
    }

    @Override
    public Integer get() {
        return random;
    }
}
