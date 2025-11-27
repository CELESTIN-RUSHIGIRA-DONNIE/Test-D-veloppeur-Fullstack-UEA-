package cd.ac.uea.assessment.legacy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class LegacyPaymentProcessor {

    public void processPayment(Long orderId, Double amount) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/mydb";
            String user = "postgres";
            String password = "secret";

            conn = DriverManager.getConnection(url, user, password);
            
            String sql = "INSERT INTO payments (order_id, amount) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, orderId);
            stmt.setDouble(2, amount);
            
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
