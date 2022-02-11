package DAO;

import connection.MyConnection;
import model.Chi_tiet_dv;
import model.Phu_kien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuanLyDAO {
    private static final MyConnection myConnection = new MyConnection();

    private static final String INSERT_PHU_KIEN = "INSERT INTO phu_kien VALUE(?, ?,?,?,?,?,?);";
    private static final String INSERT_DICH_VU = "INSERT INTO chi_tiet_dv VALUE(?,?,?,?,?,?,?);";
    private static final String SELECT_PHU_KIEN_BY_ID = "SELECT * FROM phu_kien WHERE pk_id = ?;";
    private static final String UPDATE_PHU_KIEN = "UPDATE phu_kien SET pk_ten = ?, pk_anh = ?, pk_gia = ?, pk_so_luong = ?, pk_mo_ta = ?, pk_lpk_id = ?  WHERE pk_id = ?;";
    private static final String SELECT_DICH_VU_BY_ID = "SELECT * FROM chi_tiet_dv WHERE ctdv_id = ?;";
    private static final String UPDATE_DICH_VU = "UPDATE chi_tiet_dv SET ctdv_anh = ?, ctdv_ten = ?, ctdv_gia = ?, ctdv_mo_ta = ?, ctdv_trang_thai = ?, ctdv_dv_id = ? WHERE ctdv_id = ?;";
    private static final String DELETE_PHU_KIEN_BY_ID = "DELETE FROM phu_kien WHERE pk_id = ?;";
    private static final String DELETE_DICH_VU_BY_ID = "DELETE FROM chi_tiet_dv WHERE ctdv_id = ?;";

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
            preparedStatement.setString(1, chi_tiet_dv.getCtdv_id());
            preparedStatement.setString(2, chi_tiet_dv.getCtdv_anh());
            preparedStatement.setString(3, chi_tiet_dv.getCtdv_ten());
            preparedStatement.setInt(4, chi_tiet_dv.getCtdv_gia());
            preparedStatement.setString(5, chi_tiet_dv.getCtdv_mo_ta());
            preparedStatement.setInt(6, chi_tiet_dv.getCtdv_trang_thai());
            preparedStatement.setString(7, chi_tiet_dv.getCtdv_dv_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Phu_kien tim_phu_kien(String id) {
        Phu_kien phu_kien = null;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PHU_KIEN_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String pk_id = resultSet.getString(1);
                String pk_ten = resultSet.getString(2);
                String pk_anh = resultSet.getString(3);
                int pk_gia = resultSet.getInt(4);
                int pk_so_luong = resultSet.getInt(5);
                String pk_mo_ta = resultSet.getString(6);
                String pk_lpk_id = resultSet.getString(7);
                phu_kien = new Phu_kien(pk_id, pk_ten, pk_anh, pk_gia, pk_so_luong, pk_mo_ta, pk_lpk_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phu_kien;
    }

    public boolean sua_phu_kien(Phu_kien phu_kien) {
        boolean rowUpdated = false;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PHU_KIEN);
            preparedStatement.setString(7, phu_kien.getPk_id());
            preparedStatement.setString(1, phu_kien.getPk_ten());
            preparedStatement.setString(2, phu_kien.getPk_anh());
            preparedStatement.setInt(3, phu_kien.getPk_gia());
            preparedStatement.setInt(4, phu_kien.getPk_so_luong());
            preparedStatement.setString(5, phu_kien.getPk_mo_ta());
            preparedStatement.setString(6, phu_kien.getPk_lpk_id());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public Chi_tiet_dv tim_dich_vu(String id) {
        Chi_tiet_dv chi_tiet_dv = null;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DICH_VU_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ctdv_id = resultSet.getString(1);
                String ctdv_anh = resultSet.getString(2);
                String ctdv_ten = resultSet.getString(3);
                int ctdv_gia = resultSet.getInt(4);
                String ctdv_mo_ta = resultSet.getString(5);
                int ctdv_trang_thai = resultSet.getInt(6);
                String ctdv_dv_id = resultSet.getString(7);
                chi_tiet_dv = new Chi_tiet_dv(ctdv_id, ctdv_anh, ctdv_ten, ctdv_gia, ctdv_mo_ta, ctdv_trang_thai, ctdv_dv_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chi_tiet_dv;
    }

    public boolean sua_dich_vu(Chi_tiet_dv chi_tiet_dv) {
        boolean rowUpdated = false;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DICH_VU);
            preparedStatement.setString(7, chi_tiet_dv.getCtdv_id());
            preparedStatement.setString(1, chi_tiet_dv.getCtdv_anh());
            preparedStatement.setString(2, chi_tiet_dv.getCtdv_ten());
            preparedStatement.setInt(3, chi_tiet_dv.getCtdv_gia());
            preparedStatement.setString(4, chi_tiet_dv.getCtdv_mo_ta());
            preparedStatement.setInt(5, chi_tiet_dv.getCtdv_trang_thai());
            preparedStatement.setString(6, chi_tiet_dv.getCtdv_dv_id());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public boolean xoa_phu_kien(String id) {
        boolean rowDeleted = false;
        try (Connection connection = myConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PHU_KIEN_BY_ID);) {
            preparedStatement.setString(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    public boolean xoa_dich_vu(String id) {
        boolean rowDeleted = false;
        try (Connection connection = myConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DICH_VU_BY_ID);) {
            preparedStatement.setString(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
