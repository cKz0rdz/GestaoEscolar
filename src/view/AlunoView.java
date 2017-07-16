package view;

import dao.AlunoDAO;
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
import model.Aluno;


public class AlunoView extends javax.swing.JInternalFrame {

        Aluno aluno;
        AlunoDAO alunoDAO;
        List<Aluno> listaAlunos;
 
    public AlunoView() {
        alunoDAO = new AlunoDAO();
        listaAlunos = new ArrayList<>();
        initComponents();
        this.setVisible(true);
        atualizarTabelaAluno();
            }
    
  public void atualizarTabelaAluno(){
        aluno = new Aluno();
       try{
            listaAlunos = alunoDAO.listaAluno();
       }
       catch (SQLException ex){
       Logger.getLogger(AlunoView.class.getName()) .log(Level.SEVERE, null, ex);
       }
         String dados[][] = new String[listaAlunos.size()] [5]; 
            
       int i = 0;
       for (Aluno aluno : listaAlunos) {
       dados[i] [0] = String.valueOf(aluno.getCodAluno());
       dados[i] [1] = aluno.getNomeAluno();
       dados[i] [2] = aluno.getDatanascimentoAluno();
       dados[i] [3] = aluno.getEnderecoAluno();
       dados[i] [4] = aluno.getTelefoneAluno();
       i++;
       }
       String tituloColuna[] = {"Código", "Nome", "Data de Nascimento", "Endereço", "Telefone"};
       DefaultTableModel tabelaAluno = new DefaultTableModel();
       tabelaAluno.setDataVector(dados, tituloColuna);
       tblAluno.setModel(new DefaultTableModel(dados, tituloColuna){
       boolean[] canEdit = new boolean[]
       {
       false, false, false, false, false
       };
       
       public boolean isCellEditable (int rowIndex, int columnIndex){
           return canEdit[columnIndex];
       }
       });
       tblAluno.getColumnModel().getColumn(0) .setPreferredWidth(50);
       tblAluno.getColumnModel().getColumn(1) .setPreferredWidth(300);
       tblAluno.getColumnModel().getColumn(2) .setPreferredWidth(150);
       tblAluno.getColumnModel().getColumn(3) .setPreferredWidth(200);
       tblAluno.getColumnModel().getColumn(4) .setPreferredWidth(100);
       
       
       
       DefaultTableCellRenderer centralizado = new DefaultTableRenderer();
       centralizado.setHorizontalAlignment(SwingConstants.CENTER);
       tblAluno.getColumnModel().getColumn(0) .setCellRenderer(centralizado);
       tblAluno.setRowHeight(25);
       tblAluno.updateUI();
        }
  
    public void limpaCamposAluno(){
    
        txtCodigoAluno.setText("");
        txtNomeAluno.setText("");
        txtDataNascimentoAluno.setText("");
        cbSexoAluno.setSelectedItem("");
        cbCorAluno.setSelectedItem("");
        txtNaturalidadeAluno.setText("");
        txtUF.setText("");
        cbNacionalidadeAluno.setSelectedItem("");
        txtNumeroTermo.setText("");
        txtFolha.setText("");
        txtLivro.setText("");
        txtDataEmissao.setText("");
        txtUFCertidao.setText("");
        txtCPF.setText("");
        txtRG.setText("");
        txtDataEmissaoRG.setText("");
        txtUFRG.setText("");
        txtOrgaoExpedidor.setText("");
        txtPai.setText("");
        txtMae.setText("");
        txtEndereco.setText("");
        txtBairro.setText("");
        txtTelefone.setText("");
        txtTelefone1.setText("");    
    }
    public void ativaCampos(){
        txtNomeAluno.setEnabled(true);
        txtDataNascimentoAluno.setEnabled(true);
        cbSexoAluno.setEnabled(true);
        cbCorAluno.setEnabled(true);
        txtNaturalidadeAluno.setEnabled(true);
        txtUF.setEnabled(true);
        cbNacionalidadeAluno.setEnabled(true);
        txtNumeroTermo.setEnabled(true);
        txtFolha.setEnabled(true);
        txtLivro.setEnabled(true);
        txtDataEmissao.setEnabled(true);
        txtUFCertidao.setEnabled(true);
        txtCPF.setEnabled(true);
        txtRG.setEnabled(true);
        txtDataEmissaoRG.setEnabled(true);
        txtUFRG.setEnabled(true);
        txtOrgaoExpedidor.setEnabled(true);
        txtPai.setEnabled(true);
        txtMae.setEnabled(true);
        txtEndereco.setEnabled(true);
        txtBairro.setEnabled(true);
        txtTelefone.setEnabled(true);
        txtTelefone1.setEnabled(true);
    }
    
