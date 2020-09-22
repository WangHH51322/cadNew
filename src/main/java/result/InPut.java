package result;

import org.kabeja.dxf.DXFDocument;
import org.kabeja.parser.ParseException;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static data.GetBlock.getDXFInsertByBlockName;
import static data.MathMethod.*;
import static data.ReadCad.nodeData;
import static data.ReadCad.pipeData;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 17:42
 */
public class InPut {

    //将各个图层上的管段整合到一起
    public static List<List<String>> pipeContact(String dataPath, List<String> layerName){
        List<List<List<String>>> pipes = new ArrayList<>();
        List<List<String>> pipe = new ArrayList<>();
        for (int i = 0; i < layerName.size(); i++) {
             pipes.add(pipeData(dataPath,layerName.get(i)));
        }
        if (pipes.size() == 1){
            pipe = contact1(pipes.get(0));
        }else if (pipes.size() == 2){
            pipe = contact2(pipes.get(0),pipes.get(1));
        }else if (pipes.size() == 3){
            pipe = contact3(pipes.get(0),pipes.get(1),pipes.get(2));
        }else if (pipes.size() == 4){
            pipe = contact4(pipes.get(0),pipes.get(1),pipes.get(2),pipes.get(3));
        }else if (pipes.size() == 5){
            pipe = contact5(pipes.get(0),pipes.get(1),pipes.get(2),pipes.get(3),pipes.get(4));
        }else {
            System.out.println("图层过多,请修改源码");
        }
        return pipe;
    }
    //将各个图层上的节点整合到一起
    public static List<List<String>> nodeContact(String dataPath, List<String> layerName){
        List<List<List<String>>> nodes = new ArrayList<>();
        List<List<String>> node = new ArrayList<>();
        for (int i = 0; i < layerName.size(); i++) {
            nodes.add(nodeData(dataPath,layerName.get(i)));
        }
        if (nodes.size() == 1){
            node = contact1(nodes.get(0));
        }else if (nodes.size() == 2){
            node = contact2(nodes.get(0),nodes.get(1));
        }else if (nodes.size() == 3){
            node = contact3(nodes.get(0),nodes.get(1),nodes.get(2));
        }else if (nodes.size() == 4){
            node = contact4(nodes.get(0),nodes.get(1),nodes.get(2),nodes.get(3));
        }else if (nodes.size() == 5){
            node = contact5(nodes.get(0),nodes.get(1),nodes.get(2),nodes.get(3),nodes.get(4));
        }else {
            System.out.println("图层过多,请修改源码");
        }
        return node;
    }
    //将所有的块对象整合到一起
    public static List<List<String>> blockContact(String dataPath) throws FileNotFoundException, ParseException {
        //读取块参数,参数格式:<块编号,块数目,块外框左下角x,块外框左下角y,块外框右上角x,块外框右上角y>
        Parser dxfParser = ParserBuilder.createDefaultParser();
        dxfParser.parse(new FileInputStream(dataPath), "GBK");
        DXFDocument doc = dxfParser.getDocument();
        List<List<String>> block = getDXFInsertByBlockName(doc);
        return block;
    }

}
