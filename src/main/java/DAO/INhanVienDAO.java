package DAO;

import model.Nhan_vien;

import java.util.List;

public interface INhanVienDAO {
    List<Nhan_vien> getAllNhanVien();

    void updateNhanVien(Nhan_vien nhanVien, int id);
}
