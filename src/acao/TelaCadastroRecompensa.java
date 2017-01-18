package acao;

import Entidades.Recompensa;
import Entidades.Usuario;
import OperacoesBancoSQL.InsercaoBanco;

public class TelaCadastroRecompensa {
    
    Usuario user = Usuario.getUsuarioAtivo();
    
    public TelaCadastroRecompensa() {
        
    }
    
    public void receberDados(String titulo, String descricao, int xp) {
        // Insere os dados da recompensa no usuario
        Recompensa r = new Recompensa(titulo, descricao, xp); 
        user.setRecompensa(r);

        // Insere no banco
        InsercaoBanco insere = new InsercaoBanco();
        insere.inserirRecompensa(user);
    }
    
}
