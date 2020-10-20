import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author chen jia
 * @date 2020/10/20 12:49
 */
public class HelloClassLoader extends ClassLoader {


    public static void main(String[] args) {

        HelloClassLoader classLoader = new HelloClassLoader();
        try {
            Class<?> hello = classLoader.findClass("Hello");
            Method method = hello.getDeclaredMethod("hello");
            method.invoke(hello.newInstance());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] bytes = readFile2ByteArray();

        return defineClass(name, bytes, 0, bytes.length);
    }


    /**
     * 读取文件到字节数组
     * 每个字节和255做减法
     *
     * @return
     */
    private byte[] readFile2ByteArray() {

        InputStream inputStream = HelloClassLoader.class.getResourceAsStream("Hello.xlass");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];
        try {
            int n = inputStream.read(bytes);
            while (n != -1) {
                for (int i = 0; i < n; i++) {
                    bytes[i] = (byte) (255 - bytes[i]);
                }
                byteArrayOutputStream.write(bytes, 0, n);
                n = inputStream.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

//        FileOutputStream fileOutputStream = null;
//        try {
//            fileOutputStream = new FileOutputStream("C:\\Users\\admin\\Desktop\\test1.txt");
//            byteArrayOutputStream.writeTo(fileOutputStream);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (fileOutputStream != null) {
//                try {
//                    fileOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        return byteArrayOutputStream.toByteArray();

    }
}
