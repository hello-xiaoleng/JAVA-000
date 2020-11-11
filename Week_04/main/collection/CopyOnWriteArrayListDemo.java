package collection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {

        // ArrayList，LinkedList，Vector不安全，运行报错
//        List<Integer> list = new ArrayList<Integer>();
//        List<Integer> list = new LinkedList<>();
//        List<Integer> list = new Vector<>();

        // 只有CopyOnWriteArrayList 安全，不报错
        List<Integer> list = new CopyOnWriteArrayList<Integer>();

        for (int i = 0; i < 100_00; i++) {
            list.add(i);
        }

        PutThread putThread = new PutThread(list);
        RemoveThread removeThread = new RemoveThread(list);
        putThread.start();
        removeThread.start();

    }

    public static class PutThread extends Thread {
        private List<Integer> list;

        public PutThread(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (Integer i : list) {
                System.out.println("i");
            }
        }
    }

    public static class RemoveThread extends Thread {
        private List<Integer> list;

        public RemoveThread(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < list.size(); i++) {
                list.remove(i);
            }
        }
    }

}
