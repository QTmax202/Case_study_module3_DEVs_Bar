package model;

public class Account {
    private int acc_id;
    private String acc_username;
    private String acc_password;
    private String acc_phan_cap;
    private int acc_kh_id;
    private String acc_nv_id;

    public Account() {
    }

    public Account(String acc_password, String acc_nv_id) {
        this.acc_password = acc_password;
        this.acc_nv_id = acc_nv_id;
    }

    public Account(String acc_password, int acc_kh_id) {
        this.acc_password = acc_password;
        this.acc_kh_id = acc_kh_id;
    }

    public Account(String acc_username, String acc_password, String acc_phan_cap, int acc_kh_id) {
        this.acc_username = acc_username;
        this.acc_password = acc_password;
        this.acc_phan_cap = acc_phan_cap;
        this.acc_kh_id = acc_kh_id;
    }

    public Account(String acc_username, String acc_password, String acc_phan_cap, String acc_nv_id) {
        this.acc_username = acc_username;
        this.acc_password = acc_password;
        this.acc_phan_cap = acc_phan_cap;
        this.acc_nv_id = acc_nv_id;
    }

    public Account(int acc_id, String acc_username, String acc_password, String acc_phan_cap, int acc_kh_id, String acc_nv_id) {
        this.acc_id = acc_id;
        this.acc_username = acc_username;
        this.acc_password = acc_password;
        this.acc_phan_cap = acc_phan_cap;
        this.acc_kh_id = acc_kh_id;
        this.acc_nv_id = acc_nv_id;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public String getAcc_username() {
        return acc_username;
    }

    public void setAcc_username(String acc_username) {
        this.acc_username = acc_username;
    }

    public String getAcc_password() {
        return acc_password;
    }

    public void setAcc_password(String acc_password) {
        this.acc_password = acc_password;
    }

    public String getAcc_phan_cap() {
        return acc_phan_cap;
    }

    public void setAcc_phan_cap(String acc_phan_cap) {
        this.acc_phan_cap = acc_phan_cap;
    }

    public int getAcc_kh_id() {
        return acc_kh_id;
    }

    public void setAcc_kh_id(int acc_kh_id) {
        this.acc_kh_id = acc_kh_id;
    }

    public String getAcc_nv_id() {
        return acc_nv_id;
    }

    public void setAcc_nv_id(String acc_nv_id) {
        this.acc_nv_id = acc_nv_id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "acc_id=" + acc_id +
                ", acc_username='" + acc_username + '\'' +
                ", acc_password='" + acc_password + '\'' +
                ", acc_phan_cap='" + acc_phan_cap + '\'' +
                ", acc_kh_id=" + acc_kh_id +
                ", acc_nv_id='" + acc_nv_id + '\'' +
                '}';
    }
}
