package future;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {
    public static void main(String[] args) {
        //第一种方式
        FutureTask<Integer> task;
//        task = new java.util.concurrent.FutureTaskDemo<>(() -> new Random().nextInt());
//        new Thread(task).start();
        //第二种方方式
        ExecutorService executor = Executors.newSingleThreadExecutor();
        task = new FutureTask<>(() -> new Random().nextInt());
        executor.submit(task);

        try {
            System.out.println("result: " + task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}