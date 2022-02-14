package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hoa_don {
    private int hd_id;
    private String hd_nv_id;
    private int hd_kh_id;
    private LocalDate hd_ngay_lap;
    private int tong_tien;

    public Hoa_don(int hd_id, String hd_nv_id, int hd_kh_id, LocalDate hd_ngay_lap) {
        this.hd_id = hd_id;
        this.hd_nv_id = hd_nv_id;
        this.hd_kh_id = hd_kh_id;
        this.hd_ngay_lap = hd_ngay_lap;
    }

    public Hoa_don(String hd_nv_id, int hd_kh_id, LocalDate hd_ngay_lap) {
        this.hd_nv_id = hd_nv_id;
        this.hd_kh_id = hd_kh_id;
        this.hd_ngay_lap = hd_ngay_lap;
    }

    public Hoa_don(int hd_id, String hd_nv_id, int hd_kh_id, LocalDate hd_ngay_lap, int tong_tien) {
        this.hd_id = hd_id;
        this.hd_nv_id = hd_nv_id;
        this.hd_kh_id = hd_kh_id;
        this.hd_ngay_lap = hd_ngay_lap;
        this.tong_tien = tong_tien;
    }

    public int getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(int tong_tien) {
        this.tong_tien = tong_tien;
    }

    public int getHd_id() {
        return hd_id;
    }

    public void setHd_id(int hd_id) {
        this.hd_id = hd_id;
    }

    public String getHd_nv_id() {
        return hd_nv_id;
    }

    public void setHd_nv_id(String hd_nv_id) {
        this.hd_nv_id = hd_nv_id;
    }

    public int getHd_kh_id() {
        return hd_kh_id;
    }

    public void setHd_kh_id(int hd_kh_id) {
        this.hd_kh_id = hd_kh_id;
    }

    public LocalDate getHd_ngay_lap() {
        return hd_ngay_lap;
    }

    public String getNgay_lap_hd() {
        return hd_ngay_lap.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setHd_ngay_lap(LocalDate hd_ngay_lap) {
        this.hd_ngay_lap = hd_ngay_lap;
    }
}
