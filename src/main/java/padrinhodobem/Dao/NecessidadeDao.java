/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padrinhodobem.Dao;

import padrinhodobem.Dao.DbConnection;
import padrinhodobem.Dao.DaoInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import padrinhodobem.entity.Crianca;
import padrinhodobem.entity.Necessidade;
import padrinhodobem.entity.Usuario;

/**
 *
 * @author herbert
 */
public class NecessidadeDao implements DaoInterface<Necessidade> {

  private static final Logger LOG = Logger.getLogger(NecessidadeDao.class.getName());

  @Override
  public Optional<Necessidade> get(int id) throws Exception {

    String sql = "SELECT * FROM `necessidade` WHERE id = ?";

    try (Connection conn = DbConnection.ObterConexao()) {

      PreparedStatement ps = conn.prepareStatement(sql);

      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery()) {

        rs.next();

        return Optional.ofNullable(new Necessidade(
            rs.getInt("id"),
            rs.getString("tipo"),
            rs.getInt("crianca_id"))
        );
      }
    }
  }


  @Override
  public List<Necessidade> getAll() throws Exception {

    List<Necessidade> NecessidadeList = new ArrayList<>();

    String sql = "SELECT * FROM `necessidade`;";

    try (Connection conn = DbConnection.ObterConexao()) {

      PreparedStatement ps = conn.prepareStatement(sql);

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        NecessidadeList.add(new Necessidade(
                rs.getInt("id"),
            rs.getString("tipo"),
            rs.getInt("crianca_id")
        )
        );}


      return NecessidadeList;
    }

  }
  
  
  
  public List<Necessidade> getNecessidadeCrianca(Crianca crianca) throws Exception {

    List<Necessidade> NecessidadeCriancaList = new ArrayList<>();

    String sql = "SELECT * FROM `necessidade` where crianca_id = ? ;";

    try (Connection conn = DbConnection.ObterConexao()) {

      PreparedStatement ps = conn.prepareStatement(sql);
      
      ps.setInt(1, crianca.getId());

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        NecessidadeCriancaList.add(new Necessidade(
                rs.getInt("id"),
            rs.getString("tipo"),
            rs.getInt("crianca_id")
        )
        );}


      return NecessidadeCriancaList;
    }

  }
  
  public List<Necessidade> getNecessidadeDisponiveis(Crianca c, Usuario u) throws Exception {

    List<Necessidade> NecessidadeCriancaList = new ArrayList<>();

//    String sql = "SELECT * FROM `necessidade` ne \n" +
//        "left join apadrinhamento ap on ap.necessidade_id = ne.id\n" +
//        "where ne.crianca_id = ? and (ap.usuario_id is null or ap.usuario_id != ?);";
    
    String sql = "SELECT * FROM `necessidade` ne left join apadrinhamento ap on ap.necessidade_id = ne.id and ap.crianca_id = ne.crianca_id and ap.usuario_id = ? where ne.crianca_id = ? and ap.usuario_id is null;";

    try (Connection conn = DbConnection.ObterConexao()) {

      PreparedStatement ps = conn.prepareStatement(sql);
      
      ps.setInt(2, c.getId());      
      ps.setInt(1, u.getId());


      ResultSet rs = ps.executeQuery();


      while (rs.next()) {
        NecessidadeCriancaList.add(new Necessidade(
                rs.getInt("id"),
            rs.getString("tipo"),
            rs.getInt("crianca_id")
        )
        );}


      return NecessidadeCriancaList;
    }

  }
  

  @Override
  public void save(Necessidade t) throws Exception {

    String createSql = "INSERT INTO `necessidade`(tipo, crianca_id) VALUES (?,?);";
    String updateSql = "REPLACE INTO `necessidade` (id, tipo, crianca_id) VALUES (?,?,?)";

    try (Connection conn = DbConnection.ObterConexao()) {

      PreparedStatement ps;

      int currentId = t.getId();
      int i = 1;

      if (currentId == 0)
        ps = conn.prepareStatement(createSql, Statement.RETURN_GENERATED_KEYS);
      else {
        ps = conn.prepareStatement(updateSql);
        ps.setInt(i++, currentId);
      }

      ps.setString(i++, t.getTipo());
      ps.setInt(i++, t.GetCriancaId());

      int affectedRows = ps.executeUpdate();

      if (currentId == 0) {
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
      } else {
        ps.execute();
      }

    }

  }

  @Override
  public void update(Necessidade t, String[] params) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void delete(Necessidade t) throws Exception {
    String sql = "DELETE FROM necessidade WHERE id = ?";
    try (Connection conn = DbConnection.ObterConexao()) {

      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, t.getId());

      ps.execute();

    }

  }

}
