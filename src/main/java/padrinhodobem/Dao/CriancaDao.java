package padrinhodobem.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import padrinhodobem.entity.Crianca;

/**
 *
 * @author herbert
 */
public class CriancaDao implements DaoInterface<Crianca>{

    @Override
    public Optional<Crianca> get(int id) throws Exception {
        
        String sql = "SELECT * FROM crianca WHERE id = ?;";
        
        try(Connection conn = DbConnection.ObterConexao()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()){
                
                rs.next();
                
                return Optional.ofNullable(new Crianca(
                        rs.getInt("id"), 
                        rs.getString("nome"), 
                        rs.getString("historia"), 
                        rs.getString("local"), 
                        rs.getInt("idade")
                ));
            }
        }
    }

    @Override
    public List<Crianca> getAll() throws Exception {
        
        List<Crianca> criancas = new ArrayList<>();
        
        String sql = "SELECT * FROM crianca;";
        
        try(Connection conn = DbConnection.ObterConexao()) {
        
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                criancas.add(new  Crianca(
                        rs.getInt("id"), 
                        rs.getString("nome"), 
                        rs.getString("historia"), 
                        rs.getString("local"), 
                        rs.getInt("idade")
                ));
            }
            
            return criancas;
        
        }
        
        
    }

    @Override
    public void save(Crianca t) throws Exception {
        
        String createSql = "INSERT INTO `crianca`(nome, idade, historia, local) VALUES (?,?,?,?);";
        String updateSql = "REPLACE INTO `usuario` (id, nome, idade, historia, local) VALUES (?,?,?,?,?)";
     
      
        try (Connection conn = DbConnection.ObterConexao()) {

            PreparedStatement ps;
            
            int currentId = t.getId();
            int i = 1;

            
            if(currentId == 0) ps = conn.prepareStatement(createSql, Statement.RETURN_GENERATED_KEYS);
            else {
                ps = conn.prepareStatement(updateSql);
                ps.setInt(i++, currentId);
            }
            
            ps.setString(i++, t.getNome());
            ps.setInt(i++, t.getIdade());
            ps.setString(i++, t.getHistoria());
            ps.setString(i++, t.getLocal());
            
            int affectedRows = ps.executeUpdate();
            
            if(currentId == 0){
                if (affectedRows == 0) {
                    System.out.println("No rows inserted.");
                } else {
                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int insertedId = generatedKeys.getInt(1);
                            System.out.println("Inserted ID: " + insertedId);
                        }
                    }
                }
            }else {
                ps.execute();
            }
        }
      
    }

    @Override
    public void update(Crianca t, String[] params) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Crianca t) throws Exception {
        String sql = "DELETE FROM crianca WHERE id = ?";
        
        try (Connection conn = DbConnection.ObterConexao()){
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, t.getId());
            
            ps.execute();
        }
    }
    
    
    
    
}
