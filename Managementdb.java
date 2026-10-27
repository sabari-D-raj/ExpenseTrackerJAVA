import java.sql.*;
import java.time.LocalDate;
public class Managementdb {
    public static void addExpense(  String category, int amount, LocalDate date) throws SQLException{
        Connection con=Database.getConnection();
        PreparedStatement ps= con.prepareStatement("INSERT INTO Expense(category,expense,date) VALUES(?,?,?)");
        ps.setString(1, category);
        ps.setInt(2, amount);
        ps.setDate(3, java.sql.Date.valueOf(date));
        ps.executeUpdate();
    
    }
    public static ResultSet reportExpense(LocalDate start,LocalDate end,Connection con) throws SQLException{
            PreparedStatement ps= con.prepareStatement("SELECT category,SUM(expense) AS total FROM Expense WHERE `date`>=? AND `date`<=? GROUP BY category ORDER BY total DESC ");
            ps.setDate(1, java.sql.Date.valueOf(start));
            ps.setDate(2,java.sql.Date.valueOf(end));
            return ps.executeQuery();
    }
}
