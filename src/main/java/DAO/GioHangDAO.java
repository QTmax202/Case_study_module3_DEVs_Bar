package DAO;

import connection.MyConnection;
import model.Hddv_tam_thoi;
import model.Hdmh_tam_thoi;
import model.Pet_shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GioHangDAO {
    private static final MyConnection myConnection = new MyConnection();

    public void create_hdmhtt_ps(Hdmh_tam_thoi list){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into hdmh_tam_thoi (hdmhtt_kh_id, hdmhtt_ps_id, hdmhtt_so_luong, hdmhtt_thanh_tien)\n" +
                    " values (? , ?, 1, ?);");
            preparedStatement.setInt(1, list.getHdmhtt_kh_id());
            preparedStatement.setInt(2, list.getHdmhtt_ps_id());
            preparedStatement.setInt(3, list.getHdmhtt_thanh_tien());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create_hdmhtt_pk(Hdmh_tam_thoi list){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into hdmh_tam_thoi (hdmhtt_kh_id, hdmhtt_pk_id, hdmhtt_so_luong, hdmhtt_thanh_tien)\n" +
                    " values (? , ?, ?, ?);");
            preparedStatement.setInt(1, list.getHdmhtt_kh_id());
            preparedStatement.setString(2, list.getHdmhtt_pk_id());
            preparedStatement.setInt(3, list.getHdmhtt_so_luong());
            preparedStatement.setInt(4, list.getHdmhtt_thanh_tien());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Hdmh_tam_thoi getHdmh_tam_thoi(int hdmhtt_id){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" select * from hdmh_tam_thoi\n" +
                    " where hdmhtt_id = ?;");
            preparedStatement.setInt(1, hdmhtt_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            int id = resultSet.getInt(1);
            int kh_id = resultSet.getInt(2);
            int ps_id = resultSet.getInt(3);
            String pk_id =resultSet.getString(4);
            int so_luong = resultSet.getInt(5);
            int thanh_tien = resultSet.getInt(6);
            return new Hdmh_tam_thoi(id, kh_id, ps_id, pk_id, so_luong, thanh_tien);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Hdmh_tam_thoi> getAll_hdmhtt(int hdmhtt_kh_id){
        ArrayList<Hdmh_tam_thoi> lists = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" select * from hdmh_tam_thoi\n" +
                    " where hdmhtt_kh_id = ?;");
            preparedStatement.setInt(1, hdmhtt_kh_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                int kh_id = resultSet.getInt(2);
                int ps_id = resultSet.getInt(3);
                String pk_id =resultSet.getString(4);
                int so_luong = resultSet.getInt(5);
                int thanh_tien = resultSet.getInt(6);
                lists.add(new Hdmh_tam_thoi(id, kh_id, ps_id, pk_id, so_luong, thanh_tien));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    public ArrayList<Hdmh_tam_thoi> getLists_hdmhtt_ps(int hdmhtt_kh_id){
        ArrayList<Hdmh_tam_thoi> lists = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" select hdmh.hdmhtt_id, hdmh.hdmhtt_kh_id, ps.ps_ten, hdmh.hdmhtt_so_luong, hdmh.hdmhtt_thanh_tien\n" +
                    " from hdmh_tam_thoi hdmh\n" +
                    " join pet_shop ps\n" +
                    " on hdmh.hdmhtt_ps_id = ps.ps_id\n" +
                    " where hdmhtt_kh_id = ?;");
            preparedStatement.setInt(1, hdmhtt_kh_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                int kh_id = resultSet.getInt(2);
                String ps_ten =resultSet.getString(3);
                int so_luong = resultSet.getInt(4);
                int thanh_tien = resultSet.getInt(5);
                lists.add(new Hdmh_tam_thoi(id, kh_id, ps_ten, so_luong, thanh_tien));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    public ArrayList<Hddv_tam_thoi> getLists_hddvtt_dv(int hdmhtt_kh_id){
        ArrayList<Hddv_tam_thoi> lists = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select hddv.hddvtt_id, hddv.hddvtt_kh_id, hddv.hddvtt_ctdv_id, ctdv.ctdv_ten, hddv.hddvtt_ngay_dat, hddv.hddvtt_thanh_tien\n" +
                    "from hddv_tam_thoi hddv\n" +
                    "join chi_tiet_dv ctdv\n" +
                    "on hddv.hddvtt_ctdv_id = ctdv.ctdv_id\n" +
                    "where hddv.hddvtt_kh_id = ?;");
            preparedStatement.setInt(1, hdmhtt_kh_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                int kh_id = resultSet.getInt(2);
                String ctdv_id =resultSet.getString(3);
                String ctdv_ten =resultSet.getString(4);
                LocalDate ngay_dat = LocalDate.parse(String.valueOf(resultSet.getDate(5)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                int thanh_tien = resultSet.getInt(6);
                lists.add(new Hddv_tam_thoi(id, kh_id, ctdv_id, ctdv_ten, ngay_dat, thanh_tien));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    public ArrayList<Hdmh_tam_thoi> getLists_hdmhtt_pk(int hdmhtt_kh_id){
        ArrayList<Hdmh_tam_thoi> lists = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(" select hdmh.hdmhtt_id, hdmh.hdmhtt_kh_id, pk.pk_ten, hdmh.hdmhtt_so_luong, hdmh.hdmhtt_thanh_tien\n" +
                    " from hdmh_tam_thoi hdmh\n" +
                    " join phu_kien pk\n" +
                    " on hdmh.hdmhtt_pk_id = pk.pk_id\n" +
                    " where hdmhtt_kh_id = ?;");
            preparedStatement.setInt(1, hdmhtt_kh_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                int kh_id = resultSet.getInt(2);
                String ps_ten =resultSet.getString(3);
                int so_luong = resultSet.getInt(4);
                int thanh_tien = resultSet.getInt(5);
                lists.add(new Hdmh_tam_thoi(id, kh_id, ps_ten, so_luong, thanh_tien));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    public void delete_hdmhtt(int hdmhtt_kh_id){
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from hdmh_tam_thoi\n" +
                    " where hdmhtt_kh_id = ?;");
            preparedStatement.setInt(1, hdmhtt_kh_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete_hdmhdv(int hdmhtt_kh_id){
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from hdmh_tam_thoi\n" +
                    " where hdmhtt_kh_id = ?;");
            preparedStatement.setInt(1, hdmhtt_kh_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete_hdmhtt_ps_pk(int hd_kh_id){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from hddv_tam_thoi\n" +
                    " where hddvtt_kh_id = ? ;");
            preparedStatement.setInt(1, hd_kh_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete_hdmhtt_dv(int hd_id){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from hddv_tam_thoi \n" +
                    "where hddvtt_id = ?;");
            preparedStatement.setInt(1, hd_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
