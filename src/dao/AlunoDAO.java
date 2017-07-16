package dao;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Aluno;

public class AlunoDAO {

    
    PreparedStatement pst;
    String sql;
    
    public void salvar (Aluno aluno) throws SQLException{
        
    sql = "insert into aluno values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    pst = Conexao.getInstance().prepareStatement(sql);   
    pst.setInt (1, 0);
    pst.setString (2, aluno.getNomeAluno());
    pst.setString (3, aluno.getDatanascimentoAluno());
    pst.setString (4, aluno.getSexoAluno());
    pst.setString (5, aluno.getCorAluno());
    pst.setString (6, aluno.getNaturalidadeAluno());
    pst.setString (7, aluno.getUfAluno());
    pst.setString (8, aluno.getNacionalidadeAluno());
    pst.setString (9, aluno.getNumerotermoAluno());
    pst.setString (10, aluno.getFolhaAluno());
    pst.setString (11, aluno.getLivroAluno());
    pst.setString (12, aluno.getDataemissao());
    pst.setString (13, aluno.getUf());
    pst.setString (14, aluno.getCpfAluno());
    pst.setString (15, aluno.getRgAluno());
    pst.setString (16, aluno.getDataemissaoRG());
    pst.setString (17, aluno.getUfRG());
    pst.setString (18, aluno.getOrgaoexpedidor());
    pst.setString (19, aluno.getPaiAluno());
    pst.setString (20, aluno.getMaeAluno());
    pst.setString (21, aluno.getEnderecoAluno());
    pst.setString (22, aluno.getBairroAluno());
    pst.setString (23, aluno.getTelefoneAluno());
    pst.setString (24, aluno.getTelefone1Aluno());
    pst.execute();
    pst.close(); 
    
}

    public List<Aluno> listaAluno() throws SQLException {     
        List<Aluno> listaAluno;
        listaAluno = new ArrayList<>();
        
        sql = "select * from aluno order by nome";
        pst = Conexao.getInstance().prepareStatement(sql);
        
        ResultSet rs = pst.executeQuery();
        
        while (rs.next()){
            listaAluno.add(new Aluno( rs.getInt("codigo"),
                                      rs.getString("nome"),
                                      rs.getString("datanascimento"),
                                      rs.getString("sexo"),
                                      rs.getString("cor"),
                                      rs.getString("naturalidade"),
                                      rs.getString("uf"),
                                      rs.getString("nacionalidade"),
                                      rs.getString("ntermo"),
                                      rs.getString("folha"),
                                      rs.getString("livro"),
                                      rs.getString("dataemissao"),
                                      rs.getString("uflivro"),
                                      rs.getString("cpfaluno"),
                                      rs.getString("rgaluno"),
                                      rs.getString("dataemissaorg"),
                                      rs.getString("ufrg"),
                                      rs.getString("orgaoexpedidor"),
                                      rs.getString("pai"),
                                      rs.getString("mae"),
                                      rs.getString("enderecoaluno"),
                                      rs.getString("bairro"),
                                      rs.getString("telefone"),
                                      rs.getString("telefone1")));
        }
        pst.close();
        return listaAluno;
  }

    private static class SQLExcepiton extends Exception {

        public SQLExcepiton() {
        }
        
        
    }
    public void excluir (Aluno aluno) throws SQLException {
        
        sql = "delete from aluno where codigo=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, aluno.getCodAluno());
        pst.execute();
        pst.close();
        }
  public void alterar (Aluno aluno) throws SQLException {
      
      sql = "update aluno set nome=?, datanascimento=?, sexo=?, cor=?, naturalidade=?,"
              + "uf=?, nacionalidade=?, ntermo=?, folha=?, livro=?, dataemissao=?,"
              + " uflivro=?, cpfaluno=?,rgaluno=?, dataemissaorg=?,ufrg=?"
              + "orgaoexpedidor=?, pai=?,mae=?, enderecoaluno=?,bairro=?"
              + "telefone=?, telefone1=? where codigo=? ";
      
    pst.setString (1, aluno.getNomeAluno());      
    pst.setString (2, aluno.getDatanascimentoAluno());
    pst.setString (3, aluno.getSexoAluno());
    pst.setString (4, aluno.getCorAluno());
    pst.setString (5, aluno.getNaturalidadeAluno());
    pst.setString (6, aluno.getUfAluno());
    pst.setString (7, aluno.getNacionalidadeAluno());
    pst.setString (8, aluno.getNumerotermoAluno());
    pst.setString (9, aluno.getFolhaAluno());
    pst.setString (10, aluno.getLivroAluno());
    pst.setString (11, aluno.getDataemissao());
    pst.setString (12, aluno.getUf());
    pst.setString (13, aluno.getCpfAluno());
    pst.setString (14, aluno.getRgAluno());
    pst.setString (15, aluno.getDataemissaoRG());
    pst.setString (16, aluno.getUfRG());
    pst.setString (17, aluno.getOrgaoexpedidor());
    pst.setString (18, aluno.getPaiAluno());
    pst.setString (19, aluno.getMaeAluno());
    pst.setString (20, aluno.getEnderecoAluno());
    pst.setString (21, aluno.getBairroAluno());
    pst.setString (22, aluno.getTelefoneAluno());
    pst.setString (23, aluno.getTelefone1Aluno());
  }
}
