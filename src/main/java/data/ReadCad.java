package data;

import org.kabeja.dxf.*;
import org.kabeja.parser.ParseException;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static data.MathMethod.*;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 13:37
 */
public class ReadCad {

    //nodeData<<端点x,端点y,端点特征值>>
    public static List<List<String>> nodeData(String DataPath, String LayerName) {

        List<List<String>> node = new ArrayList<List<String>>();

        try {
            String sourceFile = DataPath;
            InputStream inputStream = new FileInputStream(sourceFile);

            Parser parser = ParserBuilder.createDefaultParser();
            parser.parse(inputStream, "GBK");
            DXFDocument dxfDoc = parser.getDocument();
            DXFLayer pipeNetworkLayer = dxfDoc.getDXFLayer(LayerName);
            List<DXFLWPolyline> lwPolylines = pipeNetworkLayer.getDXFEntities(DXFConstants.ENTITY_TYPE_LWPOLYLINE);

            int ii = 1;//管段编号

            for (DXFLWPolyline lwPolyline : lwPolylines) {

                Iterator<DXFVertex> iterator = lwPolyline.getVertexIterator();
                List<String> listpipes = new ArrayList<String>();
                List<String> listpipes1 = new ArrayList<String>();
                List<String> listpipes2 = new ArrayList<String>();

                //给管段编号
                listpipes.add(String.valueOf(ii));
                ii += 1;

                while (iterator.hasNext()) {
                    DXFVertex temp = iterator.next();
                    listpipes.add(String.valueOf(temp.getX()));
                    listpipes.add(String.valueOf(temp.getY()));
                    listpipes.add(String.valueOf(((int)temp.getX())*111112+((int)temp.getY())*333337));
                }
                //管段起点x,y和特征值
                listpipes1.add(listpipes.get(1));
                listpipes1.add(listpipes.get(2));
                listpipes1.add(listpipes.get(3));

                //管段终点x,y和特征值
                listpipes2.add(listpipes.get(4));
                listpipes2.add(listpipes.get(5));
                listpipes2.add(listpipes.get(6));

                //node中把管段起终点拆开,合并成一列<端点x,端点y,端点特征值>
                node.add(listpipes1);
                node.add(listpipes2);

            }

        }catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

        return node;
    }

    //nodesData<<端点x,端点y,端点特征值>>
    public static List<List<String>> nodesData(List<List<String>> pipe) {

        List<List<String>> nodes = new ArrayList<>();
        for (int i = 0; i < pipe.size(); i++) {
            List<String> listpipes1 = new ArrayList<String>();
            List<String> listpipes2 = new ArrayList<String>();

            //管段起点x,y和特征值
            listpipes1.add(pipe.get(i).get(1));
            listpipes1.add(pipe.get(i).get(2));
            listpipes1.add(pipe.get(i).get(3));
            //管段终点x,y和特征值
            listpipes2.add(pipe.get(i).get(4));
            listpipes2.add(pipe.get(i).get(5));
            listpipes2.add(pipe.get(i).get(6));
            nodes.add(listpipes1);
            nodes.add(listpipes2);
        }
        return nodes;
    }

    //pipeData<<管段编号,起点x,起点y,起点特征值,终点x,终点y,终点特征值,管段名称>>
    public static List<List<String>> pipeData(String DataPath,String LayerName) {

        List<List<String>> pipe = new ArrayList<List<String>>();

        try {
            String sourceFile = DataPath;
            InputStream inputStream = new FileInputStream(sourceFile);

            Parser parser = ParserBuilder.createDefaultParser();
            parser.parse(inputStream, "GBK");
            DXFDocument dxfDoc = parser.getDocument();
            DXFLayer pipeNetworkLayer = dxfDoc.getDXFLayer(LayerName);
            List<DXFLWPolyline> lwPolylines = pipeNetworkLayer.getDXFEntities(DXFConstants.ENTITY_TYPE_LWPOLYLINE);

            int ii = 1;//管段编号

            for (DXFLWPolyline lwPolyline : lwPolylines) {

                Iterator<DXFVertex> iterator = lwPolyline.getVertexIterator();
                List<String> listpipes = new ArrayList<String>();

                //给管段编号
                listpipes.add(String.valueOf(ii));
                ii += 1;

                while (iterator.hasNext()) {
                    DXFVertex temp = iterator.next();
                    listpipes.add(String.valueOf(temp.getX()));
                    listpipes.add(String.valueOf(temp.getY()));
                    listpipes.add(String.valueOf(((int)temp.getX())*111112+((int)temp.getY())*333337));
                }
                //管段名称
                listpipes.add(LayerName);

                //将管段起终点坐标放在一行上<管段编号,起点x,起点y,起点特征值,终点x,终点y,终点特征值,管段名称>
                pipe.add(listpipes);

            }

        }catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        return pipe;
    }

