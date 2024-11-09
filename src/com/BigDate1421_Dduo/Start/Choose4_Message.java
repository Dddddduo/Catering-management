package com.BigDate1421_Dduo.Start;

import javax.swing.*;
import java.awt.*;
//感谢
public class Choose4_Message extends JFrame {
    //这里使用了图形化组件Java Swing

    public void UI() {

        setTitle("感谢");

        //更改默认状态,这样才可以添加文字
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label1 = new JLabel("谢谢老师");
        JLabel label2 = new JLabel("这是我们小组的课设");
        JLabel label3 = new JLabel("耗时一周写成的课程设计");
        JLabel label4 = new JLabel("现在是北京时间2024/7/2 19:12:43");
        JLabel label5 = new JLabel("此处特别感谢老师的指导");

        /*
        设置字体大小
        这里本来实现放大文本框的
        可是尝试后发现文字无法正常显示
        Font font = new Font("Arial", Font.PLAIN, 20);
        新建一个字体
        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        label4.setFont(font);
        label5.setFont(font);
         */

        //使用垂直盒子布局来排列多个JLabel组件
        //因为居中显示的话无法换行只会使界面原来越宽
        Box vbox = Box.createVerticalBox();
        vbox.add(label1);
        vbox.add(label2);
        vbox.add(label3);
        vbox.add(label4);
        vbox.add(label5);

        //通过Container获取当前JFrame内容面板
        //调用方法来添加组件
        Container contentPane = getContentPane();
        contentPane.add(vbox);

        //自动调整JFrame的大小
        pack();

        /*
        居中显示但是会被现有的程序覆盖

        //获得屏幕尺寸
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // 计算窗口位置，使其显示在屏幕中心
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;

        //设置窗口位置
        setLocation(x, y);
        */

        //没有设置界面框的大小是因为字会莫名其妙消失,不设置是默认填充状态

        //设置界面居中
        this.setLocationRelativeTo(null);
        //取消默认的居中放置
        this.setLayout(null);
        //显示窗口
        setVisible(true);

        /*
        想改变窗口图标
        但是
        这里因为没有使用JFrame所以想不到方法来改变窗口图标

        ImageIcon icon = new ImageIcon("icon.png");
        frame.setIconImage(icon.getImage());
        */
    }

    public static void message(){
        Choose4_Message choose4Message = new Choose4_Message();
        choose4Message.UI();
    }

}
