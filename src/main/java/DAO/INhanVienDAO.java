package DAO;

import model.Nhan_vien;

import java.util.ArrayList;

public interface INhanVienDAO {
    ArrayList<Nhan_vien> getALlNhanVien();

    void updateNhanVien(Nhan_vien nhanVien, int id);
}
