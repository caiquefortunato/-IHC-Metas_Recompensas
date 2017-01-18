package OperacoesBancoSQL;

import Entidades.Usuario;
import bancoSQL.ConexaoMySQL;
import java.sql.*;

public class InsercaoBanco {

    public InsercaoBanco() {

    }

    public void inserirUsuario(Usuario user) {

        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            // Cria conexao com o banco
            Connection c = conn.getConexaoMySQL();

            String sql = "INSERT INTO USUARIOS (USERNAME, NOME, SENHA, EMAIL, EXPERIENCIA) "
                    + "VALUES (?,?,?,?,?);";

            try (PreparedStatement stmt = c.prepareStatement(sql)) {
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getNome());
                stmt.setString(3, user.getSenha());
                stmt.setString(4, user.getEmail());
                stmt.setInt(5, 0);
                stmt.execute();
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
    }

    public void inserirRecompensa(Usuario user) {

        //Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            // Cria conexao com o banco
            Connection c = conn.getConexaoMySQL();

            String sql = "INSERT INTO RECOMPENSAS (id_Recompensa, USER, TITULO, DESCRICAO, XP) "
                    + "VALUES (?,?,?,?,?);";

            try (PreparedStatement stmt = c.prepareStatement(sql)) {
                stmt.setString(1, null);
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getRecompensa().getTitulo());
                stmt.setString(4, user.getRecompensa().getDescricao());
                stmt.setInt(5, user.getRecompensa().getXp());

                stmt.execute();
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }

    }

    public void inserirMetaEducacao(Usuario user) {

        //Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            // Cria conexao com o banco
            Connection c = conn.getConexaoMySQL();

            String sql = "INSERT INTO META_EDUCACAO (id_Edu, USER, TITULO, DESCRICAO, "
                    + "DEDICACAO, DISCIPLINA, DIFICULDADE) "
                    + "VALUES (?,?,?,?,?,?,?);";

            try (PreparedStatement stmt = c.prepareStatement(sql)) {
                stmt.setString(1, null);
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getMetaEducacao().getTitulo());
                stmt.setString(4, user.getMetaEducacao().getDescricao());
                stmt.setInt(5, user.getMetaEducacao().getHorasEstudo());
                stmt.setString(6, user.getMetaEducacao().getNomeDisciplina());
                stmt.setInt(7, user.getMetaEducacao().getDificuldade());

                stmt.execute();
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }

    }

    public void inserirMetaLeitura(Usuario user) {

        //Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            // Cria conexao com o banco
            Connection c = conn.getConexaoMySQL();

            String sql = "INSERT INTO META_LEITURA (id_leitura, USER, TITULO, DESCRICAO, "
                    + "DEDICACAO, DIFICULDADE, NOME_LIVRO, ASSUNTO_LIVRO, PG_DIA) "
                    + "VALUES (?,?,?,?,?,?,?,?,?);";

            try (PreparedStatement stmt = c.prepareStatement(sql)) {
                stmt.setString(1, null);
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getMetaLeitura().getTitulo());
                stmt.setString(4, user.getMetaLeitura().getDescricao());
                stmt.setInt(5, user.getMetaLeitura().getHorasLidas());
                stmt.setInt(6, user.getMetaLeitura().getDificuldade());
                stmt.setString(7, user.getMetaLeitura().getNomeLivro());
                stmt.setString(8, user.getMetaLeitura().getAssuntoLivro());
                stmt.setInt(9, user.getMetaLeitura().getPaginasDia());

                stmt.execute();
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
    }

    public void inserirMetaAlimentacao(Usuario user) {

        //Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            // Cria conexao com o banco
            Connection c = conn.getConexaoMySQL();

            String sql = "INSERT INTO META_ALIMENTACAO (id_alimentacao, USER, TITULO, "
                    + "DESCRICAO, "
                    + "DIFICULDADE, NOME_COMIDA, NOME_BEBIDA, VEZES_DIA) "
                    + "VALUES (?,?,?,?,?,?,?,?);";

            try (PreparedStatement stmt = c.prepareStatement(sql)) {
                stmt.setString(1, null);
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getMetaAlimentacao().getTitulo());
                stmt.setString(4, user.getMetaAlimentacao().getDescricao());
                stmt.setInt(5, user.getMetaAlimentacao().getDificuldade());
                stmt.setString(6, user.getMetaAlimentacao().getNomeComida());
                stmt.setString(7, user.getMetaAlimentacao().getNomeBebida());
                stmt.setInt(8, user.getMetaAlimentacao().getVezesDia());

                stmt.execute();
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
    }

    public void inserirMetaEsporte(Usuario user) {

        //Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            // Cria conexao com o banco
            Connection c = conn.getConexaoMySQL();

            String sql = "INSERT INTO META_ESPORTE (id_metaEsporte, USER, TITULO, "
                    + "DESCRICAO, DIFICULDADE, NOME_ESPORTE, KM, TEMPO_PRATICADO,"
                    + "VEZES_SEMANA) VALUES (?,?,?,?,?,?,?,?,?);";

            try (PreparedStatement stmt = c.prepareStatement(sql)) {
                stmt.setString(1, null);
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getEsporte().getTitulo());
                stmt.setString(4, user.getEsporte().getDescricao());
                stmt.setInt(5, user.getEsporte().getDificuldade());
                stmt.setString(6, user.getEsporte().getNomeEsporte());
                stmt.setInt(7, user.getEsporte().getKm());
                stmt.setInt(8, user.getEsporte().getTempoPraticado());
                stmt.setInt(9, user.getEsporte().getVezesSemana());

                stmt.execute();
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
    }

    public void inserirOutrasMetas(Usuario user) {

        //Statement stmt = null;
        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            // Cria conexao com o banco
            Connection c = conn.getConexaoMySQL();

            String sql = "INSERT INTO META_OUTROS (id_outros, USER, TITULO, "
                    + "DESCRICAO, DIFICULDADE, NOME_CATEGORIA, DIAS)"
                    + " VALUES (?,?,?,?,?,?,?);";

            try (PreparedStatement stmt = c.prepareStatement(sql)) {
                stmt.setString(1, null);
                stmt.setString(2, user.getUsername());
                stmt.setString(3, user.getOutrasMetas().getTitulo());
                stmt.setString(4, user.getOutrasMetas().getDescricao());
                stmt.setInt(5, user.getOutrasMetas().getDificuldade());
                stmt.setInt(7, user.getOutrasMetas().getDias());

                stmt.execute();
            }

        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);

        }
    }
}