/**
 * @author Gadiel Amir Ocaña Veliz
 * Carnne: 231270
 * Universidad del Valle de Guatemala
 * POO
 * Lab#4
 * Clase controlador implementa iKayak
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;
public class Kayak implements iKayak{
    //Atributos
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();
    private String usuarioActual;


    /**
     * Se instancia para acceder a metodos
     */
    public Kayak(){
    }

    //gets y sets
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
    //Metodos implementados

    /**
     * Metodo para ingresar al sistema
     * @param username
     * @param password
     * @return
     */
    @Override
    public Usuario login(String username, String password) {
        for(Usuario u: usuarios){
            if (u.getUsername().equals(username) && u.getPassword().equals(password)){
                return u;

            }
        }
        setUsuarioActual(username);
        return null;
    }

    /**
     * Crea un usuario y lo almacena
     * @param username
     * @param password
     * @param tipo
     */
    @Override
    public void registroUsuario(String username, String password, String tipo) {
        Usuario newUser = new Usuario(username,password,tipo);
        usuarios.add(newUser);
        System.out.println("Usuario agregado con exito.");
    }

    /**
     * Cambia la contraseña de un usuario
     * @param nuevaPassword
     */
    @Override
    public void cambiarPassword(String nuevaPassword) {
        for(Usuario u:usuarios){
            if(u.getUsername().equals(usuarioActual)){
                u.setPassword(nuevaPassword);
            }
        }
        System.out.println("Se ha cambiado el password con exito");

    }

    /**
     * Cambia la membresia del usuario
     */
    @Override
    public void cambiarTipoUsuario() {
        for(Usuario u:usuarios){
            if(u.getUsername().equals(usuarioActual)){
                u.setTipo("premium");
            }
        }
        System.out.println("Se ha cambiado su membresia a premium.");
    }

    /**
     * Hace una reserva y la almacena
     * @param fechaVuelo
     * @param tipoVuelo
     * @param cantidadBoletos
     * @param aerolinea
     * @param username
     */
    @Override
    public void reservacion(String fechaVuelo,boolean tipoVuelo,int cantidadBoletos,String aerolinea,String username) {
        Reserva newReservation = new Reserva(fechaVuelo,tipoVuelo,cantidadBoletos,aerolinea,"",0,"","",0,username);
        reservas.add(newReservation);
        System.out.println("Se ha hecho con exito la reserva.");
    }

    /**
     * Completa una reserva
     * @param numeroTarjeta
     * @param cuotas
     * @param claseVuelo
     * @param numeroAsiento
     * @param cantidadMaletas
     */
    @Override
    public void confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas) {
        for(Reserva r:reservas){
            if (r.getUsername()==usuarioActual){
                r.setNumeroTarjeta(numeroTarjeta);
                r.setCuotas(cuotas);
                r.setClaseVuelo(claseVuelo);
                r.setNumeroAsiento(numeroAsiento);
            }
        }
    }

    /**
     * Se muestra los datos de la reserva
     * @return
     */
    //String fechaVuelo,boolean tipoVuelo,int cantidadBoletos,String aerolinea,String username
    @Override
    public String itinerario() {
        String itinerario = "";
        for(Reserva r : reservas){
            if(r.getUsername() == usuarioActual){
                itinerario = r.toString();
            }
        }
        return itinerario;
    }

    /**
     * Guarda lo que esta contenido en la lista de usuarios y lo almacena en un csv
     * @throws IOException
     */
    @Override
    public void guardarUsuario() throws IOException {
        String archivo = "/Users/GadielOcana/Desktop/usuarios.csv";
        PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));
        for (Usuario u: usuarios){
            String line = u.getUsername()+","+u.getPassword()+","+u.getTipo();
            writer.println(line);
        }
        writer.close();

    }

    /**
     * Guarda lo que esta contenido en la lita de reservas en un csv
     * @throws IOException
     */
    @Override
    public void guardarReserva() throws IOException {
        String archivo = "/Users/GadielOcana/Desktop/reservations.csv";
        PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));
        for (Reserva u: reservas){
            //Falta username en el csv
            String line = u.getFechaVuelo()+","+u.isTipoVuelo()+","+u.getCantidadBoletos()+","+u.getAerolinea()+","+u.getNumeroTarjeta()+","+u.getCuotas()+","+u.getClaseVuelo()+","+u.getNumeroAsiento()+","+u.getCantidadMaletas()+","+ u.getUsername();
            writer.println(line);
        }
        writer.close();

    }

    /**
     * Lee el csv de usuarios y lo almacena en la lista de usuarios
     */
    @Override
    public void leerUsuario() {
        //Pegar aca la direccion del csv si su dispositivo no es mac.
        String archivo = "/Users/GadielOcana/Desktop/usuarios.csv";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while((line = bufferedReader.readLine())!=null){
                try{
                    if(!line.trim().isEmpty()){
                        String[] fields = line.split(",");
                        String username = fields[0];
                        String password = fields[1];
                        String tipo = fields[2];
                        Usuario newUser = new Usuario(username,password,tipo);
                        usuarios.add(newUser);
                    }
                }catch (Exception e){
                    System.out.println(" - Verifique el formato de la siguiente linea: "+line);
                }
            }
        }catch (IOException e){
            System.out.println("Revise el nombre del archivo");
        }
    }

    /***
     *Lee el csv de reservas y lo cargo en la lista de reservas
     */
    @Override
    public void leerReserva() {
        //Pegar aca la direccion del csv si su dispositivo no es mac.
        String archivo = "/Users/GadielOcana/Desktop/reservations.csv";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while((line = bufferedReader.readLine())!=null){
                try{
                    if(!line.trim().isEmpty()){
                        String[] fields = line.split(",");
                        String fechaVuelo  = fields[0];
                        boolean tipoVuelo = Boolean.parseBoolean(fields[1]);
                        int cantidadBoletos = Integer.parseInt(fields[2]);
                        String aerolinea = fields[3];
                        String numeroTarjeta = fields[4];
                        int cuotas = Integer.parseInt(fields[5]);
                        String claseVuelo = fields[6];
                        String numeroAsiento = fields[7];
                        int cantidadMaletas = Integer.parseInt(fields[8]);
                        String username = fields[9];


                        Reserva reserva = new Reserva(fechaVuelo,tipoVuelo,cantidadBoletos,aerolinea,numeroTarjeta,cuotas,claseVuelo,numeroAsiento,cantidadMaletas,username);
                        reservas.add(reserva);
                    }
                }catch (Exception e){
                    System.out.println(" - Verifique el formato de la siguiente linea: "+line);
                }
            }
        }catch (IOException e){
            System.out.println("Revise el nombre del archivo");
        }

    }

    public String getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }


}
