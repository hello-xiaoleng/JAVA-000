package java8;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {
    
    public static void main(String[] args) throws IOException {
    
        List<Integer> list = Arrays.asList(4,2,3,5,1,2,2,7,6);
        print(list);
        
        // Optional
        Optional<Integer> first = list.stream().findFirst();
        
        System.out.println(first.map(i -> i * 100).orElse(100));

        int sum = list.stream().filter(i -> i < 4).distinct().reduce(0, Integer::sum);
        System.out.println("sum="+sum);

        Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(a -> a, a -> (a + 1), (a, b) -> a, LinkedHashMap::new));
        print(map);

        map.forEach((k, v) -> System.out.println("key:value = " + k + ":" + v));
        List<Integer> list1 = map.entrySet().parallelStream().map(e -> e.getKey() + e.getValue()).collect(Collectors.toList());
        print(list1);
        
    
    }
    
    
    private static void print(Object obj) {
        System.out.println(JSON.toJSONString(obj));
    }
}
