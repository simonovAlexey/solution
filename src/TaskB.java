
public class TaskB extends BaseTask{
    @Override
    public void run() {
        super.run(); // do smth. else
    }

    public TaskB() {
        super("B", 2,5);
    }
}
