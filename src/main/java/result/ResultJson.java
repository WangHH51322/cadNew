package result;


import com.alibaba.fastjson.JSON;
import org.kabeja.parser.ParseException;

import java.io.*;
import java.util.*;

import static data.MathMethod.addPlugIntoNode;
import static data.MathMethod.removePlug;
import static data.NetWork.nodeintegration;
import static data.NetWork.pipeintegration;
import static data.PlugCalculate.addPlug;
import static data.PlugCalculate.getPlug;
import static data.ReadCad.nodesData;
import static data.ReadCad.pipesData;
import static data.ValveCalculate.*;
import static excel.Out2Excel.dataExcel;
import static result.InPut.*;
import static result.InPut.pipeContact;
import static result.InPut.pipeContact;


/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 18:48
 */
public class ResultJson {

    public static void getResultJson(String dataPath,List<String> layerName,String excelPath) throws FileNotFoundException, ParseException {
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

//        //从所有块对象中分别获取加油栓和地井阀
//        List<List<String>> plug = getPlug(block);
//        System.out.println("加油栓:" + plug);
//        System.out.println("加油栓的数目" + plug.size());
//        List<List<String>> valve = getValve(block);
//        System.out.println("地井阀:" + valve);
//        System.out.println("地井阀的数目" + valve.size());
//
//        System.out.println("不考虑阀门时的管段:" + pipeList);
//        System.out.println("不考虑阀门时的节点:" + nodeList);
//        System.out.println("不考虑阀门时的管段数目:" + pipeList.size());
//        System.out.println("不考虑阀门时的节点数目:" + nodeList.size());
//        System.out.println("*************************************");
//
//
//        //将单阀的坐标加到listTest中去,判断单阀在哪条管段上,并将单阀所在的管段拆分成两根管段加到总管段数中去
//        //删除原有管段,并重新对管段进行编号
//        System.out.println("加入单阀后的管段:" + singleValve(valve,nodeList,pipeList));
//        System.out.println("加入单阀后管段数目:" + pipeList.size());
//        System.out.println("加入单阀后的节点" + nodeList);
//        System.out.println("加入单阀后节点数目:" + nodeList.size());
//        System.out.println("*************************************");
//
//
//
//
//        //将双阀地井阀的外框坐标加到valveTwo中去
//        //valveTwo:<地井阀名称,起点x,起点y,终点x,终点y,地井阀的中心坐标x,中心坐标y>
//        //判断哪些节点在地井阀中
//        //判断地井阀中心点与节点的相对位置
//        //并根据相对位置,确定具体阀的位置
//        System.out.println("加入双阀地井阀后的管段:" + doubleValve(valve,nodeList,pipeList,distance));
//        System.out.println("加入双阀地井阀后管段数目:" + pipeList.size());
//        System.out.println("加入双阀地井阀后的节点:" + nodeList);
//        System.out.println("加入双阀地井阀后节点数目:" + nodeList.size());
//        System.out.println("*************************************");
//
//
//        //将双阀地井阀的外框坐标加到valveThree中去
//        //valveThree:<地井阀名称,起点x,起点y,终点x,终点y,地井阀的中心坐标x,中心坐标y>
//        //判断哪些节点在地井阀中
//        //判断地井阀中心点与节点的相对位置
//        //并根据相对位置,确定具体阀的位置
//        System.out.println("加入三阀地井阀后的管段:" + tribleValve(valve, nodeList, pipeList,distance));
//        System.out.println("加入三阀地井阀后管段数目:" + pipeList.size());
//        System.out.println("加入三阀地井阀后的节点" + nodeList);
//        System.out.println("加入三阀地井阀后节点数目:" + nodeList.size());
//        System.out.println("*************************************");
//
//
//        //判断加油栓是否在节点上,并更改节点名称
//        addPlugIntoNode(plug,nodeList);
//        //将与节点重合的加油栓从加油栓数组中删去
//        List<List<String>> newPlug = removePlug(plug,nodeList);
//        System.out.println("不重合加油栓个数:" + newPlug.size());
//
//        System.out.println("加入加油栓后的管段" + addPlug(newPlug, nodeList, pipeList));
//        System.out.println("加入加油栓后管段数目:" + pipeList.size());
//        System.out.println("加入加油栓后的节点" + nodeList);
//        System.out.println("加入加油栓后节点数目:" + nodeList.size());

        for (int i = 0; i < pipeList.size(); i++) {
            //起点x
            double x1 = Double.parseDouble(pipeList.get(i).get(1));
            //起点y
            double y1 = Double.parseDouble(pipeList.get(i).get(2));
            //终点x
            double x2 = Double.parseDouble(pipeList.get(i).get(4));
            //终点y
            double y2 = Double.parseDouble(pipeList.get(i).get(5));
            double length =Math.pow(Math.pow((x1 - x2),2) + Math.pow((y1 - y2),2),0.5);
            pipeList.get(i).add(String.valueOf(length));
        }

        System.out.println("管段数目:" + pipeList.size());
        System.out.println(pipeList);
        System.out.println("节点数目:" + nodeList.size());
        System.out.println(nodeList);

        List<Map<String, Object>> pipeMaps = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < pipeList.size(); i++) {
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            for (int j = 0; j < pipeList.get(i).size(); j++) {
                map.put("管段编号",Double.parseDouble(pipeList.get(i).get(0)));
                map.put("起点编号",Double.parseDouble(pipeList.get(i).get(3)));
                map.put("终点编号",Double.parseDouble(pipeList.get(i).get(6)));
                map.put("起点x",Double.parseDouble(pipeList.get(i).get(1)));
                map.put("起点y",Double.parseDouble(pipeList.get(i).get(2)));
                map.put("终点x",Double.parseDouble(pipeList.get(i).get(4)));
                map.put("终点y",Double.parseDouble(pipeList.get(i).get(5)));
                map.put("管长",Double.parseDouble(pipeList.get(i).get(8)));
            }
            pipeMaps.add(map);
        }
        String pipeStr = JSON.toJSONString(pipeMaps);
        System.out.println(pipeMaps);
        try {
            String str = excelPath.substring(0, excelPath.lastIndexOf("\\"));//截取@之前的字符串;
            File file = new File(str + "\\pipe.json");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }

            // true = append file
            FileWriter fileWritter = new FileWriter(file, false);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(pipeStr);
            bufferWritter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Map<String, Object>> nodeMaps = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < nodeList.size(); i++) {
            Map<String, Object> map = new LinkedHashMap<String, Object>();
            for (int j = 0; j < nodeList.get(i).size(); j++) {
                map.put("节点编号",Double.parseDouble(nodeList.get(i).get(0)));
                map.put("节点类型",nodeList.get(i).get(3));
                map.put("坐标x",Double.parseDouble(nodeList.get(i).get(1)));
                map.put("坐标y",Double.parseDouble(nodeList.get(i).get(2)));
            }
            nodeMaps.add(map);
        }

        String nodeStr = JSON.toJSONString(nodeMaps);
        System.out.println(nodeMaps);
        try {

            String str = excelPath.substring(0, excelPath.lastIndexOf("\\"));//截取@之前的字符串;
            File file = new File(str + "\\node.json");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            } else {
                file.delete();
                file.createNewFile();
            }

            // true = append file
            FileWriter fileWritter = new FileWriter(file, false);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(nodeStr);
            bufferWritter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
