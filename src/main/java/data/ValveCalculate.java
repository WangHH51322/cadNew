package data;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ValveCalculate {
  public static List<List<String>> singleValve(List<List<String>> block, List<List<String>> listTest, List<List<String>> pipe, List<String> errors) {
    List<List<String>> valveOne = new ArrayList<>();
    int x0 = pipe.size();
    int y0 = listTest.size();
    for (int i = 0; i < block.size(); i++) {
      List<String> valve = new ArrayList<>();
      if (((String)((List<String>)block.get(i)).get(1)).equals("1")) {
        valve.add(((List<String>)block.get(i)).get(0));
        valve.add(((List<String>)block.get(i)).get(2));
        valve.add(((List<String>)block.get(i)).get(3));
        valveOne.add(valve);
      }
    }
    MathMethod.add(valveOne, listTest);
    List<Integer> n1 = new ArrayList<>();
    for (int ii = 0; ii < valveOne.size() * 2 + pipe.size(); ii++) {
      label85: for (int k = 0; k < pipe.size(); k++) {
        DecimalFormat df = new DecimalFormat("######0.0");
        for (int m = 0; m < valveOne.size(); m++) {
          int var1 = (int)Double.parseDouble(((List<String>)pipe.get(k)).get(1));
          double var11 = Double.parseDouble(((List<String>)pipe.get(k)).get(1));
          int var2 = (int)Double.parseDouble(((List<String>)pipe.get(k)).get(4));
          double var22 = Double.parseDouble(((List<String>)pipe.get(k)).get(4));
          int var3 = (int)Double.parseDouble(((List<String>)pipe.get(k)).get(2));
          double var33 = Double.parseDouble(((List<String>)pipe.get(k)).get(2));
          int var4 = (int)Double.parseDouble(((List<String>)pipe.get(k)).get(5));
          double var44 = Double.parseDouble(((List<String>)pipe.get(k)).get(5));
          int var5 = listTest.size() - valveOne.size() + m;
          int var6 = (int)Double.parseDouble(((List<String>)listTest.get(var5)).get(1));
          double var66 = Double.parseDouble(((List<String>)listTest.get(var5)).get(1));
          int var7 = (int)Double.parseDouble(((List<String>)listTest.get(var5)).get(2));
          double var77 = Double.parseDouble(((List<String>)listTest.get(var5)).get(2));
          if (var3 == var4 && var7 == var3 && var6 < MathMethod.getBig(var1, var2) && var6 > MathMethod.getSmall(var1, var2)) {
            System.out.println("管段编号:" + (String)((List<String>)pipe.get(k)).get(0) + ",节点编号:" + var5 + 1);
            n1.add(Integer.valueOf(var5 + 1));
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            list1.add(null);
            list1.add(((List<String>)pipe.get(k)).get(1));
            list1.add(((List<String>)pipe.get(k)).get(2));
            list1.add(((List<String>)pipe.get(k)).get(3));
            list1.add(((List<String>)listTest.get(var5)).get(1));
            list1.add(((List<String>)listTest.get(var5)).get(2));
            list1.add(((List<String>)listTest.get(var5)).get(0));
            list1.add(((List<String>)pipe.get(k)).get(7));
            list2.add(null);
            list2.add(((List<String>)listTest.get(var5)).get(1));
            list2.add(((List<String>)listTest.get(var5)).get(2));
            list2.add(((List<String>)listTest.get(var5)).get(0));
            list2.add(((List<String>)pipe.get(k)).get(4));
            list2.add(((List<String>)pipe.get(k)).get(5));
            list2.add(((List<String>)pipe.get(k)).get(6));
            list2.add(((List<String>)pipe.get(k)).get(7));
            pipe.remove(pipe.get(k));
            pipe.add(list1);
            pipe.add(list2);
            MathMethod.sequence(pipe);
            break label85;
          }
          if (var1 == var2 && var6 == var1 && var7 < MathMethod.getBig(var3, var4) && var7 > MathMethod.getSmall(var3, var4)) {
            System.out.println("管段编号:" + (String)((List<String>)pipe.get(k)).get(0) + ",节点编号:" + var5 + 1);
            n1.add(Integer.valueOf(var5 + 1));
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            list1.add(null);
            list1.add(((List<String>)pipe.get(k)).get(1));
            list1.add(((List<String>)pipe.get(k)).get(2));
            list1.add(((List<String>)pipe.get(k)).get(3));
            list1.add(((List<String>)listTest.get(var5)).get(1));
            list1.add(((List<String>)listTest.get(var5)).get(2));
            list1.add(((List<String>)listTest.get(var5)).get(0));
            list1.add(((List<String>)pipe.get(k)).get(7));
            list2.add(null);
            list2.add(((List<String>)listTest.get(var5)).get(1));
            list2.add(((List<String>)listTest.get(var5)).get(2));
            list2.add(((List<String>)listTest.get(var5)).get(0));
            list2.add(((List<String>)pipe.get(k)).get(4));
            list2.add(((List<String>)pipe.get(k)).get(5));
            list2.add(((List<String>)pipe.get(k)).get(6));
            list2.add(((List<String>)pipe.get(k)).get(7));
            pipe.remove(pipe.get(k));
            pipe.add(list1);
            pipe.add(list2);
            MathMethod.sequence(pipe);
            break label85;
          }
          if (var1 != var2 && var3 != var4 && var6 < MathMethod.getBig(var1, var2) && var6 > MathMethod.getSmall(var1, var2) && var7 < MathMethod.getBig(var3, var4) && var7 > MathMethod.getSmall(var3, var4) && df
            .format((var44 - var33) / (var22 - var11)).equals(df.format((var44 - var77) / (var22 - var66))) && df.format((var44 - var33) / (var22 - var11)).equals(df.format((var33 - var77) / (var11 - var66)))) {
            n1.add(Integer.valueOf(var5 + 1));
            System.out.println("管段编号:" + (String)((List<String>)pipe.get(k)).get(0) + ",节点编号:" + var5 + 1);
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            list1.add(null);
            list1.add(((List<String>)pipe.get(k)).get(1));
            list1.add(((List<String>)pipe.get(k)).get(2));
            list1.add(((List<String>)pipe.get(k)).get(3));
            list1.add(((List<String>)listTest.get(var5)).get(1));
            list1.add(((List<String>)listTest.get(var5)).get(2));
            list1.add(((List<String>)listTest.get(var5)).get(0));
            list1.add(((List<String>)pipe.get(k)).get(7));
            list2.add(null);
            list2.add(((List<String>)listTest.get(var5)).get(1));
            list2.add(((List<String>)listTest.get(var5)).get(2));
            list2.add(((List<String>)listTest.get(var5)).get(0));
            list2.add(((List<String>)pipe.get(k)).get(4));
            list2.add(((List<String>)pipe.get(k)).get(5));
            list2.add(((List<String>)pipe.get(k)).get(6));
            list2.add(((List<String>)pipe.get(k)).get(7));
            pipe.remove(pipe.get(k));
            pipe.add(list1);
            pipe.add(list2);
            MathMethod.sequence(pipe);
            break label85;
          }
        }
      }
    }
    System.out.println("在管段上的单阀节点编号:" + n1);
    int y1 = y0 + valveOne.size();
    List<Integer> n2 = new ArrayList<>();
    for (int j = y0 + 1; j <= y1; j++)
      n2.add(Integer.valueOf(j));
    System.out.println("所有的单阀地井阀节点编号:" + n2);
    if (n1.size() < n2.size()) {
      label80: for (int j = ((Integer)Collections.<Integer>min(n2)).intValue(); j <= ((Integer)Collections.max((Collection)n2)).intValue(); j++) {
        for (int k = ((Integer)Collections.<Integer>min(n1)).intValue(); k <= ((Integer)Collections.max((Collection)n1)).intValue(); k++) {
          if (j == k) {
            n2.remove(Integer.valueOf(j));
            n1.remove(Integer.valueOf(k));
            if (n1.size() == 0)
              break label80;
          }
        }
      }
      System.out.println("未统计的单阀地井阀节点编号:" + n2);
      for (int j = 0; j < n2.size(); j++) {
        for (int k = 0; k < listTest.size(); k++) {
          if (((Integer)n2.get(j)).intValue() == Integer.parseInt(((List<String>)listTest.get(k)).get(0))) {
            String error1 = "[未统计的单阀地井阀节点" + n2.get(j) + "的坐标为:(" + (String)((List<String>)listTest.get(k)).get(1) + "," + (String)((List<String>)listTest.get(k)).get(2) + ")]";
            errors.add(error1);
            break;
          }
        }
      }
    }
    return pipe;
  }

  public static List<List<String>> doubleValve(List<List<String>> block, List<List<String>> listTest, List<List<String>> pipe, double distance, List<String> errors) {
    int x0 = pipe.size();
    int y0 = listTest.size();
    List<List<String>> valveTwo = new ArrayList<>();
    List<List<String>> valves = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("######0.0");
    for (int k = 0; k < block.size(); k++) {
      List<String> valve = new ArrayList<>();
      if (((String)((List<String>)block.get(k)).get(1)).equals("2")) {
        valve.add(((List<String>)block.get(k)).get(0));
        valve.add(((List<String>)block.get(k)).get(2));
        valve.add(((List<String>)block.get(k)).get(3));
        valve.add(((List<String>)block.get(k)).get(4));
        valve.add(((List<String>)block.get(k)).get(5));
        valve.add(String.valueOf((Double.parseDouble(((List<String>)block.get(k)).get(2)) + Double.parseDouble(((List<String>)block.get(k)).get(4))) / 2.0D));
        valve.add(String.valueOf((Double.parseDouble(((List<String>)block.get(k)).get(3)) + Double.parseDouble(((List<String>)block.get(k)).get(5))) / 2.0D));
        valveTwo.add(valve);
      }
    }
    System.out.println("双阀地井阀:" + valveTwo);
      System.out.println(valveTwo);
    System.out.println("双阀地井阀个数:" + valveTwo.size());
      System.out.println("listTest:" + listTest);
    for (int j = 0; j < valveTwo.size(); j++) {
      int count1 = 0;
      for (int i2 = 0; i2 < listTest.size(); i2++) {
        int i3 = 0;
        List<String> valve = new ArrayList<>();
        List<String> location = new ArrayList<>();
        int var1 = (int)Double.parseDouble(((List<String>)listTest.get(i2)).get(1));
        double var1_1 = Double.parseDouble(((List<String>)listTest.get(i2)).get(1));
        int var2 = (int)Double.parseDouble(((List<String>)listTest.get(i2)).get(2));
        double var2_2 = Double.parseDouble(((List<String>)listTest.get(i2)).get(2));
        int var3 = (int)Double.parseDouble(((List<String>)valveTwo.get(j)).get(1));
        int var4 = (int)Double.parseDouble(((List<String>)valveTwo.get(j)).get(2));
        int var5 = (int)Double.parseDouble(((List<String>)valveTwo.get(j)).get(3));
        int var6 = (int)Double.parseDouble(((List<String>)valveTwo.get(j)).get(4));
        int var11 = (int)Double.parseDouble(((List<String>)valveTwo.get(j)).get(5));
        double var111 = Double.parseDouble(((List<String>)valveTwo.get(j)).get(5));
        int var12 = (int)Double.parseDouble(((List<String>)valveTwo.get(j)).get(6));
        double var112 = Double.parseDouble(((List<String>)valveTwo.get(j)).get(6));
        if (var1 > MathMethod.getSmall(var3, var5) && var1 < MathMethod.getBig(var3, var5) && var2 > MathMethod.getSmall(var4, var6) && var2 < MathMethod.getBig(var4, var6)) {
          System.out.println("节点" + (String)((List<String>)listTest.get(i2)).get(0) + "在地井阀" + (String)((List<String>)valveTwo.get(j)).get(0) + "上");
          count1++;
          List<List<String>> pipeTest = new ArrayList<>();
          for (int l = 0; l < pipe.size(); l++) {
            int p1_1 = (int)Double.parseDouble(((List<String>)pipe.get(l)).get(1));
            int p2_1 = (int)Double.parseDouble(((List<String>)pipe.get(l)).get(2));
            int p1_2 = (int)Double.parseDouble(((List<String>)pipe.get(l)).get(4));
            int p2_2 = (int)Double.parseDouble(((List<String>)pipe.get(l)).get(5));
            if ((p1_1 == var1 && p2_1 == var2) || (p1_2 == var1 && p2_2 == var2)) {
              System.out.println("管段:" + (String)((List<String>)pipe.get(l)).get(0) + "在地井阀" + (String)((List<String>)valveTwo.get(j)).get(0) + "上");
              pipeTest.add(pipe.get(l));
            }
          }
          System.out.println(pipeTest);
          if (df.format(Double.parseDouble(((List<String>)pipeTest.get(0)).get(1))).equals(df.format(Double.parseDouble(((List<String>)pipeTest.get(0)).get(4)))) || df
            .format(Double.parseDouble(((List<String>)pipeTest.get(0)).get(2))).equals(df.format(Double.parseDouble(((List<String>)pipeTest.get(0)).get(5)))) || df
            .format(Double.parseDouble(((List<String>)pipeTest.get(1)).get(1))).equals(df.format(Double.parseDouble(((List<String>)pipeTest.get(1)).get(4)))) || df
            .format(Double.parseDouble(((List<String>)pipeTest.get(1)).get(2))).equals(df.format(Double.parseDouble(((List<String>)pipeTest.get(1)).get(5)))) || df
            .format(Double.parseDouble(((List<String>)pipeTest.get(2)).get(1))).equals(df.format(Double.parseDouble(((List<String>)pipeTest.get(2)).get(4)))) || df
            .format(Double.parseDouble(((List<String>)pipeTest.get(2)).get(2))).equals(df.format(Double.parseDouble(((List<String>)pipeTest.get(2)).get(5))))) {
            ((List<String>)valveTwo.get(j)).add("水平");
            if (var11 < var1) {
              location.add("左");
              valve.add(((List<String>)valveTwo.get(j)).get(0));
              valve.add(String.valueOf(Double.parseDouble(((List<String>)listTest.get(i2)).get(1)) - distance));
              valve.add(((List<String>)listTest.get(i2)).get(2));
            } else {
              location.add("右");
              valve.add(((List<String>)valveTwo.get(j)).get(0));
              valve.add(String.valueOf(Double.parseDouble(((List<String>)listTest.get(i2)).get(1)) + distance));
              valve.add(((List<String>)listTest.get(i2)).get(2));
            }
            if (var12 > var2) {
              location.add("上");
              valve.add(((List<String>)valveTwo.get(j)).get(0));
              valve.add(((List<String>)listTest.get(i2)).get(1));
              valve.add(String.valueOf(Double.parseDouble(((List<String>)listTest.get(i2)).get(2)) + distance));
            } else {
              location.add("下");
              valve.add(((List<String>)valveTwo.get(j)).get(0));
              valve.add(((List<String>)listTest.get(i2)).get(1));
              valve.add(String.valueOf(Double.parseDouble(((List<String>)listTest.get(i2)).get(2)) - distance));
            }
            valves.add(valve);
          } else {
            ((List<String>)valveTwo.get(j)).add("倾斜");
            int varS1_1 = (int)Double.parseDouble(((List<String>)pipeTest.get(0)).get(1));
            double varS11_1 = Double.parseDouble((pipeTest.get(0)).get(1));
            int varS2_1 = (int)Double.parseDouble((pipeTest.get(0)).get(2));
            double varS22_1 = Double.parseDouble((pipeTest.get(0)).get(2));
            int varE1_1 = (int)Double.parseDouble((pipeTest.get(0)).get(4));
            double varE11_1 = Double.parseDouble((pipeTest.get(0)).get(4));
            int varE2_1 = (int)Double.parseDouble((pipeTest.get(0)).get(5));
            double varE22_1 = Double.parseDouble(((List<String>)pipeTest.get(0)).get(5));
            int varS1_2 = (int)Double.parseDouble(((List<String>)pipeTest.get(1)).get(1));
            double varS11_2 = Double.parseDouble(((List<String>)pipeTest.get(1)).get(1));
            int varS2_2 = (int)Double.parseDouble(((List<String>)pipeTest.get(1)).get(2));
            double varS22_2 = Double.parseDouble(((List<String>)pipeTest.get(1)).get(2));
            int varE1_2 = (int)Double.parseDouble(((List<String>)pipeTest.get(1)).get(4));
            double varE11_2 = Double.parseDouble(((List<String>)pipeTest.get(1)).get(4));
            int varE2_2 = (int)Double.parseDouble(((List<String>)pipeTest.get(1)).get(5));
            double varE22_2 = Double.parseDouble(((List<String>)pipeTest.get(1)).get(5));
            int varS1_3 = (int)Double.parseDouble(((List<String>)pipeTest.get(2)).get(1));
            double varS11_3 = Double.parseDouble(((List<String>)pipeTest.get(2)).get(1));
            int varS2_3 = (int)Double.parseDouble(((List<String>)pipeTest.get(2)).get(2));
            double varS22_3 = Double.parseDouble(((List<String>)pipeTest.get(2)).get(2));
            int varE1_3 = (int)Double.parseDouble(((List<String>)pipeTest.get(2)).get(4));
            double varE11_3 = Double.parseDouble(((List<String>)pipeTest.get(2)).get(4));
            int varE2_3 = (int)Double.parseDouble(((List<String>)pipeTest.get(2)).get(5));
            double varE22_3 = Double.parseDouble(((List<String>)pipeTest.get(2)).get(5));
            double k1 = (var1_1 - var111) / (var112 - var2_2);
            double b1 = (Math.pow(var111, 2.0D) + Math.pow(var112, 2.0D) - var1_1 * var111 - var2_2 * var112) / (var112 - var2_2);
            if (df.format((varS22_1 - varE22_1) / (varS11_1 - varE11_1)).equals(df.format((varS22_2 - varE22_2) / (varS11_2 - varE11_2)))) {
              double k2 = (varS22_1 - varE22_1) / (varS11_1 - varE11_1);
              double b2 = (varE22_1 * varS11_1 - varS22_1 * varE11_1) / (varS11_1 - varE11_1);
              double k3 = (varS22_3 - varE22_3) / (varS11_3 - varE11_3);
              double b3 = (varE22_3 * varS11_3 - varS22_3 * varE11_3) / (varS11_3 - varE11_3);
              if (!df.format(k1).equals(df.format(k2))) {
                double x1 = (b1 - b2) / (k2 - k1);
                double d1 = (k2 * b1 - k1 * b2) / (k2 - k1);
                valve.add(((List<String>)valveTwo.get(j)).get(0));
                valve.add(String.valueOf(x1));
                valve.add(String.valueOf(d1));
              }
              if (!df.format(k1).equals(df.format(k3))) {
                double x2 = (b1 - b3) / (k3 - k1);
                double y2 = (k3 * b1 - k1 * b3) / (k3 - k1);
                valve.add(((List<String>)valveTwo.get(j)).get(0));
                valve.add(String.valueOf(x2));
                valve.add(String.valueOf(y2));
              }
                valves.add(valve);
                System.out.println("111" + valves);
            } else if (df.format((varS22_1 - varE22_1) / (varS11_1 - varE11_1)).equals(df.format((varS22_3 - varE22_3) / (varS11_3 - varE11_3)))) {
              double k2 = (varS22_1 - varE22_1) / (varS11_1 - varE11_1);
              double b2 = (varE22_1 * varS11_1 - varS22_1 * varE11_1) / (varS11_1 - varE11_1);
              double k3 = (varS22_2 - varE22_2) / (varS11_2 - varE11_2);
              double b3 = (varE22_2 * varS11_2 - varS22_2 * varE11_2) / (varS11_2 - varE11_2);
              if (!df.format(k1).equals(df.format(k2))) {
                double x1 = (b1 - b2) / (k2 - k1);
                double d1 = (k2 * b1 - k1 * b2) / (k2 - k1);
                valve.add(((List<String>)valveTwo.get(j)).get(0));
                valve.add(String.valueOf(x1));
                valve.add(String.valueOf(d1));
              }
              if (!df.format(k1).equals(df.format(k3))) {
                double x2 = (b1 - b3) / (k3 - k1);
                double y2 = (k3 * b1 - k1 * b3) / (k3 - k1);
                valve.add(((List<String>)valveTwo.get(j)).get(0));
                valve.add(String.valueOf(x2));
                valve.add(String.valueOf(y2));
              }
                valves.add(valve);
                System.out.println("111" + valves);
            } else if (df.format((varS22_2 - varE22_2) / (varS11_2 - varE11_2)).equals(df.format((varS22_3 - varE22_3) / (varS11_3 - varE11_3)))) {
              double k2 = (varS22_1 - varE22_1) / (varS11_1 - varE11_1);
              double b2 = (varE22_1 * varS11_1 - varS22_1 * varE11_1) / (varS11_1 - varE11_1);
              double k3 = (varS22_2 - varE22_2) / (varS11_2 - varE11_2);
              double b3 = (varE22_2 * varS11_2 - varS22_2 * varE11_2) / (varS11_2 - varE11_2);
              if (!df.format(k1).equals(df.format(k2))) {
                double x1 = (b1 - b2) / (k2 - k1);
                double d1 = (k2 * b1 - k1 * b2) / (k2 - k1);
                valve.add(((List<String>)valveTwo.get(j)).get(0));
                valve.add(String.valueOf(x1));
                valve.add(String.valueOf(d1));
              }
              if (!df.format(k1).equals(df.format(k3))) {
                double x2 = (b1 - b3) / (k3 - k1);
                double y2 = (k3 * b1 - k1 * b3) / (k3 - k1);
                valve.add(((List<String>)valveTwo.get(j)).get(0));
                valve.add(String.valueOf(x2));
                valve.add(String.valueOf(y2));
              }
                valves.add(valve);
                System.out.println("111" + valves);
            }
          }
        }
      }
        System.out.println("111111" + valves);
      if (count1 > 1) {
        String error = "[此地井阀存在问题,阀内存在不止一个节点,地井阀坐标：(" + (String)((List<String>)valveTwo.get(j)).get(1) + "," + (String)((List<String>)valveTwo.get(j)).get(2) + ")]";
        errors.add(error);
      }
    }
    System.out.println("双阀地井阀" + valveTwo);
    for (int i = 0; i < valveTwo.size(); i++) {
      List<String> valve = new ArrayList<>();
      List<String> valve1 = new ArrayList<>();
      if ((valveTwo.get(i)).size() == 7) {
        System.out.println("不含节点的双阀地井阀:" + valveTwo.get(i));
        double x1 = Double.parseDouble((valveTwo.get(i)).get(1));
        double d1 = Double.parseDouble((valveTwo.get(i)).get(2));
        double x2 = Double.parseDouble((valveTwo.get(i)).get(3));
        double y2 = Double.parseDouble((valveTwo.get(i)).get(4));
        double xC = Double.parseDouble((valveTwo.get(i)).get(5));
        double yC = Double.parseDouble((valveTwo.get(i)).get(6));
        double k11 = (x2 - x1) / (d1 - y2);
        double b11 = (Math.pow(x1, 2.0D) + Math.pow(d1, 2.0D) - Math.pow(x2, 2.0D) - Math.pow(y2, 2.0D)) / 2.0D * (d1 - y2);
        double k1 = (d1 - y2) / (x1 - x2);
        double b1 = (x1 * y2 - x2 * d1) / (x1 - x2);
        for (int i2 = 0; i2 < pipe.size(); i2++) {
          double x3 = Double.parseDouble(((List<String>)pipe.get(i2)).get(1));
          double y3 = Double.parseDouble(((List<String>)pipe.get(i2)).get(2));
          double x4 = Double.parseDouble(((List<String>)pipe.get(i2)).get(4));
          double y4 = Double.parseDouble(((List<String>)pipe.get(i2)).get(5));
          if (df.format(x3).equals(df.format(x4))) {
            if (yC < MathMethod.getBig2(y3, y4) && yC > MathMethod.getSmall2(y3, y4)) {
              double x = x3;
              double y = k1 * x3 + b1;
              if (y > d1 && y < y2 && x > x1 && x < x2) {
                valve.add(((List<String>)valveTwo.get(i)).get(0));
                valve.add(String.valueOf(x));
                valve.add(String.valueOf(y));
              }
            }
          }else if (df.format(y3).equals(df.format(y4))) {
            if (xC < MathMethod.getBig2(x3, x4) && xC > MathMethod.getSmall2(x3, x4)) {
              double x = (y3 - b1) / k1;
              double y = y3;
              if (y > d1 && y < y2 && x > x1 && x < x2) {
                valve.add(((List<String>)valveTwo.get(i)).get(0));
                valve.add(String.valueOf(x));
                valve.add(String.valueOf(y));
              }
            }
          }else if ((xC < MathMethod.getBig2(x3, x4) && xC > MathMethod.getSmall2(x3, x4)) || (yC < MathMethod.getBig2(y3, y4) && yC > MathMethod.getSmall2(y3, y4))) {
            double k2 = (y3 - y4) / (x3 - x4);
            double b2 = (x3 * y4 - x4 * y3) / (x3 - x4);
            if (!df.format(k1).equals(df.format(k2))) {
              double x = (b1 - b2) / (k2 - k1);
              double y = (k2 * b1 - k1 * b2) / (k2 - k1);
              if (y > d1 && y < y2 && x > x1 && x < x2) {
                valve.add(((List<String>)valveTwo.get(i)).get(0));
                valve.add(String.valueOf(x));
                valve.add(String.valueOf(y));
              }
            }
          }
        }
        if (valve.size() == 6){
            valves.add(valve);
            System.out.println("阀的具体位置:" + valve);
        }
          if (valve.size() != 6){
              System.out.println("进入计算：");
              for (int i2 = 0; i2 < pipe.size(); i2++) {
                  double x3 = Double.parseDouble(((List<String>)pipe.get(i2)).get(1));
                  double y3 = Double.parseDouble(((List<String>)pipe.get(i2)).get(2));
                  double x4 = Double.parseDouble(((List<String>)pipe.get(i2)).get(4));
                  double y4 = Double.parseDouble(((List<String>)pipe.get(i2)).get(5));
                  double k2 = (y3 - y4) / (x3 - x4);
                  double b2 = (x3 * y4 - x4 * y3) / (x3 - x4);
                  if ((xC < MathMethod.getBig2(x3, x4) && xC > MathMethod.getSmall2(x3, x4)) || (yC < MathMethod.getBig2(y3, y4) && yC > MathMethod.getSmall2(y3, y4))) {
                      double xx = (b11 - b2) / (k2 - k11);
                      double yy = (k2 * b11 - k11 * b2) / (k2 - k11);
                      System.out.println("进入计算2：");
                      if (yy > d1 && yy < y2 || xx > x1 && xx < x2) {
                          valve1.add(((List<String>)valveTwo.get(i)).get(0));
                          valve1.add(String.valueOf(xx));
                          valve1.add(String.valueOf(yy));
                          System.out.println("进入计算3：");
                      }
                  }
              }
          }

        System.out.println(valve1.size());
        if (valve1.size() == 6){
            valves.add(valve1);
            System.out.println("阀的具体位置2:" + valve1);
        }
        if (valve.size() != 6 && valve1.size() != 6) {
          String error = "[此双阀地井阀内的阀门数量少于2个存在问题,坐标为：(" + (String)((List<String>)valveTwo.get(i)).get(1) + "," + (String)((List<String>)valveTwo.get(i)).get(2) + ")]";
          errors.add(error);
        }
      }
    }

    System.out.println("阀门位置" + valves);
      System.out.println(valves);
    System.out.println("阀门个数" + valves.size());
    List<List<String>> halfValves = new ArrayList<>();
    for (int m = 0; m < valves.size(); m++) {
      List<String> halfValve1 = new ArrayList<>();
      List<String> halfValve2 = new ArrayList<>();
      halfValve1.add((valves.get(m)).get(0));
      halfValve1.add((valves.get(m)).get(1));
      halfValve1.add((valves.get(m)).get(2));
      halfValve2.add((valves.get(m)).get(3));
      halfValve2.add((valves.get(m)).get(4));
      halfValve2.add((valves.get(m)).get(5));
      halfValves.add(halfValve1);
      halfValves.add(halfValve2);
    }
      System.out.println("单个阀门位置" + halfValves);
      System.out.println("单个阀门个数" + halfValves.size());
    MathMethod.add(halfValves, listTest);
      System.out.println("全部节点的位置" + listTest);
    List<Integer> n1 = new ArrayList<>();
    for (int n = 0; n < halfValves.size(); n++) {
        int var5 = listTest.size() - halfValves.size() + n;
        System.out.println("var5:" + var5);
      for (int i2 = 0; i2 < pipe.size(); i2++) {
        int var1 = (int)Double.parseDouble((pipe.get(i2)).get(1));
        double var11 = Double.parseDouble((pipe.get(i2)).get(1));
        int var2 = (int)Double.parseDouble((pipe.get(i2)).get(4));
        double var22 = Double.parseDouble((pipe.get(i2)).get(4));
        int var3 = (int)Double.parseDouble((pipe.get(i2)).get(2));
        double var33 = Double.parseDouble((pipe.get(i2)).get(2));
        int var4 = (int)Double.parseDouble((pipe.get(i2)).get(5));
        double var44 = Double.parseDouble((pipe.get(i2)).get(5));
        int var6 = (int)Double.parseDouble((listTest.get(var5)).get(1));
        double var66 = Double.parseDouble((listTest.get(var5)).get(1));
        int var7 = (int)Double.parseDouble((listTest.get(var5)).get(2));
        double var77 = Double.parseDouble((listTest.get(var5)).get(2));
        if (var3 == var4 && var7 == var3 && var6 < MathMethod.getBig(var1, var2) && var6 > MathMethod.getSmall(var1, var2)) {
          System.out.println("管段编号:" + (String)((List<String>)pipe.get(i2)).get(0) + ",节点编号:" + (var5 + 1));
          n1.add(Integer.valueOf(var5 + 1));
          List<String> list1 = new ArrayList<>();
          List<String> list2 = new ArrayList<>();
          list1.add(null);
          list1.add(((List<String>)pipe.get(i2)).get(1));
          list1.add(((List<String>)pipe.get(i2)).get(2));
          list1.add(((List<String>)pipe.get(i2)).get(3));
          list1.add(((List<String>)listTest.get(var5)).get(1));
          list1.add(((List<String>)listTest.get(var5)).get(2));
          list1.add(((List<String>)listTest.get(var5)).get(0));
          list1.add(((List<String>)pipe.get(i2)).get(7));
          list2.add(null);
          list2.add(((List<String>)listTest.get(var5)).get(1));
          list2.add(((List<String>)listTest.get(var5)).get(2));
          list2.add(((List<String>)listTest.get(var5)).get(0));
          list2.add(((List<String>)pipe.get(i2)).get(4));
          list2.add(((List<String>)pipe.get(i2)).get(5));
          list2.add(((List<String>)pipe.get(i2)).get(6));
          list2.add(((List<String>)pipe.get(i2)).get(7));
          pipe.remove(pipe.get(i2));
          pipe.add(list1);
          pipe.add(list2);
          MathMethod.sequence(pipe);
        }
        if (var1 == var2 && var6 == var1 && var7 < MathMethod.getBig(var3, var4) && var7 > MathMethod.getSmall(var3, var4)) {
          System.out.println("管段编号:" + (String)((List<String>)pipe.get(i2)).get(0) + ",节点编号:" + (var5 + 1));
          n1.add(Integer.valueOf(var5 + 1));
          List<String> list1 = new ArrayList<>();
          List<String> list2 = new ArrayList<>();
          list1.add(null);
          list1.add(((List<String>)pipe.get(i2)).get(1));
          list1.add(((List<String>)pipe.get(i2)).get(2));
          list1.add(((List<String>)pipe.get(i2)).get(3));
          list1.add(((List<String>)listTest.get(var5)).get(1));
          list1.add(((List<String>)listTest.get(var5)).get(2));
          list1.add(((List<String>)listTest.get(var5)).get(0));
          list1.add(((List<String>)pipe.get(i2)).get(7));
          list2.add(null);
          list2.add(((List<String>)listTest.get(var5)).get(1));
          list2.add(((List<String>)listTest.get(var5)).get(2));
          list2.add(((List<String>)listTest.get(var5)).get(0));
          list2.add(((List<String>)pipe.get(i2)).get(4));
          list2.add(((List<String>)pipe.get(i2)).get(5));
          list2.add(((List<String>)pipe.get(i2)).get(6));
          list2.add(((List<String>)pipe.get(i2)).get(7));
          pipe.remove(pipe.get(i2));
          pipe.add(list1);
          pipe.add(list2);
          MathMethod.sequence(pipe);
        }
        if (var1 != var2 && var3 != var4 && var66 < MathMethod.getBig2(var11, var22) && var66 > MathMethod.getSmall2(var11, var22) && var77 <
          MathMethod.getBig2(var33, var44) && var77 > MathMethod.getSmall2(var33, var44) && df
          .format((var44 - var33) / (var22 - var11)).equals(df.format((var44 - var77) / (var22 - var66))) && df
          .format((var44 - var33) / (var22 - var11)).equals(df.format((var33 - var77) / (var11 - var66)))) {
          System.out.println("管段编号:" + (String)((List<String>)pipe.get(i2)).get(0) + ",节点编号:" + (var5 + 1));
          n1.add(Integer.valueOf(var5 + 1));
          List<String> list1 = new ArrayList<>();
          List<String> list2 = new ArrayList<>();
          list1.add(null);
          list1.add(((List<String>)pipe.get(i2)).get(1));
          list1.add(((List<String>)pipe.get(i2)).get(2));
          list1.add(((List<String>)pipe.get(i2)).get(3));
          list1.add(((List<String>)listTest.get(var5)).get(1));
          list1.add(((List<String>)listTest.get(var5)).get(2));
          list1.add(((List<String>)listTest.get(var5)).get(0));
          list1.add(((List<String>)pipe.get(i2)).get(7));
          list2.add(null);
          list2.add(((List<String>)listTest.get(var5)).get(1));
          list2.add(((List<String>)listTest.get(var5)).get(2));
          list2.add(((List<String>)listTest.get(var5)).get(0));
          list2.add(((List<String>)pipe.get(i2)).get(4));
          list2.add(((List<String>)pipe.get(i2)).get(5));
          list2.add(((List<String>)pipe.get(i2)).get(6));
          list2.add(((List<String>)pipe.get(i2)).get(7));
          pipe.remove(pipe.get(i2));
          pipe.add(list1);
          pipe.add(list2);
          MathMethod.sequence(pipe);
        }
      }
    }
    System.out.println("在管段上的双阀节点编号:" + n1);
    int y1 = y0 + valveTwo.size() * 2;
    List<Integer> n2 = new ArrayList<>();
    for (int i1 = y0 + 1; i1 <= y1; i1++)
      n2.add(Integer.valueOf(i1));
    System.out.println("所有的双阀地井阀节点编号:" + n2);
    if (n1.size() < n2.size()) {
      label212: for (int i1 = ((Integer)Collections.<Integer>min(n2)).intValue(); i1 <= ((Integer)Collections.max((Collection)n2)).intValue(); i1++) {
        for (int i2 = ((Integer)Collections.<Integer>min(n1)).intValue(); i2 <= ((Integer)Collections.max((Collection)n1)).intValue(); i2++) {
          if (i1 == i2) {
            n2.remove(Integer.valueOf(i1));
            n1.remove(Integer.valueOf(i2));
            if (n1.size() == 0)
              break label212;
          }
        }
      }
      System.out.println("未统计的双阀地井阀节点编号:" + n2);
      for (int i1 = 0; i1 < n2.size(); i1++) {
        for (int i2 = 0; i2 < listTest.size(); i2++) {
          if ((n2.get(i1)).intValue() == Integer.parseInt((listTest.get(i2)).get(0))) {
            System.out.println("未统计的双阀地井阀节点" + n2.get(i1) + "的坐标为:(" + listTest.get(i2).get(1) + "," + listTest.get(i2).get(2) + ")");
              System.out.println("未统计的双阀地井阀节点" + n2.get(i1) + "为:" + listTest.get(i2));
            String error = "未统计的双阀地井阀节点" + n2.get(i1) + "的坐标为:(" + (String)((List<String>)listTest.get(i2)).get(1) + "," + (String)((List<String>)listTest.get(i2)).get(2) + ")";
            errors.add(error);
            break;
          }
        }
      }
    }
    return pipe;
  }

  public static List<List<String>> tribleValve(List<List<String>> block, List<List<String>> listTest, List<List<String>> pipe, double distance, List<String> errors) {
    List<List<String>> valveThree = new ArrayList<>();
    int x0 = pipe.size();
    int y0 = listTest.size();
    for (int i = 0; i < block.size(); i++) {
      List<String> valve = new ArrayList<>();
      if (((String)((List<String>)block.get(i)).get(1)).equals("3")) {
        valve.add(((List<String>)block.get(i)).get(0));
        valve.add(((List<String>)block.get(i)).get(2));
        valve.add(((List<String>)block.get(i)).get(3));
        valve.add(((List<String>)block.get(i)).get(4));
        valve.add(((List<String>)block.get(i)).get(5));
        valve.add(String.valueOf((Double.parseDouble(((List<String>)block.get(i)).get(2)) + Double.parseDouble(((List<String>)block.get(i)).get(4))) / 2.0D));
        valve.add(String.valueOf((Double.parseDouble(((List<String>)block.get(i)).get(3)) + Double.parseDouble(((List<String>)block.get(i)).get(5))) / 2.0D));
        valveThree.add(valve);
      }
    }
    List<List<String>> valves = new ArrayList<>();
    for (int k = 0; k < valveThree.size(); k++) {
      List<List<String>> valveThreeNodes = new ArrayList<>();
      List<String> valve01 = new ArrayList<>();
      List<String> valve02 = new ArrayList<>();
      List<String> valve03 = new ArrayList<>();
      int var3 = (int)Double.parseDouble(((List<String>)valveThree.get(k)).get(1));
      int var4 = (int)Double.parseDouble(((List<String>)valveThree.get(k)).get(2));
      int var5 = (int)Double.parseDouble(((List<String>)valveThree.get(k)).get(3));
      int var6 = (int)Double.parseDouble(((List<String>)valveThree.get(k)).get(4));
      int var11 = (int)Double.parseDouble(((List<String>)valveThree.get(k)).get(5));
      double var111 = Double.parseDouble(((List<String>)valveThree.get(k)).get(5));
      int var12 = (int)Double.parseDouble(((List<String>)valveThree.get(k)).get(6));
      double var112 = Double.parseDouble(((List<String>)valveThree.get(k)).get(6));
      int count1 = 0;
      for (int n = 0; n < listTest.size(); n++) {
        List<String> valveThreeNode = new ArrayList<>();
        int var1 = (int)Double.parseDouble(((List<String>)listTest.get(n)).get(1));
        int var2 = (int)Double.parseDouble(((List<String>)listTest.get(n)).get(2));
        if (var1 > MathMethod.getSmall(var3, var5) && var1 < MathMethod.getBig(var3, var5) && var2 > MathMethod.getSmall(var4, var6) && var2 < MathMethod.getBig(var4, var6)) {
          System.out.println("节点" + (String)((List<String>)listTest.get(n)).get(0) + "在地井阀" + (String)((List<String>)valveThree.get(k)).get(0) + "上");
          count1++;
          valveThreeNode.add(((List<String>)listTest.get(n)).get(0));
          valveThreeNode.add(((List<String>)listTest.get(n)).get(1));
          valveThreeNode.add(((List<String>)listTest.get(n)).get(2));
          valveThreeNodes.add(valveThreeNode);
        }
      }
      if (count1 == 2) {
        int var1_1 = (int)Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(1));
        double var11_1 = Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(1));
        int var1_2 = (int)Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(2));
        double var11_2 = Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(2));
        int var2_1 = (int)Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(1));
        double var22_1 = Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(1));
        int var2_2 = (int)Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(2));
        double var22_2 = Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(2));
        int var3_1 = (var1_1 + var2_1) / 2;
        double var33_1 = (var11_1 + var22_1) / 2.0D;
        int var3_2 = (var1_2 + var2_2) / 2;
        double var33_2 = (var11_2 + var22_2) / 2.0D;
        if (var1_1 == var2_1 || var1_2 == var2_2) {
          if (var11 < var1_1) {
            ((List<String>)valveThreeNodes.get(0)).add("左");
          } else {
            ((List<String>)valveThreeNodes.get(0)).add("右");
          }
          if (var12 > var1_2) {
            ((List<String>)valveThreeNodes.get(0)).add("上");
          } else {
            ((List<String>)valveThreeNodes.get(0)).add("下");
          }
          if (var11 < var2_1) {
            ((List<String>)valveThreeNodes.get(1)).add("左");
          } else {
            ((List<String>)valveThreeNodes.get(1)).add("右");
          }
          if (var12 > var2_2) {
            ((List<String>)valveThreeNodes.get(1)).add("上");
          } else {
            ((List<String>)valveThreeNodes.get(1)).add("下");
          }
        } else {
          List<String> location = new ArrayList<>();
          if (var111 < var33_1) {
            location.add("左");
          } else {
            location.add("右");
          }
          if (var112 > var33_2) {
            location.add("上");
          } else {
            location.add("下");
          }
          location.add("斜");
          valveThreeNodes.add(location);
        }
        System.out.println(valveThreeNodes);
        if (valveThreeNodes.size() == 2) {
          if (((String)((List<String>)valveThreeNodes.get(0)).get(3)).equals(((List)valveThreeNodes.get(1)).get(3)) && ((String)((List<String>)valveThreeNodes.get(0)).get(3)).equals("右")) {
            valve01.add(((List<String>)valveThree.get(k)).get(0));
            valve01.add(String.valueOf(Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(1)) + distance));
            valve01.add(((List<String>)valveThreeNodes.get(0)).get(2));
            valve02.add(((List<String>)valveThree.get(k)).get(0));
            valve02.add(String.valueOf(Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(1)) + distance));
            valve02.add(((List<String>)valveThreeNodes.get(1)).get(2));
            valve03.add(((List<String>)valveThree.get(k)).get(0));
            valve03.add(((List<String>)valveThreeNodes.get(1)).get(1));
            valve03.add(String.valueOf((Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(2)) + Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(2))) / 2.0D));
            valves.add(valve01);
            valves.add(valve02);
            valves.add(valve03);
          } else if (((String)((List<String>)valveThreeNodes.get(0)).get(3)).equals(((List)valveThreeNodes.get(1)).get(3)) && ((String)((List<String>)valveThreeNodes.get(0)).get(3)).equals("左")) {
            valve01.add(((List<String>)valveThree.get(k)).get(0));
            valve01.add(String.valueOf(Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(1)) - distance));
            valve01.add(((List<String>)valveThreeNodes.get(0)).get(2));
            valve02.add(((List<String>)valveThree.get(k)).get(0));
            valve02.add(String.valueOf(Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(1)) - distance));
            valve02.add(((List<String>)valveThreeNodes.get(1)).get(2));
            valve03.add(((List<String>)valveThree.get(k)).get(0));
            valve03.add(((List<String>)valveThreeNodes.get(1)).get(1));
            valve03.add(String.valueOf((Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(2)) + Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(2))) / 2.0D));
            valves.add(valve01);
            valves.add(valve02);
            valves.add(valve03);
          }
          if (((String)((List<String>)valveThreeNodes.get(0)).get(4)).equals(((List)valveThreeNodes.get(1)).get(4)) && ((String)((List<String>)valveThreeNodes.get(0)).get(4)).equals("上")) {
            valve01.add(((List<String>)valveThree.get(k)).get(0));
            valve01.add(((List<String>)valveThreeNodes.get(0)).get(1));
            valve01.add(String.valueOf(Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(2)) + distance));
            valve02.add(((List<String>)valveThree.get(k)).get(0));
            valve02.add(((List<String>)valveThreeNodes.get(1)).get(1));
            valve02.add(String.valueOf(Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(2)) + distance));
            valve03.add(((List<String>)valveThree.get(k)).get(0));
            valve03.add(String.valueOf((Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(1)) + Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(1))) / 2.0D));
            valve03.add(((List<String>)valveThreeNodes.get(1)).get(2));
            valves.add(valve01);
            valves.add(valve02);
            valves.add(valve03);
          } else if (((String)((List<String>)valveThreeNodes.get(0)).get(4)).equals(((List)valveThreeNodes.get(1)).get(4)) && ((String)((List<String>)valveThreeNodes.get(0)).get(4)).equals("下")) {
            valve01.add(((List<String>)valveThree.get(k)).get(0));
            valve01.add(((List<String>)valveThreeNodes.get(0)).get(1));
            valve01.add(String.valueOf(Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(2)) - distance));
            valve02.add(((List<String>)valveThree.get(k)).get(0));
            valve02.add(((List<String>)valveThreeNodes.get(1)).get(1));
            valve02.add(String.valueOf(Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(2)) - distance));
            valve03.add(((List<String>)valveThree.get(k)).get(0));
            valve03.add(String.valueOf((Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(1)) + Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(1))) / 2.0D));
            valve03.add(((List<String>)valveThreeNodes.get(1)).get(2));
            valves.add(valve01);
            valves.add(valve02);
            valves.add(valve03);
          }
        }
        if (valveThreeNodes.size() == 3) {
          double d1_1 = Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(1));
          double d1_2 = Double.parseDouble(((List<String>)valveThreeNodes.get(0)).get(2));
          double d2_1 = Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(1));
          double d2_2 = Double.parseDouble(((List<String>)valveThreeNodes.get(1)).get(2));
          double d3_1 = Math.abs((d1_2 - d2_2) / 2.0D);
          double d3_2 = Math.abs((d1_1 - d2_1) / 2.0D);
          if (((String)((List<String>)valveThreeNodes.get(2)).get(0)).equals("右") && ((String)((List<String>)valveThreeNodes.get(2)).get(1)).equals("下")) {
            valve01.add(((List<String>)valveThree.get(k)).get(0));
            valve01.add(String.valueOf(d1_1 + d3_1));
            valve01.add(String.valueOf(d1_2 - d3_2));
            valve02.add(((List<String>)valveThree.get(k)).get(0));
            valve02.add(String.valueOf(d2_1 + d3_1));
            valve02.add(String.valueOf(d2_2 - d3_2));
            valve03.add(((List<String>)valveThree.get(k)).get(0));
            valve03.add(String.valueOf((d1_1 + d2_1) / 2.0D));
            valve03.add(String.valueOf((d1_2 + d2_2) / 2.0D));
            valves.add(valve01);
            valves.add(valve02);
            valves.add(valve03);
          }
          if (((String)((List<String>)valveThreeNodes.get(2)).get(0)).equals("左") && ((String)((List<String>)valveThreeNodes.get(2)).get(1)).equals("上")) {
            valve01.add(((List<String>)valveThree.get(k)).get(0));
            valve01.add(String.valueOf(d1_1 - d3_1));
            valve01.add(String.valueOf(d1_2 + d3_2));
            valve02.add(((List<String>)valveThree.get(k)).get(0));
            valve02.add(String.valueOf(d2_1 - d3_1));
            valve02.add(String.valueOf(d2_2 + d3_2));
            valve03.add(((List<String>)valveThree.get(k)).get(0));
            valve03.add(String.valueOf((d1_1 + d2_1) / 2.0D));
            valve03.add(String.valueOf((d1_2 + d2_2) / 2.0D));
            valves.add(valve01);
            valves.add(valve02);
            valves.add(valve03);
          }
          if (((String)((List<String>)valveThreeNodes.get(2)).get(0)).equals("右") && ((String)((List<String>)valveThreeNodes.get(2)).get(1)).equals("上")) {
            valve01.add(((List<String>)valveThree.get(k)).get(0));
            valve01.add(String.valueOf(d1_1 + d3_1));
            valve01.add(String.valueOf(d1_2 + d3_2));
            valve02.add(((List<String>)valveThree.get(k)).get(0));
            valve02.add(String.valueOf(d2_1 + d3_1));
            valve02.add(String.valueOf(d2_2 + d3_2));
            valve03.add(((List<String>)valveThree.get(k)).get(0));
            valve03.add(String.valueOf((d1_1 + d2_1) / 2.0D));
            valve03.add(String.valueOf((d1_2 + d2_2) / 2.0D));
            valves.add(valve01);
            valves.add(valve02);
            valves.add(valve03);
          }
          if (((String)((List<String>)valveThreeNodes.get(2)).get(0)).equals("左") && ((String)((List<String>)valveThreeNodes.get(2)).get(1)).equals("下")) {
            valve01.add(((List<String>)valveThree.get(k)).get(0));
            valve01.add(String.valueOf(d1_1 - d3_1));
            valve01.add(String.valueOf(d1_2 - d3_2));
            valve02.add(((List<String>)valveThree.get(k)).get(0));
            valve02.add(String.valueOf(d2_1 - d3_1));
            valve02.add(String.valueOf(d2_2 - d3_2));
            valve03.add(((List<String>)valveThree.get(k)).get(0));
            valve03.add(String.valueOf((d1_1 + d2_1) / 2.0D));
            valve03.add(String.valueOf((d1_2 + d2_2) / 2.0D));
            valves.add(valve01);
            valves.add(valve02);
            valves.add(valve03);
          }
        }
      } else if (valveThreeNodes.size() == 1){
        String error = "[此三阀地井阀内的节点数为1个，存在问题,坐标为：(" + (String)((List<String>)valveThree.get(k)).get(1) + "," + (String)((List<String>)valveThree.get(k)).get(2) + ")]";
        errors.add(error);
      } else if (valveThreeNodes.size() > 2){
        String error = "[此三阀地井阀内的节点数大于2个，存在问题,坐标为：(" + (String)((List<String>)valveThree.get(k)).get(1) + "," + (String)((List<String>)valveThree.get(k)).get(2) + ")]";
        errors.add(error);
      }
      System.out.println(valves);
    }
    MathMethod.add(valves, listTest);
    List<Integer> n1 = new ArrayList<>();
    for (int j = 0; j < valves.size(); j++) {
      for (int n = 0; n < pipe.size(); n++) {
        DecimalFormat df = new DecimalFormat("######0.0");
        int var1 = (int)Double.parseDouble(((List<String>)pipe.get(n)).get(1));
        double var11 = Double.parseDouble(((List<String>)pipe.get(n)).get(1));
        int var2 = (int)Double.parseDouble(((List<String>)pipe.get(n)).get(4));
        double var22 = Double.parseDouble(((List<String>)pipe.get(n)).get(4));
        int var3 = (int)Double.parseDouble(((List<String>)pipe.get(n)).get(2));
        double var33 = Double.parseDouble(((List<String>)pipe.get(n)).get(2));
        int var4 = (int)Double.parseDouble(((List<String>)pipe.get(n)).get(5));
        double var44 = Double.parseDouble(((List<String>)pipe.get(n)).get(5));
        int var5 = listTest.size() - valves.size() + j;
        int var6 = (int)Double.parseDouble(((List<String>)listTest.get(var5)).get(1));
        double var66 = Double.parseDouble(((List<String>)listTest.get(var5)).get(1));
        int var7 = (int)Double.parseDouble(((List<String>)listTest.get(var5)).get(2));
        double var77 = Double.parseDouble(((List<String>)listTest.get(var5)).get(2));
        if (var3 == var4 && var7 == var3 && var6 < MathMethod.getBig(var1, var2) && var6 > MathMethod.getSmall(var1, var2)) {
          System.out.println("管段编号:" + (String)((List<String>)pipe.get(n)).get(0) + ",节点编号:" + var5 + 1);
          n1.add(Integer.valueOf(var5 + 1));
          List<String> list1 = new ArrayList<>();
          List<String> list2 = new ArrayList<>();
          list1.add(null);
          list1.add(((List<String>)pipe.get(n)).get(1));
          list1.add(((List<String>)pipe.get(n)).get(2));
          list1.add(((List<String>)pipe.get(n)).get(3));
          list1.add(((List<String>)listTest.get(var5)).get(1));
          list1.add(((List<String>)listTest.get(var5)).get(2));
          list1.add(((List<String>)listTest.get(var5)).get(0));
          list1.add(((List<String>)pipe.get(n)).get(7));
          list2.add(null);
          list2.add(((List<String>)listTest.get(var5)).get(1));
          list2.add(((List<String>)listTest.get(var5)).get(2));
          list2.add(((List<String>)listTest.get(var5)).get(0));
          list2.add(((List<String>)pipe.get(n)).get(4));
          list2.add(((List<String>)pipe.get(n)).get(5));
          list2.add(((List<String>)pipe.get(n)).get(6));
          list2.add(((List<String>)pipe.get(n)).get(7));
          pipe.remove(pipe.get(n));
          pipe.add(list1);
          pipe.add(list2);
          MathMethod.sequence(pipe);
        }
        if (var1 == var2 && var6 == var1 && var7 < MathMethod.getBig(var3, var4) && var7 > MathMethod.getSmall(var3, var4)) {
          System.out.println("管段编号:" + (String)((List<String>)pipe.get(n)).get(0) + ",节点编号:" + var5 + 1);
          n1.add(Integer.valueOf(var5 + 1));
          List<String> list1 = new ArrayList<>();
          List<String> list2 = new ArrayList<>();
          list1.add(null);
          list1.add(((List<String>)pipe.get(n)).get(1));
          list1.add(((List<String>)pipe.get(n)).get(2));
          list1.add(((List<String>)pipe.get(n)).get(3));
          list1.add(((List<String>)listTest.get(var5)).get(1));
          list1.add(((List<String>)listTest.get(var5)).get(2));
          list1.add(((List<String>)listTest.get(var5)).get(0));
          list1.add(((List<String>)pipe.get(n)).get(7));
          list2.add(null);
          list2.add(((List<String>)listTest.get(var5)).get(1));
          list2.add(((List<String>)listTest.get(var5)).get(2));
          list2.add(((List<String>)listTest.get(var5)).get(0));
          list2.add(((List<String>)pipe.get(n)).get(4));
          list2.add(((List<String>)pipe.get(n)).get(5));
          list2.add(((List<String>)pipe.get(n)).get(6));
          list2.add(((List<String>)pipe.get(n)).get(7));
          pipe.remove(pipe.get(n));
          pipe.add(list1);
          pipe.add(list2);
          MathMethod.sequence(pipe);
        }
        if (var1 != var2 && var3 != var4 && var66 < MathMethod.getBig2(var11, var22) && var66 > MathMethod.getSmall2(var11, var22) && var77 <
          MathMethod.getBig2(var33, var44) && var77 > MathMethod.getSmall2(var33, var44) && df
          .format((var44 - var33) / (var22 - var11)).equals(df.format((var44 - var77) / (var22 - var66))) && df
          .format((var44 - var33) / (var22 - var11)).equals(df.format((var33 - var77) / (var11 - var66)))) {
          System.out.println("管段编号:" + (String)((List<String>)pipe.get(n)).get(0) + ",节点编号:" + var5 + 1);
          n1.add(Integer.valueOf(var5 + 1));
          List<String> list1 = new ArrayList<>();
          List<String> list2 = new ArrayList<>();
          list1.add(null);
          list1.add(((List<String>)pipe.get(n)).get(1));
          list1.add(((List<String>)pipe.get(n)).get(2));
          list1.add(((List<String>)pipe.get(n)).get(3));
          list1.add(((List<String>)listTest.get(var5)).get(1));
          list1.add(((List<String>)listTest.get(var5)).get(2));
          list1.add(((List<String>)listTest.get(var5)).get(0));
          list1.add(((List<String>)pipe.get(n)).get(7));
          list2.add(null);
          list2.add(((List<String>)listTest.get(var5)).get(1));
          list2.add(((List<String>)listTest.get(var5)).get(2));
          list2.add(((List<String>)listTest.get(var5)).get(0));
          list2.add(((List<String>)pipe.get(n)).get(4));
          list2.add(((List<String>)pipe.get(n)).get(5));
          list2.add(((List<String>)pipe.get(n)).get(6));
          list2.add(((List<String>)pipe.get(n)).get(7));
          pipe.remove(pipe.get(n));
          pipe.add(list1);
          pipe.add(list2);
          MathMethod.sequence(pipe);
        }
      }
    }
    System.out.println("在管段上的三阀节点编号:" + n1);
    int y1 = y0 + valveThree.size() * 3;
    List<Integer> n2 = new ArrayList<>();
    int m;
    for (m = y0 + 1; m <= y1; m++)
      n2.add(Integer.valueOf(m));
    System.out.println("所有的三阀地井阀节点编号:" + n2);
    if (n1.size() < n2.size()) {
      label152: for (m = ((Integer)Collections.<Integer>min(n2)).intValue(); m <= ((Integer)Collections.max((Collection)n2)).intValue(); m++) {
        for (int n = ((Integer)Collections.<Integer>min(n1)).intValue(); n <= ((Integer)Collections.max((Collection)n1)).intValue(); n++) {
          if (m == n) {
            n2.remove(Integer.valueOf(m));
            n1.remove(Integer.valueOf(n));
            if (n1.size() == 0)
              break label152;
          }
        }
      }
      System.out.println("未统计的三阀地井阀节点编号:" + n2);
      for (m = 0; m < n2.size(); m++) {
        for (int n = 0; n < listTest.size(); n++) {
          if (((Integer)n2.get(m)).intValue() == Integer.parseInt(((List<String>)listTest.get(n)).get(0))) {
            System.out.println("未统计的三阀地井阀节点" + n2.get(m) + "的坐标为:(" + (String)((List<String>)listTest.get(n)).get(1) + "," + (String)((List<String>)listTest.get(n)).get(2) + ")");
            String error = "未统计的三阀地井阀节点" + n2.get(m) + "的坐标为:(" + (String)((List<String>)listTest.get(n)).get(1) + "," + (String)((List<String>)listTest.get(n)).get(2) + ")";
            errors.add(error);
            break;
          }
        }
      }
    }
    return pipe;
  }

  public static List<List<String>> getValve(List<List<String>> block) {
    List<List<String>> valve = new ArrayList<>();
    for (int i = 0; i < block.size(); i++) {
      if (((String)((List<String>)block.get(i)).get(0)).contains("阀"))
        valve.add(block.get(i));
    }
    return valve;
  }
}


/* Location:              D:\wang\project\CAD\cadintegration02\target\classes\!\data\ValveCalculate.class
 * Java compiler version: 12 (56.0)
 * JD-Core Version:       1.1.3
 */