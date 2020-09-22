package data;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static data.MathMethod.add02;
import static data.MathMethod.sequence;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 15:59
 */
public class PlugCalculate {

    //将加油栓加入到拓扑结构中去
    public static List<List<String>> addPlug(List<List<String>> newPlug, List<List<String>> listTest, List<List<String>> pipe) {
        int x0 = pipe.size();
        int y0 = listTest.size();

        add02(newPlug, listTest);

        //将在管段上的加油栓编号放入List<Integer>中
        List<Integer> n1 = new ArrayList<>();

        for (int j = 0; j < newPlug.size(); j++) {
            for (int i = 0; i < pipe.size(); i++) {
                DecimalFormat df = new DecimalFormat("######0.0");

                int var1 = (int)Double.parseDouble(pipe.get(i).get(1));
                double var11 = Double.parseDouble(pipe.get(i).get(1));

                int var2 = (int)Double.parseDouble(pipe.get(i).get(4));
                double var22 = Double.parseDouble(pipe.get(i).get(4));

                int var3 = (int)Double.parseDouble(pipe.get(i).get(2));
                double var33 = Double.parseDouble(pipe.get(i).get(2));

                int var4 = (int)Double.parseDouble(pipe.get(i).get(5));
                double var44 = Double.parseDouble(pipe.get(i).get(5));

                int var5 = listTest.size() - newPlug.size() + j;

                int var6 = (int)Double.parseDouble(listTest.get(var5).get(1));
                double var66 = Double.parseDouble(listTest.get(var5).get(1));

                int var7 = (int)Double.parseDouble(listTest.get(var5).get(2));
                double var77 = Double.parseDouble(listTest.get(var5).get(2));


                if (var3 == var4 && var7 == var3 && var6 < MathMethod.getBig(var1, var2) && var6 > MathMethod.getSmall(var1, var2)) {
                    System.out.println("管段编号:" + pipe.get(i).get(0) + ",节点编号:" + (var5 + 1));
                    //在管段上的加油栓编号
                    n1.add(var5 + 1);

                    List<String> list1 = new ArrayList<>();
                    List<String> list2 = new ArrayList<>();

                    list1.add(null);
                    list1.add(pipe.get(i).get(1));
                    list1.add(pipe.get(i).get(2));
                    list1.add(pipe.get(i).get(3));
                    list1.add(listTest.get(var5).get(1));
                    list1.add(listTest.get(var5).get(2));
                    list1.add(listTest.get(var5).get(0));

                    list1.add(pipe.get(i).get(7));


                    list2.add(null);
                    list2.add(listTest.get(var5).get(1));
                    list2.add(listTest.get(var5).get(2));
                    list2.add(listTest.get(var5).get(0));
                    list2.add(pipe.get(i).get(4));
                    list2.add(pipe.get(i).get(5));
                    list2.add(pipe.get(i).get(6));

                    list2.add(pipe.get(i).get(7));



                    pipe.remove(pipe.get(i));

                    pipe.add(list1);
                    pipe.add(list2);

                    sequence(pipe);
                }
                else if (var1 == var2 && var6 == var1 && var7 < MathMethod.getBig(var3, var4) && var7 > MathMethod.getSmall(var3, var4)) {
                    System.out.println("管段编号:" + pipe.get(i).get(0) + ",节点编号:" + (var5 + 1));
                    //在管段上的加油栓编号
                    n1.add(var5 + 1);

                    List<String> list1 = new ArrayList<>();
                    List<String> list2 = new ArrayList<>();

                    list1.add(null);
                    list1.add(pipe.get(i).get(1));
                    list1.add(pipe.get(i).get(2));
                    list1.add(pipe.get(i).get(3));
                    list1.add(listTest.get(var5).get(1));
                    list1.add(listTest.get(var5).get(2));
                    list1.add(listTest.get(var5).get(0));

                    list1.add(pipe.get(i).get(7));


                    list2.add(null);
                    list2.add(listTest.get(var5).get(1));
                    list2.add(listTest.get(var5).get(2));
                    list2.add(listTest.get(var5).get(0));
                    list2.add(pipe.get(i).get(4));
                    list2.add(pipe.get(i).get(5));
                    list2.add(pipe.get(i).get(6));

                    list2.add(pipe.get(i).get(7));



                    pipe.remove(pipe.get(i));
                    pipe.add(list1);
                    pipe.add(list2);
                    sequence(pipe);
                }
                else if (var1 != var2 && var3 != var4 && var6 < MathMethod.getBig(var1, var2) && var6 > MathMethod.getSmall(var1, var2) && var7 < MathMethod.getBig(var3, var4) && var7 > MathMethod.getSmall(var3, var4) &&
                    df.format((var44 - var33) / (var22 - var11)).equals(df.format((var44 - var77) / (var22 - var66))) && df.format((var44 - var33) / (var22 - var11)).equals(df.format((var33 - var77) / (var11 - var66)))) {

                    System.out.println("管段编号:" + pipe.get(i).get(0) + ",节点编号:" + (var5 + 1));
                    //在管段上的加油栓编号
                    n1.add(var5 + 1);

                    List<String> list1 = new ArrayList<>();
                    List<String> list2 = new ArrayList<>();

                    list1.add(null);
                    list1.add(pipe.get(i).get(1));
                    list1.add(pipe.get(i).get(2));
                    list1.add(pipe.get(i).get(3));
                    list1.add(listTest.get(var5).get(1));
                    list1.add(listTest.get(var5).get(2));
                    list1.add((listTest.get(var5)).get(0));

                    list1.add((pipe.get(i)).get(7));


                    list2.add(null);
                    list2.add((listTest.get(var5)).get(1));
                    list2.add((listTest.get(var5)).get(2));
                    list2.add((listTest.get(var5)).get(0));
                    list2.add((pipe.get(i)).get(4));
                    list2.add((pipe.get(i)).get(5));
                    list2.add((pipe.get(i)).get(6));

                    list2.add((pipe.get(i)).get(7));



                    pipe.remove(pipe.get(i));
                    pipe.add(list1);
                    pipe.add(list2);
                    sequence(pipe);
                }
            }
        }
        for (int i = 0; i < pipe.size(); i++) {
            //起点x
            double x1 = Double.parseDouble(pipe.get(i).get(1));
            //起点y
            double y1 = Double.parseDouble(pipe.get(i).get(2));
            //终点x
            double x2 = Double.parseDouble(pipe.get(i).get(4));
            //终点y
            double y2 = Double.parseDouble(pipe.get(i).get(5));
            double length =Math.pow(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2),0.5);
            pipe.get(i).add(String.valueOf(length));
        }

