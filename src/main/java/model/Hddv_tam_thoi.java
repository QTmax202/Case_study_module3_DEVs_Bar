package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Hddv_tam_thoi {
    private int hddvtt_id;
    private int hddvtt_kh_id;
    private String hddvtt_ctdv_id;
    private String hddvtt_ctdv_ten;
    private int hddvtt_petkh_id;
    private LocalDate hddvtt_thoi_gian_dat;
    private int hddvtt_thanh_tien;

    public Hddv_tam_thoi(int hddvtt_id, int hddvtt_kh_id, String hddvtt_ctdv_id, int hddvtt_petkh_id, LocalDate hddvtt_thoi_gian_dat, int hddvtt_thanh_tien) {
        this.hddvtt_id = hddvtt_id;
        this.hddvtt_kh_id = hddvtt_kh_id;
        this.hddvtt_ctdv_id = hddvtt_ctdv_id;
        this.hddvtt_petkh_id = hddvtt_petkh_id;
        this.hddvtt_thoi_gian_dat = hddvtt_thoi_gian_dat;
        this.hddvtt_thanh_tien = hddvtt_thanh_tien;
    }

    public Hddv_tam_thoi(int hddvtt_kh_id, String hddvtt_ctdv_id, int hddvtt_petkh_id, LocalDate hddvtt_thoi_gian_dat, int hddvtt_thanh_tien) {
        this.hddvtt_kh_id = hddvtt_kh_id;
        this.hddvtt_ctdv_id = hddvtt_ctdv_id;
        this.hddvtt_petkh_id = hddvtt_petkh_id;
        this.hddvtt_thoi_gian_dat = hddvtt_thoi_gian_dat;
        this.hddvtt_thanh_tien = hddvtt_thanh_tien;
    }

    public Hddv_tam_thoi(int hddvtt_kh_id, String hddvtt_ctdv_id, LocalDate hddvtt_thoi_gian_dat, int hddvtt_thanh_tien) {
        this.hddvtt_kh_id = hddvtt_kh_id;
        this.hddvtt_ctdv_id = hddvtt_ctdv_id;
        this.hddvtt_thoi_gian_dat = hddvtt_thoi_gian_dat;
        this.hddvtt_thanh_tien = hddvtt_thanh_tien;
    }

    public Hddv_tam_thoi(int hddvtt_id, int hddvtt_kh_id, String hddvtt_ctdv_id,String hddvtt_ctdv_ten, LocalDate hddvtt_thoi_gian_dat, int hddvtt_thanh_tien) {
        this.hddvtt_id = hddvtt_id;
        this.hddvtt_kh_id = hddvtt_kh_id;
        this.hddvtt_ctdv_id = hddvtt_ctdv_id;
        this.hddvtt_ctdv_ten = hddvtt_ctdv_ten;
        this.hddvtt_thoi_gian_dat = hddvtt_thoi_gian_dat;
        this.hddvtt_thanh_tien = hddvtt_thanh_tien;
    }

    public int getHddvtt_id() {
        return hddvtt_id;
    }

    public void setHddvtt_id(int hddvtt_id) {
        this.hddvtt_id = hddvtt_id;
    }

    public int getHddvtt_kh_id() {
        return hddvtt_kh_id;
    }

    public void setHddvtt_kh_id(int hddvtt_kh_id) {
        this.hddvtt_kh_id = hddvtt_kh_id;
    }

    public String getHddvtt_ctdv_id() {
        return hddvtt_ctdv_id;
    }

    public void setHddvtt_ctdv_id(String hddvtt_ctdv_id) {
        this.hddvtt_ctdv_id = hddvtt_ctdv_id;
    }

    public int getHddvtt_petkh_id() {
        return hddvtt_petkh_id;
    }

    public void setHddvtt_petkh_id(int hddvtt_petkh_id) {
        this.hddvtt_petkh_id = hddvtt_petkh_id;
    }

    public String getHddvtt_thoi_gian_dat() {
        return hddvtt_thoi_gian_dat.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setHddvtt_thoi_gian_dat(LocalDate hddvtt_thoi_gian_dat) {
        this.hddvtt_thoi_gian_dat = hddvtt_thoi_gian_dat;
    }

    public int getHddvtt_thanh_tien() {
        return hddvtt_thanh_tien;
    }

    public void setHddvtt_thanh_tien(int hddvtt_thanh_tien) {
        this.hddvtt_thanh_tien = hddvtt_thanh_tien;
    }


}
