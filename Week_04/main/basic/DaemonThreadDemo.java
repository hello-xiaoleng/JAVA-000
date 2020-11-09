package basic;

import java.util.concurrent.TimeUnit;

/**
 * @author �¼�
 * @date 2020-11-08
 * �ػ��߳�demo
 * main�߳�ִ����ϣ��ػ��߳��Զ��˳�
 */
public class DaemonThreadDemo extends Thread {

    @Override
    public void run() {
        try {
            //����5����
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
