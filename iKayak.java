import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface iKayak {
    Usuario login(String username,String password);
    void registroUsuario(String username,String password,String tipo);
    void cambiarPassword(String nuevaPassword);
    void cambiarTipoUsuario();
    void reservacion(String fechaVuelo,boolean tipoVuelo,int cantidadBoletos,String aerolinea,String username);
    void confirmacion(String numeroTarjeta,int cuotas,String claseVuelo,String numeroAsiento,int cantidadMaletas);
    String itinerario();
    void guardarUsuario() throws IOException;
    void guardarReserva() throws IOException;
    void leerUsuario();
    void leerReserva();
}