    public void desativaCampos(){
        txtNomeAluno.setEnabled(false);
        txtDataNascimentoAluno.setEnabled(false);
        cbSexoAluno.setEnabled(false);
        cbCorAluno.setEnabled(false);
        txtNaturalidadeAluno.setEnabled(false);
        txtUF.setEnabled(false);
        cbNacionalidadeAluno.setEnabled(false);
        txtNumeroTermo.setEnabled(false);
        txtFolha.setEnabled(false);
        txtLivro.setEnabled(false);
        txtDataEmissao.setEnabled(false);
        txtUFCertidao.setEnabled(false);
        txtCPF.setEnabled(false);
        txtRG.setEnabled(false);
        txtDataEmissaoRG.setEnabled(false);
        txtUFRG.setEnabled(false);
        txtOrgaoExpedidor.setEnabled(false);
        txtPai.setEnabled(false);
        txtMae.setEnabled(false);
        txtEndereco.setEnabled(false);
        txtBairro.setEnabled(false);
        txtTelefone.setEnabled(false);
        txtTelefone1.setEnabled(false);    
    }
    
    public void preparaNovo() {
        btnNovo.setEnabled(false);
        btnCadastrar.setEnabled(true);
        btnCancelar.setEnabled(true);
        tblAluno.setEnabled(false);
        tblAluno.clearSelection();
                
    }
    
    public void preparaCadastrar(){
         btnNovo.setEnabled(true);
         btnCadastrar.setEnabled(false);
         btnCancelar.setEnabled(false);
         tblAluno.setEnabled(true);
            }
    
    public void preparaCancelar() {
        btnNovo.setEnabled(true);
        btnCadastrar.setEnabled(false);
        btnCancelar.setEnabled(false);
        tblAluno.setEnabled(true);
            }
    
    public void preparaSelecaoTabela(){
        btnNovo.setEnabled(true);
        btnExcluir.setEnabled(true);
        btnAlterar.setEnabled(true);
    }
    
    public void preparaAlterar(){
        btnNovo.setEnabled(false);
        btnCadastrar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
        tblAluno.setEnabled(false);
        tblAluno.clearSelection();
    }
    
