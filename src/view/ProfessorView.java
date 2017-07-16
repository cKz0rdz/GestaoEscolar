package view;

import dao.ProfessorDAO;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import model.Professor;

public class ProfessorView extends javax.swing.JInternalFrame {
        
    Professor professor;
    ProfessorDAO professorDAO;
    List<Professor> listaProfessores;
    
  
    public ProfessorView() {
        professorDAO = new ProfessorDAO();
        listaProfessores = new ArrayList<>();
        initComponents();
        this.setVisible(true);
        atualizarTabelaProfessor();
    }
public void atualizarTabelaProfessor() {

        professor = new Professor();
        try {
        listaProfessores = professorDAO.listaProfessor();
                
        }catch (SQLException ex){
       Logger.getLogger(AlunoView.class.getName()) .log(Level.SEVERE, null, ex);
       }
       String dados[][] = new String[listaProfessores.size()] [5];
        
        int i = 0;
        
        for (Professor professor : listaProfessores) {
        
            dados[i] [0] = String.valueOf(professor.getCodProfessor());
            dados[i] [1] =  professor.getNomeProfessor();
            dados[i] [2] = professor.getDatanascimentoProfessor();
            dados[i] [3] = professor.getEderecoProfessor();
            dados[i] [4] = professor.getTelefoneProfessor();
            i++;
        }
            String tituloColuna[] = {"Código", "Nome", "Data de Nascimento", "Endereço", "Telefone"};
             DefaultTableModel tabelaProfessor = new DefaultTableModel();
             tabelaProfessor.setDataVector(dados, tituloColuna);
             tblProfessor.setModel(new DefaultTableModel(dados, tituloColuna){
             boolean[] canEdit = new boolean[]
       {
            false, false, false, false, false
       };
       
       public boolean isCellEditable (int rowIndex, int columnIndex){
           return canEdit[columnIndex];
       }
       });
             
             tblProfessor.getColumnModel().getColumn(0) .setPreferredWidth(50);
             tblProfessor.getColumnModel().getColumn(1) .setPreferredWidth(300);
             tblProfessor.getColumnModel().getColumn(2) .setPreferredWidth(150);
             tblProfessor.getColumnModel().getColumn(3) .setPreferredWidth(200);
             tblProfessor.getColumnModel().getColumn(4) .setPreferredWidth(100);
       
             DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
             centralizado.setHorizontalAlignment(SwingConstants.CENTER);
             tblProfessor.getColumnModel().getColumn(0) .setCellRenderer(centralizado);
             tblProfessor.setRowHeight(25);
             tblProfessor.updateUI();       
}      
        

public void ativaCampos(){

        txtNomeProfessor.setEnabled(true);
        txtDataNascimentoProfessor.setEnabled(true);
        txtCpfProfessor.setEnabled(true);
        txtRgProfessor.setEnabled(true);
        txtOrgaoExpedidorProfessor.setEnabled(true);
        txtMatriculaProfessor.setEnabled(true);
        txtEnderecoProfessor.setEnabled(true);
        txtBairroProfessor.setEnabled(true);
        txtTelefoneProfessor.setEnabled(true);
        txtEmailProfessor.setEnabled(true);
}
public void desativaCampos() {

        txtNomeProfessor.setEnabled(false);
        txtDataNascimentoProfessor.setEnabled(false);
        txtCpfProfessor.setEnabled(false);
        txtRgProfessor.setEnabled(false);
        txtOrgaoExpedidorProfessor.setEnabled(false);
        txtMatriculaProfessor.setEnabled(false);
        txtEnderecoProfessor.setEnabled(false);
        txtBairroProfessor.setEnabled(false);
        txtTelefoneProfessor.setEnabled(false);
        txtEmailProfessor.setEnabled(false);
}
   public void preparaNovo() {
       btnNovoProfessor.setEnabled(false);
       btnCadastrarProfessor.setEnabled(true);
       btnCancelar.setEnabled(true);
       tblProfessor.setEnabled(false);
       tblProfessor.clearSelection();
       
    }
    
    public void preparaCadastrar(){
        btnNovoProfessor.setEnabled(true);
        btnCadastrarProfessor.setEnabled(false);
        btnCancelar.setEnabled(false);
        tblProfessor.setEnabled(true);
    }
    
