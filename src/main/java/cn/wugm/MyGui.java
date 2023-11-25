package cn.wugm;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MyGui {

    private JFrame frame;
    private JButton chooseButton;
    private JTextField filePathField;
    private JPanel mainPanel;

    public MyGui() {
        // 初始化界面组件  
        frame = new JFrame("文件选择器");

        // 创建主面板，使用GridBagLayout布局管理器  
        mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        // 创建按钮  
        chooseButton = new JButton("清选择数据所在文件夹");
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(chooseButton, constraints);

        // 创建输出框  
        filePathField = new JTextField();

        filePathField.setSize(200,30);
        constraints.gridx = 0;
        constraints.gridy = 10;
        mainPanel.add(filePathField, constraints);

        // 为按钮添加点击事件监听器  
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 创建JFileChooser对象  
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                // 显示文件选择对话框，返回用户选择的选项  
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    // 如果用户点击了“打开”按钮，则获取选择的文件路径，并更新文本框的内容  
                    String filePath = fileChooser.getSelectedFile().getPath();
                    try {
                        String unioDate = UnioDate.getUnioDate(filePath);
                        filePathField.setText(unioDate);
                    } catch (IOException ioException) {
                        filePathField.setText(ioException.getMessage());
                        ioException.printStackTrace();
                    }

                }
            }
        });

        // 将主面板添加到窗口  
        frame.add(mainPanel, BorderLayout.CENTER);

        // 设置窗口属性并显示  
        frame.setSize(800, 400); // 调整窗口大小以适应输出框在下方的布局
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyGui()); // 在事件调度线程中创建并显示GUI
    }
}  
