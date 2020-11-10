package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author chenjia
 * @date 2020-11-10
 * 总结: park方法和unPark方法顺序可以互换，不会出现异常
 * interrupt方法会终止park，且不会出现异常
 */
public class LockSupportDemo {

    public static void main(String[] args) {

        //park():停止线程 unPark():恢复线程
        Thread thread1 = new Thread(new ChangeObjectThread("thread-1"));
        thread1.start();

//        LockSupport.unpark(thread1);
//        System.out.println("main 执行结束");
//        thread1.interrupt();
        LockSupport.unpark(thread1);
        System.out.println("main执行结束");
    }


    public static class ChangeObjectThread implements Runnable {
        private String name;

        public ChangeObjectThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("in " + this.name);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("被中断了");
            }
            System.out.println("继续执行");
        }

    }

}
