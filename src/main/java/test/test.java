package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/12 17:18
 */
public class test {
    public static void main(String[] args) {
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        n1.add(0);
        n1.add(1);
        n1.add(2);
        n1.add(3);
        n2.add(0);
        n2.add(1);
        n2.add(2);
        loop:for (int i = Collections.min(n1); i <= Collections.max(n1); i++) {
            for (int j = Collections.min(n2); j <= Collections.max(n2); j++) {
                if (i == j){
                    n1.remove(Integer.valueOf(i));
                    n2.remove(Integer.valueOf(j));
                    if (n2.size() == 0){
                        break loop;
                    }
                }
            }
        }
        System.out.println(n1);

        List<Integer> n3 = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            n3.add(i);
        }
        System.out.println(n3);
    }
}
