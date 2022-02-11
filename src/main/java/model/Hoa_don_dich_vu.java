package model;

import java.time.LocalDate;

public class Hoa_don_dich_vu {
    private int hddv_id;
    private int hddv_hd_id;
    private String hddv_ctdv_id;
    private int hddv_petkh_id;
    private LocalDate hddv_ngay_dat;
    private int hddv_thanh_tien;

    public Hoa_don_dich_vu(int hddv_id, int hddv_hd_id, String hddv_ctdv_id, int hddv_petkh_id, LocalDate hddv_ngay_dat, int hddv_thanh_tien) {
        this.hddv_id = hddv_id;
        this.hddv_hd_id = hddv_hd_id;
        this.hddv_ctdv_id = hddv_ctdv_id;
        this.hddv_petkh_id = hddv_petkh_id;
        this.hddv_ngay_dat = hddv_ngay_dat;
        this.hddv_thanh_tien = hddv_thanh_tien;
    }

    public Hoa_don_dich_vu(int hddv_hd_id, String hddv_ctdv_id, int hddv_petkh_id, LocalDate hddv_ngay_dat, int hddv_thanh_tien) {
        this.hddv_hd_id = hddv_hd_id;
        this.hddv_ctdv_id = hddv_ctdv_id;
        this.hddv_petkh_id = hddv_petkh_id;
        this.hddv_ngay_dat = hddv_ngay_dat;
        this.hddv_thanh_tien = hddv_thanh_tien;
    }

    public Hoa_don_dich_vu(int hddv_hd_id, String hddv_ctdv_id, LocalDate hddv_thoi_gian_dat, int hddv_thanh_tien) {
        this.hddv_hd_id = hddv_hd_id;
        this.hddv_ctdv_id = hddv_ctdv_id;
        this.hddv_ngay_dat = hddv_thoi_gian_dat;
        this.hddv_thanh_tien = hddv_thanh_tien;
    }

    public int getHddv_id() {
        return hddv_id;
    }

    public void setHddv_id(int hddv_id) {
        this.hddv_id = hddv_id;
    }

    public int getHddv_hd_id() {
        return hddv_hd_id;
    }

    public void setHddv_hd_id(int hddv_hd_id) {
        this.hddv_hd_id = hddv_hd_id;
    }

    public String getHddv_ctdv_id() {
        return hddv_ctdv_id;
    }

    public void setHddv_ctdv_id(String hddv_ctdv_id) {
        this.hddv_ctdv_id = hddv_ctdv_id;
    }

    public int getHddv_petkh_id() {
        return hddv_petkh_id;
    }

    public void setHddv_petkh_id(int hddv_petkh_id) {
        this.hddv_petkh_id = hddv_petkh_id;
    }

    public LocalDate getHddv_ngay_dat() {
        return hddv_ngay_dat;
    }

    public void setHddv_ngay_dat(LocalDate hddv_thoi_gian_dat) {
        this.hddv_ngay_dat = hddv_thoi_gian_dat;
    }

    public int getHddv_thanh_tien() {
        return hddv_thanh_tien;
    }

    public void setHddv_thanh_tien(int hddv_thanh_tien) {
        this.hddv_thanh_tien = hddv_thanh_tien;
    }
}
