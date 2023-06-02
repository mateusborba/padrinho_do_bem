
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padrinhodobem.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import padrinhodobem.entity.Apadrinhamento;
import padrinhodobem.entity.Crianca;
import padrinhodobem.entity.Usuario;

/**
 *
 * @author herbert
 */
public class ApadrinhamentoDao implements DaoInterface<Apadrinhamento>{

    @Override
    public Optional<Apadrinhamento> get(int id) throws Exception {
        
        String sql = "SELECT * FROM apadrinhamento WHERE id = ?;";
        
        try(Connection conn = DbConnection.ObterConexao()){
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()){
                
                rs.next();
                
                return Optional.ofNullable(new Apadrinhamento(
                        rs.getInt("id"), 
                        rs.getTimestamp("data_inicio").toInstant(), 
                        rs.getInt("tempo_meses"), 
                        rs.getInt("crianca_id"), 
                        rs.getInt("necessidade_id"), 
                        rs.getInt("usuario_id")
                ));
            }
        }
        
    }

    @Override
    public List<Apadrinhamento> getAll() throws Exception {
        
        List<Apadrinhamento> criancas = new ArrayList<>();
        
        String sql = "SELECT * FROM apadrinhamento;";
        
        try(Connection conn = DbConnection.ObterConexao()) {
        
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                criancas.add(new Apadrinhamento(
                        rs.getInt("id"), 
                        rs.getTimestamp("data_inicio").toInstant(), 
                        rs.getInt("tempo_meses"), 
                        rs.getInt("crianca_id"), 
                        rs.getInt("necessidade_id"), 
                        rs.getInt("usuario_id")
                ));
            }
            
            return criancas;
        
        }
        
    }
    
    public List<Apadrinhamento> getApadrinhamentosUsuario(Usuario user) throws Exception {
        
        List<Apadrinhamento> criancas = new ArrayList<>();
        
        String sql = "SELECT * FROM apadrinhamento where usuario_id = ?;";
        
        try(Connection conn = DbConnection.ObterConexao()) {
        
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1,user.getId());
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                criancas.add(new Apadrinhamento(
                        rs.getInt("id"), 
                        rs.getTimestamp("data_inicio").toInstant(), 
                        rs.getInt("tempo_meses"), 
                        rs.getInt("crianca_id"), 
                        rs.getInt("necessidade_id"), 
                        rs.getInt("usuario_id")
                ));
            }
            
            return criancas;
        
        }
        
    }
    
    public List<Apadrinhamento> getApadrinhamentosCrianca(Crianca c) throws Exception {
        
        List<Apadrinhamento> criancas = new ArrayList<>();
        
        String sql = "SELECT * FROM apadrinhamento where crianca_id = ?;";
        
        try(Connection conn = DbConnection.ObterConexao()) {
        
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setInt(1,c.getId());
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                criancas.add(new Apadrinhamento(
                        rs.getInt("id"), 
                        rs.getTimestamp("data_inicio").toInstant(), 
                        rs.getInt("tempo_meses"), 
                        rs.getInt("crianca_id"), 
                        rs.getInt("necessidade_id"), 
                        rs.getInt("usuario_id")
                ));
            }
            
            return criancas;
        
        }
        
    }

    @Override
    public void save(Apadrinhamento t) throws Exception {
    
        
        String createSql = "insert into `apadrinhamento` (`crianca_id`, `data_inicio`, `necessidade_id`, `tempo_meses`, `usuario_id`) values (?,?,?,?,?);";
        String updateSql = "REPLACE INTO `apadrinhamento` (`id`, `crianca_id`, `data_inicio`, `necessidade_id`, `tempo_meses`, `usuario_id`) values (?,?,?,?,?,?);";
     
      
        try (Connection conn = DbConnection.ObterConexao()) {

            PreparedStatement ps;
            
            int currentId = t.getId();
            int i = 1;

            
            if(currentId == 0) ps = conn.prepareStatement(createSql, Statement.RETURN_GENERATED_KEYS);
            else {
                ps = conn.prepareStatement(updateSql);
                ps.setInt(i++, currentId);
            }
            
            ps.setInt(i++, t.getCriancaId());
            ps.setTimestamp(i++, Timestamp.from(t.getDataInicio()));
            ps.setInt(i++, t.getNecessidadeId());
            ps.setInt(i++, t.getDuracao());
            ps.setInt(i++, t.getUsuarioId());
                        
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
    public void update(Apadrinhamento t, String[] params) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Apadrinhamento t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
    
    public static void main(String[] Args){
    
        var i = new ApadrinhamentoDao();
        
        try {
            System.out.println(i.get(1).get().getTempoString());            
            
            System.out.println(i.getAll());

        } catch (Exception ex) {
            Logger.getLogger(ApadrinhamentoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
