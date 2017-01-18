package telas;

import Entidades.Usuario;
import bancoSQL.ConexaoMySQL;
import java.awt.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane; // Importando as Bibliotecas 

public final class MinhasMetas extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9062723127251023044L;
	@SuppressWarnings("rawtypes")
	private final class AbstractListModelExtension5 extends javax.swing.AbstractListModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = -8898768231217829942L;
		String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

		public int getSize() { return strings.length; }

		public Object getElementAt(int i) { return strings[i]; }
	}
	@SuppressWarnings("rawtypes")
	private final class AbstractListModelExtension4 extends javax.swing.AbstractListModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 6122697413971339675L;
		String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

		public int getSize() { return strings.length; }

		public Object getElementAt(int i) { return strings[i]; }
	}
	@SuppressWarnings("rawtypes")
	private final class AbstractListModelExtension3 extends javax.swing.AbstractListModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8808660363617880068L;
		String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

		public int getSize() { return strings.length; }

		public Object getElementAt(int i) { return strings[i]; }
	}
	@SuppressWarnings("rawtypes")
	private final class AbstractListModelExtension2 extends javax.swing.AbstractListModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3165503359701491751L;
		String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

		public int getSize() { return strings.length; }

		public Object getElementAt(int i) { return strings[i]; }
	}
	@SuppressWarnings("rawtypes")
	private final class AbstractListModelExtension extends javax.swing.AbstractListModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -8808660363617880068L;
		String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };

		public int getSize() { return strings.length; }

		public Object getElementAt(int i) { return strings[i]; }
	}
	JList<String> jList = null;  //  Nome do elemento jList
    List idMeta;

    /**
     *
     * @param categoria
     * @param connection
     * @throws SQLException
     */
    public void populateJList(int categoria, Connection connection) throws SQLException {
        String query = null;        // Consulta a ser realizada no banco
        String coluna = null;      // Recebe a coluna respectiva a tabela a ser consultada

        switch (categoria) {
            case 1: // Alimentação
                query = "SELECT * FROM META_ALIMENTACAO";
                coluna = "id_alimentacao";
                jList = jListAlimentacao;
                break;
            case 2: // Educação
                query = "SELECT * FROM META_EDUCACAO";
                coluna = "id_Edu";
                jList = jListEducacao;
                break;
            case 3: // Esporte
                query = "SELECT * FROM META_ESPORTE";
                coluna = "id_metaEsporte";
                jList = jListEsporte;
                break;
            case 4: // Leitura
                query = "SELECT * FROM META_LEITURA";
                coluna = "id_leitura";
                jList = jListLeitura;
                break;
            case 5: // Outras
                query = "SELECT * FROM META_OUTROS";
                coluna = "id_outros";
                jList = jListOutras;
                break;
        }
        query+=" WHERE USER='";
        query+=Usuario.getUsuarioAtivo().getUsername() + "';";

        DefaultListModel<String> model = new DefaultListModel<String>(); //Cria um novo list model
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query); //Roda a consulta
                ) {

            while (resultSet.next()) { //Percorre as linhas da consulta
                String tituloMeta = resultSet.getString("TITULO"); //Recebe o elemento título do banco
                idMeta.add(String.valueOf(resultSet.getInt(coluna))); //get the element in column "item_code"
                model.addElement(tituloMeta); // Adiciona os ítens aos Models
            }

            jList.setModel(model);
        }
    }

    public MinhasMetas() {
        initComponents();     // Inicializa os componentes do Frame
        idMeta = new List(); // Lista que conterá o ID das metas consultadas

        //Cria conexão com o Banco de Dados
        ConexaoMySQL conn = ConexaoMySQL.getConexao();
        Connection c = conn.getConexaoMySQL();

        // Lista todas as metas dos usuários, em cada uma das  JLists
        for (int categoria = 1; categoria < 6; categoria++) {
            try {
                populateJList(categoria, c);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(new JFrame(), "Eggs are not supposed to be green.");
                Logger.getLogger(MinhasMetas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTab = new javax.swing.JTabbedPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListAlimentacao = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListEducacao = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListEsporte = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListLeitura = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListOutras = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menu.setForeground(new java.awt.Color(255, 255, 255));
        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/menu.png"))); // NOI18N
        menu.setToolTipText("Menu");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/goal.png"))); // NOI18N
        jLabel1.setText("Minhas Metas");

        jListAlimentacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jListAlimentacao.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListAlimentacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAlimentacaoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListAlimentacao);

        jTab.addTab("Alimentação", jScrollPane3);

        jListEducacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jListEducacao.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListEducacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEducacaoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListEducacao);

        jTab.addTab("Educação", jScrollPane4);

        jListEsporte.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jListEsporte.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListEsporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListEsporteMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jListEsporte);

        jTab.addTab("Esporte", jScrollPane5);

        jListLeitura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jListLeitura.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListLeitura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListLeituraMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jListLeitura);

        jTab.addTab("Leitura", jScrollPane6);

        jListOutras.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jListOutras.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListOutras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListOutrasMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jListOutras);

        jTab.addTab("Outras", jScrollPane7);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nesta tela você pode visualizar sua metas. ");

        jLabel5.setFont(new java.awt.Font("Bookman Old Style", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Clique duas vezes em uma meta para edita-la ou receber XPs.");

        jButton1.setText("Criar Meta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Não possui metas ? Cadastre uma agora !");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTab, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel1))
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menu)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTab, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        // Passa para a tela de Menu
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });

        // Fecha a janela da aplicação
        this.dispose();
    }//GEN-LAST:event_menuActionPerformed

    private void jListAlimentacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAlimentacaoMouseClicked
        jList = jListAlimentacao;
        if (evt.getClickCount() == 2) {
            int index = jList.locationToIndex(evt.getPoint());
            if (index >= 0) {
                Object o = jList.getModel().getElementAt(index);
                // Passa para a tela de criacao
                java.awt.EventQueue.invokeLater(() -> {
                    try {
                        new MetaAlimentacao(o.toString()).setVisible(true);
                        this.dispose(); 
                    } catch (SQLException ex) {
                        Logger.getLogger(MinhasMetas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }
    }//GEN-LAST:event_jListAlimentacaoMouseClicked

    private void jListEducacaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListEducacaoMouseClicked
        jList = jListEducacao;
        if (evt.getClickCount() == 2) {
            int index = jList.locationToIndex(evt.getPoint());
            if (index >= 0) {
                Object o = jList.getModel().getElementAt(index);
                // Passa para a tela de criacao
                java.awt.EventQueue.invokeLater(() -> {
                    try {
                        new MetaEducacao(o.toString()).setVisible(true);
                        this.dispose(); 
                    } catch (SQLException ex) {
                        Logger.getLogger(MinhasMetas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }
    }//GEN-LAST:event_jListEducacaoMouseClicked

    private void jListEsporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListEsporteMouseClicked
        jList = jListEsporte;
        if (evt.getClickCount() == 2) {
            int index = jList.locationToIndex(evt.getPoint());
            if (index >= 0) {
                Object o = jList.getModel().getElementAt(index);
                // Passa para a tela de criacao
                java.awt.EventQueue.invokeLater(() -> {
                    try {
                        new MetaEsporte(o.toString()).setVisible(true);
                        this.dispose(); 
                    } catch (SQLException ex) {
                        Logger.getLogger(MinhasMetas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jListEsporteMouseClicked

    private void jListLeituraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListLeituraMouseClicked
        jList = jListLeitura;
        if (evt.getClickCount() == 2) {
            int index = jList.locationToIndex(evt.getPoint());
            if (index >= 0) {
                Object o = jList.getModel().getElementAt(index);
                // Passa para a tela de criacao
                java.awt.EventQueue.invokeLater(() -> {
                    try {
                        new MetaLeitura(o.toString()).setVisible(true);
                        this.dispose(); 
                    } catch (SQLException ex) {
                        Logger.getLogger(MinhasMetas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }
    }//GEN-LAST:event_jListLeituraMouseClicked

    private void jListOutrasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListOutrasMouseClicked
        jList = jListOutras;
        if (evt.getClickCount() == 2) {
            int index = jList.locationToIndex(evt.getPoint());
            if (index >= 0) {
                Object o = jList.getModel().getElementAt(index);
                // Passa para a tela de criacao
                java.awt.EventQueue.invokeLater(() -> {
                    try {
                        new Outras(o.toString()).setVisible(true);
                        this.dispose(); 
                    } catch (SQLException ex) {
                        Logger.getLogger(MinhasMetas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
        }
    }//GEN-LAST:event_jListOutrasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // Passa para a tela de metasPerfil
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroMeta().setVisible(true);
            }
        });

        // Fecha a janela da aplicação
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jListAlimentacao;
    private javax.swing.JList jListEducacao;
    private javax.swing.JList jListEsporte;
    private javax.swing.JList jListLeitura;
    private javax.swing.JList jListOutras;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTab;
    private javax.swing.JButton menu;
    // End of variables declaration//GEN-END:variables
}
