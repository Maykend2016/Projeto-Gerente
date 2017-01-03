/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_de_dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author mayke
 */
public class CadastroCRUD {
    
    public void cadastroUsuario(Usuario usuario){
    Connection connetcion = new AcessoBD().Conexao();

    String sql = "INSERT INTO usuario(nome, login, email, senha) VALUES (?,?,?,?);";
    
    PreparedStatement stmt;
        try {
            stmt = connetcion.prepareStatement(sql);
            stmt.setString(1, usuario.getNomeCompleto());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getSenha());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CadastroCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