        System.out.println("在管段上的加油栓节点编号:" + n1);
        int y1 = y0 + newPlug.size();
        //将在所有的单阀地井阀编号放入List<Integer>中
        List<Integer> n2 = new ArrayList<>();
        for (int i = y0+1; i <= y1; i++) {
            n2.add(i);
        }
        System.out.println("所有的非盲端加油栓节点编号:" + n2);
        if (n1.size() < n2.size()){
            loop:for (int i = Collections.min(n2); i <= Collections.max(n2); i++) {
                for (int j = Collections.min(n1); j <= Collections.max(n1); j++) {
                    if (i == j){
                        n2.remove(Integer.valueOf(i));
                        n1.remove(Integer.valueOf(j));
                        if (n1.size() == 0){
                            break loop;
                        }
                    }
                }
            }
            System.out.println("未统计的加油栓节点编号:" + n2);
            for (int i = 0; i < n2.size(); i++) {
                loop:for (int j = 0; j < listTest.size(); j++) {
                    if (n2.get(i) == Integer.parseInt(listTest.get(j).get(0))){
                        System.out.println("未统计的加油栓节点" + n2.get(i) + "的坐标为:(" + listTest.get(j).get(1) + "," + listTest.get(j).get(2) + ")");
                        break loop;
                    }
                }

            }
        }
        return pipe;
    }

    //获得哦所有块对象中的加油栓
    public static List<List<String>> getPlug(List<List<String>> block){
        List<List<String>> plug = new ArrayList<>();
        System.out.println("所有块:" + block);
        for (int i = 0; i < block.size(); i++) {
            if (block.get(i).get(0).contains("栓")){
                plug.add(block.get(i));
            }
        }
        return plug;
    }
}
