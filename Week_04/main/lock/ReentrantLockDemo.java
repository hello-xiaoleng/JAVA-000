
package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chenjia
 * @date 2020-11-10
 */
public class ReentrantLockDemo {

    public static void main(String[] args) {
        final Counter counter = new Counter();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.get();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.put();
            }
        }).start();
    }

    public static class Counter {

        private final ReentrantLock lock = new ReentrantLock(true);

        private void get() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " begin get");
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + " end get");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        private void put() {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " begin put");
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + " end put");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
