/*
package banco_de_dados;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mayke
 */
/**
public class AcessoBD {
    
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;
    
    public AcessoBD(){
        this.servidor = "localhost";
        this.banco = "aula";
        this.usuario = "root";
        this.senha = "12091996";
    }
    public boolean conectar(){
        try{
            this.conexao = (Connection) DriverManager.getConnection("jdbc:mysql://"+this.servidor+"/"+this.banco,this.usuario,this.senha);
            return true; //coneta com o banco
        }//se não conseguir, gera um erro de exceção
        catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }//retorna ao atributo conexao
    public Connection getConnection(){
        return conexao;
    }
}


*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco_de_dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Mayke
 */
public class AcessoBD  {
    
	
	private String driver = "com.mysql.jdbc.Driver";
	private String caminho = "jdbc:mysql://127.0.0.1/aula1";// MYDB é o nome do provavel banco
	private String usuario = "root";
	private String senha = "12091996";
	public static Connection conn = null;
	
	public Connection Conexao (){
		
		try {
			//System.setProperty("jdbc.Drivers", driver);
                        Class.forName(driver);
			conn = DriverManager.getConnection(caminho, usuario, senha);
			JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
		}catch(ClassNotFoundException ex){
                    Logger.getLogger(AcessoBD.class.getName()).log(Level.SEVERE, null, ex);
			
		} catch (SQLException e){
                    throw new RuntimeException(e);
                }
                
                return conn;
        }
	
	
}