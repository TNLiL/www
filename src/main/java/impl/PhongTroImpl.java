package impl;

import dao.PhongTroDAO;
import db.DBConnection;
import model.KhuTro;
import model.PhongTro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhongTroImpl implements PhongTroDAO {
    public PhongTro mapRow(ResultSet rs) throws SQLException {
        return new PhongTro(
                rs.getString("MAPHONG"),
                rs.getString("TENPHONG"),
                rs.getDouble("GIATHUE"),
                rs.getDouble("DIENTICH"),
                rs.getString("HINHANH"),
                new KhuTro(
                rs.getString("MAKHU"),
                rs.getString("TENKHU"),
                rs.getString("DIACHI"),
                rs.getString("CHUSOHUU")));
    }
    @Override
    public List<PhongTro> findAll() throws SQLException {
        List<PhongTro> list = new ArrayList<PhongTro>();
        String SQL = "SELECT p.*, k.TENKHU, k.DIACHI, k.CHUSOHUU FROM phongtro p JOIN khutro k ON p.MAKHU = k.MAKHU";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            list.add(mapRow(rs));
        }
        return list;
    }

    @Override
    public PhongTro findById(String id) throws SQLException {
            String SQL = "SELECT p.*, k.TENKHU, k.DIACHI, k.CHUSOHUU FROM phongtro p JOIN khutro k ON p.MAKHU = k.MAKHU WHERE p.MAPHONG = ?";
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(SQL);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return mapRow(rs);
            }
            else  return null;

    }

    @Override
    public List<PhongTro> findByName(String name) throws SQLException {
        List<PhongTro> list = new ArrayList<PhongTro>();
        String SQL = "SELECT p.*, k.TENKHU, k.DIACHI, k.CHUSOHUU FROM phongtro p JOIN khutro k ON p.MAKHU = k.MAKHU WHERE p.TENPHONG like ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, '%' + name + '%');
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            list.add(mapRow(rs));
        }
        return list;
    }

    @Override
    public List<PhongTro> findByKhuTro(String maKhu) throws SQLException {
        List<PhongTro> list = new ArrayList<PhongTro>();
        String SQL = "SELECT p.*, k.TENKHU, k.DIACHI, k.CHUSOHUU FROM phongtro p JOIN khutro k ON p.MAKHU = k.MAKHU WHERE k.MAKHU = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1,maKhu );
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            list.add(mapRow(rs));
        }
        return list;
    }

    @Override
    public boolean update(PhongTro phongTro) throws SQLException {
        String SQL = "UPDATE phongtro SET TENPHONG = ?, GIATHUE = ?, DIENTICH = ?, HINHANH = ?, MAKHU = ? WHERE MAPHONG = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, phongTro.getTenPhong());
        ps.setDouble(2,phongTro.getGiaThue());
        ps.setDouble(3,phongTro.getDienTich());
        ps.setString(4, phongTro.getHinhAnh());
        ps.setString(5, phongTro.getKhuTro().getMaKhu());
        ps.setString(6, phongTro.getMaPhong());
        return ps.executeUpdate()>0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String SQL = "DELETE FROM phongtro WHERE MAPHONG = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, id);
        return ps.executeUpdate()>0;
    }

    @Override
    public boolean insert(PhongTro phongTro) throws SQLException {
        String SQL = "INSERT INTO phongtro (MAPHONG, TENPHONG, GIATHUE, DIENTICH, HINHANH, MAKHU) VALUES (?,?,?,?,?,?)";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, phongTro.getMaPhong());
        ps.setString(2, phongTro.getTenPhong());
        ps.setDouble(3,phongTro.getGiaThue());
        ps.setDouble(4,phongTro.getDienTich());
        ps.setString(5, phongTro.getHinhAnh());
        ps.setString(6, phongTro.getKhuTro().getMaKhu());
        return ps.executeUpdate()>0;
    }
}
