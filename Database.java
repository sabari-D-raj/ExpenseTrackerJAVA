import java.sql.*;
public class Database {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/expensetracker",
            "root",
            "#"
        );
    }
public static void main(String[] args) {
        try (Connection con = getConnection()) {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("CREATE TABLE  Expense (id INT PRIMARY KEY,category VARCHAR(50),expense INT ,date DATE)");
            System.out.println("Database connected and table ready.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
