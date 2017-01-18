package Util;

import javax.swing.JOptionPane;

public class Aguarde implements Runnable {

    private static final Object lock = new Object();
            
    @Override
    public void run() {
        
        synchronized (lock) {
        JOptionPane.showMessageDialog(null, "Uma mensagem está sendo "
                + "enviada para seu e-mail. Enquanto isso, é possível utilizar"
                + "a aplicação.");
        }
    }
    
}
