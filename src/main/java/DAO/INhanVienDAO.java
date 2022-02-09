package DAO;

import model.Nhan_vien;

import java.sql.SQLException;
import java.util.ArrayList;

public interface INhanVienDAO {
    void insertNhanVien(Nhan_vien nhanVien) throws SQLException;
    ArrayList<Nhan_vien> selectAllNhanViens();
    boolean updateNhanVien(Nhan_vien nhanVien) throws SQLException;
}
