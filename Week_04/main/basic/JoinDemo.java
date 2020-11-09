package basic;


/**
 * @author wuleng
 * @date 2020-11-08
 * <p>
 * 小结: 当前线程调用join方法会让出当前cpu得执行权限，进入Runnable状态，等待下一个cpu轮询。
 * join方法会释放锁，底层调用得wait方法，锁得是当前对象。
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
