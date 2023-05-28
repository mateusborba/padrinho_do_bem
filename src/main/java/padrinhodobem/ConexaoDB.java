package padrinhodobem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author herbert
 */
public class ConexaoDB {
  private static String host = "localhost";
  private static String porta = "3306";
  private static String db = "db_cursos";
  private static String usuario = "root";
  private static String senha = "usjt";

  public static Connection ObterConexao() throws Exception {

    String url = String.format("jdbc:mysql://%s:%s/%s?useTimezone=true&serverTimezone=UTC", host, porta, db);

    return DriverManager.getConnection(url, usuario, senha);

  }

}
