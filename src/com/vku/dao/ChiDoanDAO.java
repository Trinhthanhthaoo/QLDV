package com.vku.dao;

import com.vku.common.Database;
import com.vku.model.ChiDoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChiDoanDAO {
    public static List<ChiDoan> getAll() {
        List<ChiDoan> chiDoans = new ArrayList<>();

        try {
            String sql = "SELECT * FROM chi_doan"; 
            PreparedStatement ps = Database.getConnection().prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String id = rs.getString("id"); 
                String tenChiDoan = rs.getString("ten_chi_doan");  
                String moTa = rs.getString("mo_ta");  

                // Tạo đối tượng ChiDoan và thêm vào danh sách
                ChiDoan chiDoan = new ChiDoan(id, tenChiDoan, moTa);
                chiDoans.add(chiDoan);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ChiDoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return chiDoans;
    }
    
    
   public static boolean insert(String tenChiDoan, String moTa) {
    String sql = "INSERT INTO chi_doan (ten_chi_doan, mo_ta) VALUES (?, ?)";
    
    try (Connection conn = Database.getConnection(); 
         PreparedStatement ps = conn.prepareStatement(sql)) {
        
        // Gán giá trị cho các tham số trong câu lệnh SQL
        ps.setString(1, tenChiDoan);
        ps.setString(2, moTa);
        
        // Thực thi câu lệnh INSERT
        int rowsAffected = ps.executeUpdate();
        
        // Nếu có ít nhất một dòng bị ảnh hưởng, tức là thêm thành công
        return rowsAffected > 0;
        
    } catch (SQLException ex) {
        Logger.getLogger(ChiDoanDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return false;
}

    
     public static boolean update(ChiDoan chiDoan) {
        String sql = "UPDATE chi_doan SET ten_chi_doan = ?, mo_ta = ? WHERE id = ?";
        try (PreparedStatement ps = Database.getConnection().prepareStatement(sql)) {
            ps.setString(1, chiDoan.getTen_chi_doan());
            ps.setString(2, chiDoan.getMo_ta());
            ps.setString(3, chiDoan.getId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ChiDoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
      public static boolean delete(String id) {
        String sql = "DELETE FROM chi_doan WHERE id = ?";
        try (PreparedStatement ps = Database.getConnection().prepareStatement(sql)) {
            ps.setString(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ChiDoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static List<ChiDoan> getSearch(String keyword) {
    List<ChiDoan> chiDoans = new ArrayList<>();

    try {
     
        String sql = "SELECT * FROM chi_doan WHERE ten_chi_doan LIKE ? OR mo_ta LIKE ?";
        PreparedStatement ps = Database.getConnection().prepareStatement(sql);
        ps.setString(1, "%" + keyword + "%"); 
        ps.setString(2, "%" + keyword + "%");  
        
        ResultSet rs = ps.executeQuery();

   
        while (rs.next()) {
            String id = rs.getString("id"); 
            String tenChiDoan = rs.getString("ten_chi_doan");
            String moTa = rs.getString("mo_ta");

            ChiDoan chiDoan = new ChiDoan(id, tenChiDoan, moTa);
            chiDoans.add(chiDoan);
        }

    } catch (SQLException ex) {
        Logger.getLogger(ChiDoanDAO.class.getName()).log(Level.SEVERE, null, ex);
    }

    return chiDoans;
}

}
