package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.FileWriter;
import javax.swing.*;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/18 22:39
 */
public class Guiwriter extends JFrame
{
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JLabel l = new JLabel("请输入文件路径：(如:D:\\data\\test1.dxf)");
    JLabel l2 = new JLabel("请输入管段图层名称:(多个图层请用逗号隔开,如:--GY-DN150,--GY-管道DN450)");
    JTextField f = new JTextField();
    JButton b = new JButton("执行程序");
    public Guiwriter() //构造方法
    {
        this.setLayout(new BorderLayout());
        p1.setLayout(new GridLayout(3, 2));
        p1.add(l);
        p1.add(l2);
        p1.add(f);
        this.add(p1, BorderLayout.NORTH);
        p2.add(b, BorderLayout.CENTER);
        this.add(p2, BorderLayout.CENTER);
        this.setSize(200, 200);
        this.setVisible(true);
        b.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        String str =f.getText();
                        run(str);
                    }
                });
    }
    public void run(String str){
        String rtnFile1 = "d:/OK.txt";//输出文件路径du
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(rtnFile1));
            String str1 = str ;
            bw.write(str1);
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main (String args[]){
        new Guiwriter();
    }
}
