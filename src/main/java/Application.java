import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        List<Timer> allTimers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (start, check, stop, exit): ");
            String input = scanner.nextLine();
            if (input.contains("start")){
                String[] keyWords = input.split("\\s+");
                boolean createNewTimer = true;
                for (Timer timer: allTimers) {
                    if(timer.getTimerName().equals(keyWords[1])) {
                        Timer newTimer = new Timer(timer.getTimerName(), timer.getCounter());
                        newTimer.start();
                        allTimers.add(newTimer);
                        allTimers.remove(timer);
                        createNewTimer = false;
                        break;
                    }
                }
                if (createNewTimer) {
                    Timer timer = new Timer(keyWords[1]);
                    timer.start();
                    allTimers.add(timer);
                }
            } else if (input.equals("check")) {
                for (Timer timer: allTimers) {
                    System.out.println("Name: " + timer.getTimerName() + " Id: " + timer.getId() + " Seconds: " + timer.getCounter());
                }
            } else if (input.contains("stop")) {
                String[] keyWords = input.split("\\s+");
                for (Timer timer: allTimers) {
                    if (timer.getTimerName().equals(keyWords[1])){
                        timer.interrupt();
                    }
                }
            } else if (input.equals("exit")) {
                for (Timer timer: allTimers) {
                    timer.interrupt();
                    System.out.println("Name: " + timer.getTimerName() + " Id: " + timer.getId() + " Seconds: " + timer.getCounter());
                }
                System.exit(1);
            }
        }

    }
}
