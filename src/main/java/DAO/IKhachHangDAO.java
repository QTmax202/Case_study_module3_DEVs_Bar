package DAO;

import model.Khach_hang;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IKhachHangDAO {
    ArrayList<Khach_hang> selectAllKhachHangs();
    void insertKhachHang(Khach_hang kh) throws SQLException;
    boolean updateKhachHang(Khach_hang kh) throws SQLException;
}
