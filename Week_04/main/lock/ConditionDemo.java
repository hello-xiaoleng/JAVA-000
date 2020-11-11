package lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenjia
 * @date 2020-11-10
 */
public class ConditionDemo {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final Object[] items = new Object[20];
    private int putptr, takeptr, count;

    public static void main(String[] args) {
        ConditionDemo demo = new ConditionDemo();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        demo.put(new Object());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });
            threads.add(thread);
        }

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(() -> {
                while (true) {
                    try {
                        demo.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

    }


    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            // 当count等于数组的大小时，当前线程等待，直到notFull通知，再进行生产
            while (count == items.length) {
                System.out.println(Thread.currentThread().getName() + " waiting...");
                notFull.await();
            }

            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread().getName() + " put");
            items[putptr] = x;
            if (++putptr == items.length) {
                putptr = 0;
            }
            ++count;
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            // 当count为0，进入等待，直到notEmpty通知，进行消费。
            while (count == 0) {
                System.out.println(Thread.currentThread().getName() + " waiting...");
                notEmpty.await();
            }
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println(Thread.currentThread().getName() + " take");
            Object x = items[takeptr];
            if (++takeptr == items.length) {
                takeptr = 0;
            }
            --count;
            notFull.signalAll();
            return x;
        } finally {
            lock.unlock();
        }
    }
}