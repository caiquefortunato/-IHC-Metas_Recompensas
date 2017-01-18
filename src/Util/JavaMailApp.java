package Util;

import Entidades.Usuario;
import OperacoesBancoSQL.SelecaoBanco;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class JavaMailApp implements Runnable {
    
    private final String email = "metaserecompensas@gmail.com";
    private final String senha = "TP-PM.123";
    private final String emailUsuario;
    private static final Object lock = new Object();
    
    public JavaMailApp(String email) {
        this.emailUsuario = email;
    }
    
    @Override
    public void run() {
        synchronized (lock) {
            enviarEmail(emailUsuario);
        }
    }
    
    private void enviarEmail(String emailUsuario) {
        SelecaoBanco select = new SelecaoBanco();
        Usuario user = Usuario.getUsuarioAtivo();
        
        user = select.enviarDados(emailUsuario);
        
        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(email, senha);
                }
            });
        
       /** Ativa Debug para sessão */
       session.setDebug(true);
       try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email)); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                            .parse(emailUsuario);  
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Recuperação de senha: Metas e Recompensas.");//Assunto
            message.setText("Prezado(a) " + user.getNome() + ", \n\n" +
                "A senha cadastrada no aplicativo Metas e Recompensas é: " +
                user.getSenha() + ".\n\n" + "Lembramos que seu nome de usuário é: " 
                + user.getUsername() + "\n\n" + "Obrigado por utilizar nosso aplicativo." +
                "\n\n Se você não se lembra de ter recuperado sua senha, favor desconsiderar"
                + "este e-mail." + "\n\n" + "Equipe Metas e Recompensas.");
            /**Método para enviar a mensagem criada*/
            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Mensagem enviada.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        } 
       
    }


}