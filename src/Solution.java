import java.io.*;
import java.net.MalformedURLException;
import java.time.LocalTime;

public class Solution {
    int readDelay;
    File file;

    public Solution(int readDelay, File file) {
        this.readDelay = readDelay;
        this.file = file;
    }

    public static BaseTask getTask(String type) {
        BaseTask task;
        switch (type) {
            case "A":
                task = new TaskA();
                break;
            case "B":
                task = new TaskB();
                break;
            case "C":
                task = new TaskC();
                break;
            default:
                return null;

        }
        return task;
    }

    public static void main(String[] args) throws InterruptedException {

        int readDelay;
        File file;

        try {
            readDelay = Integer.parseInt(args[0]);
        } catch (Exception e) {
            readDelay = 2; //default value
        }
        try {
            file = new File(args[1]);
            if (!file.canRead()) throw new MalformedURLException();
        } catch (Exception e) {
            System.out.println("invalid file, check filename and path. For example: D:\\t.txt ");
            return;
        }

        Solution solution = new Solution(readDelay,file);
        Executor executor = new Executor();
        solution.run(executor);
    }

    private void run(Executor executor) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                BaseTask task = Solution.getTask(line);
                if (task != null) {
                    System.out.println(LocalTime.now() + " receive task " + task);
                    executor.execute(task);
                    Thread.sleep(readDelay);
                }
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("incorrect File");
        } catch (InterruptedException e) {
            System.out.println("interrupted exception");
        } catch (IOException e) {
            System.out.println("IOException");
        }

        executor.shutdown();
    }
}
