package cn.wugm;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class ResizingTextField extends JTextField {

    public ResizingTextField() {
        super();
        // 添加文档监听器以监听文本字段中的更改
        getDocument().addDocumentListener(new ResizingDocumentListener(this));
    }



    // 内部的文档监听器类  
    private static class ResizingDocumentListener implements DocumentListener {
        private JTextField textField;

        public ResizingDocumentListener(JTextField textField) {
            this.textField = textField;
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            adjustTextFieldSize();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            adjustTextFieldSize();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            // 对于JTextField，不需要处理此事件  
        }

        // 调整文本字段的大小以适应其内容  
        private void adjustTextFieldSize() {
            textField.setText("你好骚都是垃圾多快好省尽快哈发卡机等哈拉法基花洒科技哈科技大花洒合计看哈倒垃圾凯撒户籍卡德哈卡后期哇嘎嘎都问哈噶几");

            FontMetrics fontMetrics = textField.getFontMetrics(textField.getFont());
            int width = fontMetrics.stringWidth(textField.getText()) + textField.getInsets().left + textField.getInsets().right;
            int height = fontMetrics.getHeight() + textField.getInsets().top + textField.getInsets().bottom;
            textField.setPreferredSize(new Dimension(width, height));
            textField.revalidate(); // 重新布局容器  
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("自动调整大小的文本字段");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ResizingTextField(), BorderLayout.CENTER);
            frame.pack();
            frame.setVisible(true);
        });
    }
}  
