package DAO;

import connection.MyConnection;
import model.Chi_tiet_dv;
import model.Giong_pet;
import model.Pet_shop;
import model.Phu_kien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopDAO {
    private static final MyConnection myConnection = new MyConnection();

    private static final String SELECT_ALL_PET = "SELECT * FROM pet_shop";
    private static final String SELECT_ALL_GIONG_PET = "SELECT * FROM giong_pet;";
    private static final String SELECT_ALL_DICH_VU = "SELECT ctdv_id, ctdv_anh, ctdv_ten, ctdv_gia, dich_vu.dv_id, ctdv_trang_thai, dich_vu.dv_ten\n" +
            "FROM chi_tiet_dv\n" +
            "JOIN dich_vu ON chi_tiet_dv.ctdv_dv_id = dich_vu.dv_id\n" +
            "GROUP by dich_vu.dv_ten";
    private static final String SELECT_ALL_PHU_KIEN = "SELECT pk_id, pk_ten, pk_anh, pk_gia, pk_so_luong, loai_phu_kien.lpk_id, loai_phu_kien.lpk_ten\n" +
            "FROM phu_kien\n" +
            "JOIN loai_phu_kien ON phu_kien.pk_lpk_id = loai_phu_kien.lpk_id\n" +
            "GROUP BY loai_phu_kien.lpk_ten;";
    private static final String SELECT_PET_BY_ID = "SELECT * FROM pet_shop\n" +
            "WHERE ps_gp_id LIKE ?;";
    private static final String SELECT_PHU_KIEN_BY_ID = "SELECT pk_id, pk_ten, pk_anh, pk_gia, pk_so_luong, loai_phu_kien.lpk_id, loai_phu_kien.lpk_ten\n" +
            "FROM phu_kien\n" +
            "JOIN loai_phu_kien ON phu_kien.pk_lpk_id = loai_phu_kien.lpk_id\n" +
            "WHERE loai_phu_kien.lpk_id LIKE ?;";
    private static final String SELECT_DICH_VU_BY_ID = "SELECT * FROM chi_tiet_dv\n" +
            "WHERE ctdv_dv_id LIKE ?;";


    public List<Giong_pet> giongPet() {
        List<Giong_pet> giong_pets = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GIONG_PET);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String gp_id = resultSet.getString(1);
                String gp_ten = resultSet.getString(2);
                String gp_mo_ta = resultSet.getString(3);
                String gp_lp_id = resultSet.getString(4);
                giong_pets.add(new Giong_pet(gp_id, gp_ten, gp_mo_ta, gp_lp_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giong_pets;
    }


    public List<Pet_shop> petShopById(String petShop_id) {
        List<Pet_shop> pet_shops = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PET_BY_ID);
            preparedStatement.setString(1, petShop_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ps_id = Integer.parseInt(resultSet.getString(1));
                String ps_ten = resultSet.getString(2);
                String ps_anh = resultSet.getString(3);
                int ps_gia = Integer.parseInt(resultSet.getString(4));
                LocalDate ps_ngay_sinh = LocalDate.parse(String.valueOf(resultSet.getDate(5)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String ps_mo_ta = resultSet.getString(6);
                int ps_trang_thai = Integer.parseInt(resultSet.getString(7));
                String ps_gp_id = resultSet.getString(8);
                pet_shops.add(new Pet_shop(ps_id, ps_ten, ps_anh, ps_gia, ps_ngay_sinh, ps_mo_ta, ps_trang_thai, ps_gp_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet_shops;
    }

    public List<Pet_shop> petShop() {
        List<Pet_shop> pet_shops = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PET);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ps_id = Integer.parseInt(resultSet.getString(1));
                String ps_ten = resultSet.getString(2);
                String ps_anh = resultSet.getString(3);
                int ps_gia = Integer.parseInt(resultSet.getString(4));
                LocalDate ps_ngay_sinh = LocalDate.parse(String.valueOf(resultSet.getDate(5)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String ps_mo_ta = resultSet.getString(6);
                int ps_trang_thai = Integer.parseInt(resultSet.getString(7));
                String ps_gp_id = resultSet.getString(8);
                pet_shops.add(new Pet_shop(ps_id, ps_ten, ps_anh, ps_gia, ps_ngay_sinh, ps_mo_ta, ps_trang_thai, ps_gp_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet_shops;
    }

    public List<Phu_kien> phu_kien() {
        List<Phu_kien> phu_kiens = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM phu_kien");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String pk_id = resultSet.getString(1);
                String pk_ten = resultSet.getString(2);
                String pk_anh = resultSet.getString(3);
                int pk_gia = Integer.parseInt(resultSet.getString(4));
                int pk_so_luong = Integer.parseInt(resultSet.getString(5));
                String pk_mo_ta = resultSet.getString(6);
                String pk_lpk_id = resultSet.getString(7);
                phu_kiens.add(new Phu_kien(pk_id, pk_ten, pk_anh, pk_gia, pk_so_luong, pk_mo_ta, pk_lpk_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phu_kiens;
    }

    public List<Chi_tiet_dv> dich_vu() {
        List<Chi_tiet_dv> chi_tiet_dvs = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM chi_tiet_dv");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ctdv_id = resultSet.getString(1);
                String ctdv_anh = resultSet.getString(2);
                String ctdv_ten = resultSet.getString(3);
                int ctdv_gia = resultSet.getInt(4);
                String ctdv_mo_ta = resultSet.getString(5);
                int ctdv_trang_thai = resultSet.getInt(6);
                String ctdv_dv_id = resultSet.getString(7);
                chi_tiet_dvs.add(new Chi_tiet_dv(ctdv_id, ctdv_anh, ctdv_ten, ctdv_gia, ctdv_mo_ta, ctdv_trang_thai, ctdv_dv_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chi_tiet_dvs;
    }


    public List<Phu_kien> loaiPhuKien() {
        List<Phu_kien> phu_kiens = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PHU_KIEN);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String pk_id = resultSet.getString(1);
                String pk_ten = resultSet.getString(2);
                String pk_anh = resultSet.getString(3);
                int pk_gia = Integer.parseInt(resultSet.getString(4));
                int pk_so_luong = Integer.parseInt(resultSet.getString(5));
                String pk_mo_ta = resultSet.getString(6);
                String pk_lpk_id = resultSet.getString(7);
                phu_kiens.add(new Phu_kien(pk_id, pk_ten, pk_anh, pk_gia, pk_so_luong, pk_mo_ta, pk_lpk_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phu_kiens;
    }

    public List<Phu_kien> phu_kien_theo_id(String phu_kien_id) {
        List<Phu_kien> phu_kiens = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PHU_KIEN_BY_ID);
            preparedStatement.setString(1, phu_kien_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String pk_id = resultSet.getString(1);
                String pk_ten = resultSet.getString(2);
                String pk_anh = resultSet.getString(3);
                int pk_gia = resultSet.getInt(4);
                int pk_so_luong = resultSet.getInt(5);
                String pk_mo_ta = resultSet.getString(6);
                String pk_lpk_id = resultSet.getString(7);
                phu_kiens.add(new Phu_kien(pk_id, pk_ten, pk_anh, pk_gia, pk_so_luong, pk_mo_ta, pk_lpk_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phu_kiens;
    }

    public List<Chi_tiet_dv> loaiDichVu() {
        List<Chi_tiet_dv> chi_tiet_dvs = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DICH_VU);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ctdv_id = resultSet.getString(1);
                String ctdv_anh = resultSet.getString(2);
                String ctdv_ten = resultSet.getString(3);
                int ctdv_gia = Integer.parseInt(resultSet.getString(4));
                String ctdv_mo_ta = resultSet.getString(5);
                int ctdv_trang_thai = Integer.parseInt(resultSet.getString(6));
                String ctdv_dv_id = resultSet.getString(7);
                chi_tiet_dvs.add(new Chi_tiet_dv(ctdv_id, ctdv_anh, ctdv_ten, ctdv_gia, ctdv_mo_ta, ctdv_trang_thai, ctdv_dv_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chi_tiet_dvs;
    }

    public List<Chi_tiet_dv> dich_vu_theo_id(String dich_vu_id) {
        List<Chi_tiet_dv> chi_tiet_dvs = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DICH_VU_BY_ID);
            preparedStatement.setString(1, dich_vu_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ctdv_id = resultSet.getString(1);
                String ctdv_anh = resultSet.getString(2);
                String ctdv_ten = resultSet.getString(3);
                int ctdv_gia = resultSet.getInt(4);
                String ctdv_mo_ta = resultSet.getString(5);
                int ctdv_trang_thai = resultSet.getInt(6);
                String ctdv_dv_id = resultSet.getString(7);
                chi_tiet_dvs.add(new Chi_tiet_dv(ctdv_id, ctdv_anh, ctdv_ten, ctdv_gia, ctdv_mo_ta, ctdv_trang_thai, ctdv_dv_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chi_tiet_dvs;
    }

    public List<Pet_shop> pet_tang(String petShop_id) {
        List<Pet_shop> pet_shops = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pet_shop\n" +
                    "WHERE ps_gp_id LIKE ?\n" +
                    "ORDER BY ps_gia;");
            preparedStatement.setString(1, petShop_id);
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
                pet_shops.add(new Pet_shop(ps_id, ps_ten, ps_anh, ps_gia, ps_ngay_sinh, ps_mo_ta, ps_trang_thai, ps_gp_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet_shops;
    }

    public List<Pet_shop> tim_thu_cung(String name) {
        List<Pet_shop> pet_shops = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM pet_shop WHERE ps_ten LIKE N?;");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int ps_id = Integer.parseInt(resultSet.getString(1));
                String ps_ten = resultSet.getString(2);
                String ps_anh = resultSet.getString(3);
                int ps_gia = Integer.parseInt(resultSet.getString(4));
                LocalDate ps_ngay_sinh = LocalDate.parse(String.valueOf(resultSet.getDate(5)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String ps_mo_ta = resultSet.getString(6);
                int ps_trang_thai = Integer.parseInt(resultSet.getString(7));
                String ps_gp_id = resultSet.getString(8);
                pet_shops.add(new Pet_shop(ps_id, ps_ten, ps_anh, ps_gia, ps_ngay_sinh, ps_mo_ta, ps_trang_thai, ps_gp_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pet_shops;
    }

    public List<Phu_kien> tim_phu_kien(String name) {
        List<Phu_kien> phu_kiens = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM phu_kien WHERE pk_ten LIKE N?;");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String pk_id = resultSet.getString(1);
                String pk_ten = resultSet.getString(2);
                String pk_anh = resultSet.getString(3);
                int pk_gia = Integer.parseInt(resultSet.getString(4));
                int pk_so_luong = Integer.parseInt(resultSet.getString(5));
                String pk_mo_ta = resultSet.getString(6);
                String pk_lpk_id = resultSet.getString(7);
                phu_kiens.add(new Phu_kien(pk_id, pk_ten, pk_anh, pk_gia, pk_so_luong, pk_mo_ta, pk_lpk_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phu_kiens;
    }

    public List<Chi_tiet_dv> tim_dich_vu(String name) {
        List<Chi_tiet_dv> chi_tiet_dvs = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM chi_tiet_dv WHERE ctdv_ten LIKE N?;");
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ctdv_id = resultSet.getString(1);
                String ctdv_anh = resultSet.getString(2);
                String ctdv_ten = resultSet.getString(3);
                int ctdv_gia = resultSet.getInt(4);
                String ctdv_mo_ta = resultSet.getString(5);
                int ctdv_trang_thai = resultSet.getInt(6);
                String ctdv_dv_id = resultSet.getString(7);
                chi_tiet_dvs.add(new Chi_tiet_dv(ctdv_id, ctdv_anh, ctdv_ten, ctdv_gia, ctdv_mo_ta, ctdv_trang_thai, ctdv_dv_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chi_tiet_dvs;
    }
}
