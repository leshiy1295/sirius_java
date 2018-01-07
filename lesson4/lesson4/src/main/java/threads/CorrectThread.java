package threads;

public class CorrectThread extends Thread {
    private final CorrectIncrementExample checker;
    private final StateObject object;

    public CorrectThread (CorrectIncrementExample checker, StateObject object) {
        this.checker = checker;
        this.object = object;
    }

    public void run() {
        while (!checker.stop()) {
            increment();
        }
    }

    public void increment() {
        object.increment();
    }

    public int getI() {
        return object.getI();
    }
}

