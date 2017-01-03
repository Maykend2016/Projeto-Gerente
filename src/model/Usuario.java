package model;

public class Usuario {
	
	private long id;
	private String login;
	private String senha;
	private String email;
	private String nomeCompleto;
	

    public Usuario(long id, String login, String senha, String email, String nomeCompleto) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.nomeCompleto = nomeCompleto;
    }

    public Usuario() {
        
    }
        

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", login=" + login + ", senha=" + senha + ", email=" + email + ", nomeCompleto=" + nomeCompleto + '}';
    }
    
    
 

}
