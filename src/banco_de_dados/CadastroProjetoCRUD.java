package banco_de_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Projeto;
import model.Usuario;

public class CadastroProjetoCRUD {
	 public void cadastroProjeto(Projeto projeto){
		    Connection connetcion = new AcessoBD().Conexao();

		    String sql = "INSERT INTO projeto(id, descricao, data_criacao, data_final) VALUES (?,?,?,?);";
		    
		    PreparedStatement stmt;
		        try {
		            stmt = connetcion.prepareStatement(sql);
		            stmt.setString(1, projeto.getDescricaoGeral());
		            stmt.setString(2, projeto.getDataDeCriacao());
		            stmt.setString(3, projeto.getDataDeFinalizacao());
		            
		            stmt.execute();
		        } catch (SQLException ex) {
		            Logger.getLogger(CadastroProjetoCRUD.class.getName()).log(Level.SEVERE, null, ex);
		        }
		    
		    }
		    
}
