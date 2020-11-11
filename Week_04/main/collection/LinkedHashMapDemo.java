package collection;

import java.util.*;

public class LinkedHashMapDemo {
    public static void main(String[] args) {

        // test hash map
        System.out.println("=====>1. test hash map");
        Map<String, String> hashMap = new HashMap<>(6);
        hashMap.put("name1", "josan1");
        hashMap.put("name2", "josan2");
        hashMap.put("name3", "josan3");
        Set<Map.Entry<String, String>> set = hashMap.entrySet();
        for (Map.Entry entry : set) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("hashMap key:" + key + ",value:" + value);
        }

        // test linked hash map
        System.out.println("=====>2. test linked hash map");
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("name1", "josan1");
        linkedHashMap.put("name2", "josan2");
        linkedHashMap.put("name3", "josan3");
        Set<Map.Entry<String, String>> set1 = linkedHashMap.entrySet();
        for (Map.Entry entry : set1) {
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            System.out.println("linkedHashMap key:" + key + ",value:" + value);
        }

    }
}
