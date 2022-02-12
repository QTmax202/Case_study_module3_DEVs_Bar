package model;

public class Giong_pet {
    private String gp_id;
    private String gp_ten;
    private String gp_mo_ta;
    private String gp_lp_id;

    public Giong_pet() {
    }

    public Giong_pet(String gp_id, String gp_ten, String gp_mo_ta, String gp_lp_id) {
        this.gp_id = gp_id;
        this.gp_ten = gp_ten;
        this.gp_mo_ta = gp_mo_ta;
        this.gp_lp_id = gp_lp_id;
    }

    public Giong_pet(String gp_ten, String gp_mo_ta, String gp_lp_id) {
        this.gp_ten = gp_ten;
        this.gp_mo_ta = gp_mo_ta;
        this.gp_lp_id = gp_lp_id;
    }

    public String getGp_id() {
        return gp_id;
    }

    public void setGp_id(String gp_id) {
        this.gp_id = gp_id;
    }

    public String getGp_ten() {
        return gp_ten;
    }

    public void setGp_ten(String gp_ten) {
        this.gp_ten = gp_ten;
    }

    public String gp_mo_ta() {
        return gp_mo_ta;
    }

    public void setGp_mo_ta(String gp_mo_ta) {
        this.gp_mo_ta = gp_mo_ta;
    }

    public String getGp_lp_id() {
        return gp_lp_id;
    }

    public void setGp_lp_id(String gp_lp_id) {
        this.gp_lp_id = gp_lp_id;
    }

    @Override
    public String toString() {
        return "giong_pet{" +
                "gp_id='" + gp_id + '\'' +
                ", gp_ten='" + gp_ten + '\'' +
                ", gp_mo_ta='" + gp_mo_ta + '\'' +
                ", gp_lp_id='" + gp_lp_id + '\'' +
                '}';
    }
}
