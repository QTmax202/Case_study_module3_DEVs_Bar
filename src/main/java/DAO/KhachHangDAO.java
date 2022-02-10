package DAO;

import model.Khach_hang;


import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;

public class KhachHangDAO {
    private static final String INSERT_KHACH_HANG_SQL = "insert into khach_hang(kh_anh, kh_ten, kh_gioi_tinh, kh_email, kh_phone_number, kh_ngay_sinh, kh_dia_chi) value(?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_KHACH_HANG = "select * from khach_hang;";
    private static final String UPDATE_KHACH_HANG_SQL = "update khach_hang set kh_anh= ?,kh_ten= ?, kh_gioi_tinh=?, kh_email=?, kh_phone_number=?, kh_ngay_sinh=?, kh_dia_chi=?  where kh_id = ?;";
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quan_ly_pet_shop?useSSL=false", "root", "12345678");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public ArrayList<Khach_hang> selectAllKhachHangs() {
        return null;
    }

    public void insertKhachHang(Khach_hang kh) throws SQLException {
        System.out.println(INSERT_KHACH_HANG_SQL);

        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_KHACH_HANG_SQL)) {
//            preparedStatement.setString(1, kh.getKh_id());
            preparedStatement.setString(1, kh.getKh_anh());
            preparedStatement.setString(2, kh.getKh_ten());
            preparedStatement.setString(3, kh.getKh_gioi_tinh());
            preparedStatement.setString(4, kh.getKh_email());
            preparedStatement.setString(5, kh.getKh_phone_number());
            preparedStatement.setDate(6, java.sql.Date.valueOf(kh.getKh_ngay_sinh()));
            preparedStatement.setString(7, kh.getKh_dia_chi());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    public ArrayList<Khach_hang> selectAllKhachHang(){

        ArrayList<Khach_hang> khachHangs = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_KHACH_HANG);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String kh_id = rs.getString("kh_id");
                String kh_anh = rs.getString("kh_anh");
                String kh_ten = rs.getString("kh_ten");
                String kh_gioi_tinh = rs.getString("kh_gioi_tinh");
                String kh_email = rs.getString("kh_email");
                String kh_phone_number = rs.getString("kh_phone_number");
                LocalDate kh_ngay_sinh = rs.getDate("kh_ngay_sinh").toLocalDate();
                String kh_dia_chi = rs.getString("kh_dia_chi");
                khachHangs.add(new Khach_hang(kh_id, kh_anh, kh_ten, kh_gioi_tinh, kh_email, kh_phone_number, kh_ngay_sinh, kh_dia_chi));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return khachHangs;
    }

    public boolean updateKhachHang(Khach_hang kh) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_KHACH_HANG_SQL);) {

            statement.setString(1, kh.getKh_anh());
            statement.setString(2, kh.getKh_ten());
            statement.setString(3, kh.getKh_gioi_tinh());
            statement.setString(4, kh.getKh_email());
            statement.setString(5, kh.getKh_phone_number());
            statement.setDate(6, java.sql.Date.valueOf(kh.getKh_ngay_sinh()));
            statement.setString(7,  kh.getKh_dia_chi());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
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
