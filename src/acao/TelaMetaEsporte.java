package acao;

import Entidades.Esporte;
import Entidades.Usuario;
import OperacoesBancoSQL.InsercaoBanco;

public class TelaMetaEsporte {
    
    Usuario user = Usuario.getUsuarioAtivo();
    
    public TelaMetaEsporte() {
        
    }
    
    public void receberDados (Esporte esporte) {
        user.setEsporte(esporte);
        
         // Insere os dados
        InsercaoBanco insere = new InsercaoBanco();
        insere.inserirMetaEsporte(user);
    }
    
}
