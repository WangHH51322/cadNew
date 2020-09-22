package test;

/**
 * @author Qing
 * @version 1.0
 * @date 2020/7/23 22:12
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 * 下拉复选框组件
 *
 */
public class MultiComboBoxs extends JComponent implements ActionListener {

    private List<String> values;
    private MultiPopup popup;
    private JTextField editor;
    protected JButton arrowButton;

    public MultiComboBoxs(List<String> value) {
        values = value;
        initComponent();
    }

    public void change(List<String> value){
        this.values = value;
        popup = new MultiPopup(values);
    }

    private void initComponent() {
        this.setLayout(new BorderLayout());
        popup = new MultiPopup(values);
        editor = new JTextField();
        editor.setBackground(Color.WHITE);
        editor.setEditable(false);
        editor.setPreferredSize(new Dimension(151, 22));
        editor.addActionListener(this);
        arrowButton = createArrowButton();
        arrowButton.addActionListener(this);
        add(editor, BorderLayout.WEST);
        add(arrowButton, BorderLayout.CENTER);
    }

    //获取选中的数据
    public List<String> getSelectedValues() {
        return popup.getSelectedValues();
    }

    //设置需要选中的值
    public void setSelectValues(List<String> selectvalues) {
        popup.setSelectValues(selectvalues);
        setText(selectvalues);
    }

    private void setText(List<String> values) {
        editor.setText(String.valueOf(values));
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        if (!popup.isVisible()) {
            popup.show(this, 0, getHeight());
        }
    }

    protected JButton createArrowButton() {
        JButton button = new BasicArrowButton(BasicArrowButton.SOUTH, UIManager.getColor("ComboBox.buttonBackground"),
                UIManager.getColor("ComboBox.buttonShadow"), UIManager.getColor("ComboBox.buttonDarkShadow"),
                UIManager.getColor("ComboBox.buttonHighlight"));
        button.setName("ComboBox.arrowButton");
        return button;
    }


    //内部类MultiPopup

    public class MultiPopup extends JPopupMenu implements ActionListener {
        private List<String> values;
        private List<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
        private JButton commitButton;
        private JButton cancelButton;

        public MultiPopup(List<String> value) {
            super();
            values = value;
            initComponent();
        }

        private void initComponent() {
            JPanel checkboxPane = new JPanel();
            JPanel buttonPane = new JPanel();
            this.setLayout(new BorderLayout());
            for (String value : values) {
                JCheckBox temp = new JCheckBox(value);
                checkBoxList.add(temp);
            }

            checkboxPane.setLayout(new GridLayout(checkBoxList.size(), 2, 3, 4));
            for (JCheckBox box : checkBoxList) {
                checkboxPane.add(box);
            }

            commitButton = new JButton("确定");
            commitButton.addActionListener(this);

            cancelButton = new JButton("取消");
            cancelButton.addActionListener(this);

            buttonPane.add(commitButton);
            buttonPane.add(cancelButton);
            this.add(checkboxPane, BorderLayout.CENTER);
            this.add(buttonPane, BorderLayout.SOUTH);

        }

        public void setSelectValues(List<String> values) {
            if (values.size() > 0) {
                for (int i = 0; i < values.size(); i++) {
                    for (int j = 0; j < checkBoxList.size(); j++) {
                        if (values.get(i).equals(checkBoxList.get(j).getText())) {
                            checkBoxList.get(j).setSelected(true);
                        }
                    }
                }
                setText(getSelectedValues());
            }
        }


        public List<String> getSelectedValues() {
            List<String> selectedValues = new ArrayList<String>();

            for (int i = 0; i < checkBoxList.size(); i++) {
                if (checkBoxList.get(i).isSelected()) {
                    selectedValues.add(values.get(i));
                }
            }


            return selectedValues;
        }



        @Override
        public void actionPerformed(ActionEvent arg0) {
            // TODO Auto-generated method stub
            Object source = arg0.getSource();
            if (source instanceof JButton) {
                JButton button = (JButton) source;
                if (button.equals(commitButton)) {
                    setText(getSelectedValues());
                    popup.setVisible(false);
                } else if (button.equals(cancelButton)) {
                    popup.setVisible(false);
                }
            }
        }

    }

}

