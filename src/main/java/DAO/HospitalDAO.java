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
import java.util.ArrayList;

public class HospitalDAO {
    private static final MyConnection myConnection = new MyConnection();

    public ArrayList<Pet_shop> getLimit8Pet_Shop() {
        ArrayList<Pet_shop> pet_shops = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select ps.ps_id, ps.ps_ten, ps.ps_anh, ps.ps_gia , ps.ps_ngay_sinh, ps.ps_mota,  ps.ps_trang_thai, ps.ps_gp_id from pet_shop ps\n" +
                    "join giong_pet gp on ps.ps_gp_id = gp.gp_id\n" +
                    "where ps.ps_trang_thai != 0\n" +
                    "limit 8;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String anh = resultSet.getString(3);
                int gia = resultSet.getInt(4);
                LocalDate ngay_sinh = LocalDate.parse(String.valueOf(resultSet.getDate(5)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String mo_ta = resultSet.getString(6);
                int trang_thai = resultSet.getInt(7);
                String giong = resultSet.getString(8);
                pet_shops.add(new Pet_shop(id, name, anh, gia, ngay_sinh , mo_ta , trang_thai, giong));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pet_shops;
    }

    public ArrayList<Phu_kien> getLimit8Phu_Kien() {
        ArrayList<Phu_kien> phu_kiens = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select pk.pk_id, pk.pk_ten, pk.pk_anh, pk.pk_gia, pk.pk_so_luong, pk.pk_mo_ta, lpk.lpk_ten from phu_kien pk\n" +
                    "join loai_phu_kien lpk on lpk.lpk_id = pk.pk_lpk_id\n" +
                    "where pk.pk_so_luong != 0\n"+
                    "limit 8;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String anh = resultSet.getString(3);
                int gia = resultSet.getInt(4);
                int so_luong = resultSet.getInt(5);
                String mo_ta = resultSet.getString(6);
                String loai_phu_kien = resultSet.getString(7);
                phu_kiens.add(new Phu_kien(id, name, anh, gia, so_luong , mo_ta , loai_phu_kien));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return phu_kiens;
    }

    public ArrayList<Chi_tiet_dv> getLimit8Dich_Vu() {
        ArrayList<Chi_tiet_dv> dich_vus = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select ctdv.ctdv_id, ctdv.ctdv_anh, ctdv.ctdv_ten, ctdv.ctdv_gia, ctdv.ctdv_mo_ta, ctdv.ctdv_trang_thai, dv.dv_ten\n" +
                    "from chi_tiet_dv ctdv\n" +
                    "join dich_vu dv on dv.dv_id = ctdv.ctdv_dv_id\n" +
                    "where ctdv.ctdv_trang_thai != 0\n"+
                    "limit 8; ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String anh = resultSet.getString(2);
                String name = resultSet.getString(3);
                int gia = resultSet.getInt(4);
                String mo_ta = resultSet.getString(5);
                int trang_thai = resultSet.getInt(6);
                String dich_vu = resultSet.getString(7);
                dich_vus.add(new Chi_tiet_dv(id, anh, name, gia, mo_ta , trang_thai, dich_vu));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dich_vus;
    }

    public ArrayList<Pet_shop> getAllPet_Shop() {
        ArrayList<Pet_shop> pet_shops = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select ps.ps_id, ps.ps_ten, ps.ps_anh, ps.ps_gia , ps.ps_ngay_sinh, gp.gp_mo_ta, ps.ps_mota,  ps.ps_trang_thai, ps.ps_gp_id from pet_shop ps\n" +
                    "join giong_pet gp on ps.ps_gp_id = gp.gp_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String anh = resultSet.getString(3);
                int gia = resultSet.getInt(4);
                LocalDate ngay_sinh = LocalDate.parse(String.valueOf(resultSet.getDate(5)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                String mo_ta = resultSet.getString(6) + " " +resultSet.getString(7);
                int trang_thai = resultSet.getInt(8);
                String giong = resultSet.getString(9);
                pet_shops.add(new Pet_shop(id, name, anh, gia, ngay_sinh , mo_ta , trang_thai, giong));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pet_shops;
    }

    public ArrayList<Phu_kien> getAllPhu_Kien() {
        ArrayList<Phu_kien> phu_kiens = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select pk.pk_id, pk.pk_ten, pk.pk_anh, pk.pk_gia, pk.pk_so_luong, pk.pk_mo_ta, pk.pk_lpk_id from phu_kien pk\n" +
                    "join loai_phu_kien lpk on lpk.lpk_id = pk.pk_lpk_id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String anh = resultSet.getString(3);
                int gia = resultSet.getInt(4);
                int so_luong = resultSet.getInt(5);
                String mo_ta = resultSet.getString(6);
                String loai_phu_kien = resultSet.getString(7);
                phu_kiens.add(new Phu_kien(id, name, anh, gia, so_luong , mo_ta , loai_phu_kien));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return phu_kiens;
    }

    public ArrayList<Chi_tiet_dv> getAllDich_Vu() {
        ArrayList<Chi_tiet_dv> dich_vus = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select ctdv.ctdv_id, ctdv.ctdv_anh, ctdv.ctdv_ten, ctdv.ctdv_gia, ctdv.ctdv_mo_ta, ctdv.ctdv_trang_thai, ctdv.ctdv_dv_id\n" +
                    "from chi_tiet_dv ctdv\n" +
                    "join dich_vu dv on dv.dv_id = ctdv.ctdv_dv_id");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String anh = resultSet.getString(2);
                String name = resultSet.getString(3);
                int gia = resultSet.getInt(4);
                String mo_ta = resultSet.getString(5);
                int trang_thai = resultSet.getInt(6);
                String dich_vu = resultSet.getString(7);
                dich_vus.add(new Chi_tiet_dv(id, anh, name, gia, mo_ta , trang_thai, dich_vu));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dich_vus;
    }
}