    ////pipesData<<管段编号,起点x,起点y,起点特征值,终点x,终点y,终点特征值,管段名称>>
    public static List<List<String>> pipesData(List<List<String>> pipe , List<List<String>> node) {

        for (int j = 0; j < node.size(); j++) {
            for (int i = 0; i < pipe.size(); i++) {
                DecimalFormat df   = new DecimalFormat("######0.0000");
                //管段i的起点x 转化值
                int var1 = (int)Double.parseDouble(pipe.get(i).get(1));
                double var11 = Double.parseDouble(pipe.get(i).get(1));
                //管段i的终点x 转化值
                int var2 = (int)Double.parseDouble(pipe.get(i).get(4));
                double var22 = Double.parseDouble(pipe.get(i).get(4));
                //管段i的起点y 转化值
                int var3 = (int)Double.parseDouble(pipe.get(i).get(2));
                double var33 = Double.parseDouble(pipe.get(i).get(2));
                //管段i的终点y 转化值
                int var4 = (int)Double.parseDouble(pipe.get(i).get(5));
                double var44 = Double.parseDouble(pipe.get(i).get(5));
                //节点x 转化值
                int var6 = (int)Double.parseDouble(node.get(j).get(0));
                double var66 = Double.parseDouble(node.get(j).get(0));
                //节点y 转化值
                int var7 = (int)Double.parseDouble(node.get(j).get(1));
                double var77 = Double.parseDouble(node.get(j).get(1));

                //管段水平,节点在管段上
                if (var3 == var4 && var7 == var3 && var6 < getBig(var1,var2) && var6 > getSmall(var1,var2)){
//                        System.out.println("管段编号:" + pipe.get(i).get(0) + ",节点编号:" + (var5+1));
                    List<String> list1 = new ArrayList<String>();
                    List<String> list2 = new ArrayList<String>();
                    //新建管段1
                    list1.add(null);
                    list1.add(pipe.get(i).get(1));
                    list1.add(pipe.get(i).get(2));
                    list1.add(pipe.get(i).get(3));
                    list1.add(node.get(j).get(0));
                    list1.add(node.get(j).get(1));
                    list1.add(node.get(j).get(2));
                    //管段的型号
                    list1.add(pipe.get(i).get(7));

                    //新建管段2
                    list2.add(null);
                    list2.add(node.get(j).get(0));
                    list2.add(node.get(j).get(1));
                    list2.add(node.get(j).get(2));
                    list2.add(pipe.get(i).get(4));
                    list2.add(pipe.get(i).get(5));
                    list2.add(pipe.get(i).get(6));
                    //管段的型号
                    list2.add(pipe.get(i).get(7));
                    //System.out.println(list1);
                    //System.out.println(list2);
                    //删除原管段
                    pipe.remove(pipe.get(i));
                    //将单阀所在的管段拆分成两根管段
                    pipe.add(list1);
                    pipe.add(list2);
                    //加入新管段后将管段编号重新排序
                    sequence(pipe);
                }else
                if (var1 == var2 && var6 == var1 && var7 < getBig(var3,var4) && var7 > getSmall(var3,var4)){//管段竖直,单阀在管段上
                    //System.out.println("管段编号:" + pipe.get(i).get(0) + ",节点编号:" + (var5+1));
                    List<String> list1 = new ArrayList<String>();
                    List<String> list2 = new ArrayList<String>();
                    //新建管段1
                    list1.add(null);
                    list1.add(pipe.get(i).get(1));
                    list1.add(pipe.get(i).get(2));
                    list1.add(pipe.get(i).get(3));
                    list1.add(node.get(j).get(0));
                    list1.add(node.get(j).get(1));
                    list1.add(node.get(j).get(2));
                    //管段的型号
                    list1.add(pipe.get(i).get(7));

                    //新建管段2
                    list2.add(null);
                    list2.add(node.get(j).get(0));
                    list2.add(node.get(j).get(1));
                    list2.add(node.get(j).get(2));
                    list2.add(pipe.get(i).get(4));
                    list2.add(pipe.get(i).get(5));
                    list2.add(pipe.get(i).get(6));
                    //管段的型号
                    list2.add(pipe.get(i).get(7));
                    //System.out.println(list1);
                    //System.out.println(list2);
                    //将单阀所在的管段拆分成两根管段
                    pipe.remove(pipe.get(i));
                    pipe.add(list1);
                    pipe.add(list2);
                    sequence(pipe);
                }else
                if ( var11 != var22 && var33 != var44 && var66 < getBig2(var11,var22) && var66 > getSmall2(var11,var22) && var77 < getBig2(var33,var44) && var77 > getSmall2(var33,var44)
                        && df.format((var44 - var33) / (var22 - var11)).equals(df.format((var44 - var77) / (var22 - var66))) && df.format((var44 - var33) / (var22 - var11)).equals(df.format((var33 - var77) / (var11 - var66))))
                {
                    //管道倾斜时
                    //System.out.println("管段编号:" + pipe.get(i).get(0) + ",节点编号:" + (var5+1));
                    List<String> list1 = new ArrayList<String>();
                    List<String> list2 = new ArrayList<String>();
                    //新建管段1
                    list1.add(null);
                    list1.add(pipe.get(i).get(1));
                    list1.add(pipe.get(i).get(2));
                    list1.add(pipe.get(i).get(3));
                    list1.add(node.get(j).get(0));
                    list1.add(node.get(j).get(1));
                    list1.add(node.get(j).get(2));
                    //管段的型号
                    list1.add(pipe.get(i).get(7));

                    //新建管段2
                    list2.add(null);
                    list2.add(node.get(j).get(0));
                    list2.add(node.get(j).get(1));
                    list2.add(node.get(j).get(2));
                    list2.add(pipe.get(i).get(4));
                    list2.add(pipe.get(i).get(5));
                    list2.add(pipe.get(i).get(6));
                    //管段的型号
                    list2.add(pipe.get(i).get(7));
                    //                        System.out.println(list1);
                    //                        System.out.println(list2);
                    //将单阀所在的管段拆分成两根管段
                    pipe.remove(pipe.get(i));
                    pipe.add(list1);
                    pipe.add(list2);
                    sequence(pipe);
                }
            }
        }
        return pipe;
    }

