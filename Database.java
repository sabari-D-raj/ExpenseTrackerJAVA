import java.sql.*;
public class Database{
    public static void main(String[] args) {  //i can throws SQLexpections without error handling inseide the main
        try(Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/expensetracker","root","#")){
                    if(con!=null){
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate("CREATE TABLE Expense(id INTEGER PRIMARY KEY ,category VARCHAR(50),expense INTEGER)");
                    }
        }
        catch(SQLException e){
            System.out.println("error"+e);
        }
    }
}