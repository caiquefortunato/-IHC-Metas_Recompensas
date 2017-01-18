package OperacoesBancoSQL;

import Entidades.OutrasMetas;
import Entidades.Recompensa;
import Entidades.Usuario;
import bancoSQL.ConexaoMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelecaoBanco {
    
    private boolean retorno = false;

    public SelecaoBanco() {

    }

    public void listarMetas(Usuario user) {
        Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            try ( // Cria conexao com o banco
                    Connection c = conn.getConexaoMySQL()) {
                c.setAutoCommit(false);

                stmt = c.createStatement();
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIOS;")) {
                    while (rs.next()) {
                        String username = rs.getString("USERNAME");
                        String nome = rs.getString("NOME");
                        String senha = rs.getString("SENHA");
                        String email = rs.getString("EMAIL");

                        if (username.equals(user.getUsername())) {
                            user.setNome(nome);
                            user.setSenha(senha);
                            user.setEmail(email);
                        }
                    }
                }
                stmt.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void preencherCamposUsuario(Usuario user) {
        Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            try ( // Cria conexao com o banco
                    Connection c = conn.getConexaoMySQL()) {
                c.setAutoCommit(false);
                
                stmt = c.createStatement();
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIOS;")) {
                    while (rs.next()) {
                        String username = rs.getString("USERNAME");
                        String nome = rs.getString("NOME");
                        String senha = rs.getString("SENHA");
                        String email = rs.getString("EMAIL");
                        int xp = rs.getInt("EXPERIENCIA");
                        
                        if (username.equals(user.getUsername())) {
                            user.setNome(nome);
                            user.setSenha(senha);
                            user.setEmail(email);
                            user.setExperiencia(xp);
                        }
                    }
                }
                stmt.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public boolean conferirEmail(String email) {
        Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            try ( // Cria conexao com o banco
                    Connection c = conn.getConexaoMySQL()) {
                c.setAutoCommit(false);
                
                stmt = c.createStatement();
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIOS;")) {
                    while (rs.next()) {
                        String emailBanco = rs.getString("EMAIL");
                        
                        if (emailBanco.equals(email)) {
                            retorno = true;
                        }
                    }
                }
                stmt.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return retorno;
    }

    public Usuario enviarDados(String emailUsuario) {
        Usuario user = Usuario.getUsuarioAtivo();

        Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            try ( // Cria conexao com o banco
                    Connection c = conn.getConexaoMySQL()) {
                c.setAutoCommit(false);
                
                stmt = c.createStatement();
                try (ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIOS;")) {
                    while (rs.next()) {
                        String username = rs.getString("USERNAME");
                        String nome = rs.getString("NOME");
                        String senha = rs.getString("SENHA");
                        String email = rs.getString("EMAIL");
                        
                        if (emailUsuario.equals(email)) {
                            user.setNome(nome);
                            user.setSenha(senha);
                            user.setUsername(username);
                        }
                        
                    }
                }
                stmt.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        return user;
    }

    public static OutrasMetas metasInfo(String metaNome, int categoria, Connection connection) throws SQLException {
        String query = null;        // Consulta a ser realizada no banco
        String coluna = null;      // Recebe a coluna respectiva a tabela a ser consultada

        //Entradas a serem encapsuladas
        String titulo = null;
        String descricao = null;
        int dificuldade = 0;
        String nomeCategoria = null;

        // TITULO, DESCRIÇÃO E DIFICULDADE
        switch (categoria) {
            case 1: // Alimentação
                query = "SELECT * FROM META_ALIMENTACAO";
                coluna = "id_alimentacao";
                nomeCategoria = "Alimentação";
                break;
            case 2: // Educação
                query = "SELECT * FROM META_EDUCACAO";
                coluna = "id_Edu";
                nomeCategoria = "Educação";
                break;
            case 3: // Esporte
                query = "SELECT * FROM META_ESPORTE";
                coluna = "id_metaEsporte";
                nomeCategoria = "Esporte";

                break;
            case 4: // Leitura
                query = "SELECT * FROM META_LEITURA";
                coluna = "id_leitura";
                nomeCategoria = "Leitura";

                break;
            case 5: // Outras
                query = "SELECT * FROM META_OUTROS";
                coluna = "id_outros";
                nomeCategoria = "Outras";

                break;
        }

        query += " WHERE TITULO = '" + metaNome + "';";

        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query); //Roda a consulta
                ) {

            while (resultSet.next()) { //Percorre as linhas da consulta
                //Recebe as entradas do banco
                titulo = resultSet.getString("TITULO");
                descricao = resultSet.getString("DESCRICAO");
                dificuldade = resultSet.getInt("DIFICULDADE");
            }
            OutrasMetas meta = new OutrasMetas(titulo, descricao, dificuldade, 1);
            return meta;

        }
    }

    public static Recompensa recompensasInfo(String recompensaNome, Connection c) throws SQLException {
        String query = "SELECT * FROM RECOMPENSAS";

        //Entradas a serem encapsuladas
        String titulo = null;
        String descricao = null;
        int xp = 0;

        query += " WHERE TITULO = '" + recompensaNome + "';";

        try (
                Statement statement = c.createStatement();
                ResultSet resultSet = statement.executeQuery(query); //Roda a consulta
                ) {

            while (resultSet.next()) { //Percorre as linhas da consulta
                //Recebe as entradas do banco
                titulo = resultSet.getString("TITULO");
                descricao = resultSet.getString("DESCRICAO");
                xp = resultSet.getInt("XP");
            }
            Recompensa recompensa = new Recompensa(titulo, descricao, xp);
            return recompensa;

        }
    }
    
    public boolean verificarSenha(String login, String senha) {
        retorno = false;
        
        Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            try ( // Cria conexao com o banco
                    Connection c = conn.getConexaoMySQL()) {
                c.setAutoCommit(false);
                
                stmt = c.createStatement();
                try (ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" )) {
                    while ( rs.next() ) {
                        String nomeUsuario = rs.getString("USERNAME");
                        String senhaUsuario = rs.getString("SENHA");
                        
                        if(nomeUsuario.equals(login)) {
                            if(senhaUsuario.equals(senha)) {
                                retorno = true;
                            }
                        }
                    }
                }
                stmt.close();
            }
        } catch ( SQLException e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }        
        return retorno;        
    }
    
    public boolean verificarDisponibilidade(String login) {
        retorno = false;
        
        Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            try ( // Cria conexao com o banco
                    Connection c = conn.getConexaoMySQL()) {
                c.setAutoCommit(false);
                
                stmt = c.createStatement();
                try (ResultSet rs = stmt.executeQuery( "SELECT * FROM USUARIOS;" )) {
                    while ( rs.next() ) {
                        String username = rs.getString("USERNAME");
                        
                        if(username.equals(login)) {
                            retorno = true;
                        }
                    }
                }
                stmt.close();
            }
        } catch ( SQLException e ) {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }        
        
        return retorno;
    }
}
