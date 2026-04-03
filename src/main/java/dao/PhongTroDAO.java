package dao;

import model.PhongTro;

import java.sql.SQLException;
import java.util.List;

public interface PhongTroDAO {
    List<PhongTro> findAll() throws SQLException;
    PhongTro findById(String id) throws SQLException;
    List<PhongTro> findByName(String name) throws SQLException;
    List<PhongTro> findByKhuTro(String name) throws SQLException;
    boolean update(PhongTro phongTro) throws SQLException;
    boolean delete (String id) throws SQLException;
    boolean insert (PhongTro phongTro) throws SQLException;
}
