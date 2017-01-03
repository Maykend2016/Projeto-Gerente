
package control;

import banco_de_dados.AcessoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Projeto;

/**
 *
 * @author mayke
 */
public class ProjetoControl {
    
     private static ProjetoControl controladorProjeto;
    
  
    public static ProjetoControl getInstance(){
        if(controladorProjeto == null){
            controladorProjeto = new ProjetoControl();
            return controladorProjeto;
        }
        return controladorProjeto;
    }
  
    public static boolean cadastrarProjeto(Projeto projeto){
        AcessoBD conecta = new AcessoBD();
        conecta.Conexao();
        String sql = "INSERT INTO projeto() VALUES(?,?,?,?)";
        
        
        
        try {
            
            PreparedStatement pst = conecta.conn.prepareStatement(sql);
            pst.setString(1, null);
            pst.setString(2, projeto.getDescricaoGeral());
            pst.setString(3, projeto.getDataDeCriacao());
            pst.setString(4, projeto.getDataDeFinalizacao());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Conectar! \n Erro: " + ex.getMessage());
        }
        conecta.Conexao();
        return true;
    }
    
    public static boolean deletarProjeto(){
        return true;
    }
    
    public static boolean editarProjeto(){
        return true;
    }
    
    public static ArrayList listarProjeto(){
        AcessoBD conecta = new AcessoBD();
        conecta.Conexao();
        
        try {
            ArrayList projeto = new ArrayList();
            String sql = "SELECT * FROM projeto";
            
            PreparedStatement pst = conecta.conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                
                projeto.add(new Object[]{ rs.getInt("id"),
                    rs.getString("descricao"), 
                    rs.getString("data_criacao"), 
                    rs.getString("data_final")});
            }
            return projeto;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
