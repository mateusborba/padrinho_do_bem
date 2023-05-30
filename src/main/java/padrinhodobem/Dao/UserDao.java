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
import padrinhodobem.entity.Usuario;

/**
 *
 * @author herbert
 */
public class UserDao implements DaoInterface<Usuario> {

  private static final Logger LOG = Logger.getLogger(UserDao.class.getName());

  @Override
  public Optional<Usuario> get(int id) throws Exception {

    String sql = "SELECT * FROM `usuario` WHERE id = ?";

    try (Connection conn = DbConnection.ObterConexao()) {

      PreparedStatement ps = conn.prepareStatement(sql);

      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery()) {

        rs.next();

        return Optional.ofNullable(new Usuario(
            rs.getInt("id"),
            rs.getString("email"),
            rs.getString("cpf"),
            rs.getString("nome"),
            rs.getString("senha"),
            rs.getBoolean("type")));
      }
    }
  }

  public Optional<Usuario> getByCPF(String cpf) throws Exception {

    String sql = "SELECT * FROM `usuario` WHERE cpf = ?";

    try (Connection conn = DbConnection.ObterConexao()) {

      PreparedStatement ps = conn.prepareStatement(sql);

      ps.setString(1, cpf);
      try (ResultSet rs = ps.executeQuery()) {

        rs.next();

        return Optional.ofNullable(new Usuario(
            rs.getInt("id"),
            rs.getString("email"),
            rs.getString("cpf"),
            rs.getString("nome"),
            rs.getString("senha"),
            rs.getBoolean("type")));
      } finally {
        conn.close();
      }
    }

  }

  @Override
  public List<Usuario> getAll() throws Exception {

    List<Usuario> UsersList = new ArrayList<>();

    String sql = "SELECT * FROM `usuario`;";

    try (Connection conn = DbConnection.ObterConexao()) {

      PreparedStatement ps = conn.prepareStatement(sql);

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        UsersList.add(new Usuario(
            rs.getInt("id"),
            rs.getString("email"),
            rs.getString("cpf"),
            rs.getString("nome"),
            rs.getString("senha"),
            rs.getBoolean("type")));
      }

      System.out.println("Lista de usuarios: ");

      System.out.println(UsersList);

      return UsersList;
    }

  }

  @Override
  public void save(Usuario t) throws Exception {

    String createSql = "INSERT INTO `usuario`(cpf, nome, email, senha) VALUES (?,?,?,?);";
    String updateSql = "REPLACE INTO `usuario` (id, cpf, nome, email, senha) VALUES (?,?,?,?,?)";

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

      ps.setString(i++, t.getCpf());
      ps.setString(i++, t.getNome());
      ps.setString(i++, t.getEmail());
      ps.setString(i++, t.getSenha());

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
  public void update(Usuario t, String[] params) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void delete(Usuario t) throws Exception {
    String sql = "DELETE FROM usuario WHERE id = ?";
    try (Connection conn = DbConnection.ObterConexao()) {

      PreparedStatement ps = conn.prepareStatement(sql);
      ps.setInt(1, t.getId());

      ps.execute();

    }

  }

}
