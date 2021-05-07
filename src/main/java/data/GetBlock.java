package data;

import org.kabeja.dxf.*;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/5 15:13
 */
public class GetBlock {

    //通过blockName获取entity,在此之前,需要将CAD图中你想读取数据的块对象的图层可视化,并且隐藏其他块对象的图层,避免干扰
    public static List<List<String>> getDXFInsertByBlockName(DXFDocument dxfdoc){
        List<List<String>> node = new ArrayList<List<String>>();
        Iterator iter = dxfdoc.getDXFLayerIterator();
        while(iter.hasNext()){
            DXFLayer dXFLayer = (DXFLayer)iter.next();
            if(dXFLayer.isVisible()){
                List<String> list = getDXFEntityTypes(dXFLayer);
                for(String s : list){
                    if(s.equals("INSERT")){
                        List<DXFEntity> l = dXFLayer.getDXFEntities(s);
                        for(DXFEntity d : l){
                            //单个地井阀中的单个阀
                            //每次赋值完得清空
                            //地井阀参数格式:<阀编号,阀数目,地井阀外框左下角x,地井阀外框左下角y,地井阀外框右上角x,地井阀外框右上角y>
                            List<String> valve = new ArrayList<String>();
                            DXFInsert i = (DXFInsert)d;
                            //System.out.println("ID: "+d.getID()+" Boolean:"+d.isBlockEntity());
                            //System.out.println("BlockID: "+i.getBlockID()+ ",x:" + i.getPoint().getX() + ",y:" + i.getPoint().getY());
                            Bounds b = i.getBounds();
                            //一个地井阀中阀的数目 = contain + 1
//                            int contain = searchByIndexOf(i.getBlockID(),"x");
//                            int contain01 = searchByIndexOf(i.getBlockID(),"X");
//                            int count = contain + contain01 + 1;
                            //System.out.println("阀的个数" + count);
                            //单阀地井阀参数
                            //地井阀参数格式:<阀编号,阀数目,地井阀基点x,地井阀基点y,null,null>
                            if ((i.getBlockID()).contains("单") && (i.getBlockID()).contains("阀") || i.getBlockID().contains("3类") || i.getBlockID().contains("7类")){
                                valve.add(i.getBlockID());
                                valve.add(String.valueOf(1));
                                valve.add(String.valueOf(i.getPoint().getX()));
                                valve.add(String.valueOf(i.getPoint().getY()));
                                valve.add(null);
                                valve.add(null);
                                node.add(valve);
                            }else
                                //双阀地井阀参数
                                //地井阀参数格式:<阀编号,阀数目,地井阀外框左下角x,地井阀外框左下角y,地井阀外框右上角x,地井阀外框右上角y>
                                if ((i.getBlockID()).contains("双") && (i.getBlockID()).contains("阀") || i.getBlockID().contains("2类") || i.getBlockID().contains("4类")){
                                    valve.add(i.getBlockID());
                                    valve.add(String.valueOf(2));
                                    valve.add(String.valueOf(b.getMinimumX()));
                                    valve.add(String.valueOf(b.getMinimumY()));
                                    valve.add(String.valueOf(b.getMaximumX()));
                                    valve.add(String.valueOf(b.getMaximumY()));
                                    node.add(valve);
                                }else
                                    //三阀地井阀参数
                                    //地井阀参数格式:<阀编号,阀数目,地井阀外框左下角x,地井阀外框左下角y,地井阀外框右上角x,地井阀外框右上角y>
                                    if ((i.getBlockID()).contains("三") && (i.getBlockID()).contains("阀") || i.getBlockID().contains("1类") || i.getBlockID().contains("6类")){
                                        valve.add(i.getBlockID());
                                        valve.add(String.valueOf(3));
                                        valve.add(String.valueOf(b.getMinimumX()));
                                        valve.add(String.valueOf(b.getMinimumY()));
                                        valve.add(String.valueOf(b.getMaximumX()));
                                        valve.add(String.valueOf(b.getMaximumY()));
                                        node.add(valve);
                                    }else if((i.getBlockID()).contains("栓"))
                                    //加油栓的名称当中不包含单,双,三
                                    {
                                        valve.add(i.getBlockID());
                                        valve.add(null);
                                        valve.add(String.valueOf(i.getPoint().getX()));
                                        valve.add(String.valueOf(i.getPoint().getY()));
                                        valve.add(null);
                                        valve.add(null);
                                        node.add(valve);
                                    }
                        }
                    }
                }
            }
        }
        return node;
    }

    //通过图层获取DXFEntityType
    public static List<String> getDXFEntityTypes(DXFLayer dXFLayer){
        List<String> list = new ArrayList<String>();
        Iterator iter = dXFLayer.getDXFEntityTypeIterator();
        while(iter.hasNext()){
            String d = (String)iter.next();
            list.add(d);
//			System.out.println(d);
        }
        return list;
    }

    //统计字符串出现的次数
    public static int searchByIndexOf(String str,String newStr){
        int count=0;
        int i=0;
        while(str.indexOf(newStr,i)>=0){
            count++;
            i=str.indexOf(newStr,i)+newStr.length();
        }
        return count;
    }
}
