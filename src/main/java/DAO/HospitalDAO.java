package DAO;

import connection.MyConnection;
import model.pet_shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HospitalDAO {
    private static final MyConnection myConnection = new MyConnection();

    public ArrayList<pet_shop> getAllPet_shop() {
        ArrayList<pet_shop> product_cate = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select ps.ps_id, ps.ps_ten, ps.ps_anh, ps.ps_gia , ps.ps_ngay_sinh, ps.ps_mota, ps.ps_trang_thai, gp.gp_ten from pet_shop ps\n" +
                    "join giong_pet gp on ps.ps_gp_id = gp.gp_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String anh = resultSet.getString(3);
                int gia = resultSet.getInt(4);
//                String ngay_sinh = resultSet.getString(resultSet.getDate(5).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                String ngay_sinh = resultSet.getString(String.valueOf(resultSet.getDate(5)));
                String mo_ta = resultSet.getString(6);
                int trang_thai = resultSet.getInt(7);
                String giong = resultSet.getString(8);
                product_cate.add(new pet_shop(id, name, anh, gia, ngay_sinh , mo_ta , trang_thai, giong));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product_cate;
    }
}
