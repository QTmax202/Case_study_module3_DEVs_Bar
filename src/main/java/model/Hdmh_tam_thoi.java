package model;

public class Hdmh_tam_thoi {
    private int hdmhtt_id;
    private int hdmhtt_kh_id;
    private int hdmhtt_ps_id;
    private String hdmhtt_pk_id;
    private int  hdmhtt_so_luong;
    private int hdmhtt_thanh_tien;
    private String hdmhtt_ten;

    public Hdmh_tam_thoi(int hdmhtt_id, int hdmhtt_kh_id, int hdmhtt_ps_id, String hdmhtt_pk_id, int hdmhtt_so_luong, int hdmhtt_thanh_tien) {
        this.hdmhtt_id = hdmhtt_id;
        this.hdmhtt_kh_id = hdmhtt_kh_id;
        this.hdmhtt_ps_id = hdmhtt_ps_id;
        this.hdmhtt_pk_id = hdmhtt_pk_id;
        this.hdmhtt_so_luong = hdmhtt_so_luong;
        this.hdmhtt_thanh_tien = hdmhtt_thanh_tien;
    }

    public Hdmh_tam_thoi(int hdmhtt_kh_id, int hdmhtt_ps_id, int hdmhtt_so_luong, int hdmhtt_thanh_tien) {
        this.hdmhtt_kh_id = hdmhtt_kh_id;
        this.hdmhtt_ps_id = hdmhtt_ps_id;
        this.hdmhtt_so_luong = hdmhtt_so_luong;
        this.hdmhtt_thanh_tien = hdmhtt_thanh_tien;
    }

    public Hdmh_tam_thoi(int hdmhtt_kh_id, String hdmhtt_pk_id, int hdmhtt_so_luong, int hdmhtt_thanh_tien) {
        this.hdmhtt_kh_id = hdmhtt_kh_id;
        this.hdmhtt_pk_id = hdmhtt_pk_id;
        this.hdmhtt_so_luong = hdmhtt_so_luong;
        this.hdmhtt_thanh_tien = hdmhtt_thanh_tien;
    }

    public Hdmh_tam_thoi(int hdmhtt_id, int hdmhtt_kh_id, String hdmhtt_ten, int hdmhtt_so_luong, int hdmhtt_thanh_tien) {
        this.hdmhtt_id = hdmhtt_id;
        this.hdmhtt_kh_id = hdmhtt_kh_id;
        this.hdmhtt_ten = hdmhtt_ten;
        this.hdmhtt_so_luong = hdmhtt_so_luong;
        this.hdmhtt_thanh_tien = hdmhtt_thanh_tien;
    }

    public String getHdmhtt_ten() {
        return hdmhtt_ten;
    }

    public int getHdmhtt_id() {
        return hdmhtt_id;
    }

    public void setHdmhtt_id(int hdmhtt_id) {
        this.hdmhtt_id = hdmhtt_id;
    }

    public int getHdmhtt_kh_id() {
        return hdmhtt_kh_id;
    }

    public void setHdmhtt_kh_id(int hdmhtt_kh_id) {
        this.hdmhtt_kh_id = hdmhtt_kh_id;
    }

    public int getHdmhtt_ps_id() {
        return hdmhtt_ps_id;
    }

    public void setHdmhtt_ps_id(int hdmhtt_ps_id) {
        this.hdmhtt_ps_id = hdmhtt_ps_id;
    }

    public String getHdmhtt_pk_id() {
        return hdmhtt_pk_id;
    }

    public void setHdmhtt_pk_id(String hdmhtt_pk_id) {
        this.hdmhtt_pk_id = hdmhtt_pk_id;
    }

    public int getHdmhtt_so_luong() {
        return hdmhtt_so_luong;
    }

    public void setHdmhtt_so_luong(int hdmhtt_so_luong) {
        this.hdmhtt_so_luong = hdmhtt_so_luong;
    }

    public int getHdmhtt_thanh_tien() {
        return hdmhtt_thanh_tien;
    }

    public void setHdmhtt_thanh_tien(int hdmhtt_thanh_tien) {
        this.hdmhtt_thanh_tien = hdmhtt_thanh_tien;
    }
}
