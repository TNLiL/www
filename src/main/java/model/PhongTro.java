package model;

public class PhongTro {
    private String maPhong;
    private String tenPhong;
    private double giaThue;
    private double dienTich;
    private String hinhAnh;
    private KhuTro khuTro;

    public PhongTro(String maPhong, String tenPhong, double giaThue, double dienTich, String hinhAnh, KhuTro khuTro) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.giaThue = giaThue;
        this.dienTich = dienTich;
        this.hinhAnh = hinhAnh;
        this.khuTro = khuTro;
    }

    public PhongTro() {
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public double getGiaThue() {
        return giaThue;
    }

    public void setGiaThue(double giaThue) {
        this.giaThue = giaThue;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public KhuTro getKhuTro() {
        return khuTro;
    }

    public void setKhuTro(KhuTro khuTro) {
        this.khuTro = khuTro;
    }
}
