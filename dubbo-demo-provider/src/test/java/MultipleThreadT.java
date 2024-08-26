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

    @Test
    void MultipleThreadTest3() {
        try {
            FutureTask<Integer> futureTask = new FutureTask<>(() -> {
                int result = 0;
                for (int i = 0; i < 10; i++) {
                    result += i;
                }
                return result;
            });
            Thread thread = new Thread(futureTask);
            thread.start();
            System.out.println("计算结果为：" + futureTask.get());
        }catch (Exception e){
            System.out.println("计算出错");
            e.printStackTrace();
            return ;
        }finally {
            System.out.println("计算结束 finally");
        }
    }
}
