import java.util.List;

public class Timer extends Thread {

    private String name;
    private int counter;

    public String getTimerName() {
        return this.name;
    }

    public int getCounter() {
        return this.counter;
    }

    public Timer(String name) {
        this.name = name;
        this.counter = 0;
    }

    public Timer(String name, int counter) {
        this.name = name;
        this.counter = counter;
    }

    @Override
    public void run() {
        while (!this.currentThread().isInterrupted()) {
            try {
                this.counter += 1;
                this.sleep(1000);
            } catch (InterruptedException e) {
                this.currentThread().interrupt();
            }
        }
    }
}
