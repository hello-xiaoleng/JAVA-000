package basic;


import java.util.concurrent.TimeUnit;

/**
 * @author wuleng
 * @date 2020-11-08
 */
public class WaitAndNotifyDemo {


    public static void main(String[] args) {

        final ProducerAndConsumer demo = new WaitAndNotifyDemo().new ProducerAndConsumer();

        System.out.println("生产者消费者demo");

        new Thread(() -> demo.product(), "thread-producer").start();

        new Thread(() -> demo.consume(), "thread-consumer-1").start();

        new Thread(() -> demo.consume(), "thread-consumer-2").start();

    }


    public class ProducerAndConsumer {

        private final Object lock = new Object();

        private final Integer MAX = 10;

        private int productCount = 0;


        /**
         * 生产者
         */
        public void product() {
            synchronized (lock) {
                while (true) {
                    if (productCount < MAX) {
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        productCount++;
                        System.out.println(Thread.currentThread().getName() + "producer producting......");
                    } else {
                        System.out.println("waiting for consumer");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }

        /**
         * 消费者
         */
        public void consume() {
            synchronized (lock) {
                while (true) {
                    if (productCount <= 0) {
                        System.out.println("waiting for producer......");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "consumer consume.......");
                        productCount--;
                    }
                    lock.notifyAll();
                }
            }
        }
    }
}
