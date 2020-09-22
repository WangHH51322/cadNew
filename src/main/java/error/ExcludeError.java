package error;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/12 11:05
 */
public class ExcludeError {

    public static List<String> errorPipeFirst(List<List<String>> pipe){

        List<String> s = new ArrayList<>();

        //管段自动排错
        for (int i = 0; i < pipe.size(); i++) {
            DecimalFormat df = new DecimalFormat("######0.0");
            //管段不是单根管段,而是连续多线段时
            if (pipe.get(i).size() != 8){
                System.out.println("s1：管段" + pipe.get(i).get(0) + "处存在问题,起点坐标是:(" + pipe.get(i).get(1) + "," + pipe.get(i).get(2) + ")" +
                        ",终点坐标是:(" + pipe.get(i).get(4) + "," + pipe.get(i).get(5) + ")");
                String s1 = "[管段" + pipe.get(i).get(0) + "处存在问题,起点坐标是:(" + pipe.get(i).get(1) + "," + pipe.get(i).get(2) + ")" +
                        ",终点坐标是:(" + pipe.get(i).get(4) + "," + pipe.get(i).get(5) + ")";
                s.add(s1);

                if (pipe.get(i).size() > 11){
                    System.out.println("s2：管段" + pipe.get(i).get(0) + "处存在问题可能是连续多线段未处理");
                    String s2 = "管段" + pipe.get(i).get(0) + "处存在问题可能是连续多线段未处理]>>>>>>";
                    s.add(s2);

                }else if (pipe.get(i).size() == 11){
                    //管段起点 x
                    int p1_1 = (int)Double.parseDouble(pipe.get(i).get(1));
                    String p11_1 = df.format(Double.parseDouble(pipe.get(i).get(1)));
                    //管段起点 y
                    int p2_1 = (int)Double.parseDouble(pipe.get(i).get(2));
                    String p22_1 = df.format(Double.parseDouble(pipe.get(i).get(2)));
                    //管段中间点 x
                    int p1_2 = (int)Double.parseDouble(pipe.get(i).get(4));
                    String p11_2 = df.format(Double.parseDouble(pipe.get(i).get(4)));
                    //管段中间点 y
                    int p2_2 = (int)Double.parseDouble(pipe.get(i).get(5));
                    String p22_2 = df.format(Double.parseDouble(pipe.get(i).get(5)));
                    //管段终点 x
                    int p1_3 = (int)Double.parseDouble(pipe.get(i).get(7));
                    String p11_3 = df.format(Double.parseDouble(pipe.get(i).get(7)));
                    //管段终点 y
                    int p2_3 = (int)Double.parseDouble(pipe.get(i).get(8));
                    String p22_3 = df.format(Double.parseDouble(pipe.get(i).get(8)));
                    if ((p11_1.equals(p11_2) && p22_1.equals(p22_2)) || (p11_1.equals(p11_3) && p22_1.equals(p22_3)) || (p11_2.equals(p11_3) && p22_2.equals(p22_3))){
                        System.out.println("s3:管段" + pipe.get(i).get(0) + "处存在问题可能是管段端点处有节点重合");
                        String s3 = "管段" + pipe.get(i).get(0) + "处存在问题可能是管段端点处有节点重合]>>>>>>";
                        s.add(s3);
                    }else {
                        System.out.println("s4:管段" + pipe.get(i).get(0) + "处存在问题可能是连续多线段未处理");
                        String s4 = "管段" + pipe.get(i).get(0) + "处存在问题可能是连续多线段未处理]>>>>>>";
                        s.add(s4);
                    }
                }
            }
            //判断有无重合管段
            for (int j = 0; j < pipe.size(); j++) {
                if (! pipe.get(i).get(0).equals(pipe.get(j).get(0))){
                    //管段1起点 x
                    int p1_1 = (int)Double.parseDouble(pipe.get(i).get(1));
                    String p11_1 = df.format(Double.parseDouble(pipe.get(i).get(1)));
                    //管段1起点 y
                    int p2_1 = (int)Double.parseDouble(pipe.get(i).get(2));
                    String p22_1 = df.format(Double.parseDouble(pipe.get(i).get(2)));
                    //管段1终点 x
                    int p1_2 = (int)Double.parseDouble(pipe.get(i).get(4));
                    String p11_2 = df.format(Double.parseDouble(pipe.get(i).get(4)));
                    //管段1终点 y
                    int p2_2 = (int)Double.parseDouble(pipe.get(i).get(5));
                    String p22_2 = df.format(Double.parseDouble(pipe.get(i).get(5)));
                    //管段2起点 x
                    int q1_1 = (int)Double.parseDouble(pipe.get(j).get(1));
                    String q11_1 = df.format(Double.parseDouble(pipe.get(j).get(1)));
                    //管段2起点 y
                    int q2_1 = (int)Double.parseDouble(pipe.get(j).get(2));
                    String q22_1 = df.format(Double.parseDouble(pipe.get(j).get(2)));
                    //管段2终点 x
                    int q1_2 = (int)Double.parseDouble(pipe.get(j).get(4));
                    String q11_2 = df.format(Double.parseDouble(pipe.get(j).get(4)));
                    //管段2终点 y
                    int q2_2 = (int)Double.parseDouble(pipe.get(j).get(5));
                    String q22_2 = df.format(Double.parseDouble(pipe.get(j).get(5)));
                    if ( ((p11_1.equals(q11_1) && p22_1.equals(q22_1)) && (p11_2.equals(q11_2) && p22_2.equals(q22_2))) ||
                            ((p11_1.equals(q11_2) && p22_1.equals(q22_2)) && (p11_2.equals(q11_1) && p22_2.equals(q22_1))) ){
                        System.out.println("s5:管段" + pipe.get(i).get(0) + "处存在问题,起点坐标是:(" + pipe.get(i).get(1) + "," + pipe.get(i).get(2) + ")" +
                                ",终点坐标是:(" + pipe.get(i).get(4) + "," + pipe.get(i).get(5) + ")");
                        String s5 = "[管段" + pipe.get(i).get(0) + "处存在问题,起点坐标是:(" + pipe.get(i).get(1) + "," + pipe.get(i).get(2) + ")" +
                                ",终点坐标是:(" + pipe.get(i).get(4) + "," + pipe.get(i).get(5) + ")";
                        s.add(s5);

                        System.out.println("s6:管段" + pipe.get(i).get(0) + "处存在问题可能是与管段" + pipe.get(j).get(0) + "重合");
                        String s6 = "管段" + pipe.get(i).get(0) + "处存在问题可能是与管段" + pipe.get(j).get(0) + "重合]>>>>>>";
                        s.add(s6);
                    }
                }
            }
        }

        return s;
    }

}
