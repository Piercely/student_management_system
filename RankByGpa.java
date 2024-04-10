import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class student
{
    public String id;
    public String name;
    public String cpp;
    public String circuit;
    public String Ewrite;
    public String Elisten;
    public String physics;
    public String probability;
    public String history;
    public String xingzheng;
    public String pe;
    public String discrete;
    public String gpa;
    public String overall;
    public String rank;
    public student(String id,String name,String cpp,String circuit,String Ewrite,String Elisten,String physics,
                   String probability,String history,String xingzheng,String pe,String discrete)
    {
        this.id=id;this.name=name;this.cpp=cpp;this.circuit=circuit;this.Ewrite=Ewrite;this.Elisten=Elisten;
        this.physics=physics;this.probability=probability;this.history=history;this.xingzheng=xingzheng;this.pe=pe;this.discrete=discrete;
        this.gpa="0";this.overall="0";this.rank="0";
    }
    public double getsinglegpa(double a)
    {
        if (a<60)
            return 0;
        else
            return (a-60)/10.0+1;
    }
    public double  getoverallgpa()
    {
        double cppgrade=Double.parseDouble(this.cpp);
        double cirgrade=Double.parseDouble(this.circuit);
        double Ewritegrade=Double.parseDouble(this.Ewrite);
        double Elistengrade=Double.parseDouble(this.Elisten);
        double physicsgrade=Double.parseDouble(this.physics);
        double prograde=Double.parseDouble(this.probability);
        double hisgrade=Double.parseDouble(this.history);
        double xingzhenggrade=Double.parseDouble(this.xingzheng);
        double pegrade=Double.parseDouble(this.pe);
        double discretegrade=Double.parseDouble(this.discrete);
        double all=getsinglegpa(cppgrade)*3.5+getsinglegpa(cirgrade)*4+getsinglegpa(Ewritegrade)*2+
                getsinglegpa(Elistengrade)*2+getsinglegpa(physicsgrade)*3+getsinglegpa(prograde)*3+
                getsinglegpa(hisgrade)*2+getsinglegpa(xingzhenggrade)*0.3+getsinglegpa(pegrade)*1+getsinglegpa(discretegrade)*4;
        double ans=all/(24.8);
        return ans;
    }
    public double getoverall()
    {
        double cppgrade=Double.parseDouble(this.cpp);
        double cirgrade=Double.parseDouble(this.circuit);
        double Ewritegrade=Double.parseDouble(this.Ewrite);
        double Elistengrade=Double.parseDouble(this.Elisten);
        double physicsgrade=Double.parseDouble(this.physics);
        double prograde=Double.parseDouble(this.probability);
        double hisgrade=Double.parseDouble(this.history);
        double xingzhenggrade=Double.parseDouble(this.xingzheng);
        double pegrade=Double.parseDouble(this.pe);
        double discretegrade=Double.parseDouble(this.discrete);
        double ans=cppgrade+cirgrade+Ewritegrade+Elistengrade+physicsgrade+prograde+hisgrade+xingzhenggrade+pegrade+discretegrade;
        return ans;
    }
}
public class RankByGpa extends JFrame
{
    public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
    // 定义MySQL数据库的连接地址
    public static final String DBURL = "jdbc:mysql://localhost:3306/student" ;
    // MySQL数据库的连接用户名
    public static final String DBUSER = "root" ;
    // MySQL数据库的连接密码
    public static final String DBPASS = "xzk520521";
    JTable jt;
    JScrollPane scroller;
    String title[]={"id","name","C++成绩","电路成绩","英语读写","英语听说","大学物理",
    "概率论","近代史","形势与政策","体育","离散数学","总分","GPA"};
    String[][] info=new String[100][14];
    public RankByGpa()
    {
        super("按照GPA排名");
        Container con=this.getContentPane();
        con.setLayout(new BorderLayout());
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
            String sql="SELECT * FROM grade ORDER BY gpa DESC";
            ResultSet rs=stmt.executeQuery(sql);
            int i=0;
            while(rs.next()){
                int j=0;
                info[i][j]=rs.getString(1);j++;
                info[i][j]=rs.getString(2);;j++;
                info[i][j]=rs.getString(3);j++;
                info[i][j]=rs.getString(4);j++;
                info[i][j]=rs.getString(5);j++;
                info[i][j]=rs.getString(6);j++;
                info[i][j]=rs.getString(7);j++;
                info[i][j]=rs.getString(8);j++;
                info[i][j]=rs.getString(9);j++;
                info[i][j]=rs.getString(10);j++;
                info[i][j]=rs.getString(11);j++;
                info[i][j]=rs.getString(12);j++;
                info[i][j]=rs.getString(13);j++;
                info[i][j]=rs.getString(14);j++;
                i++;
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        jt=new JTable(info,title);
        scroller=new JScrollPane(jt);
        con.add(BorderLayout.CENTER,scroller);
        this.setVisible(true);
        this.setBounds(400, 300, 700, 400);
    }

}
