package dao;

import model.KhuTro;

import java.sql.SQLException;
import java.util.List;

public interface KhuTroDAO {
    List<KhuTro> findAll() throws SQLException;
    KhuTro findById(String id) throws SQLException;
}
