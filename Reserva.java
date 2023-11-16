/**
 * @author Gadiel Amir Ocaña Veliz
 * Carnne: 231270
 * Universidad del Valle de Guatemala
 * POO
 * Lab#4
 * Clase modelo de Reserva
 */
public class Reserva {
    //Atributos
    private String fechaVuelo;
    private boolean tipoVuelo;
    private int cantidadBoletos;
    private String aerolinea;
    private String numeroTarjeta;
    private int cuotas;
    private String claseVuelo;
    private String numeroAsiento;
    private int cantidadMaletas;
    private String username;

    /**
     * Instanciar una reserva
     * @param fechaVuelo
     * @param tipoVuelo
     * @param cantidadBoletos
     * @param aerolinea
     * @param numeroTarjeta
     * @param cuotas
     * @param claseVuelo
     * @param numeroAsiento
     * @param cantidadMaletas
     * @param username
     */

    public Reserva(String fechaVuelo, boolean tipoVuelo, int cantidadBoletos, String aerolinea, String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas, String username) {
        this.fechaVuelo = fechaVuelo;
        this.tipoVuelo = tipoVuelo;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
        this.numeroTarjeta = numeroTarjeta;
        this.cuotas = cuotas;
        this.claseVuelo = claseVuelo;
        this.numeroAsiento = numeroAsiento;
        this.cantidadMaletas = cantidadMaletas;
        this.username = username;
    }


    //gets y sets

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public boolean isTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(boolean tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

    public int getCantidadBoletos() {
        return cantidadBoletos;
    }

    public void setCantidadBoletos(int cantidadBoletos) {
        this.cantidadBoletos = cantidadBoletos;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public int getCantidadMaletas() {
        return cantidadMaletas;
    }

    public void setCantidadMaletas(int cantidadMaletas) {
        this.cantidadMaletas = cantidadMaletas;
    }

    /**
     * Muestra los atributos de reserva
     * @return
     */
    @Override
    public String toString() {
        return "Reserva{" +
                "fechaVuelo='" + fechaVuelo + '\'' +
                ", tipoVuelo=" + tipoVuelo +
                ", cantidadBoletos=" + cantidadBoletos +
                ", aerolinea='" + aerolinea + '\'' +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", cuotas=" + cuotas +
                ", claseVuelo='" + claseVuelo + '\'' +
                ", numeroAsiento='" + numeroAsiento + '\'' +
                ", cantidadMaletas=" + cantidadMaletas +
                ", username='" + username + '\'' +
                '}';
    }

    public String getUsername(){
        return username;
    }
}
