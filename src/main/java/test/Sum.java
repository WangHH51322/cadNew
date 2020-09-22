package test;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/18 23:07
 */
import org.apache.xmlbeans.impl.regex.ParseException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import static test.test01.FirstRead;


public class Sum extends JFrame implements ActionListener{
    JPanel panel;
    JLabel oneLabel;
    JLabel twoLabel;
    JButton sumButton;
    JTextField oneTextField;
    JTextField twoTextField;
    JTextField threeTextField;
    public Sum() {
        panel = new JPanel();
        panel.setBackground(new Color(192, 192, 192));
        panel.setLayout(new FlowLayout());
        this.add(panel);
        oneLabel = new JLabel("请输入文件路径：(如:D:\\data\\test1.dxf)");
        twoLabel = new JLabel("请输入管段图层名称:(多个图层请用英文逗号隔开,如:--GY-DN150,--GY-管道DN450)");
        oneTextField = new JTextField(15);
        twoTextField = new JTextField(15);
        threeTextField = new JTextField(50);
        sumButton = new JButton("运行");
        oneTextField.addActionListener(this);
        twoTextField.addActionListener(this);
        sumButton.addActionListener(this);
        panel.add(oneLabel);
        panel.add(oneTextField);
        panel.add(twoLabel);
        panel.add(twoTextField);
        panel.add(sumButton);
        panel.add(threeTextField);
        this.setBounds(200, 100, 200, 240);
        this.setResizable(true);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Sum();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        String one = oneTextField.getText().trim();
//        String two = twoTextField.getText().trim();
//        List<String> result = null;
//        try {
//            result = FirstRead(one, two);
//        } catch (FileNotFoundException fileNotFoundException) {
//            fileNotFoundException.printStackTrace();
//        } catch (org.kabeja.parser.ParseException parseException) {
//            parseException.printStackTrace();
//        }
//
//        threeTextField.setText(String.valueOf(result));

    }
}
