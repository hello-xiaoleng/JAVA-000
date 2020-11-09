package basic;


/**
 * @author wuleng
 * @date 2020-11-08
 * <p>
 * С��: ��ǰ�̵߳���join�������ó���ǰcpu��ִ��Ȩ�ޣ�����Runnable״̬���ȴ���һ��cpu��ѯ��
 * join�������ͷ������ײ���õ�wait�����������ǵ�ǰ����
 */
public class JoinDemo {
    public static void main(String[] args) {
        MyThread myThread = new JoinDemo().new MyThread("myThread");
        myThread.start();
        synchronized (myThread) {
            for (int i = 0; i < 40; i++) {
                if (i == 20) {
                    try {
                        myThread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "=====" + i);
            }
        }
    }

    public class MyThread extends Thread {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 20; i++) {
                    System.out.println(name + "====" + i);
                }
            }
        }
    }
}
