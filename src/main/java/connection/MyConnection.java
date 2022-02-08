package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    // các tham số để kết nối databases
    private String URL = "jdbc:mysql://localhost:3306/quan_ly_pet_shop?useSSL=false";
    private String userName = "root";
    private String passWord = "M@cb@c202";

    public Connection getConnection() {
        Connection connection = null;
        try {
            // đổi class hiện tại về quản lý như 1 drive
            Class.forName("com.mysql.jdbc.Driver");

            //quản lý connection vs driver manager
            connection = DriverManager.getConnection(URL, userName, passWord);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
