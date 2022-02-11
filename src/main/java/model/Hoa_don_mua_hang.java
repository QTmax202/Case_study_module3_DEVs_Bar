package model;

public class Hoa_don_mua_hang {
    private int hdmh_id;
    private int hdmh_hd_id;
    private int hdmh_ps_id;
    private String hdmh_pk_id;
    private int hdmh_so_luong;
    private int hdmh_thanh_tien;

    public Hoa_don_mua_hang(int hdmh_id, int hdmh_hd_id, int hdmh_ps_id, String hdmh_pk_id, int hdmh_so_luong, int hdmh_thanh_tien) {
        this.hdmh_id = hdmh_id;
        this.hdmh_hd_id = hdmh_hd_id;
        this.hdmh_ps_id = hdmh_ps_id;
        this.hdmh_pk_id = hdmh_pk_id;
        this.hdmh_so_luong = hdmh_so_luong;
        this.hdmh_thanh_tien = hdmh_thanh_tien;
    }

    public Hoa_don_mua_hang(int hdmh_hd_id, int hdmh_ps_id, String hdmh_pk_id, int hdmh_so_luong, int hdmh_thanh_tien) {
        this.hdmh_hd_id = hdmh_hd_id;
        this.hdmh_ps_id = hdmh_ps_id;
        this.hdmh_pk_id = hdmh_pk_id;
        this.hdmh_so_luong = hdmh_so_luong;
        this.hdmh_thanh_tien = hdmh_thanh_tien;
    }

    public Hoa_don_mua_hang(int hdmh_hd_id, int hdmh_ps_id, int hdmh_so_luong, int hdmh_thanh_tien) {
        this.hdmh_hd_id = hdmh_hd_id;
        this.hdmh_ps_id = hdmh_ps_id;
        this.hdmh_so_luong = hdmh_so_luong;
        this.hdmh_thanh_tien = hdmh_thanh_tien;
    }

    public Hoa_don_mua_hang(int hdmh_hd_id, String hdmh_pk_id, int hdmh_so_luong, int hdmh_thanh_tien) {
        this.hdmh_hd_id = hdmh_hd_id;
        this.hdmh_pk_id = hdmh_pk_id;
        this.hdmh_so_luong = hdmh_so_luong;
        this.hdmh_thanh_tien = hdmh_thanh_tien;
    }

    public int getHdmh_id() {
        return hdmh_id;
    }

    public void setHdmh_id(int hdmh_id) {
        this.hdmh_id = hdmh_id;
    }

    public int getHdmh_hd_id() {
        return hdmh_hd_id;
    }

    public void setHdmh_hd_id(int hdmh_hd_id) {
        this.hdmh_hd_id = hdmh_hd_id;
    }

    public int getHdmh_ps_id() {
        return hdmh_ps_id;
    }

    public void setHdmh_ps_id(int hdmh_ps_id) {
        this.hdmh_ps_id = hdmh_ps_id;
    }

    public String getHdmh_pk_id() {
        return hdmh_pk_id;
    }

    public void setHdmh_pk_id(String hdmh_pk_id) {
        this.hdmh_pk_id = hdmh_pk_id;
    }

    public int getHdmh_so_luong() {
        return hdmh_so_luong;
    }

    public void setHdmh_so_luong(int hdmh_so_luong) {
        this.hdmh_so_luong = hdmh_so_luong;
    }

    public int getHdmh_thanh_tien() {
        return hdmh_thanh_tien;
    }

    public void setHdmh_thanh_tien(int hdmh_thanh_tien) {
        this.hdmh_thanh_tien = hdmh_thanh_tien;
    }
}
