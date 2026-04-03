package model;

public class KhuTro {
    private String maKhu;
    private String tenKhu;
    private String diaChi;
    private String chuSoHuu;

    public KhuTro(String maKhu, String tenKhu, String diaChi, String chuSoHuu) {
        this.maKhu = maKhu;
        this.tenKhu = tenKhu;
        this.diaChi = diaChi;
        this.chuSoHuu = chuSoHuu;
    }

    public KhuTro() {
    }

    public String getMaKhu() {
        return maKhu;
    }

    public void setMaKhu(String maKhu) {
        this.maKhu = maKhu;
    }

    public String getTenKhu() {
        return tenKhu;
    }

    public void setTenKhu(String tenKhu) {
        this.tenKhu = tenKhu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }
}
