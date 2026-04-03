package impl;

import dao.KhuTroDAO;
import db.DBConnection;
import model.KhuTro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KhuTroImpl implements KhuTroDAO {
    @Override
    public List<KhuTro> findAll() throws SQLException {
        List<KhuTro> list = new ArrayList<KhuTro>();
        String SQL = "SELECT * FROM khutro";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            list.add(new KhuTro(
                    rs.getString("MAKHU"),
                    rs.getString("TENKHU"),
                    rs.getString("DIACHI"),
                    rs.getString("CHUSOHUU")));
        }
        return list;
    }


    @Override
    public KhuTro findById(String id) throws SQLException {
        String SQL = "SELECT * FROM khutro WHERE MAKHU = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(SQL);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return new KhuTro(
                    rs.getString("MAKHU"),
                    rs.getString("TENKHU"),
                    rs.getString("DIACHI"),
                    rs.getString("CHUSOHUU"));
        }
        else  return null;
    }
}
