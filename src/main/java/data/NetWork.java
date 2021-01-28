package data;

import java.util.ArrayList;
import java.util.List;

import static data.MathMethod.*;
import static excel.Out2Excel.dataExcel;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 16:14
 */
public class NetWork {
    public static List<List<String>> nodeintegration(List<List<String>> nodes){

        //将管段的起终点的xy叠加,方便判断重复点,并且起终点一起保存到一个一维数组中
        int[] doubles = new int[nodes.size()];
        for(int i = 0;i < nodes.size();i++){
            doubles[i] = Integer.parseInt(nodes.get(i).get(2));
        }

        //将只出现不同次数次的端点坐标保存到不同数组中，并划分类型
        List<List<String>> nodeInfo = new ArrayList<>();
        int[] one = getOne(doubles);
        for (int i = 0; i < one.length; i++) {
            List<String> oneList = new ArrayList<String>();
            oneList.add(String.valueOf(one[i]));
            oneList.add("盲端");
            nodeInfo.add(oneList);
        }
        int[] two = getTwo(doubles);
        for (int i = 0; i < two.length; i++) {
            List<String> twoList = new ArrayList<String>();
            twoList.add(String.valueOf(two[i]));
            twoList.add("弯头");
            nodeInfo.add(twoList);
        }
        int[] three = getThree(doubles);
        for (int i = 0; i < three.length; i++) {
            List<String> theeList = new ArrayList<String>();
            theeList.add(String.valueOf(three[i]));
            theeList.add("三通");
            nodeInfo.add(theeList);
        }
        int[] four = getFour(doubles);
        for (int i = 0; i < four.length; i++) {
            List<String> fourList = new ArrayList<String>();
            fourList.add(String.valueOf(four[i]));
            fourList.add("连接点");
            nodeInfo.add(fourList);
        }

//        System.out.println("1:" + one.length);
//        System.out.println("2:" + two.length);
//        System.out.println("3:" + three.length);
//        System.out.println("4:" + four.length);

        //将出现1.2.3.4次的节点,删除重复的点,每种只保留一个点,并且对端点进行编号
        int[] all = contact4(one,two,three,four);
        int[][] match = new int[all.length][4];
        for (int i = 0; i < all.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0){
                    match[i][j] = i + 1;
                }else if (j == 1){
                    match[i][j] = all[i];
                }else if (j == 2){
                    match[i][j] = 0;
                }else {
                    match[i][j] = 0;
                }
            }
        }

        //节点坐标存成List
        List<List<String>> listTest = new ArrayList<List<String>>();
        for (int i = 0; i < match.length; i++) {
            List<String> columnList = new ArrayList<String>();
            for (int j = 0; j < match[i].length; j++) {

                columnList.add(j, String.valueOf(match[i][j]));

            }
            listTest.add(i, columnList);
        }

        //给listTest里面的节点赋予节点类型
        for (int i = 0; i < listTest.size(); i++) {
            for (int j = 0; j < nodeInfo.size(); j++) {
                if (listTest.get(i).get(1).equals(nodeInfo.get(j).get(0))){
                    listTest.get(i).set(3,nodeInfo.get(j).get(1));
                }
            }
        }

        //将listTest中的特征值跟nodes中的特征值进行对比,一致后将node中的x,y坐标存到listTest中
        for (int i = 0; i < listTest.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                if (listTest.get(i).get(1).equals(nodes.get(j).get(2))){
                    listTest.get(i).set(1,nodes.get(j).get(0));
                    listTest.get(i).set(2,nodes.get(j).get(1));
                }
            }
        }

        return listTest;
    }

    public static List<List<String>> pipeintegration(List<List<String>> nodes,List<List<String>>pipes){

        //将管段的起终点的xy叠加,方便判断重复点,并且起终点一起保存到一个一维数组中
        int[] doubles = new int[nodes.size()];
        for(int i = 0;i < nodes.size();i++){
            doubles[i] = Integer.parseInt(nodes.get(i).get(2));
        }

        //将只出现不同次数次的端点坐标保存到不同数组中，并划分类型
        List<List<String>> nodeInfo = new ArrayList<>();
        int[] one = getOne(doubles);
        for (int i = 0; i < one.length; i++) {
            List<String> oneList = new ArrayList<String>();
            oneList.add(String.valueOf(one[i]));
            oneList.add("盲端");
            nodeInfo.add(oneList);
        }
        int[] two = getTwo(doubles);
        for (int i = 0; i < two.length; i++) {
            List<String> twoList = new ArrayList<String>();
            twoList.add(String.valueOf(two[i]));
            twoList.add("弯头");
            nodeInfo.add(twoList);
        }
        int[] three = getThree(doubles);
        for (int i = 0; i < three.length; i++) {
            List<String> theeList = new ArrayList<String>();
            theeList.add(String.valueOf(three[i]));
            theeList.add("三通");
            nodeInfo.add(theeList);
        }
        int[] four = getFour(doubles);
        for (int i = 0; i < four.length; i++) {
            List<String> fourList = new ArrayList<String>();
            fourList.add(String.valueOf(four[i]));
            fourList.add("连接点");
            nodeInfo.add(fourList);
        }

//        System.out.println("1:" + one.length);
//        System.out.println("2:" + two.length);
//        System.out.println("3:" + three.length);
//        System.out.println("4:" + four.length);

        //将出现1.2.3.4次的节点,删除重复的点,每种只保留一个点,并且对端点进行编号
        int[] all = contact4(one,two,three,four);
        int[][] match = new int[all.length][4];
        for (int i = 0; i < all.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0){
                    match[i][j] = i + 1;
                }else if (j == 1){
                    match[i][j] = all[i];
                }else if (j == 2){
                    match[i][j] = 0;
                }else {
                    match[i][j] = 0;
                }
            }
        }

        //节点坐标存成List
        List<List<String>> listTest = new ArrayList<List<String>>();
        for (int i = 0; i < match.length; i++) {
            List<String> columnList = new ArrayList<String>();
            for (int j = 0; j < match[i].length; j++) {

                columnList.add(j, String.valueOf(match[i][j]));

            }
            listTest.add(i, columnList);
        }

        //给listTest里面的节点赋予节点类型
        for (int i = 0; i < listTest.size(); i++) {
            for (int j = 0; j < nodeInfo.size(); j++) {
                if (listTest.get(i).get(1).equals(nodeInfo.get(j).get(0))){
                    listTest.get(i).set(3,nodeInfo.get(j).get(1));
                }
            }
        }

        //将listTest中的特征值跟nodes中的特征值进行对比,一致后将node中的x,y坐标存到listTest中
        for (int i = 0; i < listTest.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                if (listTest.get(i).get(1).equals(nodes.get(j).get(2))){
                    listTest.get(i).set(1,nodes.get(j).get(0));
                    listTest.get(i).set(2,nodes.get(j).get(1));
                }
            }
        }

        //将pipes中的特征值跟match中的特征值进行对比,一致后对pipes中的管段起终点进行编号
        for (int i = 0; i < pipes.size(); i++) {
            for (int j = 0; j < match.length; j++) {
//                //这一步将各个图层中的管段编号整合,统一编号
//                pipes.get(i).set(0,String.valueOf(i + 1));
                //对管段起点编号
                if (pipes.get(i).get(3).equals(String.valueOf(match[j][1]))){
                    pipes.get(i).set(3,String.valueOf(match[j][0]));
                }
                //对管段终点编号
                if (pipes.get(i).get(6).equals(String.valueOf(match[j][1]))){
                    pipes.get(i).set(6,String.valueOf(match[j][0]));
                }
            }
        }

        return pipes;
    }
}
