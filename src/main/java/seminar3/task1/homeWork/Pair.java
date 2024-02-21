package seminar3.task1.homeWork;


public class Pair<M, N> {
    private final M firstValue;
    private final N secondValue;

    public Pair(M firstValue, N secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public M getFirst() {
        return firstValue;
    }

    public N getSecond() {
        return secondValue;
    }

    @Override
    public String toString() {
        return String.format("[%s, %s]", firstValue.toString(), secondValue.toString());
    }
}
