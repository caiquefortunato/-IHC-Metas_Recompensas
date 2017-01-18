package acao;

import Entidades.OutrasMetas;
import Entidades.Usuario;
import OperacoesBancoSQL.InsercaoBanco;
import static OperacoesBancoSQL.SelecaoBanco.metasInfo;
import bancoSQL.ConexaoMySQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class TelaOutrasMetas {

    Usuario user = Usuario.getUsuarioAtivo();

    public TelaOutrasMetas() {

    }

    public void receberDados(OutrasMetas outrasMetas) {
        user.setOutrasMetas(outrasMetas);

        // Insere os dados
        InsercaoBanco insere = new InsercaoBanco();
        insere.inserirOutrasMetas(user);
    }

    public void ApagarMeta(String tabela, String campo, String valor) {
        Statement stmt = null;

        try {
            // Cria uma instancia para a criacao do Banco de dados
            ConexaoMySQL conn = ConexaoMySQL.getConexao();
            try ( // Cria conexao com o banco
                    Connection c = conn.getConexaoMySQL()) {
                c.setAutoCommit(false);

                stmt = c.createStatement();
                valor = "'" + valor + "'";

                String sql = "DELETE FROM " + tabela
                        + " WHERE " + campo + "=" + valor + ";";

                stmt.executeUpdate(sql);
                c.commit();

                stmt.close();
            }
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        if("RECOMPENSAS".equals(tabela)) JOptionPane.showMessageDialog(null, "A recompensa foi excluida com sucesso !");
        else JOptionPane.showMessageDialog(null, "A meta foi excluida com sucesso !");
    }
    
    public void addXP(String tituloMeta, int categoria, Usuario user) throws SQLException {
        
        //Cria conexão com o Banco de Dados
        ConexaoMySQL conn = ConexaoMySQL.getConexao();
        Connection c = conn.getConexaoMySQL();

        OutrasMetas meta = metasInfo(tituloMeta, categoria, c);
        int XP = meta.calcularDificuldade(meta.getDificuldade());
        
        String query = "UPDATE USUARIOS SET EXPERIENCIA=";
                query+=user.getExperiencia()+ XP + " WHERE USERNAME=" +"'"+user.getUsername();
                query+="';";
                
        System.out.println(query);
        JOptionPane.showMessageDialog(null,"Você ganhou "+ XP +
                " pontos de experiência !!! \n" +
                "Volte mais tarde para conseguir mais pontos.");

        Statement stmt = null;
        
        try {
            c.setAutoCommit(false);
            stmt = c.createStatement();
            stmt.executeUpdate(query);
            c.commit();
            stmt.close();
            }
        catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}