package view;

import java.awt.Frame;
import javax.swing.JFrame;


public class Principal extends javax.swing.JFrame {

   
    public Principal() {
        initComponents();
        this.setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_principal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuCadastrar = new javax.swing.JMenu();
        mniCadastrarAluno = new javax.swing.JMenuItem();
        mniCadastrarProfessor = new javax.swing.JMenuItem();
        mnuPesquisar = new javax.swing.JMenu();
        mniPesquisarAluno = new javax.swing.JMenuItem();
        mniPesquisarProfessor = new javax.swing.JMenuItem();
        mniPesquisarTurma = new javax.swing.JMenuItem();
        mnuSair = new javax.swing.JMenu();
        mniSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Cadastro");

        javax.swing.GroupLayout pnl_principalLayout = new javax.swing.GroupLayout(pnl_principal);
        pnl_principal.setLayout(pnl_principalLayout);
        pnl_principalLayout.setHorizontalGroup(
            pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnl_principalLayout.setVerticalGroup(
            pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 280, Short.MAX_VALUE)
        );

        mnuCadastrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\icones\\user_add.png")); // NOI18N
        mnuCadastrar.setText("Cadastrar");

        mniCadastrarAluno.setText(" Aluno");
        mniCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadastrarAlunoActionPerformed(evt);
            }
        });
        mnuCadastrar.add(mniCadastrarAluno);

        mniCadastrarProfessor.setText("Professor");
        mniCadastrarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCadastrarProfessorActionPerformed(evt);
            }
        });
        mnuCadastrar.add(mniCadastrarProfessor);

        jMenuBar1.add(mnuCadastrar);

        mnuPesquisar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\icones\\zoom.png")); // NOI18N
        mnuPesquisar.setText("Pesquisar");

        mniPesquisarAluno.setText("Aluno");
        mnuPesquisar.add(mniPesquisarAluno);

        mniPesquisarProfessor.setText("Professor");
        mnuPesquisar.add(mniPesquisarProfessor);

        mniPesquisarTurma.setText("Turma");
        mnuPesquisar.add(mniPesquisarTurma);

        jMenuBar1.add(mnuPesquisar);

        mnuSair.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\icones\\door_in.png")); // NOI18N
        mnuSair.setText("Sair");

        mniSair.setText("Sair");
        mniSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSairActionPerformed(evt);
            }
        });
        mnuSair.add(mniSair);

        jMenuBar1.add(mnuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSairActionPerformed
       this.dispose();
    }//GEN-LAST:event_mniSairActionPerformed

    private void mniCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastrarAlunoActionPerformed
        AlunoView aluno = new AlunoView();
        pnl_principal.removeAll();
        pnl_principal.add(aluno);
        pnl_principal.updateUI();
        
    }//GEN-LAST:event_mniCadastrarAlunoActionPerformed

    private void mniCadastrarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCadastrarProfessorActionPerformed
        ProfessorView professor = new ProfessorView();
        pnl_principal.removeAll();
        pnl_principal.add(professor);
        pnl_principal.updateUI();
    }//GEN-LAST:event_mniCadastrarProfessorActionPerformed

  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mniCadastrarAluno;
    private javax.swing.JMenuItem mniCadastrarProfessor;
    private javax.swing.JMenuItem mniPesquisarAluno;
    private javax.swing.JMenuItem mniPesquisarProfessor;
    private javax.swing.JMenuItem mniPesquisarTurma;
    private javax.swing.JMenuItem mniSair;
    private javax.swing.JMenu mnuCadastrar;
    private javax.swing.JMenu mnuPesquisar;
    private javax.swing.JMenu mnuSair;
    private javax.swing.JPanel pnl_principal;
    // End of variables declaration//GEN-END:variables
}
