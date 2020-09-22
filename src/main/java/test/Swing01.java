package test;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/18 23:45
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing01 {

    public static void main(String[] args) throws AWTException {
        JFrame jf = new JFrame("测试窗口");
        jf.setSize(300, 300);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // 创建文本框，指定可见列数为8列
        final JTextField textField = new JTextField(8);
        textField.setFont(new Font(null, Font.PLAIN, 20));
        panel.add(textField);
        final JTextField textField2 = new JTextField(8);
        textField2.setFont(new Font(null, Font.PLAIN, 20));
        panel.add(textField2);

        // 创建一个按钮，点击后获取文本框中的文本
        JButton btn = new JButton("提交");
        btn.setFont(new Font(null, Font.PLAIN, 20));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("提交: " + textField.getText());
            }
        });
        panel.add(btn);

        JButton btn2 = new JButton("测试");
        btn2.setFont(new Font(null, Font.PLAIN, 20));
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("测试: " + textField2.getText());
            }
        });
        panel.add(btn2);

        jf.setContentPane(panel);
        jf.setVisible(true);
    }

}

