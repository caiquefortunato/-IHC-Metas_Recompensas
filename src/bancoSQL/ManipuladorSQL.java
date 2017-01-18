package bancoSQL;

import java.sql.Connection;

public class ManipuladorSQL {
    
    public static void main(String[] args) {
    
        // Cria uma instancia para a criacao do Banco de dados
        ConexaoMySQL conn = ConexaoMySQL.getConexao();
        
        // Cria conexao com o banco
        Connection conexao = conn.getConexaoMySQL();
       
        // Verifica funcionamento do banco
        System.out.println(conn.statusConection());
        
        // Apaga dados existentes
        Delete apagar = new Delete();
        
        // Cria tabelas
        Tabelas tabelas = new Tabelas();
        
    }
}
