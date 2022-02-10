package DAO;

import connection.MyConnection;
import model.Chi_tiet_dv;
import model.Phu_kien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QuanLyDAO {
    private static final MyConnection myConnection = new MyConnection();

    private static final String INSERT_PHU_KIEN = "INSERT INTO phu_kien VALUE(?, ?,?,?,?,?,?);";
    private static final String INSERT_DICH_VU = "INSERT INTO chi_tiet_dv VALUE(?,?,?,?,?,?,?);";


    public void them_phu_kien(Phu_kien phu_kien) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PHU_KIEN);
            preparedStatement.setString(1, phu_kien.getPk_id());
            preparedStatement.setString(2, phu_kien.getPk_ten());
            preparedStatement.setString(3, phu_kien.getPk_anh());
            preparedStatement.setInt(4, phu_kien.getPk_gia());
            preparedStatement.setInt(5, phu_kien.getPk_so_luong());
            preparedStatement.setString(6, phu_kien.getPk_mo_ta());
            preparedStatement.setString(7, phu_kien.getPk_lpk_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void them_dich_vu(Chi_tiet_dv chi_tiet_dv) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DICH_VU);
            preparedStatement.setString(1,chi_tiet_dv.getCtdv_id());
            preparedStatement.setString(2,chi_tiet_dv.getCtdv_anh());
            preparedStatement.setString(3,chi_tiet_dv.getCtdv_ten());
            preparedStatement.setInt(4,chi_tiet_dv.getCtdv_gia());
            preparedStatement.setString(5,chi_tiet_dv.getCtdv_mo_ta());
            preparedStatement.setInt(6,chi_tiet_dv.getCtdv_trang_thai());
            preparedStatement.setString(7,chi_tiet_dv.getCtdv_dv_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
