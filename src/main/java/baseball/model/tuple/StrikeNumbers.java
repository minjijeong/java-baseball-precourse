package baseball.model.tuple;

import java.util.Iterator;
import java.util.List;

public class StrikeNumbers implements Numbers, Iterable<Integer> {
    private final List<Integer> strikeNumbers;

    public StrikeNumbers(List<Integer> strikeNumbers) {
        this.strikeNumbers = strikeNumbers;
    }

    @Override
    public int getRound(int index) {
        return strikeNumbers.get(index);
    }

    @Override
    public boolean contains(int number) {
        return strikeNumbers.contains(number);
    }

    @Override
    public Iterator<Integer> iterator() {
        return strikeNumbers.iterator();
    }

}

