
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
public class AddInfo extends JFrame implements ActionListener
{
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
    // 定义MySQL数据库的连接地址
    public static final String DBURL = "jdbc:mysql://localhost:3306/student" ;
    // MySQL数据库的连接用户名
    public static final String DBUSER = "root" ;
    // MySQL数据库的连接密码
    public static final String DBPASS = "xzk520521";
    JButton add=new JButton("添加");
    JButton reset=new JButton("重置");
    StudentPanel p2=new StudentPanel();
    String idstring,namestring,cppstring,cirstring,Ewritestring,Elistenstring,
    physicsstring,prostring,hisstring,xingzhengstring,pestring,discretestring,overallstring,gpastring;
    public AddInfo()
    {
        super("添加学生成绩");
        Container con=this.getContentPane();
        con.setLayout(new BorderLayout());
        add.setToolTipText("添加学生信息,有相同学号的信息无效!");
        reset.setToolTipText("将所有项目清除!");
        JPanel p3=new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        p3.add(add);
        p3.add(reset);
       con.add(BorderLayout.CENTER,p2);
        con.add(BorderLayout.SOUTH,p3);
        this.setBounds(400, 200, 500, 500);
        this.setVisible(true);
        this.setResizable(false);
        add.addActionListener(this);
        reset.addActionListener(this);
        this.setAlwaysOnTop(false);
        this.setFocusable(true);
    }
    public void actionPerformed(ActionEvent e1)
    {
        String s=e1.getActionCommand();
        if (s.equals("添加"))
        {
            idstring=p2.idField.getText();
            namestring=p2.nameField.getText();
            cppstring=p2.cppField.getText();
            cirstring=p2.cirField.getText();
            Ewritestring=p2.EwriteField.getText();
            Elistenstring=p2.ElistenField.getText();
            physicsstring=p2.phyField.getText();
            prostring=p2.proField.getText();
            hisstring=p2.historyField.getText();
            xingzhengstring=p2.xingzhengField.getText();
            pestring=p2.peField.getText();
            discretestring=p2.discreteField.getText();
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
                    String sql="insert into grade(id,name,cpp,circuit,Ewrite,Elisten,physics,probability,history,xingzheng" +
                            ",pe,discrete,overall,gpa)"+"VALUES('"+idstring+"','"+namestring+"','"+cppstring+"','"+cirstring+"','"+
                            Ewritestring+"','"+Elistenstring+"','"+physicsstring+"','"+prostring+"','"+hisstring+"','"+xingzhengstring
                            +"','"+pestring+"','"+discretestring+"','"+overallstring+"','"+gpastring+"')";
                    String sql1="select * from grade where id='"+idstring+"'";
                    ResultSet rs=stmt.executeQuery(sql1);
                    if(!rs.next())
                    {
                        stmt.executeUpdate(sql);
                        JOptionPane.showMessageDialog( null ,"添加成功！");
                    }else{
                        JOptionPane.showMessageDialog( null ,"该学号已经存在，请检查学号输入是否正确");
                    }
                    rs.close();
                    stmt.close();
                    conn.close();
                }catch (SQLException e)
                {
                    e.printStackTrace();
                }

        }
        else
        {
            p2.idField.setText("");
            p2.nameField.setText("");
            p2.cppField.setText("");
            p2.cirField.setText("");
            p2.EwriteField.setText("");
            p2.ElistenField.setText("");
            p2.phyField.setText("");
            p2.proField.setText("");
            p2.historyField.setText("");
            p2.xingzhengField.setText("");
            p2.peField.setText("");
            p2.discreteField.setText("");
        }
    }
}
