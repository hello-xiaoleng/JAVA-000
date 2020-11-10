package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenjia
 * @date 2020-11-10
 * 总结：1、读锁不互斥、写锁互斥
 *      2、 读锁和写锁是互斥的
 */
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        final Counter counter = new Counter();


        for (int i = 0; i < 20; i++) {
            new Thread(counter::get).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(counter::put).start();
        }
    }

    public static class Counter {
        private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

        /**
         * 读操作
         */
        public void get() {
            rwLock.readLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " get begin");
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + " get end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwLock.readLock().unlock();
            }
        }

        /**
         * 写操作
         */
        public void put() {
            rwLock.writeLock().lock();
            try {
                System.out.println(Thread.currentThread().getName() + " put begin");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " put end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                rwLock.writeLock().unlock();
            }
        }
    }
}
