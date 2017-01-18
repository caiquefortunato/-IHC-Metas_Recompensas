package bancoSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tabelas {
    
    public Tabelas() {
        criarTabelaUsuario();
        criarTabelaRecompensa();
        criarTabelaMetaEducacao();
        criarTabelaMetaLeitura();
        criarTabelaMetaAlimentacao();
        criarTabelaMetaEsporte();
        criarTabelaOutros();
    }
    
    private void criarTabelaUsuario() {
        
        Statement stmt = null;
        // Cria uma instancia para a criacao do Banco de dados
        ConexaoMySQL conn = ConexaoMySQL.getConexao();
        // Cria conexao com o banco
        Connection conexao = conn.getConexaoMySQL();
        
        try {
            stmt = conexao.createStatement();
            String sql = "CREATE TABLE USUARIOS " +
                        "(USERNAME  TEXT    PRIMARY KEY NOT NULL," +
                        " NOME      TEXT    NOT NULL, " + 
                        " SENHA     TEXT    NOT NULL, " +
                        " EMAIL     TEXT    NOT NULL, " +
                        " EXPERIENCIA     INTEGER    NOT NULL)"; 
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    
    private void criarTabelaRecompensa() {
        
        Statement stmt = null;
        // Cria uma instancia para a criacao do Banco de dados
        ConexaoMySQL conn = ConexaoMySQL.getConexao();
        // Cria conexao com o banco
        Connection conexao = conn.getConexaoMySQL();
        
        try {
            stmt = conexao.createStatement();
            String sql = "CREATE TABLE RECOMPENSAS " +
                        "(id_Recompensa INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                        " USER          TEXT        KEY NOT NULL, " + 
                        " TITULO        TEXT        NOT NULL, " + 
                        " DESCRICAO     TEXT        NOT NULL, " +
                        " XP            INTEGER     NOT NULL, " +
                        " FOREIGN KEY(USER) REFERENCES USUARIOS(USERNAME));"; 
            
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }        
    }
    
    private void criarTabelaMetaEducacao() {

        Statement stmt = null;
        // Cria uma instancia para a criacao do Banco de dados
        ConexaoMySQL conn = ConexaoMySQL.getConexao();
        // Cria conexao com o banco
        Connection conexao = conn.getConexaoMySQL();

        try {
            stmt = conexao.createStatement();
            String sql = "CREATE TABLE META_EDUCACAO " +
                        "(id_Edu INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                        " USER          TEXT        KEY NOT NULL, " +
                        " TITULO            TEXT        NOT NULL, " + 
                        " DESCRICAO         TEXT        NOT NULL, " + 
                        " DEDICACAO         INTEGER        NOT NULL, " +
                        " DISCIPLINA        TEXT        NOT NULL, " +
                        " DIFICULDADE       INTEGER     NOT NULL, " +
                        " FOREIGN KEY(USER) REFERENCES USUARIOS(USERNAME));"; 

            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }        
    }
    
    private void criarTabelaMetaLeitura() {

        Statement stmt = null;
        // Cria uma instancia para a criacao do Banco de dados
        ConexaoMySQL conn = ConexaoMySQL.getConexao();
        // Cria conexao com o banco
        Connection conexao = conn.getConexaoMySQL();

        try {
            stmt = conexao.createStatement();
            String sql = "CREATE TABLE META_LEITURA " +
                        "(id_leitura INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                        " USER          TEXT        KEY NOT NULL, " +
                        " TITULO            TEXT        NOT NULL, " + 
                        " DESCRICAO         TEXT        NOT NULL, " + 
                        " DEDICACAO         INTEGER        NOT NULL, " +
                        " DIFICULDADE       INTEGER     NOT NULL, " +
                        " NOME_LIVRO        TEXT        NOT NULL, " +
                        " ASSUNTO_LIVRO        TEXT        NOT NULL, " +
                        " PG_DIA       INTEGER     NOT NULL, " +
                        " FOREIGN KEY(USER) REFERENCES USUARIOS(USERNAME));"; 

            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }        
    }

    private void criarTabelaMetaAlimentacao() {

        Statement stmt = null;
        // Cria uma instancia para a criacao do Banco de dados
        ConexaoMySQL conn = ConexaoMySQL.getConexao();
        // Cria conexao com o banco
        Connection conexao = conn.getConexaoMySQL();

        try {
            stmt = conexao.createStatement();
            String sql = "CREATE TABLE META_ALIMENTACAO " +
                        "(id_alimentacao INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                        " USER          TEXT        KEY NOT NULL, " +
                        " TITULO            TEXT        NOT NULL, " + 
                        " DESCRICAO         TEXT        NOT NULL, " + 
                        " DIFICULDADE         INTEGER        NOT NULL, " +
                        " NOME_COMIDA       TEXT     , " +
                        " NOME_BEBIDA        TEXT       , " +
                        " VEZES_DIA        INTEGER        NOT NULL, " +
                        " FOREIGN KEY(USER) REFERENCES USUARIOS(USERNAME));"; 

            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }        
    }
    
    private void criarTabelaMetaEsporte() {

        Statement stmt = null;
        // Cria uma instancia para a criacao do Banco de dados
        ConexaoMySQL conn = ConexaoMySQL.getConexao();
        // Cria conexao com o banco
        Connection conexao = conn.getConexaoMySQL();

        try {
            stmt = conexao.createStatement();
            String sql = "CREATE TABLE META_ESPORTE " +
                        "(id_metaEsporte INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                        " USER              TEXT        KEY NOT NULL, " +
                        " TITULO            TEXT        NOT NULL, " + 
                        " DESCRICAO         TEXT        NOT NULL, " + 
                        " DIFICULDADE       INTEGER        NOT NULL, " +
                        " NOME_ESPORTE      TEXT     NOT NULL, " +
                        " KM                INTEGER        , " +
                        " TEMPO_PRATICADO   INTEGER        , " +
                        " VEZES_SEMANA      INTEGER     NOT NULL, " +
                        " FOREIGN KEY(USER) REFERENCES USUARIOS(USERNAME));"; 

            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }        
    }
    
    private void criarTabelaOutros() {

        Statement stmt = null;
        // Cria uma instancia para a criacao do Banco de dados
        ConexaoMySQL conn = ConexaoMySQL.getConexao();
        // Cria conexao com o banco
        Connection conexao = conn.getConexaoMySQL();

        try {
            stmt = conexao.createStatement();
            String sql = "CREATE TABLE META_OUTROS " +
                        "(id_outros INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                        " USER              TEXT        KEY NOT NULL, " +
                        " TITULO            TEXT        NOT NULL, " + 
                        " DESCRICAO         TEXT        NOT NULL, " + 
                        " DIFICULDADE       INTEGER        NOT NULL, " +
                        " NOME_CATEGORIA      TEXT   , " +
                        " DIAS                INTEGER   NOT NULL, " +
                        " FOREIGN KEY(USER) REFERENCES USUARIOS(USERNAME));"; 

            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }        
    }    
    
    
}
