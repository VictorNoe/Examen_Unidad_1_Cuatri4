package servidor;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;

public class servidor {
    public static void main (String[] args) throws XmlRpcException, IOException {
        System.out.println("Iniciando Servidor");
        PropertyHandlerMapping mapping= new PropertyHandlerMapping();
        mapping.addHandler("Methods", Methods.class);
        WebServer server= new WebServer(1200);
        server.getXmlRpcServer().setHandlerMapping(mapping);
        server.start();
        System.out.println("Esperando peticones...");
    }
}
