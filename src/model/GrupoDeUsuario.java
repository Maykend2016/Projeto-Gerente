package model;

public class GrupoDeUsuario {
    
    private int idGrupoUser;
    private String tipoUser;

    public GrupoDeUsuario(int idGrupoUser, String tipoUser) {
        this.idGrupoUser = idGrupoUser;
        this.tipoUser = tipoUser;
    }

    public int getIdGrupoUser() {
        return idGrupoUser;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setIdGrupoUser(int idGrupoUser) {
        this.idGrupoUser = idGrupoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
    
    
    

}
