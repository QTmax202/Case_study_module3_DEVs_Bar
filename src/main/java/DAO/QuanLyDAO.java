package DAO;

import connection.MyConnection;
import model.Chi_tiet_dv;
import model.Pet_shop;
import model.Phu_kien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QuanLyDAO {
    private static final MyConnection myConnection = new MyConnection();

    private static final String INSERT_PHU_KIEN = "INSERT INTO phu_kien VALUE(?, ?,?,?,?,?,?);";
    private static final String INSERT_DICH_VU = "INSERT INTO chi_tiet_dv VALUE(?,?,?,?,?,?,?);";
    private static final String INSERT_THU_CUNG = "INSERT INTO pet_shop VALUE(?,?,?,?,?,?,?,?);";
    private static final String SELECT_THU_CUNG_BY_ID = "SELECT * FROM pet_shop WHERE ps_id = ?;";
    private static final String UPDATE_THU_CUNG = "UPDATE pet_shop SET ps_ten = ?, ps_anh = ?, ps_gia = ?, ps_ngay_sinh = ?, ps_mota = ?, ps_trang_thai = ?, ps_gp_id = ? WHERE ps_id = ?";
    private static final String SELECT_PHU_KIEN_BY_ID = "SELECT * FROM phu_kien WHERE pk_id = ?;";
    private static final String UPDATE_PHU_KIEN = "UPDATE phu_kien SET pk_ten = ?, pk_anh = ?, pk_gia = ?, pk_so_luong = ?, pk_mo_ta = ?, pk_lpk_id = ?  WHERE pk_id = ?;";
    private static final String SELECT_DICH_VU_BY_ID = "SELECT * FROM chi_tiet_dv WHERE ctdv_id = ?;";
    private static final String UPDATE_DICH_VU = "UPDATE chi_tiet_dv SET ctdv_anh = ?, ctdv_ten = ?, ctdv_gia = ?, ctdv_mo_ta = ?, ctdv_trang_thai = ?, ctdv_dv_id = ? WHERE ctdv_id = ?;";
    private static final String DELETE_THU_CUNG_BY_ID = "DELETE FROM pet_shop WHERE ps_id = ?;";
    private static final String DELETE_PHU_KIEN_BY_ID = "DELETE FROM phu_kien WHERE pk_id = ?;";
    private static final String DELETE_DICH_VU_BY_ID = "DELETE FROM chi_tiet_dv WHERE ctdv_id = ?;";

    public void them_thu_cung(Pet_shop petShop) {
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_THU_CUNG);
            preparedStatement.setInt(1, petShop.getPs_id());
            preparedStatement.setString(2, petShop.getPs_ten());
            preparedStatement.setString(3, petShop.getPs_anh());
            preparedStatement.setInt(4, petShop.getPs_gia());
            preparedStatement.setDate(5, java.sql.Date.valueOf(petShop.getPs_ngay_sinh()));
            preparedStatement.setString(6, petShop.getPs_mo_ta());
            preparedStatement.setInt(7, petShop.getPs_trang_thai());
            preparedStatement.setString(8, petShop.getPs_gp_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    public Pet_shop tim_thu_cung(String id) {
        Pet_shop pet_shop = null;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THU_CUNG_BY_ID);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ps_id = resultSet.getInt(1);
                String ps_ten = resultSet.getString(2);
                String ps_anh = resultSet.getString(3);
                int ps_gia = resultSet.getInt(4);
                LocalDate ps_ngay_sinh = LocalDate.parse(String.valueOf(resultSet.getDate(5)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String ps_mo_ta = resultSet.getString(6);
                int ps_trang_thai = resultSet.getInt(7);
                String ps_gp_id = resultSet.getString(8);
                pet_shop = new Pet_shop(ps_id, ps_ten, ps_anh, ps_gia, ps_ngay_sinh, ps_mo_ta, ps_trang_thai, ps_gp_id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet_shop;
    }

    public boolean sua_thu_cung(Pet_shop pet_shop) {
        boolean rowUpdated = false;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_THU_CUNG);
            preparedStatement.setInt(8, pet_shop.getPs_id());
            preparedStatement.setString(1, pet_shop.getPs_ten());
            preparedStatement.setString(2, pet_shop.getPs_anh());
            preparedStatement.setInt(3, pet_shop.getPs_gia());
            preparedStatement.setDate(4, java.sql.Date.valueOf(pet_shop.getPs_ngay_sinh()));
            preparedStatement.setString(5, pet_shop.getPs_mo_ta());
            preparedStatement.setInt(6, pet_shop.getPs_trang_thai());
            preparedStatement.setString(7, pet_shop.getPs_gp_id());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowUpdated;
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

    public boolean xoa_thu_cung(String id) {
        boolean rowDeleted = false;
        try (Connection connection = myConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_THU_CUNG_BY_ID);) {
            preparedStatement.setString(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
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
