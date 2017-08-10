import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Executor {
    private ExecutorService executor;

    public Executor() {
        executor = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue<Runnable>());
    }

    public void execute(BaseTask task) {
        executor.execute(task);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
