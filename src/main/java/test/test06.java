package test;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/23 20:11
 */


import org.kabeja.parser.ParseException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static test.test01.FirstRead;

public class test06 {

    public static void main(String[] args) {
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(250, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 添加一个标签
        JLabel label = new JLabel("测试：");
        panel.add(label);


        JButton btn01 = new JButton("测试");

        List<String> values = new ArrayList<>();
        values.add("123");
        values.add("412");
        values.add("4423");
        values.add("1423");
        MultiComboBoxs comboxstatus = new MultiComboBoxs(values);

        btn01.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> selectedValues = comboxstatus.getSelectedValues();
                System.out.println(selectedValues);
            }
        });


        // 添加到内容面板
        panel.add(btn01);
        panel.add(comboxstatus);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }

}



