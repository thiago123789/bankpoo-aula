    package repositories;

    import java.sql.*;
    import java.util.logging.Level;
    import java.util.logging.Logger;

    public class DbConnection {

            private static DbConnection instance;
            private Connection conexao;
            private PreparedStatement statement;
            private ResultSet resultSet;

            static{
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (Exception e) {
                    System.out.println("Problemas carregando o Driver do MySQL");
                }
            }

            public static DbConnection getInstance(){
                if(instance == null){
                    instance = new DbConnection();
                }
                return instance;
            }

            private DbConnection(){
                try {
                    conexao = setConexao();
                } catch (SQLException ex) {
                    Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            private static Connection setConexao() throws SQLException {
                Connection retorno = null;
                retorno = DriverManager.getConnection(
                        "jdbc:mysql://127.0.0.1:3306/bank_poo?autoReconnect=true&useSSL=false", "root", "");
                retorno.setAutoCommit(true);
                return retorno;
            }

            public PreparedStatement retornoStatement(String query){
                try {
                    this.statement = (com.mysql.jdbc.PreparedStatement) this.conexao.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return this.statement;
            }

            public ResultSet comandoSQL(String query){
                try {
                    this.statement = (com.mysql.jdbc.PreparedStatement) this.conexao.prepareStatement(query);
                    this.resultSet = this.statement.executeQuery();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return this.resultSet;
            }

            public Connection getConexao(){
                return this.conexao;
            }

            public void closeConnection(){
                try {
                    this.conexao.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

    }
