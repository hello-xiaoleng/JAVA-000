package homework;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author chen jia
 * @date 2020/11/11 18:36
 */
public class HomeWork {


    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        int result = function1();
        // ȷ���õ�result �����
        System.out.println("�첽������Ϊ��" + result);
        System.out.println("ʹ��ʱ�䣺" + (System.currentTimeMillis() - start) + " ms");
    }


    // ʹ���̳߳� submit �첽�ύ����
    public static int function1() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        final Future<Integer> result = executorService.submit(() -> sum());
        try {
            return result.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
        return 0;
    }

    // ʹ�� FutureTask �첽ִ������
    public static int function2() {
        FutureTask<Integer> futureTask = new FutureTask<>(HomeWork::sum);
        try {
            new Thread(futureTask).start();
            return futureTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Semaphore
    public static int function3() {
        AtomicInteger sum = new AtomicInteger();
        Semaphore semaphore = new Semaphore(1);
        new Thread(() -> {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum.set(sum());
            semaphore.release();
        }).start();

        while (sum.get() <= 0) {
        }
        return sum.get();
    }

    // CountDownLatch
    public static int function4() {
        AtomicInteger sum = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(() -> {
            sum.set(sum());
            countDownLatch.countDown();
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sum.get();
    }

    // CyclicBarrier
    public static int function5() {
        AtomicInteger sum = new AtomicInteger();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1, () -> new Thread(() -> {
            sum.set(sum());
        }).start());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        while (sum.get() <= 0) {
        }
        return sum.get();
    }

    // CompletableFuture
    public static int function6() {
        return CompletableFuture.supplyAsync(HomeWork::sum).join();
    }

    // �߳� join
    public static int function7() {
        AtomicInteger sum = new AtomicInteger();
        final Thread thread = new Thread(() -> sum.set(sum()));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sum.get();
    }

    // �߳� sleep
    public static int function8() {
        AtomicInteger sum = new AtomicInteger();
        new Thread(() -> {
            sum.set(sum());
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sum.get();
    }


    // LockSupport
    public static int function9() {
        AtomicInteger sum = new AtomicInteger();
        Thread paren = Thread.currentThread();
        Thread thread = new Thread(() -> {
            sum.set(sum());
            LockSupport.unpark(paren);
        });
        thread.start();
        LockSupport.park();
        return sum.get();
    }

    private static int sum() {
        System.out.println("ִ��������̣߳�" + Thread.currentThread().getName());
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

}
