import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.time.LocalDate;
import java.sql.*;
public class Gui{
    public static void newframe() throws SQLException{
          JFrame jf=new JFrame("Total Report");
          jf.setSize(500,500);
          jf.setLayout(new GridLayout(4,4));;
          JLabel jl=new JLabel("enter the start Date");
          JTextField jt=new JTextField("");
          JLabel jl2=new JLabel("enter the End Date");
          JTextField jt2=new JTextField("");
          JTextField jt3=new JTextField();
          JButton jb=new JButton("SUBMIT");
          jf.add(jl);
          jf.add(jt);
          jf.add(jl2);
          jf.add(jt2);
          jf.add(jt3);
          jf.add(jb);
          jb.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    try{
                    LocalDate startDate=LocalDate.parse(jt.getText());
                    LocalDate endDate=LocalDate.parse(jt2.getText());
                    Connection con=Database.getConnection();
                    ResultSet val = Managementdb.reportExpense(startDate,endDate,con);
                    StringBuilder result = new StringBuilder();
                    while(val.next()){
                        String category=val.getString("category");
                        int amount = val.getInt("total");
                        result.append(category);
                        result.append(":₹");
                        result.append(amount);
                        result.append("\n");
                    }
                    jt3.setText(result.toString());
                }
                    catch(SQLException ex){
                        JOptionPane.showMessageDialog(jf, e);  
                    }
                
          }                 
            });
        jf.setVisible(true);
    }   
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
        JButton jb3=new JButton("TOTAL REPORT");
        jf.add(jl);
        jf.add(ctext);
        jf.add(jl2);
        jf.add(atext);
        jf.add(jb);
        jf.add(jb2);
        jf.add(jb3);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String cateogry=ctext.getText();
                int amount=Integer.parseInt(atext.getText());
                try{
                    Managementdb.addExpense(cateogry, amount, LocalDate.now());
                    JOptionPane.showMessageDialog(jf, "Expense added successfully!");
                }
                catch(SQLException ex){
                     JOptionPane.showMessageDialog(jf, ex);   
                }

            }
        });
        jb2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ctext.setText("");
                atext.setText("");
            }
        });
        jb3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                  try {
                    newframe();
                  } catch (SQLException e1) {
                    e1.printStackTrace();
                  }

            }
        });
    }

}
