package test;

import org.kabeja.dxf.DXFDocument;
import org.kabeja.dxf.DXFLayer;
import org.kabeja.parser.ParseException;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/23 20:56
 */
public class GetLayerName {

    public static List<String> getDXFLayers(String DataPath) throws FileNotFoundException, ParseException {

        String sourceFile = DataPath;
        InputStream inputStream = new FileInputStream(sourceFile);
        Parser parser = ParserBuilder.createDefaultParser();
        parser.parse(inputStream, "GBK");
        DXFDocument dxfdoc = parser.getDocument();

        List<String> dXFLayers = new ArrayList<String>();
        Iterator iter = dxfdoc.getDXFLayerIterator();
        while(iter.hasNext()){
            DXFLayer dXFLayer = (DXFLayer)iter.next();
            dXFLayers.add(dXFLayer.getName());
        }
        System.out.println(dXFLayers);
        return dXFLayers;
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

}
