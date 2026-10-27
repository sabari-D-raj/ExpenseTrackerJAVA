import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
public class Gui{
    public static void main(String[] args){
        JFrame jf= new JFrame("EXPENSE TRACKER");
        jf.setSize(500,500);
        jf.setLayout(new GridLayout(4,4));
        JLabel jl=new JLabel("CATEOGRY");
        JTextField ctext=new JTextField("");
        JLabel jl2= new JLabel("AMOUNT");
        JTextField atext=new JTextField("");
        JButton jb=new JButton("SUBMIT");
        JButton jb2=new JButton("CANCCEL");
        jf.add(jl);
        jf.add(ctext);
        jf.add(jl2);
        jf.add(atext);
        jf.add(jb);
        jf.add(jb2);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
