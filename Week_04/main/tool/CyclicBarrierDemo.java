package tool;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("回调>>" + Thread.currentThread().getName());
            System.out.println("回调>>线程组执行结束");
        });
        for (int i = 0; i < 5; i++) {
            new Thread(new ReadNum(i, cyclicBarrier)).start();
        }

        System.out.println("==>各个子线程执行结束。。。。");
        System.out.println("==>主线程执行结束。。。。");


        //CyclicBarrier 可以重复利用
//        cyclicBarrier.reset();
//        for (int i = 11; i < 16; i++) {
//            new Thread(new ReadNum(i, cyclicBarrier)).start();
//        }
    }

    static class ReadNum implements Runnable {
        private int id;
        private CyclicBarrier cyc;

        public ReadNum(int id, CyclicBarrier cyc) {
            this.id = id;
            this.cyc = cyc;
        }

        @Override
        public void run() {
            System.out.println("id:" + id + "," + Thread.currentThread().getName());
            try {
                System.out.println("线程组任务" + id + "结束，其他任务继续");
                TimeUnit.SECONDS.sleep(1);
                // 注意跟CountDownLatch不同，这里在子线程await
                cyc.await();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}