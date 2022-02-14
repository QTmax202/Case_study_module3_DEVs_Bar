package DAO;

import connection.MyConnection;
import model.*;

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

    public void create_hddvtt(Hddv_tam_thoi list){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into hddv_tam_thoi (hddvtt_kh_id, hddvtt_ctdv_id, hddvtt_ngay_dat, hddvtt_thanh_tien)\n" +
                    " values (?, ?, ?, ?);");
            preparedStatement.setInt(1, list.getHddvtt_kh_id());
            preparedStatement.setString(2, list.getHddvtt_ctdv_id());
            preparedStatement.setDate(3, java.sql.Date.valueOf(list.getHddvtt_ngay_dat()));
            preparedStatement.setInt(4, list.getHddvtt_thanh_tien());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create_hd(String nv_id, int kh_id){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into hoa_don (hd_nv_id, hd_kh_id, hd_ngay_lap)\n" +
                    " values (?, ?, ?);");
            preparedStatement.setString(1, nv_id);
            preparedStatement.setInt(2, kh_id);
            preparedStatement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create_hdmh_ps(int hd_id, int ps_id, int thanh_tien){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into hoa_don_mua_hang (hdmh_hd_id, hdmh_ps_id, hdmh_so_luong, hdmh_thanh_tien)\n" +
                    "values (?, ?, 1, ?); ");
            preparedStatement.setInt(1, hd_id);
            preparedStatement.setInt(2, ps_id);
            preparedStatement.setInt(3, thanh_tien);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create_hdmh_pk(int hd_id, String pk_id, int thanh_tien){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into hoa_don_mua_hang (hdmh_hd_id, hdmh_pk_id, hdmh_so_luong, hdmh_thanh_tien)\n" +
                    "values (?, ?, 1, ?); ");
            preparedStatement.setInt(1, hd_id);
            preparedStatement.setString(2, pk_id);
            preparedStatement.setInt(3, thanh_tien);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void create_hddv(Hoa_don_dich_vu list_dv){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into hoa_don_dich_vu (hddv_hd_id, hddv_ctdv_id, hddv_ngay_dat, hddv_thanh_tien)\n" +
                    "values (?, ?, ?, ?);");
            preparedStatement.setInt(1, list_dv.getHddv_hd_id());
            preparedStatement.setString(2, list_dv.getHddv_ctdv_id());
            preparedStatement.setDate(3, java.sql.Date.valueOf(list_dv.getHddv_ngay_dat()));
            preparedStatement.setInt(4, list_dv.getHddv_thanh_tien());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update_pet_shop(int ps_id){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update pet_shop set ps_trang_thai = 0 \n" +
                    "where ps_id = ?;");
            preparedStatement.setInt(1, ps_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update_phu_kien(String pk_id){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update phu_kien set pk_so_luong = (pk_so_luong - 1) where pk_id = ?;");
            preparedStatement.setString(1, pk_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String get_nhan_vien_id(int ca_nhan_vien){
        String nv_id = null;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select nhan_vien.nv_id from nhan_vien\n" +
                    "join ca on nhan_vien.nv_ca_id = ca.ca_id\n" +
                    "where ca.ca_bat_dau < ?\n" +
                    "and ca.ca_ket_thuc >= ?\n" +
                    "limit 1;");
            preparedStatement.setInt(1, ca_nhan_vien);
            preparedStatement.setInt(2, ca_nhan_vien);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                nv_id = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv_id;
    }

    public int get_hoa_don_kh_id_limit1(int kh_id) {
        int hd_id = 0 ;
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from hoa_don\n" +
                    "where hd_kh_id = ?\n" +
                    "order by hd_id desc\n" +
                    "limit 1;");
            preparedStatement.setInt(1, kh_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                hd_id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hd_id;
    }

    public ArrayList<Hoa_don> get_all_hd_hddv(){
        ArrayList<Hoa_don> lists = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select hd_id, hd_nv_id, hd_kh_id, hd_ngay_lap , sum(hddv.hddv_thanh_tien)\n" +
                    "from hoa_don hd\n" +
                    "join hoa_don_dich_vu hddv on hd.hd_id = hddv.hddv_hd_id\n" +
                    "group by hddv.hddv_hd_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int hd_id = resultSet.getInt(1);
                String nv_id = resultSet.getString(2);
                int kh_id = resultSet.getInt(3);
                LocalDate ngay_lap = LocalDate.parse(String.valueOf(resultSet.getDate(4)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                int thanh_tien = resultSet.getInt(5);
                lists.add(new Hoa_don(hd_id, nv_id, kh_id, ngay_lap, thanh_tien));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
    }

    public ArrayList<Hoa_don> get_all_hd_hdmh(){
        ArrayList<Hoa_don> lists = new ArrayList<>();
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select hd_id, hd_nv_id, hd_kh_id, hd_ngay_lap , sum(hdmh.hdmh_thanh_tien) from hoa_don hd\n" +
                    "join hoa_don_mua_hang hdmh on hd.hd_id = hdmh.hdmh_hd_id\n" +
                    "group by hdmh.hdmh_hd_id;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int hd_id = resultSet.getInt(1);
                String nv_id = resultSet.getString(2);
                int kh_id = resultSet.getInt(3);
                LocalDate ngay_lap = LocalDate.parse(String.valueOf(resultSet.getDate(4)), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                int thanh_tien = resultSet.getInt(5);
                lists.add(new Hoa_don(hd_id, nv_id, kh_id, ngay_lap, thanh_tien));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lists;
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
                String ctdv_id = resultSet.getString(3);
                String ctdv_ten = resultSet.getString(4);
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

    public void delete_hddvtt(int hdmhtt_kh_id){
        try{
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from hddv_tam_thoi\n" +
                    " where hddvtt_kh_id = ?;");
            preparedStatement.setInt(1, hdmhtt_kh_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete_hdmhtt_ps_pk(int hd_id){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from hdmh_tam_thoi\n" +
                    " where hdmhtt_id = ? ;");
            preparedStatement.setInt(1, hd_id);
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

    public void delete_hd_id(int hd_id){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from hoa_don \n" +
                    "where hd_id = ?;");
            preparedStatement.setInt(1, hd_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete_hdmh_hd_id(int hd_id){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from hoa_don_mua_hang \n" +
                    "where hdmh_hd_id = ?;");
            preparedStatement.setInt(1, hd_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete_hddv_hd_id(int hd_id){
        try {
            Connection connection = myConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from hoa_don_dich_vu \n" +
                    "where hddv_hd_id = ?;");
            preparedStatement.setInt(1, hd_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
