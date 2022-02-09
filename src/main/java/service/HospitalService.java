package service;

import DAO.HospitalDAO;
import model.Chi_tiet_dv;
import model.Pet_shop;
import model.Phu_kien;

import java.util.ArrayList;

public class HospitalService {
    private static final HospitalDAO hospitalDAO = new HospitalDAO();

    public ArrayList<Pet_shop> getLimit8Pet_Shop(){
        return hospitalDAO.getLimit8Pet_Shop();
    }

    public ArrayList<Phu_kien> getLimit8Phu_Kien(){
        return hospitalDAO.getLimit8Phu_Kien();
    }

    public ArrayList<Chi_tiet_dv> getLimit8Dich_Vu(){
        return hospitalDAO.getLimit8Dich_Vu();
    }
}
