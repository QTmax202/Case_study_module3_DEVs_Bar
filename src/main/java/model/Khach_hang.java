package model;

import java.util.Date;

public class Khach_hang {
    private String kh_id;
    private String kh_anh;
    private String kh_ten;
    private String kh_gioi_tinh;
    private String kh_email;
    private String kh_phone_number;
    private Date kh_ngay_sinh;
    private String kh_dia_chi;

    public Khach_hang() {
    }



    public Khach_hang(String kh_ten, String kh_gioi_tinh, String kh_phone_number, String kh_dia_chi) {
        this.kh_ten = kh_ten;
        this.kh_gioi_tinh = kh_gioi_tinh;
        this.kh_phone_number = kh_phone_number;
        this.kh_dia_chi = kh_dia_chi;
    }

    public Khach_hang(String kh_id, String kh_anh, String kh_ten, String kh_gioi_tinh, String kh_email, String kh_phone_number, Date kh_ngay_sinh, String kh_dia_chi) {
        this.kh_id = kh_id;
        this.kh_anh = kh_anh;
        this.kh_ten = kh_ten;
        this.kh_gioi_tinh = kh_gioi_tinh;
        this.kh_email = kh_email;
        this.kh_phone_number = kh_phone_number;
        this.kh_ngay_sinh = kh_ngay_sinh;
        this.kh_dia_chi = kh_dia_chi;
    }

    public Khach_hang(String kh_id, String kh_ten, String kh_gioi_tinh, String kh_phone_number, String kh_dia_chi) {
        this.kh_id = kh_id;
        this.kh_ten = kh_ten;
        this.kh_gioi_tinh = kh_gioi_tinh;
        this.kh_phone_number = kh_phone_number;
        this.kh_dia_chi = kh_dia_chi;
    }

    public String getKh_id() {
        return kh_id;
    }

    public void setKh_id(String kh_id) {
        this.kh_id = kh_id;
    }

    public String getKh_anh() {
        return kh_anh;
    }

    public void setKh_anh(String kh_anh) {
        this.kh_anh = kh_anh;
    }

    public String getKh_ten() {
        return kh_ten;
    }

    public void setKh_ten(String kh_ten) {
        this.kh_ten = kh_ten;
    }

    public String getKh_gioi_tinh() {
        return kh_gioi_tinh;
    }

    public void setKh_gioi_tinh(String kh_gioi_tinh) {
        this.kh_gioi_tinh = kh_gioi_tinh;
    }

    public String getKh_email() {
        return kh_email;
    }

    public void setKh_email(String kh_email) {
        this.kh_email = kh_email;
    }

    public String getKh_phone_number() {
        return kh_phone_number;
    }

    public void setKh_phone_number(String kh_phone_number) {
        this.kh_phone_number = kh_phone_number;
    }

    public Date getKh_ngay_sinh() {
        return kh_ngay_sinh;
    }

    public void setKh_ngay_sinh(Date kh_ngay_sinh) {
        this.kh_ngay_sinh = kh_ngay_sinh;
    }

    public String getKh_dia_chi() {
        return kh_dia_chi;
    }

    public void setKh_dia_chi(String kh_dia_chi) {
        this.kh_dia_chi = kh_dia_chi;
    }

    @Override
    public String toString() {
        return "Khach_hang{" +
                "kh_id=" + kh_id +
                ", kh_anh='" + kh_anh + '\'' +
                ", kh_ten='" + kh_ten + '\'' +
                ", kh_gioi_tinh='" + kh_gioi_tinh + '\'' +
                ", kh_email='" + kh_email + '\'' +
                ", kh_phone_number='" + kh_phone_number + '\'' +
                ", kh_ngay_sinh=" + kh_ngay_sinh +
                ", kh_dia_chi='" + kh_dia_chi + '\'' +
                '}';
    }
}
