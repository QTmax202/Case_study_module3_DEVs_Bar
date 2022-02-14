package DAO;

import connection.MyConnection;
import model.Nhan_vien;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class NhanVienDAO {
    private static final MyConnection myConnection = new MyConnection();
    private static final String INSERT_NHAN_VIEN_SQL = "insert into nhan_vien(nv_id, nv_anh, nv_ten, nv_gioi_tinh, nv_email, nv_phone_number, nv_ngay_sinh, nv_dia_chi, nv_ca_id) value(?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_ALL_NHAN_VIEN = "select * from nhan_vien;";
    private static final String UPDATE_NHAN_VIEN_SQL = "update nhan_vien set nv_anh= ?,nv_ten= ?, nv_gioi_tinh=?, nv_email=?, nv_phone_number=?, nv_ngay_sinh=?, nv_dia_chi=?, nv_ca_id=?  where nv_id = ?;";

//    public void insertNhanVien(Nhan_vien nhanVien) throws SQLException {
//        System.out.println(INSERT_NHAN_VIEN_SQL);
//
//        try (Connection connection = myConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NHAN_VIEN_SQL)) {
//            preparedStatement.setString(1, nhanVien.getNv_id());
//            preparedStatement.setString(2, nhanVien.getNv_anh());
//            preparedStatement.setString(3, nhanVien.getNv_ten());
//            preparedStatement.setString(4, nhanVien.getNv_gioi_tinh());
//            preparedStatement.setString(5, nhanVien.getNv_email());
//            preparedStatement.setString(6, nhanVien.getNv_phone_number());
//            preparedStatement.setDate(7, (Date) nhanVien.getNv_ngay_sinh());
//            preparedStatement.setString(8, nhanVien.getNv_dia_chi());
//            preparedStatement.setString(9, nhanVien.getNv_ca_id());
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//    }

    public ArrayList<Nhan_vien> selectAllNhanViens() {
        ArrayList<Nhan_vien> nhanViens = new ArrayList<>();
        try (Connection connection = myConnection.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NHAN_VIEN);) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nv_id = rs.getString("nv_id");
                String nv_anh = rs.getString("nv_anh");
                String nv_ten = rs.getString("nv_ten");
                String nv_gioi_tinh = rs.getString("nv_gioi_tinh");
                String nv_email = rs.getString("nv_email");
                String nv_phone_number = rs.getString("nv_phone_number");
                LocalDate nv_ngay_sinh = LocalDate.parse(String.valueOf(rs.getDate("nv_ngay_sinh")), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String nv_dia_chi = rs.getString("nv_dia_chi");
                String nv_ca_id = rs.getString("nv_ca_id");
                nhanViens.add(new Nhan_vien(nv_id, nv_anh, nv_ten, nv_gioi_tinh, nv_email, nv_phone_number, nv_ngay_sinh, nv_dia_chi, nv_ca_id));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return nhanViens;
    }

//    public boolean updateNhanVien(Nhan_vien nhanVien) throws SQLException {
//        boolean rowUpdated;
//        try (Connection connection = myConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_NHAN_VIEN_SQL);) {
//            statement.setString(1, nhanVien.getNv_id());
//            statement.setString(2, nhanVien.getNv_anh());
//            statement.setString(3, nhanVien.getNv_ten());
//            statement.setString(4, nhanVien.getNv_gioi_tinh());
//            statement.setString(5, nhanVien.getNv_email());
//            statement.setString(6, nhanVien.getNv_phone_number());
//            statement.setDate(7, (Date) nhanVien.getNv_ngay_sinh());
//            statement.setString(8,  nhanVien.getNv_dia_chi());
//            statement.setString(9,  nhanVien.getNv_ca_id());
//
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;
//    }
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
