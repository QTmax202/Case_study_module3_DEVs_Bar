package DAO;

import connection.MyConnection;
import model.Pet_shop;
import model.Phu_kien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class HospitalDAO {
    private static final MyConnection myConnection = new MyConnection();

    public ArrayList<Pet_shop> getLimit8Pet_Shop() {
        ArrayList<Pet_shop> pet_shops = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select ps.ps_id, ps.ps_ten, ps.ps_anh, ps.ps_gia , ps.ps_ngay_sinh, ps.ps_mota, ps.ps_trang_thai, gp.gp_ten from pet_shop ps\n" +
                    "join giong_pet gp on ps.ps_gp_id = gp.gp_id\n"+
                    "limit 8;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String anh = resultSet.getString(3);
                int gia = resultSet.getInt(4);
//                String ngay_sinh = resultSet.getString(resultSet.getDate(5).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
//                LocalDate ngay_sinh = resultSet.getDate(5).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                Date ngay_sinh = resultSet.getDate(5);
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
                    "limit 8;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String anh = resultSet.getString(3);
                int gia = resultSet.getInt(4);
                Date ngay_sinh = resultSet.getDate(5);
                String mo_ta = resultSet.getString(6);
                int trang_thai = resultSet.getInt(7);
                String giong = resultSet.getString(8);
//                phu_kiens.add(new (id, name, anh, gia, ngay_sinh , mo_ta , trang_thai, giong));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return phu_kiens;
    }

}
