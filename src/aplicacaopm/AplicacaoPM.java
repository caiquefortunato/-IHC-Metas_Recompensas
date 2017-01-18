package aplicacaopm;

import telas.*;

public class AplicacaoPM {

    public static void main(String[] args) throws ClassNotFoundException {
        
        java.awt.EventQueue.invokeLater(() -> {
            new Inicial().setVisible(true);
        });
    }
    
}