      public void preparaCancelar (){
        btnNovoProfessor.setEnabled(true);
        btnCadastrarProfessor.setEnabled(false);
        btnCancelar.setEnabled(false);
        tblProfessor.setEnabled(true);
      }
      public void preparaSelecaoTabela(){
    btnNovoProfessor.setEnabled(true);
    btnExcluirProfessor.setEnabled(true);
    btnAlterarProfessor.setEnabled(true);
    }
    
    public void preparaAlterar(){
        btnNovoProfessor.setEnabled(false);
        btnExcluirProfessor.setEnabled(false);
        btnAlterarProfessor.setEnabled(false);
        btnCadastrarProfessor.setEnabled(true);
        btnCancelar.setEnabled(true);
        tblProfessor.setEnabled(false);
        tblProfessor.clearSelection();
    }
    
    public void preparaExcluir(){
        btnExcluirProfessor.setEnabled(false);
        btnAlterarProfessor.setEnabled(false);
    }
        public void limpaCamposProfessor(){
        
        txtCodigoProfessor.setText("");
        txtNomeProfessor.setText("");
        txtDataNascimentoProfessor.setText("");
        txtCpfProfessor.setText("");
        txtRgProfessor.setText("");
        txtOrgaoExpedidorProfessor.setText("");
        txtMatriculaProfessor.setText("");
        txtEnderecoProfessor.setText("");
        txtBairroProfessor.setText("");
        txtTelefoneProfessor.setText("");
        txtEmailProfessor.setText("");    
        }
        
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_professor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblCodigoProfessor = new javax.swing.JLabel();
        txtCodigoProfessor = new javax.swing.JTextField();
        lblNomeProfessor = new javax.swing.JLabel();
        txtNomeProfessor = new javax.swing.JTextField();
        lblDataNascimentoProfessor = new javax.swing.JLabel();
        txtDataNascimentoProfessor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCpfProfessor = new javax.swing.JTextField();
        lblRgProfessor = new javax.swing.JLabel();
        txtRgProfessor = new javax.swing.JTextField();
        lblOrgaoExpedidorProfessor = new javax.swing.JLabel();
        txtOrgaoExpedidorProfessor = new javax.swing.JTextField();
        lblMatriculaProfessor = new javax.swing.JLabel();
        txtMatriculaProfessor = new javax.swing.JTextField();
        lblEnderecoProfessor = new javax.swing.JLabel();
        txtEnderecoProfessor = new javax.swing.JTextField();
        lblBairroProfessor = new javax.swing.JLabel();
        txtBairroProfessor = new javax.swing.JTextField();
        lblTelefoneProfessor = new javax.swing.JLabel();
        txtTelefoneProfessor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtEmailProfessor = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnCadastrarProfessor = new javax.swing.JButton();
        btnAlterarProfessor = new javax.swing.JButton();
        btnExcluirProfessor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProfessor = new javax.swing.JTable();
        btnNovoProfessor = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setTitle("Cadastro de Professor");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Professor", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblCodigoProfessor.setText("Código");

        txtCodigoProfessor.setEditable(false);

        lblNomeProfessor.setText("Nome");

        txtNomeProfessor.setEnabled(false);

        lblDataNascimentoProfessor.setText("Data Nascimento");

        txtDataNascimentoProfessor.setEnabled(false);

        jLabel2.setText("CPF");

        txtCpfProfessor.setEnabled(false);

        lblRgProfessor.setText("RG");

        txtRgProfessor.setEnabled(false);

        lblOrgaoExpedidorProfessor.setText("Orgão Expedidor");

        txtOrgaoExpedidorProfessor.setEnabled(false);

        lblMatriculaProfessor.setText("Matrícula");

