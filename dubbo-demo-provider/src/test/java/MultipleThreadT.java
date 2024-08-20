import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MultipleThreadT {

    @Test
    void MultipleThreadTest() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2");
            }
        });
        t2.start();
    }
    @Test
    void MultipleThreadTest2() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable() {
            public Object call() throws Exception {
                System.out.println("this is start");
                Thread.sleep(1000);
                System.out.println("this is end");
                return "idea";
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();
        if(futureTask.isCancelled()) {
            System.out.println("任务被中断了");
        }
        Thread.sleep(2000);
        if(futureTask.isDone()) {
            String result = (String) futureTask.get();
            System.out.println(result);
        }
    }
}
