
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
public class StudentPanel extends JPanel
{
    public JLabel id=new JLabel("学号",JLabel.CENTER);
    public JLabel name=new JLabel("姓名",JLabel.CENTER);
    public JLabel cpp=new JLabel("C++成绩",JLabel.CENTER);
    public JLabel circuit=new JLabel("电路成绩",JLabel.CENTER);
    public JLabel Ewrite=new JLabel("英语读写",JLabel.CENTER);
    public JLabel Elisten=new JLabel("英语听说",JLabel.CENTER);
    public JLabel physics=new JLabel("大学物理",JLabel.CENTER);
    public JLabel pro=new JLabel("概率论",JLabel.CENTER);
    public JLabel history=new JLabel("近代史",JLabel.CENTER);
    public JLabel xingzheng=new JLabel("形势与政策",JLabel.CENTER);
    public JLabel pe=new JLabel("体育成绩",JLabel.CENTER);
    public JLabel discrete=new JLabel("离散数学",JLabel.CENTER);
    public JTextField idField=new JTextField(15);
    public JTextField nameField=new JTextField(15);
    public JTextField cppField=new JTextField(15);
    public JTextField cirField=new JTextField(15);
    public JTextField EwriteField=new JTextField(15);
    public JTextField ElistenField=new JTextField(15);
    public JTextField phyField=new JTextField(15);
    public JTextField proField=new JTextField(15);
    public JTextField historyField=new JTextField(15);
    public JTextField xingzhengField=new JTextField(15);
    public JTextField peField=new JTextField(15);
    public JTextField discreteField=new JTextField(15);
    public StudentPanel()
    {
        this.setLayout(new GridLayout(16,1,0,0));
        JPanel p1=new JPanel();
        p1.setLayout(new FlowLayout(FlowLayout.CENTER));
        p1.add(id);
        p1.add(idField);
        JPanel p2=new JPanel();
        p2.setLayout(new FlowLayout(FlowLayout.CENTER));
        p2.add(name);
        p2.add(nameField);
        JPanel p3=new JPanel();
        p3.setLayout(new FlowLayout(FlowLayout.CENTER));
        p3.add(cpp);
        p3.add(cppField);
        JPanel p4=new JPanel();
        p4.setLayout(new FlowLayout(FlowLayout.CENTER));
        p4.add(circuit);
        p4.add(cirField);
        JPanel p5=new JPanel();
        p5.setLayout(new FlowLayout(FlowLayout.CENTER));
        p5.add(Ewrite);
        p5.add(EwriteField);
        JPanel p6=new JPanel();
        p6.setLayout(new FlowLayout(FlowLayout.CENTER));
        p6.add(Elisten);
        p6.add(ElistenField);
        JPanel p7=new JPanel();
        p7.setLayout(new FlowLayout(FlowLayout.CENTER));
        p7.add(physics);
        p7.add(phyField);
        JPanel p8=new JPanel();
        p8.setLayout(new FlowLayout(FlowLayout.CENTER));
        p8.add(pro);
        p8.add(proField);
        JPanel p9=new JPanel();
        p9.setLayout(new FlowLayout(FlowLayout.CENTER));
        p9.add(history);
        p9.add(historyField);
        JPanel p10=new JPanel();
        p10.setLayout(new FlowLayout(FlowLayout.CENTER));
        p10.add(xingzheng);
        p10.add(xingzhengField);
        JPanel p11=new JPanel();
        p11.setLayout(new FlowLayout(FlowLayout.CENTER));
        p11.add(pe);
        p11.add(peField);
        JPanel p12=new JPanel();
        p12.setLayout(new FlowLayout(FlowLayout.CENTER));
        p12.add(discrete);
        p12.add(discreteField);
        this.add(p1);this.add(p2);this.add(p3);this.add(p4);
        this.add(p5);this.add(p6);this.add(p7);this.add(p8);
        this.add(p9);this.add(p10);this.add(p11);this.add(p12);
    }
}
class StudentPanel2 extends StudentPanel
{
    public JLabel gpa=new JLabel("GPA",JLabel.CENTER);
    public JTextField gpaField=new JTextField(15);
    public JLabel overall=new JLabel("总分",JLabel.CENTER);
    public JTextField overallField=new JTextField(15);
    public StudentPanel2()
    {
        super();
        JPanel p13=new JPanel();
        p13.setLayout(new FlowLayout(FlowLayout.CENTER));
        p13.add(overall);
        p13.add(overallField);
        JPanel p14=new JPanel();
        p14.setLayout(new FlowLayout(FlowLayout.CENTER));
        p14.add(gpa);
        p14.add(gpaField);
        this.add(p13);
        this.add(p14);
    }

}
