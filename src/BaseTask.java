import java.time.LocalTime;

import static java.lang.System.out;
import static java.lang.Thread.sleep;


public abstract class BaseTask implements Comparable, Runnable {
    private static int i=1;

    private final String type;
    private final int id;
    private final int priority;
    private final int duration;

    @Override
    public void run() {
        out.println(LocalTime.now() + " start task " + this);
        try {
            sleep(duration);                                 // Do some things or override in file
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        out.println(LocalTime.now() + " stop task " + this);
    }

    public BaseTask(String type, int priority, int duration) {
        this.id = i++;
        this.type = type;
        this.priority = priority;
        this.duration = duration;
    }

    @Override
    public final int compareTo(Object o) {
        return Integer.compare(priority, ((BaseTask) o).priority);
    }

    @Override
    public String toString() {
        return String.format("%s ( Id:%d Duration:%d, Priority:%d)", type, id, duration, priority);
    }


}
