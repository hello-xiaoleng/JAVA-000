package lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @author chenjia
 * @date 2020-11-10
 * �ܽ�: park������unPark����˳����Ի�������������쳣
 * interrupt��������ֹpark���Ҳ�������쳣
 */
public class LockSupportDemo {

    public static void main(String[] args) {

        //park():ֹͣ�߳� unPark():�ָ��߳�
        Thread thread1 = new Thread(new ChangeObjectThread("thread-1"));
        thread1.start();

//        LockSupport.unpark(thread1);
//        System.out.println("main ִ�н���");
//        thread1.interrupt();
        LockSupport.unpark(thread1);
        System.out.println("mainִ�н���");
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
                System.out.println("���ж���");
            }
            System.out.println("����ִ��");
        }

    }

}
