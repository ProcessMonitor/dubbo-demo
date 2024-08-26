import org.junit.jupiter.api.Test;

import java.rmi.ServerException;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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


    @Test
    void CompletableFutureTest() {
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("future working start ... ");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "OK";
        }).thenAccept(result -> {
            String lowerCase = result.toLowerCase();
            System.out.println(" 拿到 OK 的结果 : " + lowerCase);
        });

        System.out.println(" Do something else");
        future.join();
    }

    @Test
    void CombineResultTest() throws ServerException {
        try {
            CompletableFuture<Void> future = CompletableFuture.runAsync(() ->
                    System.out.println("hello runAsync!")
            );
            future.get();// 输出 "hello!"
            CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() ->
                    "hello supply !"
            );
            future2.get();
            assertEquals("hello supply !", future2.get());
            CompletableFuture.allOf(future, future2).get(1, TimeUnit.SECONDS);

        } catch (Exception e) {
            throw new ServerException("超时" , e);
        }
    }
}
