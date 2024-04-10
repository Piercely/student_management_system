
import oracle.jvm.hotspot.jfr.JFR;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Decide1 extends JFrame implements ActionListener
{
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
    // 定义MySQL数据库的连接地址
    public static final String DBURL = "jdbc:mysql://localhost:3306/student" ;
    // MySQL数据库的连接用户名
    public static final String DBUSER = "root" ;
    // MySQL数据库的连接密码
    public static final String DBPASS = "xzk520521";
    JButton yes=new JButton("确定");
    JButton no=new JButton("取消");
    StudentPanel2 dec=new StudentPanel2();
    public  static String idstring,namestring,cppstring,cirstring,Ewritestring,Elistenstring,
          physicsstring,prostring,hisstring,xingzhengstring,pestring,discretestring,overallstring,gpastring;
    public Decide1()
    {
        JFrame decide=new JFrame("决定是否修改");
        //Container con1=decide.getContentPane();
        decide.setLayout(new BorderLayout());

        String deleteid=ChangeInfo.tipsField.getText();
        // System.out.println(deleteid);
        JPanel p3=new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        p3.add(yes);
        p3.add(no);
        try
        {
            Class.forName(DBDRIVER);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            Connection conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            Statement stmt=conn.createStatement();
            String sql1="select * from grade where id='"+deleteid+"'";
            ResultSet rs=stmt.executeQuery(sql1);
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
                dec.overallField.setEnabled(false);dec.gpaField.setEnabled(false);
                decide.add(BorderLayout.CENTER,dec);//设置窗体显示时间，一定要用窗体对象设置！！！！！
                decide.add(BorderLayout.SOUTH,p3);
                decide.setBounds(400, 200, 500, 500);
                decide.setVisible(true);
                yes.addActionListener(this);
                no.addActionListener(this);
            rs.close();
            stmt.close();
            conn.close();}
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public  void actionPerformed(ActionEvent e1)
    {
        String s=e1.getActionCommand();
        if (s.equals("确定"))
        {
            idstring=dec.idField.getText();
            namestring=dec.nameField.getText();
            cppstring=dec.cppField.getText();
            cirstring=dec.cirField.getText();
            Ewritestring=dec.EwriteField.getText();
            Elistenstring=dec.ElistenField.getText();
            physicsstring=dec.phyField.getText();
            prostring=dec.proField.getText();
            hisstring=dec.historyField.getText();
            xingzhengstring=dec.xingzhengField.getText();
            pestring=dec.peField.getText();
            discretestring=dec.discreteField.getText();
            student stu=new student(idstring,namestring,cppstring,cirstring,Ewritestring,Elistenstring,physicsstring
                    ,prostring,hisstring,xingzhengstring,pestring,discretestring);
            stu.gpa=Double.toString(stu.getoverallgpa());
            stu.overall=Double.toString(stu.getoverall());
            overallstring=stu.overall;
            gpastring=stu.gpa;
            try
            {
                Class.forName(DBDRIVER);
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            try
            {
                Connection conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
                Statement stmt=conn.createStatement();
                String sql="update grade set id='"+idstring+"',name='"+namestring+"',cpp='"+cppstring+
                        "',circuit='"+cirstring+"',Ewrite='"+Ewritestring+"',Elisten='"+Elistenstring+
                        "',physics='"+physicsstring+"',probability='"+prostring+"',history='"+hisstring+
                        "',xingzheng='"+xingzhengstring+"',pe='"+pestring+"',discrete='"+discretestring+"',overall='"+overallstring+"',gpa='"+
                        gpastring+"'where id='"+ChangeInfo.tipsField.getText()+"'";
                if(stmt.executeUpdate(sql)>0){
                    JOptionPane.showMessageDialog(null,"学生记录修改成功！");
                }else{
                    JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！");
                }
                stmt.close();
                conn.close();
            }catch (SQLException e)
            {
                e.printStackTrace();
            }

        }
        else
        {
            dec.idField.setText("");
            dec.nameField.setText("");
            dec.cppField.setText("");
            dec.cirField.setText("");
            dec.EwriteField.setText("");
            dec.ElistenField.setText("");
            dec.phyField.setText("");
            dec.proField.setText("");
            dec.historyField.setText("");
            dec.xingzhengField.setText("");
            dec.peField.setText("");
            dec.discreteField.setText("");
        }


    }

}
public class ChangeInfo extends JFrame
{
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
    // 定义MySQL数据库的连接地址
    public static final String DBURL = "jdbc:mysql://localhost:3306/student" ;
    // MySQL数据库的连接用户名
    public static final String DBUSER = "root" ;
    // MySQL数据库的连接密码
    public static final String DBPASS = "xzk520521";
    JLabel tips=new JLabel("请输入要修改的学生学号:",JLabel.CENTER);
    public static JTextField tipsField=new JTextField(30);
    JButton delete=new JButton("修改");
    public ChangeInfo()
    {
        super("修改学生信息");
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
                new Decide1();
            }
        });
    }
}
class Change
{
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
    // 定义MySQL数据库的连接地址
    public static final String DBURL = "jdbc:mysql://localhost:3306/student" ;
    // MySQL数据库的连接用户名
    public static final String DBUSER = "root" ;
    // MySQL数据库的连接密码
    public static final String DBPASS = "xzk520521";
    public Change()
    {
        try
        {
            Class.forName(DBDRIVER);
        }catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            Connection conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            Statement stmt=conn.createStatement();
            String sql="update grade set id='"+Decide1.idstring+"',name='"+Decide1.namestring+"',cpp='"+Decide1.cppstring+
                    "',circuit='"+Decide1.cirstring+"',Ewrite='"+Decide1.Ewritestring+"',Elisten='"+Decide1.Elistenstring+
                    "',physics='"+Decide1.physicsstring+"',probability='"+Decide1.prostring+"',history='"+Decide1.hisstring+
                    "',xingzheng='"+Decide1.xingzhengstring+"',pe='"+Decide1.pestring+"',discrete='"+Decide1.discretestring+
                    "'where id='"+ChangeInfo.tipsField.getText()+"'";
            if(stmt.executeUpdate(sql)>0){
                JOptionPane.showMessageDialog(null,"学生记录修改成功！");
            }else{
                JOptionPane.showMessageDialog( null ,"学籍系统中并无相关记录！");
            }
            stmt.close();
            conn.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
}

