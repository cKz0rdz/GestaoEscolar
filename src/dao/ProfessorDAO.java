package dao;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Professor;

public class ProfessorDAO {
    
    
    PreparedStatement pst;
    String sql;
    
    public void salvar (Professor prof) throws SQLException {
    sql = "insert into professor values (?,?,?,?,?,?,?,?,?,?,?)";
    pst = Conexao.getInstance().prepareStatement(sql);
    pst.setInt (1, 0);
    pst.setString (2, prof.getNomeProfessor());
    pst.setString (3, prof.getDatanascimentoProfessor());
    pst.setString (4, prof.getCpfprofessor());
    pst.setString (5, prof.getRgprofessor());
    pst.setString (6, prof.getOrgaoexpedidorProfessor());
    pst.setString (7, prof.getMatriculaProfessor());
    pst.setString (8, prof.getEderecoProfessor());
    pst.setString (9, prof.getBairroProfessor());
    pst.setString (10, prof.getTelefoneProfessor());
    pst.setString (11, prof.getEmailProfessor());
    pst.execute();
    pst.close();       
    }
    
    public void excluir (Professor professor) throws SQLException {
    
        sql = "delete from professor where codigoprofessor=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, professor.getCodProfessor());
        pst.execute();
        pst.close();    
    }
    public void alterar (Professor professor) throws SQLException {
    
        sql = "update professor set nomeprofessor=?, datanascimentoprofessor=?, cpfprofessor=?, rgprofessor=?,"
                + "orgaoexpedidor=?, matricula=?, enderecoprofessor=?, bairroprofessor=?, telefoneprofessor=?,"
                + "email=?, where codigoprofessor=?";
        
        pst.setString (1, professor.getNomeProfessor());
        pst.setString (2, professor.getDatanascimentoProfessor());
        pst.setString (3, professor.getCpfprofessor());
        pst.setString (4, professor.getRgprofessor());
        pst.setString (5, professor.getOrgaoexpedidorProfessor());
        pst.setString (6, professor.getMatriculaProfessor());
        pst.setString (7, professor.getEderecoProfessor());
        pst.setString (8, professor.getBairroProfessor());
        pst.setString (9, professor.getTelefoneProfessor());
        pst.setString (10, professor.getEmailProfessor());
        pst.setInt (11, professor.getCodProfessor());  
    }
    
    
    public List<Professor> listaProfessor() throws SQLException {
        List<Professor> listaProfessor;
        listaProfessor = new ArrayList<>();
        
        sql = "select * from professor order by nomeprofessor";
        pst = Conexao.getInstance().prepareStatement(sql);
        
        ResultSet rs = pst.executeQuery();
        
         while (rs.next()){
             listaProfessor.add(new Professor ( rs.getInt("codigoprofessor"),
                                                rs.getString ("nomeprofessor"),
                                                rs.getString ("datanascimentoprofessor"),
                                                rs.getString ("cpfprofessor"),
                                                rs.getString ("rgprofessor"),
                                                rs.getString ("orgaoexpedidor"),
                                                rs.getString ("matricula"),
                                                rs.getString ("enderecoprofessor"),
                                                rs.getString ("bairroprofessor"),
                                                rs.getString ("telefoneprofessor"),
                                                rs.getString ("email")));
         }
         pst.close();
        return listaProfessor;
    
    }

    private static class SQLEXception extends Exception {

        public SQLEXception() {
        }
    }
}
