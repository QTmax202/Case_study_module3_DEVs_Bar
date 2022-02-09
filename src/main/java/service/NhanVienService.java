package service;

import DAO.NhanVienDAO;
import model.Nhan_vien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienService {
    private static final NhanVienDAO nhanVienDAO = new NhanVienDAO() {
    public ArrayList<Nhan_vien> getNhanVien(){
        return nhanVienDAO.getAllNhanVien();
    }
}
