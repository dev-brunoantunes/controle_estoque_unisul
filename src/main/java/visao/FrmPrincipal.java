package visao;

public class FrmPrincipal extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmPrincipal.class.getName());

    /**
     * Creates new form FrmMain
     */
    public FrmPrincipal() {
        initComponents();
        carregarResumo();
        carregarTabelas();
    }

    private void carregarTabelas() {
        // Tabela produtos críticos

        java.util.List<modelo.Produto> produtos = new dao.ProdutoDAO().listar();

        String[] colunasCriticos = {"Produto", "Atual", "Mín."};
        javax.swing.table.DefaultTableModel modeloCriticos = new javax.swing.table.DefaultTableModel(colunasCriticos, 0);

        for (modelo.Produto p : produtos) {
            if (p.abaixoMinimo()) {
                modeloCriticos.addRow(new Object[]{
                    p.getNome(),
                    p.getQuantidade(),
                    p.getQuantidadeMinima()
                });
            }
        }

        tblCriticos.setModel(modeloCriticos);

        // Tabela últimas movimentações
        java.util.List<modelo.Movimentacao> movs = new dao.MovimentacaoDAO().listar();

        String[] colunasMovs = {"Produto", "Data", "Qtd", "Tipo"};
        javax.swing.table.DefaultTableModel modeloMovs = new javax.swing.table.DefaultTableModel(colunasMovs, 0);

        for (modelo.Movimentacao m : movs) {
            modeloMovs.addRow(new Object[]{
                m.getProduto().getNome(),
                m.getData().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yy")),
                m.getQuantidade(),
                m.getTipo()
            });
        }
        tblMovimentacoes.setModel(modeloMovs);
        tblCriticos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);

    }

    private void carregarResumo() {
        java.util.List<modelo.Produto> produtos = new dao.ProdutoDAO().listar();

        int total = produtos.size();
        long baixo = produtos.stream().filter(modelo.Produto::abaixoMinimo).count();
        double valor = produtos.stream()
                .mapToDouble(p -> p.getPreco() * p.getQuantidade())
                .sum();

        lblTotalNum.setText(String.valueOf(total));
        lblBaixoNum.setText(String.valueOf(baixo));
        lblValorNum.setText("R$ " + String.format("%.2f", valor));

        lblTotalNum.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 22));
        lblBaixoNum.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 22));
        lblValorNum.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 22));

        lblTotalNum.setForeground(new java.awt.Color(37, 99, 235));
        lblBaixoNum.setForeground(new java.awt.Color(220, 38, 38));
        lblValorNum.setForeground(new java.awt.Color(22, 163, 74));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        lblBaixo = new javax.swing.JLabel();
        lblBaixoNum = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblValor = new javax.swing.JLabel();
        lblValorNum = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        lblTotalNum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblMovimentacoes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCriticos = new javax.swing.JTable();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuMovimentacao = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuOpcoes = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem5.setText("jMenuItem5");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle de estoque");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 38, 38)));
        jPanel1.setMaximumSize(new java.awt.Dimension(200, 30));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 30));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 30));

        lblBaixo.setText("Estoque Baixo:");

        lblBaixoNum.setText("num. est. baixo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBaixo)
                    .addComponent(lblBaixoNum))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBaixo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBaixoNum)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(22, 163, 74)));
        jPanel3.setMaximumSize(new java.awt.Dimension(200, 30));
        jPanel3.setMinimumSize(new java.awt.Dimension(200, 30));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 30));

        lblValor.setText("Valor em Estoque:");

        lblValorNum.setText("valor");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblValor)
                    .addComponent(lblValorNum))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblValor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblValorNum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(37, 99, 235)));
        jPanel2.setMaximumSize(new java.awt.Dimension(200, 30));
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 30));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 30));

        lblTotal.setText("Total de Produtos:");

        lblTotalNum.setText("num. prod");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotal)
                    .addComponent(lblTotalNum))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalNum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CONTROLE DE ESTOQUE");

        jLabel2.setText("Produtos com estoque crítico:");

        jLabel3.setText("Últimas Movimentações: ");

        tblMovimentacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Produto", "Data", "Qntd", "Tipo"
            }
        ));
        jScrollPane3.setViewportView(tblMovimentacoes);
        if (tblMovimentacoes.getColumnModel().getColumnCount() > 0) {
            tblMovimentacoes.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblMovimentacoes.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblMovimentacoes.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblMovimentacoes.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        jScrollPane4.setViewportView(jScrollPane3);

        jDesktopPane1.setLayer(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        tblCriticos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Atual", "Min."
            }
        ));
        jScrollPane2.setViewportView(tblCriticos);
        if (tblCriticos.getColumnModel().getColumnCount() > 0) {
            tblCriticos.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblCriticos.getColumnModel().getColumn(1).setPreferredWidth(5);
            tblCriticos.getColumnModel().getColumn(2).setResizable(false);
            tblCriticos.getColumnModel().getColumn(2).setPreferredWidth(5);
        }

        jMenuMovimentacao.setText("Movimentação");
        jMenuMovimentacao.addActionListener(this::jMenuMovimentacaoActionPerformed);

        jMenuItem4.setText("Gerenciar");
        jMenuItem4.addActionListener(this::jMenuItem4ActionPerformed);
        jMenuMovimentacao.add(jMenuItem4);

        jMenuBar.add(jMenuMovimentacao);

        jMenuOpcoes.setText("Opções");

        jMenuItem2.setText("Categoria");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        jMenuOpcoes.add(jMenuItem2);

        jMenuItem3.setText("Produto");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        jMenuOpcoes.add(jMenuItem3);

        jMenuItem6.setText("Reajuste/preço");
        jMenuItem6.addActionListener(this::jMenuItem6ActionPerformed);
        jMenuOpcoes.add(jMenuItem6);

        jMenuBar.add(jMenuOpcoes);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addContainerGap(689, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(317, 317, 317))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new FrmCategoria().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new FrmProduto().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMovimentacaoActionPerformed
        new FrmMovimentacao().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuMovimentacaoActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new FrmMovimentacao().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new FrmReajustar().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu jMenuMovimentacao;
    private javax.swing.JMenu jMenuOpcoes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblBaixo;
    private javax.swing.JLabel lblBaixoNum;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalNum;
    private javax.swing.JLabel lblValor;
    private javax.swing.JLabel lblValorNum;
    private javax.swing.JTable tblCriticos;
    private javax.swing.JTable tblMovimentacoes;
    // End of variables declaration//GEN-END:variables
}
