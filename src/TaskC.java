
public class TaskC extends BaseTask {
    @Override
    public void run() {
        super.run(); // do smth. else
    }

    public TaskC() {
        super("C", 1,12);
    }
}
