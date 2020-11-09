package basic;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈佳
 * @date 2020-11-08
 * 守护线程demo
 * main线程执行完毕，守护线程自动退出
 */
public class DaemonThreadDemo extends Thread {

    @Override
    public void run() {
        try {
            //休眠5秒钟
            TimeUnit.SECONDS.sleep(5);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DaemonThreadDemo thread = new DaemonThreadDemo();
        thread.setName("thread-1");
        thread.setDaemon(false);
        thread.start();
        System.out.println("main thread complete");
    }
}
