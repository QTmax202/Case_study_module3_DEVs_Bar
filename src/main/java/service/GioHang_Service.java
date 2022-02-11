package service;

import DAO.GioHangDAO;
import DAO.HospitalDAO;
import model.Hdmh_tam_thoi;

import java.util.ArrayList;

public class GioHang_Service {
    private static final GioHangDAO gioHangDAO = new GioHangDAO();
    private static final HospitalDAO hospitalDAO = new HospitalDAO();

    public ArrayList<Hdmh_tam_thoi> getlist_hdmhtt_ps(int kh_id){
        ArrayList<Hdmh_tam_thoi> lists = new ArrayList<>();
        for (Hdmh_tam_thoi hd : gioHangDAO.getAll_hdmhtt(kh_id)) {
            if (hd.getHdmhtt_pk_id() == null){
                lists.add(hd);
            }
        }
        return lists;
    }

    public ArrayList<Hdmh_tam_thoi> getlist_hdmhtt_pk(int kh_id){
        ArrayList<Hdmh_tam_thoi> lists = new ArrayList<>();
        for (Hdmh_tam_thoi hd : gioHangDAO.getAll_hdmhtt(kh_id)) {
            if (hd.getHdmhtt_pk_id() != null){
                lists.add(hd);
            }
        }
        return lists;
    }
}
