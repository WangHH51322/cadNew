package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/19 20:54
 */
public class test04 {
    public static void main(String[] args) {
        Object s2 = way2().get("s1");
        System.out.println(s2);
    }
    public static Map<String,Object> way2()
    {
        List<String> s1 = new ArrayList<>();
        List<Integer> s2 = new ArrayList<>();
        s1.add("123");
        s2.add(456);
        Map<String,Object> backObject=new HashMap<String, Object>();
        backObject.put("s1", s1);
        backObject.put("s2", s2);

        return backObject;
    }
}
