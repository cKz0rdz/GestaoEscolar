package model;

public class Professor {
    
    private int codProfessor;
    private String nomeProfessor;
    private String datanascimentoProfessor;
    private String cpfprofessor;
    private String rgprofessor;
    private String orgaoexpedidorProfessor;
    private String matriculaProfessor;
    private String ederecoProfessor;
    private String telefoneProfessor;
    private String emailProfessor;

    public Professor(int codProfessor, String nomeProfessor, String datanascimentoProfessor, String cpfprofessor, String rgprofessor, String orgaoexpedidorProfessor, String matriculaProfessor, String ederecoProfessor, String bairroProfessor, String telefoneProfessor, String emailProfessor) {
        this.codProfessor = codProfessor;
        this.nomeProfessor = nomeProfessor;
        this.datanascimentoProfessor = datanascimentoProfessor;
        this.cpfprofessor = cpfprofessor;
        this.rgprofessor = rgprofessor;
        this.orgaoexpedidorProfessor = orgaoexpedidorProfessor;
        this.matriculaProfessor = matriculaProfessor;
        this.ederecoProfessor = ederecoProfessor;
        this.bairroProfessor = bairroProfessor;
        this.telefoneProfessor = telefoneProfessor;
        this.emailProfessor = emailProfessor;
        
    }

    public Professor() {
    }
    private String bairroProfessor;

    public int getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(int codProfessor) {
        this.codProfessor = codProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getDatanascimentoProfessor() {
        return datanascimentoProfessor;
    }

    public void setDatanascimentoProfessor(String datanascimentoProfessor) {
        this.datanascimentoProfessor = datanascimentoProfessor;
    }

    public String getCpfprofessor() {
        return cpfprofessor;
    }

    public void setCpfprofessor(String cpfprofessor) {
        this.cpfprofessor = cpfprofessor;
    }

    public String getRgprofessor() {
        return rgprofessor;
    }

    public void setRgprofessor(String rgprofessor) {
        this.rgprofessor = rgprofessor;
    }

    public String getOrgaoexpedidorProfessor() {
        return orgaoexpedidorProfessor;
    }

    public void setOrgaoexpedidorProfessor(String orgaoexpedidorProfessor) {
        this.orgaoexpedidorProfessor = orgaoexpedidorProfessor;
    }

    public String getMatriculaProfessor() {
        return matriculaProfessor;
    }

    public void setMatriculaProfessor(String matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }

    public String getEderecoProfessor() {
        return ederecoProfessor;
    }

    public void setEderecoProfessor(String ederecoProfessor) {
        this.ederecoProfessor = ederecoProfessor;
    }

    public String getBairroProfessor() {
        return bairroProfessor;
    }

    public void setBairroProfessor(String bairroProfessor) {
        this.bairroProfessor = bairroProfessor;
    }

    public String getTelefoneProfessor() {
        return telefoneProfessor;
    }

    public void setTelefoneProfessor(String telefoneProfessor) {
        this.telefoneProfessor = telefoneProfessor;
    }

    public String getEmailProfessor() {
        return emailProfessor;
    }

    public void setEmailProfessor(String emailProfessor) {
        this.emailProfessor = emailProfessor;
    }

    public void setDataNascimentoProfessor(String datanascimentoProfessor) {
        this.datanascimentoProfessor = datanascimentoProfessor;
    }

     
  
}
