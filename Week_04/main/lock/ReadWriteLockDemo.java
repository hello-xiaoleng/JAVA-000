package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chen jia
 * @date 2020/11/10 19:07
 */

public class ReadWriteLockDemo {

    public static void main(String[] args) {

        final Counter counter = new Counter();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> counter.get()).start();

        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> counter.get()).start();

        }


    }


    public static class Counter {

        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


        public void get() {
            ReentrantReadWriteLock.ReadLock readLock = lock.readLock();


        }

        public void put() {
            ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();


        }


    }
}
