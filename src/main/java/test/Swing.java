package test;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/19 11:37
 */


import org.kabeja.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static test.GetLayerName.getDXFLayers;
import static test.test01.FirstRead;
import static test.test02.SecondRead;
import static test.test021.LastRead;

public class Swing {

    public static void main(String[] args) {
        JFrame jf = new JFrame("测试窗口");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton btn01 = new JButton("预读取");
        JButton btn02 = new JButton("读取");
        JButton btn03 = new JButton("上传");
        JButton btn04 = new JButton("输出");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        JPanel panel10 = new JPanel();
        JPanel panel11 = new JPanel();
        JPanel panel12 = new JPanel();

        JLabel jLabel01=new JLabel("DXF文件路径(如:D:\\data\\test1.dxf):");
        final JTextField textField = new JTextField(15);
        textField.setFont(new Font(null, Font.PLAIN, 15));
        panel1.add(jLabel01);
        panel2.add(textField);

//        String strMsg = "<html><body>" + "管道图层名称((多个图层请用英文逗号" + "<br>" + "隔开,如:--GY-DN150,--GY-管道DN450):" + "<body></html>";
//        JLabel jLabel02=new JLabel(strMsg);
//        JTextArea jta = new JTextArea(3,18);
//        jta.setLineWrap(true);
//        jta.setFont(new Font(null, Font.PLAIN, 15));
//        panel3.add(jLabel02);
//        panel4.add(jta);

        panel5.add(btn01);
        panel6.add(btn02);
        panel11.add(btn03);
        panel12.add(btn04);

        JLabel jLabel03=new JLabel("结果输出:");
        final JTextArea jta2 = new JTextArea(5,25);
        jta2.setLineWrap(true);
        jta2.setFont(new Font(null, Font.PLAIN, 15));
        panel7.add(jLabel03);
        panel7.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel8.add(jta2);
        panel8.setLayout(new FlowLayout(FlowLayout.LEFT));

        List<String> layerNames = new ArrayList<>();
        layerNames.add("测试");
        JLabel jLabel04 = new JLabel("图层选择:");
        final MultiComboBoxs comboxstatus = new MultiComboBoxs(layerNames);
        panel9.add(jLabel04);
        panel10.add(comboxstatus);


        // 创建第一个水平箱容器
        Box hBox01 = Box.createHorizontalBox();
        hBox01.add(Box.createHorizontalGlue());
        hBox01.add(panel1);
        hBox01.add(panel2);

        // 创建第二水平箱容器
//        Box hBox02 = Box.createHorizontalBox();
//        hBox02.add(Box.createHorizontalGlue());
//        hBox02.add(panel3);
//        hBox02.add(panel4);

        // 创建第2.2个水平箱容器
        Box hBox05 = Box.createHorizontalBox();
        hBox05.add(Box.createHorizontalGlue());
        hBox05.add(panel9);
        hBox05.add(panel10);

        // 创建第三水平箱容器
        Box hBox03 = Box.createHorizontalBox();
        hBox03.add(Box.createHorizontalGlue());
        hBox03.add(panel11);
        hBox03.add(Box.createHorizontalGlue());
        hBox03.add(panel5);
        hBox03.add(Box.createHorizontalGlue());
        hBox03.add(panel6);
        hBox03.add(Box.createHorizontalGlue());
        hBox03.add(panel12);
        hBox03.add(Box.createHorizontalGlue());


        // 创建第四水平箱容器
        Box hBox04 = Box.createHorizontalBox();
        hBox04.add(panel7);
        hBox04.add(panel8);

        // 创建一个垂直箱容器，放置上面两个水平箱（Box组合嵌套）
        Box vBox = Box.createVerticalBox();
        vBox.add(hBox01);
        vBox.add(hBox05);
//        vBox.add(hBox02);
        vBox.add(hBox03);
        vBox.add(hBox04);

        // 把垂直箱容器作为内容面板设置到窗口
        jf.setContentPane(vBox);

        jf.pack();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> layerNames = comboxstatus.getSelectedValues();
                System.out.println(layerNames);
                String one = textField.getText().trim();
                //String two = jta.getText().trim();
                List<String> result = new ArrayList<>();
                try {
                    result = FirstRead(one, layerNames);
                    System.out.println(result);
                } catch (ParseException | FileNotFoundException parseException) {
                    parseException.printStackTrace();
                }
                jta2.setText(String.valueOf(result));
            }
        });

        btn02.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> layerNames = comboxstatus.getSelectedValues();
                System.out.println(layerNames);
                String one = textField.getText().trim();
                //String two = jta.getText().trim();
                List<String> result = new ArrayList<>();
                try {
                    result = SecondRead(one, layerNames);
                    System.out.println(result);
                } catch (ParseException | FileNotFoundException parseException) {
                    parseException.printStackTrace();
                }
                jta2.setText(String.valueOf(result));
            }
        });

        btn03.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> result = new ArrayList<>();
                String DataPath = textField.getText().trim();
                try {
                    result = getDXFLayers(DataPath);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                comboxstatus.change(result);
            }
        });

        btn04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> LayerNames = comboxstatus.getSelectedValues();
                String DataPath = textField.getText().trim();
                try {
                    LastRead(DataPath, LayerNames);
                } catch (FileNotFoundException fileNotFoundException) {
                    fileNotFoundException.printStackTrace();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
            }
        });
    }
}

