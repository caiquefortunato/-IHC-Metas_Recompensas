package acao;

import OperacoesBancoSQL.SelecaoBanco;
import Util.Aguarde;
import Util.JavaMailApp;

public class TelaRecuperacaoSenha {
   

    public TelaRecuperacaoSenha( ) {
    }
    
    public boolean verificarEmail(String emailUsuario) {
        SelecaoBanco select = new SelecaoBanco();
        if(select.conferirEmail(emailUsuario)) {
            enviarEmail(emailUsuario);
            return true;
        }
        else return false; 
    }
    
    private void enviarEmail(String emailUsuario) {
        JavaMailApp enviaEmail = new JavaMailApp(emailUsuario);
        //enviaEmail.run();
        Aguarde aguarde = new Aguarde();
        //aguarde.run();
        
        Thread t1 = new Thread(enviaEmail);
        t1.start();
        Thread t2 = new Thread(aguarde);
        t2.start();
    }
    
}
