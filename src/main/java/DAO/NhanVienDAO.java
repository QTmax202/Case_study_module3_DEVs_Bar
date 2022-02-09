package DAO;

import connection.MyConnection;
import model.Nhan_vien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NhanVienDAO implements INhanVienDAO {
    private static final MyConnection myConnection = new MyConnection();
    private static final  String SELECT_ALL_NHAN_VIEN = "Select * from nhan_vien;";

    @Override
    public ArrayList<Nhan_vien> getAllNhanVien() {
        List<Nhan_vien> nhanViens = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_NHAN_VIEN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String nv_id = resultSet.getString("nv_id");
                String nv_anh = resultSet.getString("nv_anh");
                String nv_ten = resultSet.getString("nv_ten");
                String nv_gioi_tinh = resultSet.getString("nv_gioi_tinh");
                String nv_email = resultSet.getString("nv_email");
                String nv_phone_number = resultSet.getString("nv_phone_number");
                String nv_ngay_sinh = resultSet.getString("nv_ngay_sinh");
                String nv_dia_chi = resultSet.getString("nv_dia_chi");
                String nv_ca_id = resultSet.getString("nv_ca_id");
                nhanViens.add(new Nhan_vien(nv_id, nv_anh, nv_ten, nv_gioi_tinh, nv_email, nv_phone_number, nv_ngay_sinh, nv_dia_chi, nv_ca_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanViens;
    }
}
