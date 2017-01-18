package acao;

import Entidades.Educacao;
import Entidades.Usuario;
import OperacoesBancoSQL.InsercaoBanco;

public class TelaMetaEducacao {
    
    Usuario user = Usuario.getUsuarioAtivo();

    public TelaMetaEducacao() {
    }
    
    public void receberDados(Educacao edu) {
        
        user.setMetaEducacao(edu);
        
        // Insere os dados
        InsercaoBanco insere = new InsercaoBanco();
        insere.inserirMetaEducacao(user);
    }
    
}
