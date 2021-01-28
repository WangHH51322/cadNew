package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/18 22:16
 */
public class test03 {
    public static void main(String[] args) {
        List<Integer> n2 = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            n2.add(i*5);
        }
        System.out.println(n2);
        n2.remove(Integer.valueOf(5));
        System.out.println(n2);
    }
}
