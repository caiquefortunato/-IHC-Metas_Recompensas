package acao;

import Entidades.Alimentacao;
import Entidades.Usuario;
import OperacoesBancoSQL.InsercaoBanco;

public class TelaMetaAlimentacao {

    Usuario user = Usuario.getUsuarioAtivo();

    public TelaMetaAlimentacao() {

    }

    public void receberDados(Alimentacao alimentacao) {
        user.setMetaAlimentacao(alimentacao);

        // Insere os dados
        InsercaoBanco insere = new InsercaoBanco();
        insere.inserirMetaAlimentacao(user);
    }

}
