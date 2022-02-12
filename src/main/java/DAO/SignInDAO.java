package DAO;

import connection.MyConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignInDAO {
    private static MyConnection myConnection = new MyConnection();

    public Account signIn(String acc_username, String acc_password) {
        String query = "select * from account where acc_username = ? and acc_password = ?";
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, acc_username);
            ps.setString(2, acc_password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}