package result;

import org.kabeja.parser.ParseException;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static data.MathMethod.addPlugIntoNode;
import static data.MathMethod.removePlug;
import static data.NetWork.nodeintegration;
import static data.NetWork.pipeintegration;
import static data.PlugCalculate.addPlug;
import static data.PlugCalculate.getPlug;
import static data.ReadCad.nodesData;
import static data.ReadCad.pipesData;
import static data.ValveCalculate.*;
import static data.ValveCalculate.doubleValve;
import static data.ValveCalculate.singleValve;
import static data.ValveCalculate.tribleValve;
import static excel.Out2Excel.dataExcel;
import static result.InPut.blockContact;
import static result.InPut.nodeContact;
import static result.InPut.pipeContact;


/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 18:48
 */
public class Result {

    public static List<String> getResult(String dataPath,List<String> layerName) throws FileNotFoundException, ParseException {

        double distance = 1;

        List<String> errors = new ArrayList<>();

        //将各个图层的管段合并到一起
        List<List<String>> pipe = pipeContact(dataPath,layerName);
        List<List<String>> node = nodeContact(dataPath,layerName);

        //读取块参数,参数格式:<块编号,块数目,块外框左下角x,块外框左下角y,块外框右上角x,块外框右上角y>
        List<List<String>> block = blockContact(dataPath);

        //根据node与pipe之间的关系,将管段自动分段
        List<List<String>> pipes = pipesData(pipe,node);

        //将管段起终点拆开组成节点数组
        List<List<String>> nodes = nodesData(pipes);

        //对节点进行编号,标注节点类型
        List<List<String>> nodeList = nodeintegration(nodes);

        //对管段编号,起终点编号,标注管段类型
        List<List<String>> pipeList = pipeintegration(nodes,pipes);

        //判断管段起终点编号是否跟节点一一对应
        for (int i = 0; i < pipeList.size(); i++) {
            if (Integer.parseInt(pipeList.get(i).get(3)) > nodeList.size() || Integer.parseInt(pipeList.get(i).get(3)) < 0){
                System.out.println("管段" + (i + 1) + "起点不匹配");
            }
            if (Integer.parseInt(pipeList.get(i).get(6)) > nodeList.size() || Integer.parseInt(pipeList.get(i).get(6)) < 0){
                System.out.println("管段" + (i + 1) + "终点不匹配");
            }
        }

        //从所有块对象中分别获取加油栓和地井阀
        List<List<String>> plug = getPlug(block);
        System.out.println("加油栓:" + plug);
        System.out.println("加油栓的数目" + plug.size());
        //判断是否有加油栓重合
        DecimalFormat df = new DecimalFormat("######0.0000");
        for (int i = 0; i < plug.size(); i++) {
            double var1 = Double.parseDouble((plug.get(i)).get(2));
            double var2 = Double.parseDouble((plug.get(i)).get(3));
            for (int j = 0; j < plug.size(); j++) {
                double var3 = Double.parseDouble((plug.get(j)).get(2));
                double var4 = Double.parseDouble((plug.get(j)).get(3));
                if (i != j && df.format(var1).equals(df.format(var3)) && df.format(var2).equals(df.format(var4))) {
                    System.out.println("加油栓重合:("+ var1 + "," + var2 +")");
                }
            }
        }


//        int m = plug.size();
        List<List<String>> valve = getValve(block);
        System.out.println("地井阀:" + valve);
        System.out.println("地井阀的数目" + valve.size());

        if (valve.size() > 0){
            System.out.println("不考虑阀门时的管段:" + pipeList);
            System.out.println("不考虑阀门时的节点:" + nodeList);
            System.out.println("不考虑阀门时的管段数目:" + pipeList.size());

            System.out.println("不考虑阀门时的节点数目:" + nodeList.size());

            System.out.println("*************************************");


            //将单阀的坐标加到listTest中去,判断单阀在哪条管段上,并将单阀所在的管段拆分成两根管段加到总管段数中去
            //删除原有管段,并重新对管段进行编号
            System.out.println("加入单阀后的管段:" + singleValve(valve,nodeList,pipeList,errors));
            System.out.println("加入单阀后管段数目:" + pipeList.size());
            System.out.println("加入单阀后的节点" + nodeList);
            System.out.println("加入单阀后节点数目:" + nodeList.size());
            System.out.println("加入单阀后的误差" + errors);
            System.out.println("*************************************");




            //将双阀地井阀的外框坐标加到valveTwo中去
            //valveTwo:<地井阀名称,起点x,起点y,终点x,终点y,地井阀的中心坐标x,中心坐标y>
            //判断哪些节点在地井阀中
            //判断地井阀中心点与节点的相对位置
            //并根据相对位置,确定具体阀的位置
            System.out.println("加入双阀地井阀后的管段:" + doubleValve(valve,nodeList,pipeList,distance,errors));
            System.out.println("加入双阀地井阀后管段数目:" + pipeList.size());
            System.out.println("加入双阀地井阀后的节点:" + nodeList);
            System.out.println("加入双阀地井阀后节点数目:" + nodeList.size());
            System.out.println("加入双阀后的误差" + errors);
            System.out.println("*************************************");


            //将双阀地井阀的外框坐标加到valveThree中去
            //valveThree:<地井阀名称,起点x,起点y,终点x,终点y,地井阀的中心坐标x,中心坐标y>
            //判断哪些节点在地井阀中
            //判断地井阀中心点与节点的相对位置
            //并根据相对位置,确定具体阀的位置
            System.out.println("加入三阀地井阀后的管段:" + tribleValve(valve, nodeList, pipeList,distance,errors));
            System.out.println("加入三阀地井阀后管段数目:" + pipeList.size());
            System.out.println("加入三阀地井阀后的节点" + nodeList);
            System.out.println("加入三阀地井阀后节点数目:" + nodeList.size());
            System.out.println("加入三阀后的误差" + errors);
            System.out.println("*************************************");
        }


        //判断加油栓是否在节点上,并更改节点名称
        addPlugIntoNode(plug,nodeList);
        //将与节点重合的加油栓从加油栓数组中删去
        List<List<String>> newPlug = removePlug(plug,nodeList);
//        System.out.println("不重合加油栓:" + newPlug);
        System.out.println("不重合加油栓个数:" + newPlug.size());

        System.out.println("加入加油栓后的管段" + addPlug(newPlug, nodeList, pipeList));
        System.out.println("加入加油栓后管段数目:" + pipeList.size());
        System.out.println("加入加油栓后的节点" + nodeList);
        System.out.println("加入加油栓后节点数目:" + nodeList.size());
        System.out.println("*************************************");

        //将阀门点转换为阀门起点和终点两个点
        List<List<String>> valveCount = new ArrayList<>();
        Map<String,String> couple = new HashMap<>();
        int nodeListSize = nodeList.size();
        int num = 1;
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).get(3).equals("阀门")) {
                List<String> nodeCopy = new ArrayList<>();
                nodeCopy.add(String.valueOf((nodeListSize+num)));
                nodeCopy.add(nodeList.get(i).get(1));
                nodeCopy.add(nodeList.get(i).get(2));
                nodeCopy.add("阀门" + num + "-" + "2");
                nodeList.add(nodeCopy);

                nodeList.get(i).set(3,("阀门" + num + "-" + "1"));
                valveCount.add(nodeList.get(i));
                //将同一个阀门的两个节点成对存储
                couple.put(nodeList.get(i).get(0),nodeCopy.get(0));
                num ++;
            }
        }
        System.out.println();
        //修改管段进出口节点编号
        for (int i = 0; i < valveCount.size(); i++) {
            int count = 0;
            String nodeNumb = valveCount.get(i).get(0);
            for (int j = 0; j < pipeList.size(); j++) {
                if (pipeList.get(j).get(3).equals(nodeNumb) || pipeList.get(j).get(6).equals(nodeNumb)) { //管段起终点刚好是阀节点
                    if (count == 0) {
                        count ++;
                    } else if (count == 1) {
                        if (pipeList.get(j).get(3).equals(nodeNumb)) {
                            pipeList.get(j).set(3,couple.get(nodeNumb));
                        } else if (pipeList.get(j).get(6).equals(nodeNumb)) {
                            pipeList.get(j).set(6,couple.get(nodeNumb));
                        }
                        count ++;
                    } else if (count > 1) {
                        System.out.println("同一个阀门连接超过两根管段,此阀门编号为:" + valveCount.get(i).get(0));
                    }
                }
            }
        }
        //将阀门作为元件加入pipeList
        int pipeListSize = pipeList.size();
        for (int i = 0; i < valveCount.size(); i++) {
            List<String> valveCopy = new ArrayList<>();
            valveCopy.add(String.valueOf((pipeListSize+i+1)));
            valveCopy.add(valveCount.get(i).get(1));
            valveCopy.add(valveCount.get(i).get(2));
            valveCopy.add(valveCount.get(i).get(0));
            valveCopy.add(valveCount.get(i).get(1));
            valveCopy.add(valveCount.get(i).get(2));
            valveCopy.add(couple.get(valveCount.get(i).get(0)));
            valveCopy.add("阀门" + (i+1));
            valveCopy.add("0");

            pipeList.add(valveCopy);
        }

        String excelPath = "D:\\Data\\Work\\项目\\AirPort\\机场数据\\Guangzhou\\data.xlsx";
        String pipeSheetName = "pipe";
        dataExcel(pipeList,excelPath,pipeSheetName);
        String nodeSheetName = "node";
        dataExcel(nodeList,excelPath,nodeSheetName);
        return errors;
    }


}
