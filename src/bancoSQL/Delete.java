package bancoSQL;

import java.sql.*;

public class Delete {
    
    public Delete() {
        RemoveRegistrosUsuarios();
    }
    
    private void RemoveRegistrosUsuarios() {
        Statement stmt = null;
        String sql = null;
        
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            try ( // Cria conexao com o banco
                    Connection c = conn.getConexaoMySQL()) {
                c.setAutoCommit(false);
                
                stmt = c.createStatement();
                sql = "DROP TABLE USUARIOS;";
                stmt.executeUpdate(sql);
                c.commit();
                
                stmt = c.createStatement();
                sql = "DROP TABLE RECOMPENSAS;";
                stmt.executeUpdate(sql);
                c.commit();
                
                stmt = c.createStatement();
                sql = "DROP TABLE META_EDUCACAO;";
                stmt.executeUpdate(sql);
                c.commit();
                
                stmt = c.createStatement();
                sql = "DROP TABLE META_LEITURA;";
                stmt.executeUpdate(sql);
                c.commit();
                
                stmt = c.createStatement();
                sql = "DROP TABLE META_ALIMENTACAO;";
                stmt.executeUpdate(sql);
                c.commit();
                
                stmt = c.createStatement();
                sql = "DROP TABLE META_ESPORTE;";
                stmt.executeUpdate(sql);
                c.commit();
                
                stmt = c.createStatement();
                sql = "DROP TABLE META_OUTROS;";
                stmt.executeUpdate(sql);
                c.commit();
                
                stmt.close();
            }
        } catch ( SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }  
    }
    

}
