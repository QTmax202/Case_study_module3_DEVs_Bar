package DAO;

import connection.MyConnection;
import model.Account;
import model.Khach_hang;

import java.sql.*;

public class KhachHangDAO {
    private static final MyConnection myConnection = new MyConnection();

    private static final String INSERT_KHACH_HANG = "INSERT INTO khach_hang (`kh_ten`, `kh_gioi_tinh`, `kh_phone_number`, `kh_dia_chi`) VALUES (?,?,?,?);";
    private static final String INSERT_ACC_KHACH_HANG = "INSERT INTO `casemd3`.`account` (`acc_username`, `acc_password`, `acc_phan_cap`, `acc_kh_id`) VALUES (?,?,?,?);";
    private static final String SELECT_KHACH_HANG_TOP = "SELECT * FROM khach_hang WHERE kh_id = (SELECT max(kh_id) from khach_hang);";
    private static final String SELECT_KHACH_HANG_BY_ID = "SELECT * FROM khach_hang WHERE kh_id = ?;";


    public void them_khach_hang(Khach_hang khach_hang) throws SQLException {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_KHACH_HANG);
            preparedStatement.setString(1, khach_hang.getKh_ten());
            preparedStatement.setString(2, khach_hang.getKh_gioi_tinh());
            preparedStatement.setString(3, khach_hang.getKh_phone_number());
            preparedStatement.setString(4, khach_hang.getKh_dia_chi());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Khach_hang tim_khach_hang() {
        Khach_hang khach_hang = null;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_KHACH_HANG_TOP);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String kh_id = resultSet.getString(1);
                String kh_ten = resultSet.getString(3);
                String kh_gioi_tinh = resultSet.getString(4);
                String kh_phone_number = resultSet.getString(6);
                String kh_dia_chi = resultSet.getString(8);
                khach_hang = new Khach_hang(kh_id, kh_ten, kh_gioi_tinh, kh_phone_number, kh_dia_chi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khach_hang;
    }

    public void them_acc_khach_hang(Account account) throws SQLException {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACC_KHACH_HANG);
            preparedStatement.setString(1, account.getAcc_username());
            preparedStatement.setString(2, account.getAcc_password());
            preparedStatement.setString(3, account.getAcc_phan_cap());
            preparedStatement.setInt(4, account.getAcc_kh_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Account kiem_tra_acc_khach_hang(String account) throws SQLException {
        Account account1 = null;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE acc_username LIKE ?");
            preparedStatement.setString(1, account);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String acc_username = resultSet.getString(2);
                String acc_password = resultSet.getString(3);
                String acc_phan_cap = resultSet.getString(4);
                int acc_kh_id = resultSet.getInt(5);
                account1 = new Account(acc_username, acc_password, acc_phan_cap, acc_kh_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return account1;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
