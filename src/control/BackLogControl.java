package control;

import banco_de_dados.AcessoBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.BackLog;
import model.Usuario;

/**
 *
 * @author Raiff
 */
public class BackLogControl {
    
    private static BackLogControl controladorBacklog;
    
    //singleton
    public static BackLogControl getInstance(){
        if(controladorBacklog == null){
            controladorBacklog = new BackLogControl();
            return controladorBacklog;
        }
        return controladorBacklog;
    }
    
    /**
     * Método responsávem por cadastrar um backlog no banco de dados.
     * O método recebe como parametro um objeto do tipo Backlog.
     * @author Mayke
     * @param backlog
     * @return boolean
     */
    public static boolean cadastrarBacklog(BackLog backlog){
        
        AcessoBD conecta = new AcessoBD();
        conecta.Conexao();
        
        String sql = "INSERT INTO backlog() VALUES(?,?,?,?)";
        
        try {
            PreparedStatement pst = conecta.conn.prepareStatement(sql);
            pst.setString(1, null);
            pst.setString(2, backlog.getDataDeCriacao());
            pst.setString(3, backlog.getDataUltimaModificacao());
            pst.setInt(4, backlog.getId_projeto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(BackLogControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Conectar! \n Erro: " + ex.getMessage());
        }
        conecta.Conexao();
        return true;
    }
    
    /**
     * Método responsávem por deletar um backlog no banco de dados.
     * O método recebe como parametro um objeto do tipo Backlog.
     * @author Mayke
     * @param backlog
     * @return boolean
     */
    public static boolean deletarBacklog(BackLog backlog){
        
        AcessoBD conecta = new AcessoBD();
        conecta.Conexao();
        
        try {
            String sql = "DELETE FROM backlog WHERE id = ?";
            PreparedStatement pst;
            pst = conecta.conn.prepareStatement(sql);
            pst.setLong(1, backlog.getId()); 
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao deletar Backlog! \n Erro: " + ex.getMessage());
        }
        conecta.Conexao();
        return true;
    }
    
    /**
     * Método responsávem por editar um backlog no banco de dados.
     * O método recebe como parametro um objeto do tipo Backlog.
     * @author Mayke
     * @param backlog
     * @return boolean
     */
    public static boolean editarBacklog(BackLog backlog){
        AcessoBD conecta = new AcessoBD();
        conecta.Conexao();
        
        try {
            String sql = "UPDATE backlog SET data_criacao = ?, data_modificacao = ? WHERE id = ?";
            PreparedStatement pst = conecta.conn.prepareStatement(sql);
            pst.setString(1, backlog.getDataDeCriacao().toString());
            pst.setString(2, backlog.getDataUltimaModificacao().toString());
            pst.setLong(3, backlog.getId());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Editado com suceso!");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControl.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao editar Backlog! " + ex.getMessage());
        }
        conecta.Conexao();
        return true;
    }
    
    /**
     * Método responsávem por listar todos os backlogs do banco de dados.
     * @author Mayke
     * @return ArrayList
     */
    public static ArrayList listarBacklog(){
        AcessoBD conecta = new AcessoBD();
        conecta.Conexao();
        
        try {
            ArrayList backlogs = new ArrayList();
            String sql = "SELECT * FROM backlog";
            
            PreparedStatement pst = conecta.conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                
                backlogs.add(new Object[]{ rs.getInt("id"),
                    rs.getString("data_criacao"),
                    rs.getString("data_modificacao")});
            }
            return backlogs;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
