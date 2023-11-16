/**
 * @author Gadiel Amir Ocaña Veliz
 * Carnne: 231270
 * Universidad del Valle de Guatemala
 * POO
 * Lab#4
 * Clase modelo de usuario
 */
public class Usuario {

    private String username;
    private String password;
    private String tipo;

    /**
     * Crea un objeto de tipo Usuario
     * @param username
     * @param password
     * @param tipo
     */
    public Usuario(String username, String password, String tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }
    //Gets y sets
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsuario(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Muestra los atributos del objeto.
     * @return
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + username + '\'' +
                ", password='" + password + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public String getTipo() {
        return tipo;
    }
}
