package model;

import java.time.LocalDate;
import java.util.Date;

public class Pet_shop {
    private int ps_id;
    private String ps_ten;
    private String ps_anh;
    private int ps_gia;
    private LocalDate ps_ngay_sinh;
    private String ps_mo_ta;
    private int ps_trang_thai;
    private String ps_gp_id;

    public Pet_shop(int ps_id, String ps_ten, String ps_anh, int ps_gia, LocalDate ps_ngay_sinh, String ps_mo_ta, int ps_trang_thai, String ps_gp_id) {
        this.ps_id = ps_id;
        this.ps_ten = ps_ten;
        this.ps_anh = ps_anh;
        this.ps_gia = ps_gia;
        this.ps_ngay_sinh = ps_ngay_sinh;
        this.ps_mo_ta = ps_mo_ta;
        this.ps_trang_thai = ps_trang_thai;
        this.ps_gp_id = ps_gp_id;
    }

    public Pet_shop(String ps_ten, String ps_anh, int ps_gia, LocalDate ps_ngay_sinh, String ps_mo_ta, int ps_trang_thai, String ps_gp_id) {
        this.ps_ten = ps_ten;
        this.ps_anh = ps_anh;
        this.ps_gia = ps_gia;
        this.ps_ngay_sinh = ps_ngay_sinh;
        this.ps_mo_ta = ps_mo_ta;
        this.ps_trang_thai = ps_trang_thai;
        this.ps_gp_id = ps_gp_id;
    }

    public int getPs_id() {
        return ps_id;
    }

    public void setPs_id(int ps_id) {
        this.ps_id = ps_id;
    }

    public String getPs_ten() {
        return ps_ten;
    }

    public void setPs_ten(String ps_ten) {
        this.ps_ten = ps_ten;
    }

    public String getPs_anh() {
        return ps_anh;
    }

    public void setPs_anh(String ps_anh) {
        this.ps_anh = ps_anh;
    }

    public int getPs_gia() {
        return ps_gia;
    }

    public void setPs_gia(int ps_gia) {
        this.ps_gia = ps_gia;
    }

    public LocalDate getPs_ngay_sinh() {
        return ps_ngay_sinh;
    }

    public void setPs_ngay_sinh(LocalDate ps_ngay_sinh) {
        this.ps_ngay_sinh = ps_ngay_sinh;
    }

    public String getPs_mo_ta() {
        return ps_mo_ta;
    }

    public void setPs_mo_ta(String ps_mo_ta) {
        this.ps_mo_ta = ps_mo_ta;
    }

    public int getPs_trang_thai() {
        return ps_trang_thai;
    }

    public void setPs_trang_thai(int ps_trang_thai) {
        this.ps_trang_thai = ps_trang_thai;
    }

    public String getPs_gp_id() {
        return ps_gp_id;
    }

    public void setPs_gp_id(String ps_gp_id) {
        this.ps_gp_id = ps_gp_id;
    }

    @Override
    public String toString() {
        return "pet_shop{" +
                "ps_id=" + ps_id +
                ", ps_ten='" + ps_ten + '\'' +
                ", ps_anh='" + ps_anh + '\'' +
                ", ps_gia=" + ps_gia +
                ", ps_ngay_sinh=" + ps_ngay_sinh +
                ", ps_mo_ta='" + ps_mo_ta + '\'' +
                ", ps_trang_thai=" + ps_trang_thai +
                ", ps_gp_id='" + ps_gp_id + '\'' +
                '}';
    }
}
