package acao;

import Entidades.Usuario;
import OperacoesBancoSQL.SelecaoBanco;

public class TelaLogin {
    
    private boolean verificaExistencia;
    private boolean verificaSenha = false;
    SelecaoBanco selecao = new SelecaoBanco();
    Usuario user = Usuario.getUsuarioAtivo();
    
    public TelaLogin() {
        
    }
    
    public void VerificaDisponibilidade(String login) {
        this.verificaExistencia = selecao.verificarDisponibilidade(login);
    }

    public boolean getVerificaExistencia() {
        return verificaExistencia;
    }
    
    public void VerificaSenha(String usuario, String senha) {
        this.verificaSenha = selecao.verificarSenha(usuario, senha);
    }
    
    public boolean getVerificaSenha() {
        return verificaSenha;
    }
    
    public void definirUsuario(String usuarioLogin) {
        user.setUsername(usuarioLogin);
    }
    
    public void preencherDados() {
        user.preencherDadosAposLogin();
    }
}
