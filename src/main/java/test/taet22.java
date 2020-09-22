package test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/23 22:02
 */
public class taet22 {

    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("测试1");
        list.add("测试2");
        list.add("测试3");
        String join = String.join(",", list);
        System.out.println("join{}"+join);

    }
}
