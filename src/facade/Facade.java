package facade;

import control.UsuarioControl;
import java.util.ArrayList;
import model.Usuario;

/*
 *
 * @author Mayke
 */
public class Facade {
    
    
    /* 
     *  Cadastra um novo usuário no banco de dados e
     *  recebe como parâmetro um objeto do tipo Usuario
     */
    public static boolean cadastrarUsuario(Usuario usuario){
        return UsuarioControl.cadastrarUsuario(usuario);
    }
    
    /* 
     *  Método responsável por deletar usuário do banco de dados
     *  e recebe como parâmetro um objeto do tipo Usuario  
     */
    public static boolean deletarUsuario(Usuario usuario){
        return UsuarioControl.deletarUsuario(usuario);
    }
    
    /*
     *  Método responsável por editar um usuário do banco de dados
     *  e recebe como parâmetro um objeto do tipo Usuario
    */
    
    public static boolean editarUsuario(Usuario usuario){
        return UsuarioControl.editarUsuario(usuario);
    }
    
    /*
     *  Método responsável por listar todos usuarios do banco de dados
     *  e retorna um Arraylist de Usuario
     */
    
    public static ArrayList<Usuario> listarUsuarios(){
        return UsuarioControl.listarUsuario();
    }
    
}

/*

*/