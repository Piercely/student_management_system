
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
class Findresult
{
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
    // 定义MySQL数据库的连接地址
    public static final String DBURL = "jdbc:mysql://localhost:3306/student" ;
    // MySQL数据库的连接用户名
    public static final String DBUSER = "root" ;
    // MySQL数据库的连接密码
    public static final String DBPASS = "xzk520521";
    public Findresult() {
        JFrame decide = new JFrame("查找结果");
        decide.setLayout(new BorderLayout());
        StudentPanel2 dec = new StudentPanel2();
        String deleteid = FindInfo.tipsField.getText();
        JPanel p3 = new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        //String idstring,namestring,cppstring,cirstring,Ewritestring,Elistenstring,
        //      physicsstring,prostring,hisstring,xingzhengstring,pestring,discretestring;
        try {
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            Statement stmt = conn.createStatement();
            String sql1 = "select * from grade where id='" + deleteid + "'";
            ResultSet rs = stmt.executeQuery(sql1);
            if (!rs.next())
            {
                JOptionPane.showMessageDialog( null ,"该学生尚未录入系统！请前去录入");
            }else
                {


                dec.idField.setText(rs.getString("id"));
                dec.nameField.setText(rs.getString("name"));
                dec.cppField.setText(rs.getString("cpp"));
                dec.cirField.setText(rs.getString("circuit"));
                dec.EwriteField.setText(rs.getString("Ewrite"));
                dec.ElistenField.setText(rs.getString("Elisten"));
                dec.phyField.setText(rs.getString("physics"));
                dec.proField.setText(rs.getString("probability"));
                dec.historyField.setText(rs.getString("history"));
                dec.xingzhengField.setText(rs.getString("xingzheng"));
                dec.peField.setText(rs.getString("pe"));
                dec.discreteField.setText(rs.getString("discrete"));
                dec.overallField.setText(rs.getString("overall"));
                dec.gpaField.setText(rs.getString("gpa"));
            dec.idField.setEnabled(false);
            dec.nameField.setEnabled(false);
            dec.cppField.setEnabled(false);
            dec.cirField.setEnabled(false);
            dec.EwriteField.setEnabled(false);
            dec.ElistenField.setEnabled(false);
            dec.phyField.setEnabled(false);
            dec.proField.setEnabled(false);
            dec.historyField.setEnabled(false);
            dec.xingzhengField.setEnabled(false);
            dec.peField.setEnabled(false);
            dec.discreteField.setEnabled(false);
            dec.overallField.setEnabled(false);
            dec.gpaField.setEnabled(false);
            decide.add(BorderLayout.CENTER, dec);//设置窗体显示时间，一定要用窗体对象设置！！！！！
            decide.add(BorderLayout.SOUTH, p3);
            decide.setBounds(400, 200, 500, 500);
            decide.setVisible(true);
            rs.close();
            stmt.close();
            conn.close();}

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
public class FindInfo extends JFrame
{

    JLabel tips=new JLabel("请输入要查找的学生学号:",JLabel.CENTER);
    public static JTextField tipsField=new JTextField(30);
    JButton delete=new JButton("确定");
    public FindInfo()
    {
        super("查找学生信息");
        Container con=this.getContentPane();
        this.setLayout(new GridLayout(2,1,0,0));//两行一列
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p1.add(tips);
        p1.add(tipsField);
        JPanel p2=new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        p2.add(delete);
        con.add(p1);
        con.add(p2);
        this.setBounds(400, 200, 400, 200);
        this.setVisible(true);
        this.setResizable(false);
        delete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Findresult();
            }
        });

    }

}