    //pipeInfo<<起点特征值,终点特征值>>
    public static List<List<String>> pipeInfo(String DataPath,String LayerName) {

        List<List<String>> pipeNetworkInfo = new ArrayList<List<String>>();

        try {
            String sourceFile = DataPath;
            InputStream inputStream = new FileInputStream(sourceFile);

            Parser parser = ParserBuilder.createDefaultParser();
            parser.parse(inputStream, "GBK");
            DXFDocument dxfDoc = parser.getDocument();
            DXFLayer pipeNetworkLayer = dxfDoc.getDXFLayer(LayerName);
            List<DXFLWPolyline> lwPolylines = pipeNetworkLayer.getDXFEntities(DXFConstants.ENTITY_TYPE_LWPOLYLINE);

            int ii = 1;//管段编号

            for (DXFLWPolyline lwPolyline : lwPolylines) {

                Iterator<DXFVertex> iterator = lwPolyline.getVertexIterator();
                List<String> listpipes = new ArrayList<String>();
                List<String> listpipe = new ArrayList<String>();

                //给管段编号
                listpipes.add(String.valueOf(ii));
                ii += 1;

                while (iterator.hasNext()) {
                    DXFVertex temp = iterator.next();
                    listpipe.add(String.valueOf(((int)temp.getX())*111112+((int)temp.getY())*333337));
                    listpipes.add(String.valueOf(temp.getX()));
                    listpipes.add(String.valueOf(temp.getY()));
                    listpipes.add(String.valueOf(((int)temp.getX())*111112+((int)temp.getY())*333337));
                }

                //将管段起终点坐标放在一行上<管段编号,起点x,起点y,起点特征值,终点x,终点y,终点特征值>
                pipeNetworkInfo.add(listpipe);

            }

        }catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }

        return pipeNetworkInfo;
    }

}
