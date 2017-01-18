package telas;

import Entidades.Usuario;
import bancoSQL.ConexaoMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;

public final class MinhasRecompensas extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1670706560281972688L;
	@SuppressWarnings("rawtypes")
	JList jList = null;  //  Nome do elemento jList
    Usuario user = Usuario.getUsuarioAtivo();

    @SuppressWarnings("unchecked")
	public void populateJList(String query, Connection connection) throws SQLException {
        query = "SELECT * FROM RECOMPENSAS WHERE USER = '" + user.getUsername() + "';";
        jList = jListRecompensas;

        @SuppressWarnings("rawtypes")
		DefaultListModel model = new DefaultListModel(); //Cria um novo list model
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query); //Roda a consulta
                ) {
            while (resultSet.next()) { //Percorre as linhas da consulta
                String tituloMeta = resultSet.getString("TITULO"); //Recebe o elemento título do banco
                model.addElement(tituloMeta); // Adiciona os ítens aos Models
            }
            jList.setModel(model);
        }
    }

    public MinhasRecompensas() {
        initComponents();     // Inicializa os componentes do Frame

        //Cria conexão com o Banco de Dados
        ConexaoMySQL conn = ConexaoMySQL.getConexao();
        Connection c = conn.getConexaoMySQL();

        try {
            populateJList("SELECT * FROM RECOMPENSAS", c);
        } catch (SQLException ex) {
            Logger.getLogger(MinhasRecompensas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRecompensas = new javax.swing.JList<>();
        criarRecompensa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menu2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nesta tela você pode visualizar sua recompensas. ");

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Clique duas vezes em uma meta para edita-la ou receber os pontos");

        jListRecompensas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListRecompensas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListRecompensasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListRecompensas);

        jTabbedPane1.addTab("Recompensas", jScrollPane1);

        criarRecompensa.setText("Criar Recompensa");
        criarRecompensa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarRecompensaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/goal.png"))); // NOI18N
        jLabel1.setText("Minhas Recompensas");

        menu2.setForeground(new java.awt.Color(255, 255, 255));
        menu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/menu.png"))); // NOI18N
        menu2.setToolTipText("Menu");
        menu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu2ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        botaoVoltar.setText("Voltar");
        botaoVoltar.setActionCommand("voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(botaoVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(botaoVoltar, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(criarRecompensa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menu2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(4, 4, 4)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criarRecompensa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jListRecompensasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListRecompensasMouseClicked
      jList = jListRecompensas;
        if (evt.getClickCount() == 2) {
            int index = jList.locationToIndex(evt.getPoint());
            if (index >= 0) {
                Object o = jList.getModel().getElementAt(index);
                // Passa para a tela de criacao
                java.awt.EventQueue.invokeLater(() -> {
                    try {
                        new CadastroRecompensa(o.toString()).setVisible(true);
                        this.dispose(); 
                    } catch (SQLException ex) {
                        Logger.getLogger(MinhasRecompensas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }        
    }//GEN-LAST:event_jListRecompensasMouseClicked

    private void criarRecompensaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarRecompensaActionPerformed
        // Passa para a tela de metasPerfil
        java.awt.EventQueue.invokeLater(() -> {
            new CadastroRecompensa().setVisible(true);
        });

        // Fecha a janela da aplicação
        this.dispose();        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_criarRecompensaActionPerformed

    private void menu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu2ActionPerformed
        // Passa para a tela de Menu
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });

        // Fecha a janela da aplicação
        this.dispose();
    }//GEN-LAST:event_menu2ActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        // Passa para a tela de Menu
        java.awt.EventQueue.invokeLater(() -> {
            new Perfil().setVisible(true);
        });

        // Fecha a janela da aplicação
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MinhasMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MinhasMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MinhasMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MinhasMetas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MinhasMetas().setVisible(true);
        });
    }
//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JButton criarRecompensa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jListRecompensas;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton menu2;
    // End of variables declaration//GEN-END:variables
}
