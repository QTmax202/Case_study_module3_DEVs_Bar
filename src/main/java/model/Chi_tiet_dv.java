package model;

public class Chi_tiet_dv {
    private String ctdv_id;
    private String ctdv_anh;
    private String ctdv_ten;
    private int ctdv_gia;
    private String ctdv_mo_ta;
    private int ctdv_trang_thai;
    private String ctdv_dv_id;

    public Chi_tiet_dv() {
    }

    public Chi_tiet_dv(String ctdv_id, String ctdv_anh, String ctdv_ten, int ctdv_gia, String ctdv_mo_ta, int ctdv_trang_thai, String ctdv_dv_id) {
        this.ctdv_id = ctdv_id;
        this.ctdv_anh = ctdv_anh;
        this.ctdv_ten = ctdv_ten;
        this.ctdv_gia = ctdv_gia;
        this.ctdv_mo_ta = ctdv_mo_ta;
        this.ctdv_trang_thai = ctdv_trang_thai;
        this.ctdv_dv_id = ctdv_dv_id;
    }

    public Chi_tiet_dv(String ctdv_id, String ctdv_anh, String ctdv_ten, int ctdv_gia, String ctdv_mo_ta, int ctdv_trang_thai) {
        this.ctdv_id = ctdv_id;
        this.ctdv_anh = ctdv_anh;
        this.ctdv_ten = ctdv_ten;
        this.ctdv_gia = ctdv_gia;
        this.ctdv_mo_ta = ctdv_mo_ta;
        this.ctdv_trang_thai = ctdv_trang_thai;
    }

    public String getCtdv_id() {
        return ctdv_id;
    }

    public void setCtdv_id(String ctdv_id) {
        this.ctdv_id = ctdv_id;
    }

    public String getCtdv_anh() {
        return ctdv_anh;
    }

    public void setCtdv_anh(String ctdv_anh) {
        this.ctdv_anh = ctdv_anh;
    }

    public String getCtdv_ten() {
        return ctdv_ten;
    }

    public void setCtdv_ten(String ctdv_ten) {
        this.ctdv_ten = ctdv_ten;
    }

    public int getCtdv_gia() {
        return ctdv_gia;
    }

    public void setCtdv_gia(int ctdv_gia) {
        this.ctdv_gia = ctdv_gia;
    }

    public String getCtdv_mo_ta() {
        return ctdv_mo_ta;
    }

    public void setCtdv_mo_ta(String ctdv_mo_ta) {
        this.ctdv_mo_ta = ctdv_mo_ta;
    }

    public int getCtdv_trang_thai() {
        return ctdv_trang_thai;
    }

    public void setCtdv_trang_thai(int ctdv_trang_thai) {
        this.ctdv_trang_thai = ctdv_trang_thai;
    }

    public String getCtdv_dv_id() {
        return ctdv_dv_id;
    }

    public void setCtdv_dv_id(String ctdv_dv_id) {
        this.ctdv_dv_id = ctdv_dv_id;
    }

    @Override
    public String toString() {
        return "Chi_tiet_dv{" +
                "ctdv_id='" + ctdv_id + '\'' +
                ", ctdv_anh='" + ctdv_anh + '\'' +
                ", ctdv_ten='" + ctdv_ten + '\'' +
                ", ctdv_gia=" + ctdv_gia +
                ", ctdv_mo_ta='" + ctdv_mo_ta + '\'' +
                ", ctdv_trang_thai=" + ctdv_trang_thai +
                ", ctdv_dv_id='" + ctdv_dv_id + '\'' +
                '}';
    }
}
