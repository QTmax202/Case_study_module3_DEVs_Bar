package DAO;

import connection.MyConnection;
import model.Account;
import model.Khach_hang;
import model.Nhan_vien;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class KhachHangDAO {
    private static final MyConnection myConnection = new MyConnection();

    private static final String INSERT_KHACH_HANG = "INSERT INTO khach_hang (`kh_ten`, `kh_gioi_tinh`, `kh_phone_number`, `kh_dia_chi`) VALUES (?,?,?,?);";
    private static final String INSERT_ACC_KHACH_HANG = "INSERT INTO `casemd3`.`account` (`acc_username`, `acc_password`, `acc_phan_cap`, `acc_kh_id`) VALUES (?,?,?,?);";
    private static final String INSERT_ACC_NHAN_VIEN = "INSERT INTO `casemd3`.`account` (`acc_username`, `acc_password`, `acc_phan_cap`, `acc_nv_id`) VALUES (?,?,?,?);";
    private static final String SELECT_KHACH_HANG_TOP = "SELECT * FROM khach_hang WHERE kh_id = (SELECT max(kh_id) from khach_hang);";
    private static final String INSERT_NHAN_VIEN = "INSERT INTO nhan_vien (`nv_id`, `nv_ten`, `nv_gioi_tinh`, `nv_email`, `nv_phone_number`, `nv_ngay_sinh`, `nv_dia_chi`, `nv_ca_id`) VALUES (?,?,?,?,?,?,?,?);";
    private static final String SELECT_NHAN_VIEN_BY_ID = "SELECT * FROM nhan_vien WHERE nv_id LIKE ?;";
    private static final String SELECT_ACC_NHAN_VIEN = "SELECT * FROM account WHERE acc_nv_id LIKE ?;";
    private static final String UPDATE_NHAN_VIEN = "UPDATE nhan_vien SET nv_ten = ?, nv_gioi_tinh = ?, nv_email = ?, nv_phone_number = ?, nv_ngay_sinh = ?, nv_dia_chi = ?, nv_ca_id = ? WHERE nv_id = ?;";
    private static final String UPDATE_ACC_NHAN_VIEN = "UPDATE account SET acc_password = ? WHERE acc_nv_id = ?;";
    private static final String SELECT_KHACH_HANG_BY_ID = "SELECT * FROM khach_hang WHERE kh_id LIKE ?;";
    private static final String SELECT_ACC_KHACH_HANG = "SELECT * FROM account WHERE acc_kh_id LIKE ?;";
    private static final String UPDATE_KHACH_HANG = "UPDATE khach_hang SET kh_ten = ?, kh_gioi_tinh = ?, kh_phone_number = ?, kh_dia_chi = ? WHERE kh_id = ?;";
    private static final String UPDATE_ACC_KHACH_HANG = "UPDATE account SET acc_password = ? WHERE acc_kh_id = ?";

    public Nhan_vien tim_nhan_vien(String id) {
        Nhan_vien nhan_vien = null;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_NHAN_VIEN_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nv_id = resultSet.getString(1);
                String nv_ten = resultSet.getString(3);
                String nv_gioi_tinh = resultSet.getString(4);
                String nv_email = resultSet.getString(5);
                String nv_phone_number = resultSet.getString(6);
                LocalDate nv_ngay_sinh = LocalDate.parse(String.valueOf(resultSet.getDate(7)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String nv_dia_chi = resultSet.getString(8);
                String nv_ca_id = resultSet.getString(9);
                nhan_vien = new Nhan_vien(nv_id, nv_ten, nv_gioi_tinh, nv_email, nv_phone_number, nv_ngay_sinh, nv_dia_chi, nv_ca_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhan_vien;
    }

    public Khach_hang tim_khach_hang(String id) {
        Khach_hang khach_hang = null;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_KHACH_HANG_BY_ID);
            preparedStatement.setString(1, id);
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

    public Account tim_acc_nhan_vien(String id) {
        Account account = null;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACC_NHAN_VIEN);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String acc_username = resultSet.getString(2);
                String acc_password = resultSet.getString(3);
                String acc_phan_cap = resultSet.getString(4);
                String acc_nv_id = resultSet.getString(6);
                account = new Account(acc_username, acc_password, acc_phan_cap, acc_nv_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public Account tim_acc_khach_hang(String id) {
        Account account = null;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACC_KHACH_HANG);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String acc_username = resultSet.getString(2);
                String acc_password = resultSet.getString(3);
                String acc_phan_cap = resultSet.getString(4);
                int acc_kh_id = Integer.parseInt(resultSet.getString(5));
                account = new Account(acc_username, acc_password, acc_phan_cap, acc_kh_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    public boolean sua_nhan_vien(Nhan_vien nhan_vien) throws SQLException {
        boolean rowUpdated = false;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NHAN_VIEN);
            preparedStatement.setString(8, nhan_vien.getNv_id());
            preparedStatement.setString(1, nhan_vien.getNv_ten());
            preparedStatement.setString(2, nhan_vien.getNv_gioi_tinh());
            preparedStatement.setString(3, nhan_vien.getNv_email());
            preparedStatement.setString(4, nhan_vien.getNv_phone_number());
            preparedStatement.setDate(5, java.sql.Date.valueOf(nhan_vien.getNv_ngay_sinh()));
            preparedStatement.setString(6, nhan_vien.getNv_dia_chi());
            preparedStatement.setString(7, nhan_vien.getNv_ca_id());
            System.out.println(preparedStatement);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    public boolean sua_khach_hang(Khach_hang khach_hang) throws SQLException {
        boolean rowUpdated = false;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_KHACH_HANG);
            preparedStatement.setString(5, khach_hang.getKh_id());
            preparedStatement.setString(1, khach_hang.getKh_ten());
            preparedStatement.setString(2, khach_hang.getKh_gioi_tinh());
            preparedStatement.setString(3, khach_hang.getKh_phone_number());
            preparedStatement.setString(4, khach_hang.getKh_dia_chi());
            System.out.println(preparedStatement);
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    public boolean sua_acc_nhan_vien(Account account) throws SQLException {
        boolean rowUpdated = false;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACC_NHAN_VIEN);
            preparedStatement.setString(1, account.getAcc_password());
            preparedStatement.setString(2, account.getAcc_nv_id());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    public boolean sua_acc_khach_hang(Account account) throws SQLException {
        boolean rowUpdated = false;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACC_KHACH_HANG);
            preparedStatement.setString(1, account.getAcc_password());
            preparedStatement.setInt(2, account.getAcc_kh_id());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

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

    public void them_nhan_vien(Nhan_vien nhan_vien) throws SQLException {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NHAN_VIEN);
            preparedStatement.setString(1, nhan_vien.getNv_id());
            preparedStatement.setString(2, nhan_vien.getNv_ten());
            preparedStatement.setString(3, nhan_vien.getNv_gioi_tinh());
            preparedStatement.setString(4, nhan_vien.getNv_email());
            preparedStatement.setString(5, nhan_vien.getNv_phone_number());
            preparedStatement.setDate(6, java.sql.Date.valueOf(nhan_vien.getNv_ngay_sinh()));
            preparedStatement.setString(7, nhan_vien.getNv_dia_chi());
            preparedStatement.setString(8, nhan_vien.getNv_ca_id());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Khach_hang tim_khach_hang_moi() {
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

    public void them_acc_nhan_vien(Account account) throws SQLException {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACC_NHAN_VIEN);
            preparedStatement.setString(1, account.getAcc_username());
            preparedStatement.setString(2, account.getAcc_password());
            preparedStatement.setString(3, account.getAcc_phan_cap());
            preparedStatement.setString(4, account.getAcc_nv_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Account kiem_tra_acc_nhan_vien(String account) throws SQLException {
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
                String acc_nv_id = resultSet.getString(6);
                account1 = new Account(acc_username, acc_password, acc_phan_cap, acc_nv_id);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return account1;
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
