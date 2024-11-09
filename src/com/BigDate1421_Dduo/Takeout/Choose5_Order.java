package com.BigDate1421_Dduo.Takeout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Iterator;
public class Choose5_Order extends JFrame {
    private JList<String> menuList;
    private DefaultListModel<String> menuListModel;
    private JTextArea orderTextArea;
    private JButton orderButton;

    public static HashMap<String,Integer>foods=new HashMap();
    //这个哈希表创建是为了模拟点单时使用
    //键是食品名称,值是食品价格
    public static void addExampleOrder(){
        //添加数据
        foods.put("炸鸡腿",10);
        foods.put("汉堡",15);
        foods.put("可乐",3);
        foods.put("雪碧",4);
    }

    public static void add(String name,int price) {
        //将名称和价格放入哈希表
        foods.put(name,price);
    }
    public static void delete(String name) {
        //删除哈希表内的键值对
        foods.remove(name);
    }

    public Choose5_Order() {
        /*
        这里是添加背景图片但是添加上去会遮挡文字

        ImageIcon icon1=new ImageIcon();
        //创建一个JLabel的对象(管理容器)
        JLabel jLabel1=new JLabel(icon1);
        //把管理容器添加到界面当中
        this.add(jLabel1);
        //用坐标指定图片的位置
        jLabel1.setBounds(-15,0,600,550);
         */
        //设置界面置顶 显示在主页上不会被覆盖
        this.setAlwaysOnTop(true);
        //设置界面的宽度和高度
        this.setSize(300, 300);
        //设置界面的标题
        this.setTitle("多多模拟点餐");
        //设置界面居中
        this.setLocationRelativeTo(null);
        //这样才能添加组件
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建主面板
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // 创建菜单列表
        menuListModel = new DefaultListModel<>();
        //遍历哈希表,把哈希表的键放进去
        Iterator<String> iterator = foods.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            menuListModel.addElement(key);
        }
        //因为哈希表是一种无序的数据结构
        //所以插入的时候顺序会乱
        //有用LinkedHashMap改写的想法

        menuList = new JList<>(menuListModel);
        JScrollPane menuScrollPane = new JScrollPane(menuList);
        mainPanel.add(menuScrollPane, BorderLayout.CENTER);

        //创建订单区域
        orderTextArea = new JTextArea();
        JScrollPane orderScrollPane = new JScrollPane(orderTextArea);
        mainPanel.add(orderScrollPane, BorderLayout.EAST);

        //创建按钮面板
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));

        //创建添加按钮
        JButton addButton = new JButton("添加购物车");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedItem = menuList.getSelectedValue();
                if (selectedItem != null && !selectedItem.isEmpty()) {
                    orderTextArea.append(selectedItem + "\n");
                }
            }
        });
        buttonPanel.add(addButton);

        //创建清空按钮
        JButton clearButton = new JButton("清空购物车");
        //匿名内部类来实现事件监听器
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderTextArea.setText("");
            }
        });
        buttonPanel.add(clearButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        //创建下单按钮
        orderButton = new JButton("结账");
        //这里我原本写的是匿名内部类,后来改成了Lambda表达式
        orderButton.addActionListener(e -> {
            String orderText = orderTextArea.getText();
            if (!orderText.isEmpty()) {
                double totalAmount = 0.0;

                //将菜品价格累加
                String[] orders = orderText.split("\n");
                for (String order : orders) {
                    if (foods.containsKey(order)) {
                        totalAmount += foods.get(order);
                    }
                }

                //显示总金额
                JOptionPane.showMessageDialog(Choose5_Order.this, "购物车:\n" + orderText + "\n总价格: $" + totalAmount, "结账",JOptionPane.WARNING_MESSAGE);
                orderTextArea.setText("");
            } else {
                JOptionPane.showMessageDialog(Choose5_Order.this, "购物车内无商品", "出错了", JOptionPane.ERROR_MESSAGE);
            }
        });

        //将主面板添加到窗口中
        add(mainPanel, BorderLayout.CENTER);
        add(orderButton, BorderLayout.SOUTH);
    }

    public static void order() {
        //这里我原本写的是匿名内部类,后来改成了Lambda表达式
        SwingUtilities.invokeLater(() -> {
            //启动
            Choose5_Order ui = new Choose5_Order();
            //使页面显示
            ui.setVisible(true);
        });
    }
}

