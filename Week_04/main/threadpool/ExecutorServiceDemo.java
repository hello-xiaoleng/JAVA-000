
package threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author chenjia
 * @date 2020-11-10
 */
public class ExecutorServiceDemo {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(16);

    public static void main(String[] args) {

        executorService.scheduleAtFixedRate(() -> {
            System.out.println("print hello world");
        }, 2, 1, TimeUnit.SECONDS);

        try {
            String str = executorService.submit(() -> "I am a task, which submited by the so called laoda, and run by those anonymous workers").get();
            System.out.println("str=" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
