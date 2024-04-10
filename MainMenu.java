
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class MainMenu{
    public MainMenu(){
        JFrame frame = new JFrame("学生成绩管理系统") ;
        JTextArea text = new JTextArea() ;
        text.setEditable(true) ;	// 可编辑
        frame.getContentPane().add(new JScrollPane(text)) ;	// 加入滚动条
        JMenu menuFile1 = new JMenu("操作菜单") ;
        JMenu menuFile2 = new JMenu("关于") ;
        JMenuBar menuBar = new JMenuBar() ;
        JMenuItem item1=new JMenuItem("录入学生成绩");
        JMenuItem item2=new JMenuItem("修改学生成绩");
        JMenuItem item3=new JMenuItem("删除学生成绩");
        JMenuItem item4=new JMenuItem("按学生GPA排名");

        JMenuItem item8=new JMenuItem("关于本软件");
        JMenuItem item9=new JMenuItem("查询学生成绩");
        menuFile1.add(item1);
        menuFile1.add(item9);
        menuFile1.add(item2);
        menuFile1.add(item3);
        menuFile1.add(item4);
        //menuFile1.add(item5);

        menuFile2.add(item8);
        menuBar.add(menuFile1) ;
        menuBar.add(menuFile2);
        frame.setJMenuBar(menuBar) ;	// 菜单是需要通过此方法增加的
        item4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new RankByGpa();
            }
        });
         item1.addActionListener(new ActionListener()
         {
           public void actionPerformed(ActionEvent e){
           new AddInfo();
           }
        });
        item9.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new FindInfo();
            }
        });
        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ChangeInfo();
            }
        });
        item3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new DeleteInfo();
            }
        });
        item8.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        //JOptionPane.showMessageDialog(null, "本软件由项兆坤开发", "标题",JOptionPane.PLAIN_MESSAGE);
                                        JFrame about=new JFrame("关于");
                                        about.setLayout(null);
                                        JLabel title1=new JLabel("学生成绩管理系统");
                                        JLabel title2=new JLabel("Macintosh桌面体验");
                                        JLabel title3=new JLabel("软件版本1.0");
                                        JLabel title4=new JLabel("TM和@1997-2017 Sodakun Inc.");
                                        JLabel title5=new JLabel("保留一切权利。");
                                        about.setSize(300,150);
                                        title1.setBounds(45,5,200,20);
                                        title2.setBounds(45,30,200,20);
                                        title3.setBounds(45,55,200,20);
                                        title4.setBounds(45,80,200,20);
                                        title5.setBounds(45,105,200,20);
                                        about.add(title1);
                                        about.add(title2);
                                        about.add(title3);
                                        about.add(title4);
                                        about.add(title5);
                                        about.setVisible(true);
                                        //about.setSize(100,100);
                                        about.setLocation(400,300);


                                    }
                                }
        );
        frame.setVisible(true) ;
        frame.setSize(600,600) ;
        frame.setLocation(300,200) ;
    }
}