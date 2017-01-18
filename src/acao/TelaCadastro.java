package acao;

import Entidades.Usuario;
import OperacoesBancoSQL.InsercaoBanco;
import OperacoesBancoSQL.SelecaoBanco;

public class TelaCadastro {
    
    Usuario user = Usuario.getUsuarioAtivo();
    SelecaoBanco selecao = new SelecaoBanco();
    private boolean verificaExistencia;
    
    public TelaCadastro() {
        
    }

    public TelaCadastro(Usuario user) {
        InsercaoBanco insere = new InsercaoBanco();
        insere.inserirUsuario(user);
    }
    
    public void VerificaDisponibilidade(String login) {
        this.verificaExistencia = selecao.verificarDisponibilidade(login);
    }

    public boolean getVerificaExistencia() {
        return verificaExistencia;
    }
    
    public void limparDadosUser( ) {
        user.setEmail(null);
        user.setNome(null);
        user.setUsername(null);
        user.setSenha(null);
    }

}
