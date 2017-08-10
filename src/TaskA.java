
public class TaskA extends BaseTask{

    @Override
    public void run() {
        super.run(); // do smth. else
    }

    public TaskA() {
        super("interviewA", 0,6);
    }
}
