package com.siemonsele.d4_innerclass4;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Test3 {
    public static void main(String[] args) {
        //拓展：掌握匿名内部类的真实场景
        //GUI SWING编程：桌面编程
        //1,创建一个窗口
        JFrame win = new  JFrame();

        JPanel panel = new JPanel();
        win.add(panel);

        JButton btn = new JButton("登录");
        panel.add(btn);

        //给按钮绑定单机事件监听器对象，可以用来监听用户的点击，以便做出反应
        //匿名内部类是作为一个对象参数传输给方法使用的，至于什么时候用匿名内部类要看实际开发的需要，遇到了才用，没有遇到则不会主动使用
        //还有一个很重要的作用：简化代码（新技术的基础）
//        btn.addActionListener(new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e){
//                JOptionPane.showMessageDialog(win, "没事别点我！讨厌你！");
//            }
//        });

        btn.addActionListener( e -> JOptionPane.showMessageDialog(win, "没事别点我！讨厌你！"));

        //2，设计大小，居中显示
        win.setSize(400, 300);
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.setVisible(true);
    }
}
