import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dB {
    private static final String URL = "jdbc:mysql://localhost:3306/library_db";
    private static final String USER= "root";
    private static final String pw= "123321";
    public static Connection getConnetion() throws SQLException {
        return DriverManager.getConnection(URL, USER, pw);
    }
}
