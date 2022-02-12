package model;

public class Phu_kien {
    private String pk_id;
    private String pk_ten;
    private String pk_anh;
    private int pk_gia;
    private int pk_so_luong;
    private String pk_mo_ta;
    private String pk_lpk_id;

    public Phu_kien(String pk_id, String pk_ten, String pk_anh, int pk_gia, int pk_so_luong, String pk_mo_ta, String pk_lpk_id) {
        this.pk_id = pk_id;
        this.pk_ten = pk_ten;
        this.pk_anh = pk_anh;
        this.pk_gia = pk_gia;
        this.pk_so_luong = pk_so_luong;
        this.pk_mo_ta = pk_mo_ta;
        this.pk_lpk_id = pk_lpk_id;
    }

    public Phu_kien(String pk_id, String pk_ten, int pk_gia, int pk_so_luong, String pk_mo_ta, String pk_lpk_id) {
        this.pk_id = pk_id;
        this.pk_ten = pk_ten;
        this.pk_gia = pk_gia;
        this.pk_so_luong = pk_so_luong;
        this.pk_mo_ta = pk_mo_ta;
        this.pk_lpk_id = pk_lpk_id;
    }

    public String getPk_id() {
        return pk_id;
    }

    public void setPk_id(String pk_id) {
        this.pk_id = pk_id;
    }

    public String getPk_ten() {
        return pk_ten;
    }

    public void setPk_ten(String pk_ten) {
        this.pk_ten = pk_ten;
    }

    public String getPk_anh() {
        return pk_anh;
    }

    public void setPk_anh(String pk_anh) {
        this.pk_anh = pk_anh;
    }

    public int getPk_gia() {
        return pk_gia;
    }

    public void setPk_gia(int pk_gia) {
        this.pk_gia = pk_gia;
    }

    public int getPk_so_luong() {
        return pk_so_luong;
    }

    public void setPk_so_luong(int pk_so_luong) {
        this.pk_so_luong = pk_so_luong;
    }

    public String getPk_mo_ta() {
        return pk_mo_ta;
    }

    public void setPk_mo_ta(String pk_mo_ta) {
        this.pk_mo_ta = pk_mo_ta;
    }

    public String getPk_lpk_id() {
        return pk_lpk_id;
    }

    public void setPk_lpk_id(String pk_lpk_id) {
        this.pk_lpk_id = pk_lpk_id;
    }
}
