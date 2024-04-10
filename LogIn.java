
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

class LoginCheck{
    private String name ;
    private String password ;
    public LoginCheck(String name,String password){
        this.name = name ;
        this.password = password ;
    }
    public boolean validate(){
        if("xiangzhaokun".equals(name)&&"123456".equals(password)){
            return true ;
        }else{
            return false ;
        }
    }
};

class ActionHandle{
    private JFrame frame = new JFrame("学生成绩管理系统") ;
    private JButton submit = new JButton("登陆");
    private JButton reset = new JButton("重置");
    private JLabel nameLab = new JLabel("用户名：") ;
    private JLabel passLab = new JLabel("密   码：") ;
    private JLabel infoLab = new JLabel("用户登陆系统") ;
    private JTextField nameText = new JTextField(10) ;
    private JPasswordField passText = new JPasswordField() ;
    private JPanel pan = new JPanel() ;
    public ActionHandle(){
        Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,12) ;
        infoLab.setFont(fnt) ;	// 设置标签的显示文字
        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==submit){
                    String tname = nameText.getText() ;
                    String tpass = new String(passText.getPassword()) ;
                    LoginCheck log = new LoginCheck(tname,tpass) ;
                    if(log.validate()){
                        infoLab.setText("登陆成功，欢迎光临！") ;
                        new MainMenu();
                    }else{
                        infoLab.setText("登陆失败，错误的用户名或密码！") ;
                    }
                }
            }
        }) ;
        reset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==reset){
                    nameText.setText("") ;
                    passText.setText("") ;
                    infoLab.setText("用户登陆系统") ;
                }
            }
        }) ;

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(1) ;
            }
        }) ;	// 加入事件
        frame.setLayout(null) ;
        nameLab.setBounds(5,5,60,20) ;
        passLab.setBounds(5,30,60,20) ;
        infoLab.setBounds(5,65,220,30) ;
        nameText.setBounds(65,5,100,20) ;
        passText.setBounds(65,30,100,20) ;
        submit.setBounds(165,5,60,20) ;
        reset.setBounds(165,30,60,20) ;
        frame.add(nameLab) ;
        frame.add(passLab) ;
        frame.add(infoLab) ;
        frame.add(nameText) ;
        frame.add(passText) ;
        frame.add(submit) ;
        frame.add(reset) ;
        frame.setSize(280,130) ;
        frame.setBackground(Color.WHITE) ;
        frame.setLocation(300,200) ;
        frame.setVisible(true) ;

    }
};
public class LogIn{
    public static void main(String args[]){
        new ActionHandle() ;

    }
};