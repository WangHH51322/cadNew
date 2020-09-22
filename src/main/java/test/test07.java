package test;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/26 22:17
 */
public class test07 {
    public static void main(String[] args) {
        String str="141945@9573@qq.com";
        String str1=str.substring(0, str.lastIndexOf("@"));//截取@之前的字符串
        System.out.println(str1);
    }
}
