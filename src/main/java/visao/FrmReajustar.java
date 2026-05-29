package visao;

/**
 * Tela responsável pelo reajuste de preços dos produtos.
 *
 * Permite aplicar aumentos ou descontos por categoria, além de visualizar o
 * histórico de reajustes realizados.
 *
 * @author Bruno Antunes
 */
public class FrmReajustar extends javax.swing.JFrame {

    /**
     * Logger da aplicação.
     */
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmReajustar.class.getName());

    /**
     * Construtor da tela de reajuste.
     *
     * Inicializa componentes, categorias e tabela.
     */
    public FrmReajustar() {
        initComponents();
        carregarCategorias();
        carregarTabela();
    }

    /**
     * Inicializa os componentes gráficos da tela.
     *
     * Método gerado automaticamente pelo NetBeans.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnReajustar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtNome11 = new javax.swing.JTextField();
        campPercentual = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reajuste");

        jLabel3.setText("Percentual (%):");

        jLabel4.setText("Tipo:");

        jLabel5.setText("Categoria:");

        btnReajustar.setBackground(new java.awt.Color(46, 204, 113));
        btnReajustar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReajustar.setText("Reajustar ");
        btnReajustar.addActionListener(this::btnReajustarbntAdicionarActionPerformed);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Reajuste");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AUMENTO", "DESCONTO" }));
        jComboBox1.addActionListener(this::jComboBox1ActionPerformed);

        jMenu1.setText("Movimentação");

        jMenuItem4.setText("Gerenciar");
        jMenuItem4.addActionListener(this::jMenuItem4ActionPerformed);
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opções");

        jMenuItem1.setText("Início");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        jMenu2.add(jMenuItem1);

        jMenuItem3.setText("Categoria");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        jMenu2.add(jMenuItem3);

        jMenuItem2.setText("Produto");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReajustar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(campPercentual)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtNome11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(btnReajustar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(txtNome11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Abre tela inicial do sistema.
     *
     * @param evt evento do menu
     */
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new FrmPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * Realiza reajuste de preços dos produtos.
     *
     * Valida percentual, aplica filtro de categoria, atualiza preços e registra
     * histórico de reajustes.
     *
     * @param evt evento do botão reajustar
     */
    private void btnReajustarbntAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReajustarbntAdicionarActionPerformed
        // Valida percentual
        String texto = campPercentual.getText().trim();
        if (texto.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Informe o percentual de reajuste!");
            return;
        }
        double percentual;
        try {
            percentual = Double.parseDouble(texto.replace(",", "."));
            if (percentual <= 0 || percentual > 100) {
                javax.swing.JOptionPane.showMessageDialog(this, "Percentual deve ser entre 0,01 e 100.");
                return;
            }
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Percentual inválido. Use números. Ex: 10 ou 10.5");
            return;
        }

        // Lê tipo de reajuste
        constante.TipoReajuste tipo = constante.TipoReajuste.valueOf(
                (String) jComboBox1.getSelectedItem()
        );

        // Lê filtro de categoria
        String categoriaSelecionada = (String) jComboBox2.getSelectedItem();

        dao.ProdutoDAO dao = new dao.ProdutoDAO();
        java.util.List<modelo.Produto> produtos = dao.listar();

        // Aplica filtro de categoria
        if (categoriaSelecionada != null && !categoriaSelecionada.equals("TODAS")) {
            produtos.removeIf(p -> p.getCategoria() == null
                    || !p.getCategoria().getNome().equals(categoriaSelecionada));
        }

        if (produtos.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Nenhum produto encontrado para a categoria selecionada.");
            return;
        }

        String tipoTexto = tipo == constante.TipoReajuste.AUMENTO ? "aumento" : "desconto";
        int ok = javax.swing.JOptionPane.showConfirmDialog(this,
                "Aplicar " + tipoTexto + " de " + percentual + "% em " + produtos.size() + " produto(s)?",
                "Confirmar Reajuste", javax.swing.JOptionPane.YES_NO_OPTION);
        if (ok != javax.swing.JOptionPane.YES_OPTION) {
            return;
        }

        for (modelo.Produto p : produtos) {

            // reajusta preço
            p.reajustarPreco(percentual, tipo);

            // atualiza produto
            dao.atualizar(p);

            // cria reajuste
            modelo.Reajuste r = new modelo.Reajuste();

            r.setDataReajuste(new java.util.Date());

            r.setValor(percentual);

            r.setTipo(tipo);

            r.setCategoria(p.getCategoria());

            // salva reajuste
            new dao.ReajusteDAO().inserir(r);
        }

        javax.swing.JOptionPane.showMessageDialog(this, "Reajuste concluído com sucesso!");
        campPercentual.setText("");
        carregarTabela();

    }//GEN-LAST:event_btnReajustarbntAdicionarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    /**
     * Abre tela de categorias.
     *
     * @param evt evento do menu
     */
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new FrmCategoria().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed
    /**
     * Abre tela de produtos.
     *
     * @param evt evento do menu
     */
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new FrmProduto().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed
    /**
     * Abre tela de movimentações.
     *
     * @param evt evento do menu
     */
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new FrmMovimentacao().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    /**
     * Carrega categorias no combo box.
     *
     * Adiciona opção para todas as categorias.
     */
    private void carregarCategorias() {
        jComboBox2.removeAllItems();
        jComboBox2.addItem("TODAS");
        for (modelo.Categoria c : new dao.CategoriaDAO().listar()) {
            jComboBox2.addItem(c.getNome());
        }
    }

    /**
     * Carrega tabela de histórico de reajustes.
     *
     * Busca informações diretamente no banco de dados.
     */
    private void carregarTabela() {

        javax.swing.table.DefaultTableModel model
                = new javax.swing.table.DefaultTableModel(
                        new String[]{
                            "ID",
                            "Data Reajuste",
                            "Valor",
                            "Tipo",
                            "Categoria ID"
                        }, 0
                ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        try {

            utilitario.Conexao con = new utilitario.Conexao();

            java.sql.Connection conn = con.conectar();

            String sql = "SELECT * FROM reajuste";

            java.sql.PreparedStatement stmt
                    = conn.prepareStatement(sql);

            java.sql.ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getDate("data_reajuste"),
                    rs.getDouble("valor"),
                    rs.getString("tipo"),
                    rs.getInt("categoria_id")
                });
            }

            jTable1.setModel(model);

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {

            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "Erro ao carregar reajustes: "
                    + e.getMessage()
            );
        }
    }

    /**
     * Método principal da aplicação.
     *
     * @param args argumentos da linha de comando
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmReajustar().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReajustar;
    private javax.swing.JTextField campPercentual;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNome11;
    // End of variables declaration//GEN-END:variables
}
