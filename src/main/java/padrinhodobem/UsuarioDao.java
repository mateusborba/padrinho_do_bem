/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padrinhodobem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author herbert
 */
public class UsuarioDao implements Dao {
  
  private static final Logger LOG = Logger.getLogger(UsuarioDao.class.getName());
  
  @Override
  public Optional<Usuario> get(int id) throws Exception {

    String sql = "SELECT * FROM `usuario` WHERE id = ?";

    try (Connection conn = ConexaoDB.ObterConexao()) {

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
            rs.getBoolean("type")
        ));
      }
    }
  }

  public Optional<Usuario> getByEmail(String email) throws Exception {

    String sql = "SELECT * FROM `usuario` WHERE email = ?";

    try (Connection conn = ConexaoDB.ObterConexao()) {

      PreparedStatement ps = conn.prepareStatement(sql);

      ps.setString(1, email);
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

    try (Connection conn = ConexaoDB.ObterConexao()) {

      PreparedStatement ps = conn.prepareStatement(sql);

      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        UsersList.add(new Usuario(
            rs.getInt("id"),
            rs.getString("email"),
            rs.getString("cpf"),
            rs.getString("nome"),
            rs.getString("senha"),
            rs.getBoolean("type")
        ));
      }
    
      System.out.println("Lista de usuarios: ");

      System.out.println(UsersList);

      return UsersList;
    }

  }

    @Override
    public void save(Object t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  
  
  
    @Override
    public void saver(Usuario t) throws Exception {
    
        String sql = "INSERT INTO `usuario`(cpf, nome, email, senha) VALUES (?,?,?,?);";
     
      
        try (Connection conn = ConexaoDB.ObterConexao()) {

            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      
            ps.setString(1, t.getCpf());
            ps.setString(2, t.getNome());
            ps.setString(3, t.getEmail());
            ps.setString(4, t.getSenha());




            ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        UsersList.add(new Usuario(
            rs.getInt("id"),
            rs.getString("email"),
            rs.getString("cpf"),
            rs.getString("nome"),
            rs.getString("senha"),
            rs.getBoolean("type")
        ));
      }
    
      System.out.println("Lista de usuarios: ");

      System.out.println(UsersList);

      return UsersList;
    }
      
      
  }

  @Override
  public void update(Object t, String[] params) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void delete(Object t) {
    throw new UnsupportedOperationException("Not supported yet.");
  }


  // Main de test da conexão com o banco de dados, ToDo Implementar um método de teste da classe 
  public static void main(String[] args) {
    try {
      var userDao = new UsuarioDao();

      var listaDeUsuarios = userDao.getAll();

      LOG.log(Level.SEVERE, "Lista de Usuarios do sistema", listaDeUsuarios);
    } catch (Exception ex) {
      Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

}
