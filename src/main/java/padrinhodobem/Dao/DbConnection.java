package padrinhodobem.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author herbert
 */
public class DbConnection {
  private static String host = "localhost";
  private static String porta = "3306";
  private static String db = "padrinho_do_bem_db";
  private static String usuario = "root";
  private static String senha = "mateus123";

  public static Connection ObterConexao() throws Exception {

    String url = String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC", host, porta, db);

    return DriverManager.getConnection(url, usuario, senha);

  }

}
