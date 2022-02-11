package model;

import java.time.LocalDate;

public class Pet_kh {
    private int pkh_id;
    private String pkh_amh;
    private String pkh_ten;
    private LocalDate pkh_ngay_sinh;
    private String pkh_mo_ta;
    private int pkh_kh_id;
    private String pkh_gp_id;

    public Pet_kh(int pkh_id, String pkh_amh, String pkh_ten, LocalDate pkh_ngay_sinh, String pkh_mo_ta, int pkh_kh_id, String pkh_gp_id) {
        this.pkh_id = pkh_id;
        this.pkh_amh = pkh_amh;
        this.pkh_ten = pkh_ten;
        this.pkh_ngay_sinh = pkh_ngay_sinh;
        this.pkh_mo_ta = pkh_mo_ta;
        this.pkh_kh_id = pkh_kh_id;
        this.pkh_gp_id = pkh_gp_id;
    }

    public Pet_kh(String pkh_amh, String pkh_ten, LocalDate pkh_ngay_sinh, String pkh_mo_ta, int pkh_kh_id, String pkh_gp_id) {
        this.pkh_amh = pkh_amh;
        this.pkh_ten = pkh_ten;
        this.pkh_ngay_sinh = pkh_ngay_sinh;
        this.pkh_mo_ta = pkh_mo_ta;
        this.pkh_kh_id = pkh_kh_id;
        this.pkh_gp_id = pkh_gp_id;
    }

    public Pet_kh(String pkh_ten, LocalDate pkh_ngay_sinh, String pkh_mo_ta, int pkh_kh_id, String pkh_gp_id) {
        this.pkh_ten = pkh_ten;
        this.pkh_ngay_sinh = pkh_ngay_sinh;
        this.pkh_mo_ta = pkh_mo_ta;
        this.pkh_kh_id = pkh_kh_id;
        this.pkh_gp_id = pkh_gp_id;
    }

    public int getPkh_id() {
        return pkh_id;
    }

    public void setPkh_id(int pkh_id) {
        this.pkh_id = pkh_id;
    }

    public String getPkh_amh() {
        return pkh_amh;
    }

    public void setPkh_amh(String pkh_amh) {
        this.pkh_amh = pkh_amh;
    }

    public String getPkh_ten() {
        return pkh_ten;
    }

    public void setPkh_ten(String pkh_ten) {
        this.pkh_ten = pkh_ten;
    }

    public LocalDate getPkh_ngay_sinh() {
        return pkh_ngay_sinh;
    }

    public void setPkh_ngay_sinh(LocalDate pkh_ngay_sinh) {
        this.pkh_ngay_sinh = pkh_ngay_sinh;
    }

    public String getPkh_mo_ta() {
        return pkh_mo_ta;
    }

    public void setPkh_mo_ta(String pkh_mo_ta) {
        this.pkh_mo_ta = pkh_mo_ta;
    }

    public int getPkh_kh_id() {
        return pkh_kh_id;
    }

    public void setPkh_kh_id(int pkh_kh_id) {
        this.pkh_kh_id = pkh_kh_id;
    }

    public String getPkh_gp_id() {
        return pkh_gp_id;
    }

    public void setPkh_gp_id(String pkh_gp_id) {
        this.pkh_gp_id = pkh_gp_id;
    }
}
