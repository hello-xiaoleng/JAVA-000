
package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author chenjia
 * @date 2020-11-10
 */
public class NewCachedThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10000; i++) {
            final int no = i;
            Runnable runnable = () -> {
                try {
                    System.out.println("start:" + no);
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("end:" + no);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
        System.out.println("Main Thread End!");


    }

}
