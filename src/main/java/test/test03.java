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
        String str = "aaa,bbb,ccc";

        List<String> lis = Arrays.asList(str.split(","));
        System.out.println(lis);
    }
}
