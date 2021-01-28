package data;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 13:40
 */
public class MathMethod {

    //获取两个数中较小值和较大值的方法
    public static int getBig(int a,int b){
        if (a < b){
            return b;
        }else {
            return a;
        }
    }
    public static int getSmall(int a,int b){
        if (a < b){
            return a;
        }else {
            return b;
        }
    }
    public static double getBig2(double a,double b){
        if (a < b){
            return b;
        }else {
            return a;
        }
    }
    public static double getSmall2(double a,double b){
        if (a < b){
            return a;
        }else {
            return b;
        }
    }

    //将调整后的管段数组进行重新排序
    public static List<List<String>> sequence(List<List<String>> pipe) {
        for (int i = 0; i < pipe.size(); i++) {
            int count = 0;
            count = i + 1;
            (pipe.get(i)).set(0, String.valueOf(count));
        }
        return pipe;
    }

    //将数组拼接在一起的方法
    //以下为合并List<List<String>>数组的方法,包括了两个/三个/四个/五个数组的合并,如果有需要,可以仿照代码自行添加数组个数
    public static List<List<String>> contact1(List<List<String>> a) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < a.size() ; i++) {
            result.add(a.get(i)) ;
        }
        return result;
    }
    public static List<List<String>> contact2(List<List<String>> a, List<List<String>> b) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < (a.size() + b.size()); i++) {
            if (i < a.size()) {
                result.add(a.get(i)) ;
            } else {
                result.add(b.get(i - a.size()));
            }
        }
        return result;
    }
    public static List<List<String>> contact3(List<List<String>> a, List<List<String>> b, List<List<String>> c) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < (a.size() + b.size() + c.size()); i++) {
            if (i < a.size()) {
                result.add(a.get(i)) ;
            } else if (i < a.size() + b.size()){
                result.add(b.get(i - a.size()));
            }else {
                result.add(c.get(i - a.size() - b.size()));
            }
        }
        return result;
    }
    public static List<List<String>> contact4(List<List<String>> a, List<List<String>> b, List<List<String>> c,List<List<String>> d) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < (a.size() + b.size() + c.size() + d.size()); i++) {
            if (i < a.size()) {
                result.add(a.get(i)) ;
            } else if (i < a.size() + b.size()){
                result.add(b.get(i - a.size()));
            }else if (i < a.size() + b.size() + c.size()){
                result.add(c.get(i - a.size() - b.size()));
            }else {
                result.add(d.get(i - a.size() - b.size() - c.size()));
            }
        }
        return result;
    }
    public static List<List<String>> contact5(List<List<String>> a, List<List<String>> b, List<List<String>> c,List<List<String>> d,List<List<String>> e) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < (a.size() + b.size() + c.size() + d.size() + e.size()); i++) {
            if (i < a.size()) {
                result.add(a.get(i)) ;
            } else if (i < a.size() + b.size()){
                result.add(b.get(i - a.size()));
            }else if (i < a.size() + b.size() + c.size()){
                result.add(c.get(i - a.size() - b.size()));
            }else if (i < a.size() + b.size() + c.size() + d.size()){
                result.add(d.get(i - a.size() - b.size() - c.size()));
            }else {
                result.add(e.get(i - a.size() - b.size() - c.size() - d.size()));
            }
        }
        return result;
    }

    //分别筛选出int[]数组中只出现一/二/三/四次的数,并将其放入一个新的数组
    public static int[] getOne(int[] a) {
        int c = 0;
        int d = 0;
        for (int i = 0; i < a.length; i++) {
            int b = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    b++;
                }
            }
            if (b == 1) {
                c += 1;
            }
        }
        int[] num = new int[c];
        for (int i = 0; i < a.length; i++) {
            int b = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    b++;
                }
            }
            if (b == 1) {
                num[d] = a[i];
                d += 1;
            }
        }
        return num;
    }
    public static int[] getTwo(int[] a) {
        int c = 0;
        int d = 0;
        for (int i = 0; i < a.length; i++) {
            int b = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    b++;
                }
            }
            if (b == 2) {
                c += 1;
            }
        }
        int[] num = new int[c];
        for (int i = 0; i < a.length; i++) {
            int b = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    b++;
                }
            }
            if (b == 2) {
                num[d] = a[i];
                d += 1;
            }
        }
        //将重复的数删除,只留下不重复的数
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            //利用list集合的contains方法过滤重复数据
            if (!list.contains(num[i])) {
                list.add(num[i]);
            }
        }
        //利用java8的新特性stream转换成int数组
        int[] intArr = list.stream().mapToInt(Integer::intValue).toArray();

        return intArr;
    }
    public static int[] getThree(int[] a) {
        int c = 0;
        int d = 0;
        for (int i = 0; i < a.length; i++) {
            int b = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    b++;
                }
            }
            if (b == 3) {
                c += 1;
            }
        }
        int[] num = new int[c];
        for (int i = 0; i < a.length; i++) {
            int b = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    b++;
                }
            }
            if (b == 3) {
                num[d] = a[i];
                d += 1;
            }
        }

        //将重复的数删除,只留下不重复的数
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            //利用list集合的contains方法过滤重复数据
            if (!list.contains(num[i])) {
                list.add(num[i]);
            }
        }
        //利用java8的新特性stream转换成int数组
        int[] intArr = list.stream().mapToInt(Integer::intValue).toArray();

        return intArr;
    }
    public static int[] getFour(int[] a) {
        int c = 0;
        int d = 0;
        for (int i = 0; i < a.length; i++) {
            int b = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    b++;
                }
            }
            if (b == 4) {
                c += 1;
            }
        }
        int[] num = new int[c];
        for (int i = 0; i < a.length; i++) {
            int b = 0;
            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) {
                    b++;
                }
            }
            if (b == 4) {
                num[d] = a[i];
                d += 1;
            }
        }

        //将重复的数删除,只留下不重复的数
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            //利用list集合的contains方法过滤重复数据
            if (!list.contains(num[i])) {
                list.add(num[i]);
            }
        }
        //利用java8的新特性stream转换成int数组
        int[] intArr = list.stream().mapToInt(Integer::intValue).toArray();

        return intArr;
    }
    //将上述四个数组合并
    public static int[] contact4(int[] a, int[] b, int[] c, int[] d) {
        int[] result = new int[a.length + b.length+ c.length+ d.length];
        for (int i = 0; i < result.length; i++) {
            if (i < a.length) {
                result[i] = a[i];
            } else if (i < a.length + b.length){
                result[i] = b[i - a.length];
            }else if (i < a.length + b.length + c.length){
                result[i] = c[i - a.length - b.length];
            }else {
                result[i] = d[i - a.length - b.length - c.length];
            }
        }
        return result;
    }

    //将阀门坐标和节点坐标合并的方法
    public static List<List<String>> add(List<List<String>> valveOne, List<List<String>> listTest) {
         for (int i = 0; i < valveOne.size(); i++) {
           List<String> addnode = new ArrayList<>();
           addnode.add(String.valueOf(listTest.size() + 1));
           addnode.add((valveOne.get(i)).get(1));
           addnode.add((valveOne.get(i)).get(2));
           addnode.add("阀门");
           listTest.add(addnode);
         }
        return listTest;
    }
    //将不重合的加油栓和节点合并的方法
    public static List<List<String>> add02(List<List<String>> newPlug, List<List<String>> listTest) {
        /* 1009 */     for (int i = 0; i < newPlug.size(); i++) {
            /* 1010 */       List<String> addNode = new ArrayList<>();
            /* 1011 */       addNode.add(String.valueOf(listTest.size() + 1));
            /* 1012 */       addNode.add(((List<String>)newPlug.get(i)).get(2));
            /* 1013 */       addNode.add(((List<String>)newPlug.get(i)).get(3));
            /* 1014 */       addNode.add("加油栓");
            /* 1015 */       listTest.add(addNode);
            /*      */     }
        /* 1017 */     return listTest;
        /*      */   }
    //将重合的加油栓坐标和节点坐标合并
    public static void addPlugIntoNode(List<List<String>> plug, List<List<String>> listTest) {
         DecimalFormat df = new DecimalFormat("######0.0000");
         int k = 0;
          for (int j = 0; j < listTest.size(); j++) {
              for (int i = 0; i < plug.size(); i++) {

                  double var1 = Double.parseDouble((listTest.get(j)).get(1));

                  double var2 = Double.parseDouble((listTest.get(j)).get(2));

                  double var3 = Double.parseDouble((plug.get(i)).get(2));

                  double var4 = Double.parseDouble((plug.get(i)).get(3));

                  if (df.format(var1).equals(df.format(var3)) && df.format(var2).equals(df.format(var4))) {
                       listTest.get(j).set(3, "加油栓");
                       k++;
                       break;
                  }
              }
          }
          System.out.println("与节点重合的加油栓个数:" + k);
    }
    //将不重合的加油栓坐标单独拿出,以便后面使用
    public static List<List<String>> removePlug(List<List<String>> plug, List<List<String>> listTest) {
        DecimalFormat df = new DecimalFormat("######0.0000");
        List<List<String>> newPlugs = new ArrayList<>();
         for (int i = 0; i < plug.size(); i++) {
               for (int j = 0; j < listTest.size(); j++) {

                     double var1 = Double.parseDouble((listTest.get(j)).get(1));

                     double var2 = Double.parseDouble((listTest.get(j)).get(2));

                     double var3 = Double.parseDouble((plug.get(i)).get(2));

                     double var4 = Double.parseDouble((plug.get(i)).get(3));

                     if (df.format(var1).equals(df.format(var3)) && df.format(var2).equals(df.format(var4))) {
                           plug.remove(i);
                           i--;
                           if (i < 0){
                               i = 0;
                           }
                         }
                       }
              }
             return plug;
           }

}
