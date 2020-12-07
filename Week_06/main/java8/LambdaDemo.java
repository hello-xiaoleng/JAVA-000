package java8;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

public class LambdaDemo<T extends Serializable & Collection> {

    public static void main(String args[]) {
        LambdaDemo demo = new LambdaDemo();

        MathOperation op = new MathOperation<Integer>() {
            @Override
            public Integer operation(Integer a, Integer b) {
                return 1;
            }
        };

        MathOperation op1 = (a, b) -> 1;

        // 类型声明
        MathOperation<Integer> addition = (a, b) -> a + b;

        // 不用类型声明
        MathOperation<Integer> subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation<Integer> multiplication = (a, b) -> a * b;

        // 没有大括号及返回语句
        MathOperation<Integer> division = (a, b) -> a / b;

        //pow
        MathOperation<Integer> pow = (a, b) -> (int) Math.pow(a, b);

        System.out.println("10 + 5 = " + demo.operate(10, 5, addition));
        System.out.println("10 - 5 = " + demo.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + demo.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + demo.operate(10, 5, division));

        System.out.println("10 ^ 5 = " + demo.<Integer>operate(10, 5, pow));

        // 不用括号
        GreetingService greetService1 = message -> System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

        GreetingService greetService3 = System.out::println;

        Arrays.asList(1, 2, 3).forEach(x -> System.out.println(x + 3));
        Arrays.asList(1, 2, 3).forEach(LambdaDemo::println);

        greetService1.sayMessage("kimmking");
        greetService2.sayMessage("Java");
    }

    private static void println(int x) {
        System.out.println(x + 3);
    }

    @FunctionalInterface
    interface MathOperation<T> {
        //返回类型+函数名+参数类型的列表
        T operation(T a, T b);
    }

    @FunctionalInterface
    interface GreetingService {
        void sayMessage(String message);
    }

    private <T> T operate(T a, T b, MathOperation<T> mathOperation) {
        return mathOperation.operation(a, b);
    }

}
