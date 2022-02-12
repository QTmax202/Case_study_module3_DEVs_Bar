package service;

import DAO.HospitalDAO;
import model.Chi_tiet_dv;
import model.Pet_shop;
import model.Phu_kien;

import java.util.ArrayList;

public class HospitalService {
    private static final HospitalDAO hospitalDAO = new HospitalDAO();

    public ArrayList<Pet_shop> getLimit8Pet_Shop() {
        return hospitalDAO.getLimit8Pet_Shop();
    }

    public ArrayList<Phu_kien> getLimit8Phu_Kien() {
        return hospitalDAO.getLimit8Phu_Kien();
    }

    public ArrayList<Chi_tiet_dv> getLimit8Dich_Vu() {
        return hospitalDAO.getLimit8Dich_Vu();
    }

    public Pet_shop getPet_Shop(int ps_id) {
        ArrayList<Pet_shop> pet_shops = hospitalDAO.getAllPet_Shop();
        for (Pet_shop ps : pet_shops) {
            if (ps.getPs_id() == ps_id) {
                return new Pet_shop(ps.getPs_id(), ps.getPs_ten(), ps.getPs_anh(), ps.getPs_gia(), ps.getPs_ngay_sinh(), ps.getPs_mo_ta(), ps.getPs_trang_thai(), ps.getPs_gp_id());
            }
        }
        return null;
    }

    public ArrayList<Pet_shop> getLimit4Pet_Shop(int id) {
        Pet_shop pet_shop = getPet_Shop(id);
        ArrayList<Pet_shop> pet_shops = hospitalDAO.getAllPet_Shop();
        ArrayList<Pet_shop> list_pets = new ArrayList<>();
        int index = 0;
            for (Pet_shop ps : pet_shops) {
                if (pet_shop.getPs_gp_id().equals(ps.getPs_gp_id()) && pet_shop.getPs_id() != ps.getPs_id()) {
                    if (ps.getPs_trang_thai() != 0) {
                        if (index < 4){
                            list_pets.add(ps);
                            index++;
                        }
                    }
                }
            }
        return list_pets;
    }

    public Phu_kien getPhu_Kien(String pk_id) {
        ArrayList<Phu_kien> phu_kiens = hospitalDAO.getAllPhu_Kien();
        for (Phu_kien pk : phu_kiens) {
            if (pk.getPk_id().equals(pk_id)) {
                return new Phu_kien(pk.getPk_id(), pk.getPk_ten(), pk.getPk_anh(), pk.getPk_gia(), pk.getPk_so_luong() , pk.getPk_mo_ta(), pk.getPk_lpk_id());
            }
        }
        return null;
    }

    public ArrayList<Phu_kien> getLimit4Phu_Kien(String id) {
        Phu_kien phu_kien = getPhu_Kien(id);
        ArrayList<Phu_kien> phu_kiens = hospitalDAO.getAllPhu_Kien();
        ArrayList<Phu_kien> list_pks = new ArrayList<>();
        int index = 0;
        for (Phu_kien pk : phu_kiens) {
            if (phu_kien.getPk_lpk_id().equals(pk.getPk_lpk_id()) && !phu_kien.getPk_id().equals(pk.getPk_id())) {
                if (pk.getPk_so_luong() != 0) {
                    if (index < 4){
                        list_pks.add(pk);
                        index++;
                    }
                }
            }
        }
        return list_pks;
    }

    public Chi_tiet_dv getDich_Vu(String id) {
        ArrayList<Chi_tiet_dv> dich_vus = hospitalDAO.getAllDich_Vu();
        for (Chi_tiet_dv dv : dich_vus) {
            if (dv.getCtdv_id().equals(id)) {
                return new Chi_tiet_dv(dv.getCtdv_id(), dv.getCtdv_anh(), dv.getCtdv_ten(), dv.getCtdv_gia(), dv.getCtdv_mo_ta(), dv.getCtdv_trang_thai(), dv.getCtdv_dv_id());
            }
        }
        return null;
    }

    public ArrayList<Chi_tiet_dv> getLimit4Dich_Vu(String id) {
        Chi_tiet_dv dich_vu = getDich_Vu(id);
        ArrayList<Chi_tiet_dv> dich_vus = hospitalDAO.getAllDich_Vu();
        ArrayList<Chi_tiet_dv> list_dvs = new ArrayList<>();
        int index = 0;
        for (Chi_tiet_dv dv : dich_vus) {
            if (dich_vu.getCtdv_dv_id().equals(dv.getCtdv_dv_id()) && !dich_vu.getCtdv_id().equals(dv.getCtdv_id())) {
                if (dv.getCtdv_trang_thai() != 0) {
                    if (index < 4){
                        list_dvs.add(dv);
                        index++;
                    }
                }
            }
        }
        return list_dvs;
    }
}
