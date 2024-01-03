public class Usuarios {
    private String usuario;
    private String contrasenia;
    
    public Usuarios(String usuario, String contrasenia){
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        }
    public String getusuario(){
        return usuario;
        }
    public String getcontrasenia(){
        return contrasenia;
        }
    @Override
    public String toString(){
        return usuario + "," + contrasenia;
        }
    }
