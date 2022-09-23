package cliente;

import com.google.protobuf.Descriptors;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import servidor.BeanCliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class cliente {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        BeanCliente BC = new BeanCliente();

        int option=0;
        String name;
        String apellido1;
        String apellido2;
        String curp;
        String dia;
        String mes;
        String ano;
        String rfc;
        int longitud = 3;
        String cadena = cadenaAleatoria(longitud);

        do {
            System.out.println("1) AÑADIR");
            System.out.println("2) MODIFICAR");
            System.out.println("3) CONSULTAR");
            System.out.println("4) ELIMINAR");
            System.out.println("5) SALIR");
            System.out.print("Que quieres realizar: ");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Ingresa nombre(S): ");
                    name = sc.next();
                    System.out.print("Ingresa primer apellido: ");
                    apellido1 = sc.next();
                    System.out.print("Ingresa segundo apellido: ");
                    apellido2 = sc.next();
                    System.out.print("Ingresa CURP: ");
                    curp = sc.next();
                    System.out.print("Ingresa dia nacimiento: ");
                    dia = sc.next();
                    System.out.print("Ingresa mes nacimiento: ");
                    System.out.println("\n1) Enero 2) Febrero 3) Marzo 4) Abril\n5) Mayo 6) Junio 7) Julio 8) Agosto\n9)Septiembre 10) Octubre 11) Noviembre 12) Diciembre");
                    mes = sc.next();
                    switch (mes) {
                        case "1" :
                            mes = "01";
                            break;
                        case "2" :
                            mes = "02";
                            break;
                        case "3" :
                            mes = "03";
                            break;
                        case "4" :
                            mes = "04";
                            break;
                        case "5" :
                            mes = "05";
                            break;
                        case "6" :
                            mes = "06";
                            break;
                        case "7" :
                            mes = "07";
                            break;
                        case "8" :
                            mes = "08";
                            break;
                        case "9" :
                            mes = "09";
                            break;
                        case "10" :
                            mes = "10";
                            break;
                        case "11" :
                            mes = "11";
                            break;
                        case "12 " :
                            mes = "12";
                            break;
                        default:
                            System.out.println("Opcion incorrecta");
                            break;
                    }
                    System.out.print("Ingresa año nacimiento: ");
                    ano = sc.next();

                    rfc = apellido1.trim().substring(0,2);
                    rfc = rfc.concat(apellido2.trim().substring(0,1));
                    rfc = rfc.concat(name.trim().substring(0,1));
                    rfc = rfc.concat(ano.trim().substring(2,4));
                    rfc = rfc.concat(mes);
                    rfc = rfc.concat(dia);
                    rfc = rfc.concat(cadena);
                    rfc = rfc.toUpperCase();
                    Object [] paramObjects = {name,apellido1,apellido2,curp,dia,mes,ano,rfc};
                    String result = (String) client.execute("Methods.savePersona",paramObjects);
                    System.out.println(result);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Ingresa el CURP: ");
                    curp = sc.next();
                    Object [] param2 = {curp};
                    String result2 = (String) client.execute("Methods.mostrarUsuario", param2);
                    System.out.println(result2);
                    break;
                case 4:
                    System.out.println("Ingresa el RFC");
                    curp = sc.next();
                        Object [] param3 = {curp};
                        String result3 = (String) client.execute("Methods.eliminarPersona", param3);
                        System.out.println(result3);
                    break;
                case 5:
                    System.out.println("ADIOS");
                    break;
                default:
                    System.out.println("Funcion no encontrada ");
                    break;
            }
        }while (option != 5) ;
    }

    public static int numeroAleatorioEnRango(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

    public static String cadenaAleatoria(int longitud) {
        String tres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String cadena = "";
        for (int x = 0; x < longitud; x++) {
            int indiceAleatorio = numeroAleatorioEnRango(0, tres.length() - 1);
            char caracterAleatorio = tres.charAt(indiceAleatorio);
            cadena += caracterAleatorio;
        }
        return cadena;
    }

}
