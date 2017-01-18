package acao;

import Entidades.Leitura;
import Entidades.Usuario;
import OperacoesBancoSQL.InsercaoBanco;

public class TelaMetaLeitura {
    
    Usuario user = Usuario.getUsuarioAtivo();
    
    public TelaMetaLeitura() {
        
    }
    
    public void receberDados(Leitura leitura) {
        user.setMetaLeitura(leitura);
        
        // Insere os dados
        InsercaoBanco insere = new InsercaoBanco();
        insere.inserirMetaLeitura(user);
    }
    
}
