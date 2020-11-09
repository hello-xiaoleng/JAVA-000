package atomic;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * 原子类demo
 * 10个线程分别累加100_000_000次，使用LongAdder 消耗2000ns
 * 使用 AtomicLong 消耗19605 ns，性能提升了20倍
 */
public class AtomicDemo {

    private final static AtomicInteger ATOMIC_ELEMENT = new AtomicInteger();

    private final static AtomicInteger ATOMIC_LONG = new AtomicInteger();

    private final static LongAdder LONG_ADDER = new LongAdder();

    private final static CountDownLatch LATCH = new CountDownLatch(10);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100_000_000; j++) {
//                    ATOMIC_ELEMENT.addAndGet(1);
//                    LONG_ADDER.add(1);
                    ATOMIC_LONG.addAndGet(1);
                }

                LATCH.countDown();
            });
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        //等待所有线程执行完毕
        try {
            LATCH.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(ATOMIC_LONG.get());

        System.out.println("cconsuming time:" + (end - start));
    }


}
