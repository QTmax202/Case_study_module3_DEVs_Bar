package DAO;

import connection.MyConnection;
import model.Giong_pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShopDAOIpm implements ShopDAO{
    private static final MyConnection myConnection = new MyConnection();

    private static final String SELECT_ALL_PET = "SELECT * FROM giong_pet;";

    @Override
    public List<Giong_pet> categoryPet() {
        List<Giong_pet> giong_pets = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PET);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String gp_id = resultSet.getString("gp_id");
                String gp_ten = resultSet.getString("gp_ten");
                String gp_mo_ta = resultSet.getString("gp_mo_ta");
                String gp_lp_id = resultSet.getString("gp_lp_id");
                giong_pets.add(new Giong_pet(gp_id, gp_ten, gp_mo_ta, gp_lp_id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return giong_pets;
    }
}
