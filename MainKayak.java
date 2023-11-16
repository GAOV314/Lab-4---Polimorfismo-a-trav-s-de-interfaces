import java.util.Scanner;

/**
 * @author Gadiel Amir Ocaña Veliz
 * Carnne: 231270
 * Universidad del Valle de Guatemala
 * POO
 * Lab#4
 * Clase main donde se ejecuta el codigo y se instancia el controlador
 */
public class MainKayak {
    public static void main(String[] args) {
        //Se instancia controlador
        Kayak kay = new Kayak();
        kay.leerReserva();
        kay.leerUsuario();

        Scanner input = new Scanner(System.in);
        int choice;
        boolean state = true;
        String menu = "--------Menu--------\n1.Registrarse\n2.Log in\n3.Salir";

            do {
                try {
                System.out.println(menu);
                System.out.println("Ingrese una opcion: ");
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    //Registrarse
                    case 1:
                        System.out.println("Ingrese un nombre de usuario: ");
                        String username = input.nextLine();
                        System.out.println("Ingrese una contraseña:");
                        String password = input.nextLine();
                        System.out.println("Ingrese una membresia\ngratuita\npremium");
                        String tipo = input.nextLine();
                        kay.registroUsuario(username, password, tipo);
                        System.out.println("Usuario registrado con exito");
                        break;
                    //Log in
                    case 2:
                        System.out.println("Ingrese su nombre: ");
                        String usernameL = input.nextLine();
                        System.out.println("Ingrese su password: ");
                        String passwordL = input.nextLine();
                        Usuario loginUser = kay.login(usernameL, passwordL);
                        if (loginUser != null) {
                            //Logica de ingresado
                            System.out.println("Se ha ingresado con exito");
                            if (loginUser.getTipo() == "gratuito") {
                                System.out.println("---------------\n1.Modo perfil\n2.Hacer reserva\n3.Confirmacion\n---------------\nIngrese una de las opciones antes mencionadas: ");
                                int opcion = input.nextInt();
                                input.nextLine();
                                //Modo perfil
                                if (opcion == 1) {
                                    //Para miembros gratuitos
                                        System.out.println("1.Cambiar plan\n2.Aplicar cupón de 10% de descuento\n3.Cambiar contrasena");
                                        System.out.println("Ingrese una opcion: ");
                                        int opcion1 = input.nextInt();
                                        input.nextLine();
                                        //Cambiar plan
                                        if (opcion1 == 1) {
                                            kay.cambiarTipoUsuario();

                                            //Aplicar el cupon de 10% de descuento
                                        } else if (opcion1 == 2) {
                                            System.out.println("Se ha aplicado el cupon de 10% de descuento");

                                            //Cambiar contrasena
                                        } else if (opcion1 == 3) {
                                            //Logica cambiar password
                                            System.out.println("Ingrese la nueva contraseña: ");
                                            String newPassword = input.nextLine();
                                            kay.cambiarPassword(newPassword);
                                            System.out.println("Se ha cambiado la contraseña con exito.");

                                        }
                                    //Hacer reserva
                                } else if (opcion == 2) {
                                    boolean tipoVuelo = false;
                                    System.out.println("Ingrese la fecha del vuelo: ");
                                    String fechaVuelo = input.nextLine();

                                    System.out.println("Su vuelo sera de ida y vuelta o solo de ida? \n(ida, vuelta)");
                                    String vuelo = input.nextLine();
                                    if(vuelo == "ida"){
                                        tipoVuelo = false;
                                    }else{
                                        tipoVuelo= true;
                                    }

                                    System.out.println("Ingrese la cantidad de boletos: ");
                                    int cantidadBoletos = input.nextInt();
                                    input.nextLine();
                                    System.out.println("Ingrese la aerolinea: ");
                                    String aerolinea = input.nextLine();

                                    kay.reservacion(fechaVuelo,tipoVuelo,cantidadBoletos,aerolinea, usernameL);

                                    //Modo Confirmacion
                                } else if (opcion == 3) {
                                    System.out.println("------Modo confirmacion------\n1.Imprimir itinerario\n2.Hacer confirmacion");
                                    System.out.println("Seleccione una opcion: ");
                                    int opcion3 = input.nextInt();
                                    input.nextLine();

                                    switch (opcion3){
                                        //Itinerario
                                        case 1:
                                            System.out.println(kay.itinerario());
                                            break;
                                        //Confirmacion
                                        case 2:
                                            System.out.println("Ingrese el numero de tajeta: ");
                                            String numeroTarjeta = input.nextLine();
                                            System.out.println("Ingresa la cantidad de cuotas (1 = un solo pago, hasta 24 cuotas): ");
                                            int cuotas = input.nextInt();
                                            if(cuotas>24){
                                                System.out.println("La cantidad de cuotas ingresado excede el limite de 24 meses");
                                                cuotas = 0;
                                            }
                                            input.nextLine();
                                            System.out.println("Ingrese la clase del vuelo: ");
                                            String claseVuelo = input.nextLine();
                                            String numeroAsiento = null;
                                            int cantidadMalestas = 1;
                                            kay.confirmacion(numeroTarjeta,cuotas,claseVuelo,numeroAsiento,cantidadMalestas);
                                            break;

                                    }


                                } else {
                                    System.out.println("Ingrese una respuesta en el rango 1-3");
                                }
                            }else{
                                //Else con la version premium
                                System.out.println("---------------\n1.Modo perfil\n2.Hacer reserva\n3.Confirmacion\n---------------\nIngrese una de las opciones antes mencionadas: ");
                                int opcion4 = input.nextInt();
                                input.nextLine();
                                //Modo Perfil
                                if(opcion4==1){

                                    System.out.println("¿Desea cambiar de contraseña?");
                                    System.out.println("Si si presione 's' si no 'n'");
                                    String seleccion = input.nextLine();
                                    if(seleccion == "s"){
                                        System.out.println("Ingrese la nueva contraseña: ");
                                        String newPassword = input.nextLine();
                                        kay.cambiarPassword(newPassword);
                                    }else if(seleccion == "n"){
                                        System.out.println("Saliendo del modo perfil.");
                                    }


                                    //Hacer reserva
                                } else if (opcion4 == 2) {

                                    boolean tipoVuelo = false;
                                    System.out.println("Ingrese la fecha del vuelo: ");
                                    String fechaVuelo = input.nextLine();

                                    System.out.println("Su vuelo sera de ida y vuelta o solo de ida? \n(ida, vuelta)");
                                    String vuelo = input.nextLine();
                                    if(vuelo == "ida"){
                                        tipoVuelo = false;
                                    }else{
                                        tipoVuelo= true;
                                    }

                                    System.out.println("Ingrese la cantidad de boletos: ");
                                    int cantidadBoletos = input.nextInt();
                                    input.nextLine();
                                    System.out.println("Ingrese la aerolinea: ");
                                    String aerolinea = input.nextLine();
                                    System.out.println("Ingrese su nombre de usuario: ");
                                    String username1 = input.nextLine();
                                    kay.reservacion(fechaVuelo,tipoVuelo,cantidadBoletos,aerolinea, username1);


                                    //Confirmacion
                                } else if (opcion4 == 3) {

                                    System.out.println("------Modo confirmacion------\n1.Imprimir itinerario\n2.Hacer confirmacion");
                                    System.out.println("Seleccione una opcion: ");
                                    int opcion3 = input.nextInt();
                                    input.nextLine();

                                    switch (opcion3){
                                        //Itinerario
                                        case 1:
                                            System.out.println(kay.itinerario());
                                            break;
                                        //Confirmacion
                                        case 2:
                                            System.out.println("Ingrese el numero de tajeta: ");
                                            String numeroTarjeta = input.nextLine();
                                            int cuotas = 0;
                                            String claseVuelo = null;
                                            System.out.println("Ingrese el numero de asiento: ");
                                            String numeroAsiento = input.nextLine();
                                            System.out.println("Ingrese la cantidad de maletas: ");
                                            int cantidadMalestas = input.nextInt();
                                            input.nextLine();
                                            kay.confirmacion(numeroTarjeta,cuotas,claseVuelo,numeroAsiento,cantidadMalestas);
                                            break;

                                    }

                                }


                            }
                        } else {
                            System.out.println("Credenciales incorrectas");
                        }

                        break;
                    //Salir
                    case 3:
                        System.out.println("Saliendo del programa...");
                        kay.guardarReserva();
                        kay.guardarUsuario();
                        state = false;
                        break;
                }

                }catch (Exception e){
                    input.nextLine();
                    System.out.println("Ingrese un valor valido: "+e.getMessage());
                }
            } while (state);

    }

}
