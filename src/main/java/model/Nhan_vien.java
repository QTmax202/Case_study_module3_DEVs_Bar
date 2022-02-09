package model;

import java.util.Date;

public class Nhan_vien {
    private String nv_id;
    private String nv_anh;
    private String nv_ten;
    private String nv_gioi_tinh;
    private String nv_email;
    private String nv_phone_number;
    private Date nv_ngay_sinh;
    private String nv_dia_chi;
    private String nv_ca_id;

    public Nhan_vien() {
    }

    public Nhan_vien(String nv_anh, String nv_ten, String nv_gioi_tinh, String nv_email, String nv_phone_number, Date nv_ngay_sinh, String nv_dia_chi, String nv_ca_id) {
        this.nv_anh = nv_anh;
        this.nv_ten = nv_ten;
        this.nv_gioi_tinh = nv_gioi_tinh;
        this.nv_email = nv_email;
        this.nv_phone_number = nv_phone_number;
        this.nv_ngay_sinh = nv_ngay_sinh;
        this.nv_dia_chi = nv_dia_chi;
        this.nv_ca_id = nv_ca_id;
    }

    public Nhan_vien(String nv_id, String nv_anh, String nv_ten, String nv_gioi_tinh, String nv_email, String nv_phone_number, Date nv_ngay_sinh, String nv_dia_chi, String nv_ca_id) {
        this.nv_id = nv_id;
        this.nv_anh = nv_anh;
        this.nv_ten = nv_ten;
        this.nv_gioi_tinh = nv_gioi_tinh;
        this.nv_email = nv_email;
        this.nv_phone_number = nv_phone_number;
        this.nv_ngay_sinh = nv_ngay_sinh;
        this.nv_dia_chi = nv_dia_chi;
        this.nv_ca_id = nv_ca_id;
    }

    public String getNv_id() {
        return nv_id;
    }

    public void setNv_id(String nv_id) {
        this.nv_id = nv_id;
    }

    public String getNv_anh() {
        return nv_anh;
    }

    public void setNv_anh(String nv_anh) {
        this.nv_anh = nv_anh;
    }

    public String getNv_ten() {
        return nv_ten;
    }

    public void setNv_ten(String nv_ten) {
        this.nv_ten = nv_ten;
    }

    public String getNv_gioi_tinh() {
        return nv_gioi_tinh;
    }

    public void setNv_gioi_tinh(String nv_gioi_tinh) {
        this.nv_gioi_tinh = nv_gioi_tinh;
    }

    public String getNv_email() {
        return nv_email;
    }

    public void setNv_email(String nv_email) {
        this.nv_email = nv_email;
    }

    public String getNv_phone_number() {
        return nv_phone_number;
    }

    public void setNv_phone_number(String nv_phone_number) {
        this.nv_phone_number = nv_phone_number;
    }

    public Date getNv_ngay_sinh() {
        return nv_ngay_sinh;
    }

    public void setNv_ngay_sinh(Date nv_ngay_sinh) {
        this.nv_ngay_sinh = nv_ngay_sinh;
    }

    public String getNv_dia_chi() {
        return nv_dia_chi;
    }

    public void setNv_dia_chi(String nv_dia_chi) {
        this.nv_dia_chi = nv_dia_chi;
    }

    public String getNv_ca_id() {
        return nv_ca_id;
    }

    public void setNv_ca_id(String nv_ca_id) {
        this.nv_ca_id = nv_ca_id;
    }

    @Override
    public String toString() {
        return "Nhan_vien{" +
                "nv_id='" + nv_id + '\'' +
                ", nv_anh='" + nv_anh + '\'' +
                ", nv_ten='" + nv_ten + '\'' +
                ", nv_gioi_tinh='" + nv_gioi_tinh + '\'' +
                ", nv_email='" + nv_email + '\'' +
                ", nv_phone_number='" + nv_phone_number + '\'' +
                ", nv_ngay_sinh=" + nv_ngay_sinh +
                ", nv_dia_chi='" + nv_dia_chi + '\'' +
                ", nv_ca_id='" + nv_ca_id + '\'' +
                '}';
    }
<<<<<<< HEAD
}
=======
<<<<<<< HEAD
}
=======
}
>>>>>>> 787db34e5fdd1ab57cc45903a38c1fe95afba508
>>>>>>> e39d7fcc2a539b80f6587e2e7cf41dcc08f75598
