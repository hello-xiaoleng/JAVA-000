package basic;

import java.util.concurrent.TimeUnit;

/**
 * @author �¼�
 * @date 2020-11-08
 * �ܽ�: isInterrupted() ��ѯ��ǰ�߳��ж�״̬
 *      interrupt(); �ж��̵߳�ǰ�ж�״̬���һ����õ�ǰ�߳�״̬Ϊ δ�ж�
 *      ��������״̬���߳� ����interrupt�������׳�InterruptedException�쳣
 */
public class InterruptThreadDemo {

    public static void main(String[] args) {

        Runnable01 runner01 = new Runnable01();
        Thread thread1 = new Thread(runner01);

        Runnable02 runner2 = new Runnable02();
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();


        System.out.println(Thread.activeCount());

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread.currentThread().getThreadGroup().list();
        System.out.println(Thread.currentThread().getThreadGroup().getParent().activeGroupCount());
        Thread.currentThread().getThreadGroup().getParent().list();


    }


    public static class Runnable01 implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("����Runner1����״̬---------".concat(i + ""));
            }
        }
    }


    public static class Runnable02 implements Runnable {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("����Runner2����״̬---------".concat(i + ""));
            }

            boolean result = Thread.currentThread().isInterrupted();
            boolean result1 = Thread.interrupted();
            boolean result2 = Thread.currentThread().isInterrupted();
            System.out.println("Runner2.run result ===>" + result);
            System.out.println("Runner2.run result1 ===>" + result1);
            System.out.println("Runner2.run result3 ===>" + result2);
        }


    }
}