        txtMatriculaProfessor.setEnabled(false);
        txtMatriculaProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaProfessorActionPerformed(evt);
            }
        });

        lblEnderecoProfessor.setText("Endereço");

        txtEnderecoProfessor.setEnabled(false);

        lblBairroProfessor.setText("Bairro");

        txtBairroProfessor.setEnabled(false);

        lblTelefoneProfessor.setText("Telefone");

        txtTelefoneProfessor.setEnabled(false);

        jLabel1.setText("E-mail");

        txtEmailProfessor.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCodigoProfessor)
                    .addComponent(jLabel2)
                    .addComponent(lblMatriculaProfessor)
                    .addComponent(lblEnderecoProfessor)
                    .addComponent(lblTelefoneProfessor)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCodigoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNomeProfessor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblDataNascimentoProfessor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDataNascimentoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCpfProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRgProfessor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRgProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblOrgaoExpedidorProfessor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtOrgaoExpedidorProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMatriculaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtEnderecoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(74, 74, 74)
                                .addComponent(lblBairroProfessor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBairroProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTelefoneProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEmailProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoProfessor)
                    .addComponent(txtCodigoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomeProfessor)
                    .addComponent(txtNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataNascimentoProfessor)
                    .addComponent(txtDataNascimentoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCpfProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRgProfessor)
                    .addComponent(txtRgProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrgaoExpedidorProfessor)
                    .addComponent(txtOrgaoExpedidorProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatriculaProfessor)
                    .addComponent(txtMatriculaProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnderecoProfessor)
                    .addComponent(txtEnderecoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBairroProfessor)
                    .addComponent(txtBairroProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefoneProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefoneProfessor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmailProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnCadastrarProfessor.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\icones\\user_add.png")); // NOI18N
        btnCadastrarProfessor.setText("Cadastrar");
        btnCadastrarProfessor.setEnabled(false);
        btnCadastrarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProfessorActionPerformed(evt);
            }
        });

        btnAlterarProfessor.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\icones\\wrench.png")); // NOI18N
        btnAlterarProfessor.setText("Alterar");
        btnAlterarProfessor.setEnabled(false);
        btnAlterarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarProfessorActionPerformed(evt);
            }
        });

        btnExcluirProfessor.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Downloads\\6239_16x16.png")); // NOI18N
        btnExcluirProfessor.setText("Excluir");
        btnExcluirProfessor.setEnabled(false);
        btnExcluirProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirProfessorActionPerformed(evt);
            }
        });

        tblProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Data de Nascimento", "Endereço", "Telefone"
            }
        ));
        tblProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProfessorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProfessor);

        btnNovoProfessor.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\icones\\text_signature.png")); // NOI18N
        btnNovoProfessor.setText("Novo");
        btnNovoProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProfessorActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\icones\\cancel.png")); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnNovoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(btnAlterarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout pnl_professorLayout = new javax.swing.GroupLayout(pnl_professor);
        pnl_professor.setLayout(pnl_professorLayout);
        pnl_professorLayout.setHorizontalGroup(
            pnl_professorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_professorLayout.createSequentialGroup()
                .addGroup(pnl_professorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_professorLayout.setVerticalGroup(
            pnl_professorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_professorLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_professor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_professor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProfessorActionPerformed
        if (txtNomeProfessor.getText() .isEmpty() || txtMatriculaProfessor.getText() .isEmpty()){
        JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        txtNomeProfessor.requestFocusInWindow();
        }else if (txtCodigoProfessor.getText() .isEmpty()) {
            professor = new Professor();
            professor.setNomeProfessor(txtNomeProfessor.getText());
            professor.setDataNascimentoProfessor(txtDataNascimentoProfessor.getText().toString());
            professor.setCpfprofessor(txtCpfProfessor.getText());
            professor.setRgprofessor(txtRgProfessor.getText());
            professor.setOrgaoexpedidorProfessor(txtOrgaoExpedidorProfessor.getText());
            professor.setMatriculaProfessor(txtMatriculaProfessor.getText());
            professor.setEderecoProfessor(txtEnderecoProfessor.getText());
            professor.setBairroProfessor(txtBairroProfessor.getText());
            professor.setTelefoneProfessor(txtTelefoneProfessor.getText());
            professor.setEmailProfessor(txtEmailProfessor.getText());
            
            try {
                professorDAO.salvar(professor);
                
            } catch (SQLException ex) {
                Logger.getLogger(ProfessorView.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Professosr cadastrado com sucesso");
            atualizarTabelaProfessor();
            preparaNovo();
            desativaCampos();
            limpaCamposProfessor();
        
        } else {
        professor = new Professor();
            professor.setNomeProfessor(txtNomeProfessor.getText());
            professor.setDataNascimentoProfessor(txtDataNascimentoProfessor.getText().toString());
            professor.setCpfprofessor(txtCpfProfessor.getText());
            professor.setRgprofessor(txtRgProfessor.getText());
            professor.setOrgaoexpedidorProfessor(txtOrgaoExpedidorProfessor.getText());
            professor.setMatriculaProfessor(txtMatriculaProfessor.getText());
            professor.setEderecoProfessor(txtEnderecoProfessor.getText());
            professor.setBairroProfessor(txtBairroProfessor.getText());
            professor.setTelefoneProfessor(txtTelefoneProfessor.getText());
            professor.setEmailProfessor(txtEmailProfessor.getText());
            
            try {
                professorDAO.salvar(professor);
                
            } catch (SQLException ex) {
                Logger.getLogger(ProfessorView.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            atualizarTabelaProfessor();
            preparaNovo();
            desativaCampos();
        
        }
        
        
        
        
    }//GEN-LAST:event_btnCadastrarProfessorActionPerformed

    private void txtMatriculaProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaProfessorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaProfessorActionPerformed

    private void tblProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProfessorMouseClicked
        txtCodigoProfessor.setText((String) tblProfessor.getValueAt(tblProfessor.getSelectedRow(), 0));
        txtNomeProfessor.setText((String) tblProfessor.getValueAt(tblProfessor.getSelectedRow(), 1));
        txtDataNascimentoProfessor.setText((String) tblProfessor.getValueAt(tblProfessor.getSelectedRow(), 2));
        txtEnderecoProfessor.setText((String) tblProfessor.getValueAt(tblProfessor.getSelectedRow(), 3));
        txtTelefoneProfessor.setText((String) tblProfessor.getValueAt(tblProfessor.getSelectedRow(),4));
        preparaSelecaoTabela();
    }//GEN-LAST:event_tblProfessorMouseClicked

    private void btnExcluirProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirProfessorActionPerformed
        if(txtCodigoProfessor.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Selecione um professor");
        }else {
        professor = new Professor();
        professor.setCodProfessor(Integer.parseInt(txtCodigoProfessor.getText()));
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja Excluir: " + txtNomeProfessor.getText());
        if (confirma ==0) {
        try {
            professorDAO.excluir(professor);
        }catch (SQLException ex){
        Logger.getLogger(ProfessorView.class.getName()).log(Level.SEVERE, null, ex);
        }
        limpaCamposProfessor();
        atualizarTabelaProfessor();
        preparaExcluir();
        }
        }
    }//GEN-LAST:event_btnExcluirProfessorActionPerformed

    private void btnNovoProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProfessorActionPerformed
        limpaCamposProfessor();
        preparaNovo();
        ativaCampos();
    }//GEN-LAST:event_btnNovoProfessorActionPerformed

    private void btnAlterarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarProfessorActionPerformed
       preparaAlterar();
       ativaCampos();
       
    }//GEN-LAST:event_btnAlterarProfessorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       limpaCamposProfessor();
       preparaCancelar();
       desativaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarProfessor;
    private javax.swing.JButton btnCadastrarProfessor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluirProfessor;
    private javax.swing.JButton btnNovoProfessor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBairroProfessor;
    private javax.swing.JLabel lblCodigoProfessor;
    private javax.swing.JLabel lblDataNascimentoProfessor;
    private javax.swing.JLabel lblEnderecoProfessor;
    private javax.swing.JLabel lblMatriculaProfessor;
    private javax.swing.JLabel lblNomeProfessor;
    private javax.swing.JLabel lblOrgaoExpedidorProfessor;
    private javax.swing.JLabel lblRgProfessor;
    private javax.swing.JLabel lblTelefoneProfessor;
    private javax.swing.JPanel pnl_professor;
    private javax.swing.JTable tblProfessor;
    private javax.swing.JTextField txtBairroProfessor;
    private javax.swing.JTextField txtCodigoProfessor;
    private javax.swing.JTextField txtCpfProfessor;
    private javax.swing.JTextField txtDataNascimentoProfessor;
    private javax.swing.JTextField txtEmailProfessor;
    private javax.swing.JTextField txtEnderecoProfessor;
    private javax.swing.JTextField txtMatriculaProfessor;
    private javax.swing.JTextField txtNomeProfessor;
    private javax.swing.JTextField txtOrgaoExpedidorProfessor;
    private javax.swing.JTextField txtRgProfessor;
    private javax.swing.JTextField txtTelefoneProfessor;
    // End of variables declaration//GEN-END:variables

    private static class profDAO extends ProfessorDAO {

        public profDAO() {
        }
    }

    private static class ProfDAO extends ProfessorDAO {

        public ProfDAO() {
        }
    }
}