    public void preparaExcluir(){
        btnExcluir.setEnabled(false);
        btnAlterar.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtMae = new javax.swing.JTextField();
        lblMae = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPai = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        lblPai = new javax.swing.JLabel();
        lblEndereco = new javax.swing.JLabel();
        lblTelefoneAluno = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lblTelefone1 = new javax.swing.JLabel();
        txtTelefone1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblNumeroTermo = new javax.swing.JLabel();
        txtNumeroTermo = new javax.swing.JTextField();
        lblFolha = new javax.swing.JLabel();
        txtFolha = new javax.swing.JTextField();
        lblLivro = new javax.swing.JLabel();
        txtLivro = new javax.swing.JTextField();
        lblDataEmissao = new javax.swing.JLabel();
        txtDataEmissao = new javax.swing.JTextField();
        lblUFCertidao = new javax.swing.JLabel();
        txtOrgaoExpedidor = new javax.swing.JTextField();
        lblOrgaoExpedidor = new javax.swing.JLabel();
        txtUFRG = new javax.swing.JTextField();
        lblUFRG = new javax.swing.JLabel();
        txtDataEmissaoRG = new javax.swing.JTextField();
        lblDataEmissaoRG = new javax.swing.JLabel();
        txtRG = new javax.swing.JTextField();
        lblRG = new javax.swing.JLabel();
        txtCPF = new javax.swing.JTextField();
        lblCPF = new javax.swing.JLabel();
        txtUFCertidao = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        cbNacionalidadeAluno = new javax.swing.JComboBox();
        lblNacionalidade = new javax.swing.JLabel();
        txtUF = new javax.swing.JTextField();
        lblUF = new javax.swing.JLabel();
        txtNaturalidadeAluno = new javax.swing.JTextField();
        lblNaturalidadeAluno = new javax.swing.JLabel();
        txtNomeAluno = new javax.swing.JTextField();
        lblNomeAluno = new javax.swing.JLabel();
        txtCodigoAluno = new javax.swing.JTextField();
        lblCodigoAluno = new javax.swing.JLabel();
        lblDataNascimentoAluno = new javax.swing.JLabel();
        txtDataNascimentoAluno = new javax.swing.JTextField();
        cbSexoAluno = new javax.swing.JComboBox();
        lblSexoAluno = new javax.swing.JLabel();
        cbCorAluno = new javax.swing.JComboBox();
        lblCor = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnCadastrar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAluno = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

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

        setClosable(true);
        setMaximizable(true);
        setTitle("Cadastro de Alunos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados Complementares", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel2.setToolTipText("");

        txtMae.setEnabled(false);

        lblMae.setText("Mãe");

        jLabel1.setText("Bairro");

        txtPai.setEnabled(false);

        txtEndereco.setEnabled(false);

        txtBairro.setEnabled(false);

        lblPai.setText("Pai");

        lblEndereco.setText("Endereço");

        lblTelefoneAluno.setText("Telefone");

        txtTelefone.setEnabled(false);

        lblTelefone1.setText("Telefone 1");

        txtTelefone1.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPai)
                            .addComponent(lblEndereco))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPai, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(txtEndereco)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTelefoneAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblTelefone1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefone1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblMae))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMae, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(txtBairro))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMae)
                            .addComponent(txtMae, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPai))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelefoneAluno)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone1)
                    .addComponent(txtTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Certidão Civil (nascimento)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lblNumeroTermo.setText("Nº termo");

        txtNumeroTermo.setEnabled(false);

        lblFolha.setText("Folha");

        txtFolha.setEnabled(false);

        lblLivro.setText("Livro");

        txtLivro.setEnabled(false);

        lblDataEmissao.setText("Data emissão");

        txtDataEmissao.setEnabled(false);

        lblUFCertidao.setText("UF");

        txtOrgaoExpedidor.setEnabled(false);

        lblOrgaoExpedidor.setText("Orgão Expedidor");

        txtUFRG.setEnabled(false);

        lblUFRG.setText("UF");

        txtDataEmissaoRG.setEnabled(false);

        lblDataEmissaoRG.setText("Data emissão");

        txtRG.setEnabled(false);

        lblRG.setText("RG");

        txtCPF.setEnabled(false);

        lblCPF.setText("CPF");

        txtUFCertidao.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblNumeroTermo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroTermo, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFolha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLivro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDataEmissao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUFCertidao))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOrgaoExpedidor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrgaoExpedidor, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUFRG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUFRG, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblDataEmissaoRG)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtUFCertidao, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                    .addComponent(txtDataEmissaoRG)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroTermo)
                    .addComponent(txtNumeroTermo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFolha)
                    .addComponent(txtFolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLivro)
                    .addComponent(txtLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataEmissao)
                    .addComponent(txtDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUFCertidao)
                    .addComponent(txtUFCertidao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrgaoExpedidor)
                    .addComponent(lblRG)
                    .addComponent(lblCPF)
                    .addComponent(lblUFRG)
                    .addComponent(txtOrgaoExpedidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUFRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDataEmissaoRG)
                    .addComponent(txtDataEmissaoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Aluno", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        cbNacionalidadeAluno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Brasileira", "Estrangeira" }));
        cbNacionalidadeAluno.setEnabled(false);

        lblNacionalidade.setText("Nacionalidade");

        txtUF.setEnabled(false);

        lblUF.setText("UF");

        txtNaturalidadeAluno.setEnabled(false);

        lblNaturalidadeAluno.setText("Naturalidade");

        txtNomeAluno.setEnabled(false);

        lblNomeAluno.setText("Nome");

        txtCodigoAluno.setEditable(false);

        lblCodigoAluno.setText("Código");

        lblDataNascimentoAluno.setText("Data de Nascimento");

        txtDataNascimentoAluno.setText(" ");
        txtDataNascimentoAluno.setEnabled(false);

        cbSexoAluno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Masculino", "Feminino" }));
        cbSexoAluno.setEnabled(false);

        lblSexoAluno.setText("Sexo");

        cbCorAluno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Branca", "Preta", "Parda", "Amarela", "Indigena" }));
        cbCorAluno.setEnabled(false);

        lblCor.setText("Cor");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDataNascimentoAluno)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblCodigoAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblNomeAluno)
                        .addGap(18, 18, 18)
                        .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDataNascimentoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblSexoAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSexoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(lblCor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCorAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblNaturalidadeAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNaturalidadeAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblNacionalidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbNacionalidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbNacionalidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNacionalidade)
                        .addComponent(txtUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblUF))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodigoAluno)
                        .addComponent(txtCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNomeAluno)
                        .addComponent(txtNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblNaturalidadeAluno)
                        .addComponent(txtNaturalidadeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataNascimentoAluno)
                    .addComponent(txtDataNascimentoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSexoAluno)
                    .addComponent(cbSexoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCor)
                    .addComponent(cbCorAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnCadastrar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\icones\\user_add.png")); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setEnabled(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\icones\\wrench.png")); // NOI18N
        btnAlterar.setText("Alterar");
        btnAlterar.setEnabled(false);
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Downloads\\6239_16x16.png")); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tblAluno.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlunoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblAluno);

        btnNovo.setIcon(new javax.swing.ImageIcon("C:\\Users\\Carlos\\Desktop\\icones\\text_signature.png")); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (txtNomeAluno.getText().isEmpty() || txtDataNascimentoAluno.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Preencha todos os campos");     
        txtNomeAluno.requestFocusInWindow();
        }else if (txtCodigoAluno.getText().isEmpty()) {
            aluno = new Aluno();
            aluno.setNomeAluno(txtNomeAluno.getText());
            aluno.setSexoAluno(cbSexoAluno.getSelectedItem().toString());
            aluno.setCorAluno(cbCorAluno.getSelectedItem().toString());
            aluno.setNaturalidadeAluno (txtNaturalidadeAluno.getText());
            aluno.setUfAluno(txtUF.getText());
            aluno.setNacionalidadeAluno (cbNacionalidadeAluno.getSelectedItem() .toString());
            aluno.setNumerotermoAluno (txtNumeroTermo.getText());
            aluno.setFolhaAluno(txtFolha.getText());
            aluno.setLivroAluno(txtLivro.getText());
            aluno.setDataemissao (txtDataEmissao.getText());
            aluno.setUf (txtUFCertidao.getText());
            aluno.setCpfAluno (txtCPF.getText());
            aluno.setRgAluno (txtRG.getText());
            aluno.setDataemissaoRG (txtDataEmissaoRG.getText());
            aluno.setUfRG (txtUFRG.getText());
            aluno.setOrgaoexpedidor (txtOrgaoExpedidor.getText());
            aluno.setPaiAluno (txtPai.getText());
            aluno.setMaeAluno (txtMae.getText());
            aluno.setEnderecoAluno (txtEndereco.getText());
            aluno.setBairroAluno (txtBairro.getText());
            aluno.setTelefoneAluno (txtTelefone.getText());
            aluno.setTelefone1Aluno(txtTelefone1.getText());
        
            try {
            alunoDAO.salvar(aluno);
            }catch (SQLException ex) {
            Logger.getLogger(AlunoView.class.getName()).log(Level.SEVERE, null, ex);
  
            }
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
            atualizarTabelaAluno();
            preparaCadastrar();
            preparaCancelar();
            desativaCampos();
            limpaCamposAluno();
        }else {
             aluno = new Aluno();
            aluno.setNomeAluno(txtNomeAluno.getText());
            aluno.setSexoAluno(cbSexoAluno.getSelectedItem().toString());
            aluno.setCorAluno(cbCorAluno.getSelectedItem().toString());
            aluno.setNaturalidadeAluno (txtNaturalidadeAluno.getText());
            aluno.setUfAluno(txtUF.getText());
            aluno.setNacionalidadeAluno (cbNacionalidadeAluno.getSelectedItem() .toString());
            aluno.setNumerotermoAluno (txtNumeroTermo.getText());
            aluno.setFolhaAluno(txtFolha.getText());
            aluno.setLivroAluno(txtLivro.getText());
            aluno.setDataemissao (txtDataEmissao.getText());
            aluno.setUf (txtUFCertidao.getText());
            aluno.setCpfAluno (txtCPF.getText());
            aluno.setRgAluno (txtRG.getText());
            aluno.setDataemissaoRG (txtDataEmissaoRG.getText());
            aluno.setUfRG (txtUFRG.getText());
            aluno.setOrgaoexpedidor (txtOrgaoExpedidor.getText());
            aluno.setPaiAluno (txtPai.getText());
            aluno.setMaeAluno (txtMae.getText());
            aluno.setEnderecoAluno (txtEndereco.getText());
            aluno.setBairroAluno (txtBairro.getText());
            aluno.setTelefoneAluno (txtTelefone.getText());
            aluno.setTelefone1Aluno(txtTelefone1.getText());
        
            try {
            alunoDAO.salvar(aluno);
            }catch (SQLException ex) {
            Logger.getLogger(AlunoView.class.getName()).log(Level.SEVERE, null, ex);
        
        }
            atualizarTabelaAluno();
            preparaCadastrar();
            preparaCancelar();
            desativaCampos();
    }//GEN-LAST:event_btnCadastrarActionPerformed
    }
    private void tblAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlunoMouseClicked
        txtCodigoAluno.setText((String) tblAluno.getValueAt(tblAluno.getSelectedRow(), 0));
        txtNomeAluno.setText((String) tblAluno.getValueAt(tblAluno.getSelectedRow(), 1));
        txtDataNascimentoAluno.setText((String) tblAluno.getValueAt(tblAluno.getSelectedRow(), 2));
        txtTelefone.setText((String) tblAluno.getValueAt(tblAluno.getSelectedRow(),3));
        preparaSelecaoTabela();
    }//GEN-LAST:event_tblAlunoMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
            if (txtCodigoAluno.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Selecione um aluno");
        }else {
        aluno = new Aluno();
        aluno.setCodAluno(Integer.parseInt(txtCodigoAluno.getText()));
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja Excluir: " + txtNomeAluno.getText());
        if (confirma ==0)
        {
        try {
            alunoDAO.excluir(aluno);
        } catch (SQLException ex) {
        Logger.getLogger(AlunoView.class.getName()).log(Level.SEVERE, null, ex);
        }
            limpaCamposAluno();
            atualizarTabelaAluno();
            preparaExcluir();
        }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpaCamposAluno();
        preparaNovo();
        ativaCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        preparaAlterar();
        ativaCampos();
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpaCamposAluno();
        preparaCancelar();
        desativaCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox cbCorAluno;
    private javax.swing.JComboBox cbNacionalidadeAluno;
    private javax.swing.JComboBox cbSexoAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblCodigoAluno;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblDataEmissao;
    private javax.swing.JLabel lblDataEmissaoRG;
    private javax.swing.JLabel lblDataNascimentoAluno;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblFolha;
    private javax.swing.JLabel lblLivro;
    private javax.swing.JLabel lblMae;
    private javax.swing.JLabel lblNacionalidade;
    private javax.swing.JLabel lblNaturalidadeAluno;
    private javax.swing.JLabel lblNomeAluno;
    private javax.swing.JLabel lblNumeroTermo;
    private javax.swing.JLabel lblOrgaoExpedidor;
    private javax.swing.JLabel lblPai;
    private javax.swing.JLabel lblRG;
    private javax.swing.JLabel lblSexoAluno;
    private javax.swing.JLabel lblTelefone1;
    private javax.swing.JLabel lblTelefoneAluno;
    private javax.swing.JLabel lblUF;
    private javax.swing.JLabel lblUFCertidao;
    private javax.swing.JLabel lblUFRG;
    private javax.swing.JTable tblAluno;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtCodigoAluno;
    private javax.swing.JTextField txtDataEmissao;
    private javax.swing.JTextField txtDataEmissaoRG;
    private javax.swing.JTextField txtDataNascimentoAluno;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtFolha;
    private javax.swing.JTextField txtLivro;
    private javax.swing.JTextField txtMae;
    private javax.swing.JTextField txtNaturalidadeAluno;
    private javax.swing.JTextField txtNomeAluno;
    private javax.swing.JTextField txtNumeroTermo;
    private javax.swing.JTextField txtOrgaoExpedidor;
    private javax.swing.JTextField txtPai;
    private javax.swing.JTextField txtRG;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTelefone1;
    private javax.swing.JTextField txtUF;
    private javax.swing.JTextField txtUFCertidao;
    private javax.swing.JTextField txtUFRG;
    // End of variables declaration//GEN-END:variables

    private static class DefaultTableRenderer extends DefaultTableCellRenderer {

        public DefaultTableRenderer() {
        }
    }

  
    }

