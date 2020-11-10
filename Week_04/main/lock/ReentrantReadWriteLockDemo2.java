
package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author chenjia
 * @date 2020-11-10
 */
public class ReentrantReadWriteLockDemo2 {

    private final Map<String, Object> map = new HashMap<>();

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public Object readWrite(String key) {
        Object value = null;
        System.out.println("1.���ȿ�������ȥ������ȡ����");
        rwLock.readLock().lock();
        try {
            value = map.get(key);
            if (value == null) {
                System.out.println("2.���ݲ����ڣ����ͷŶ���������д��");
                rwLock.readLock().unlock();
                rwLock.writeLock().lock();
                try {
                    //����valueֵ
                    value = "aaaa";
                } finally {
                    System.out.println("3.�ͷ�д��");
                    rwLock.writeLock().unlock();
                }
                System.out.println("4.��������");
                rwLock.readLock().lock();
            }
        } finally {
            System.out.println("5.�ͷŶ���");
            rwLock.readLock().unlock();
        }
        return value;
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo2 demo2 = new ReentrantReadWriteLockDemo2();
        demo2.readWrite("key");
    }

}
