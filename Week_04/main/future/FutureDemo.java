package future;

import java.util.Random;
import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(() -> new Random().nextInt());
        executor.shutdown();
        try {
            System.out.println("result:" + result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}