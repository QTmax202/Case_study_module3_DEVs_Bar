package service;

import DAO.GioHangDAO;
import model.Hdmh_tam_thoi;
import model.Hoa_don;

import java.util.ArrayList;

public class GioHang_Service {
    private static final GioHangDAO gioHangDAO = new GioHangDAO();

    public ArrayList<Hdmh_tam_thoi> getlist_hdmhtt_ps(int kh_id) {
        ArrayList<Hdmh_tam_thoi> lists = new ArrayList<>();
        for (Hdmh_tam_thoi hd : gioHangDAO.getAll_hdmhtt(kh_id)) {
            if (hd.getHdmhtt_pk_id() == null) {
                lists.add(hd);
            }
        }
        return lists;
    }

    public ArrayList<Hdmh_tam_thoi> getlist_hdmhtt_pk(int kh_id) {
        ArrayList<Hdmh_tam_thoi> lists = new ArrayList<>();
        for (Hdmh_tam_thoi hd : gioHangDAO.getAll_hdmhtt(kh_id)) {
            if (hd.getHdmhtt_pk_id() != null) {
                lists.add(hd);
            }
        }
        return lists;
    }

    public ArrayList<Hoa_don> getAll_hoa_don() {
        ArrayList<Hoa_don> lists_hd = new ArrayList<>();
        ArrayList<Hoa_don> lists_hddv = gioHangDAO.get_all_hd_hddv();
        ArrayList<Hoa_don> lists_hdmh = gioHangDAO.get_all_hd_hdmh();
        for (Hoa_don hddv : lists_hddv) {
            for (Hoa_don hdmh : lists_hdmh) {
                if (hddv.getHd_id() == hdmh.getHd_id()){
                    int tong_tien = hddv.getTong_tien() + hdmh.getTong_tien();
                    lists_hd.add(new Hoa_don(hddv.getHd_id(), hddv.getHd_nv_id(), hddv.getHd_kh_id(), hddv.getHd_ngay_lap(), tong_tien));
                }
            }
        }
        for (Hoa_don hddv : lists_hddv) {
            boolean check = false;
            for (Hoa_don hd : lists_hd) {
                if (hd.getHd_id() == hddv.getHd_id()) {
                    check = true;
                    break;
                }
            }
            if (!check){
                lists_hd.add(new Hoa_don(hddv.getHd_id(), hddv.getHd_nv_id(), hddv.getHd_kh_id(), hddv.getHd_ngay_lap(), hddv.getTong_tien()));
            }
        }
        for (Hoa_don hdmh : lists_hdmh) {
            boolean check = false;
            for (Hoa_don hd : lists_hd) {
                if (hd.getHd_id() == hdmh.getHd_id()) {
                    check = true;
                    break;
                }
            }
            if (!check){
                lists_hd.add(new Hoa_don(hdmh.getHd_id(), hdmh.getHd_nv_id(), hdmh.getHd_kh_id(), hdmh.getHd_ngay_lap(), hdmh.getTong_tien()));
            }
        }
        return lists_hd;
    }
}
