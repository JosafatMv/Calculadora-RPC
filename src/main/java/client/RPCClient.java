package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import server.BeanOperation;
import server.Operations;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class RPCClient {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws MalformedURLException, XmlRpcException, JAXBException {

        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        config.setEnabledForExtensions(true);
        System.out.println(config.isEnabledForExtensions());
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        String option = "";
        double num1 = 0, num2 = 0;
        double response;

        do {

            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Exponente");
            System.out.println("6. Raiz");
            System.out.println("7. Mostrar operaciones");
            System.out.println("8. Salir");
            option = sc.next();

            if (isNumber(option)) {
                switch (Integer.parseInt(option)) {
                    case 1:

                        num1 = getNumber("Ingrese el primer valor");
                        num2 = getNumber("Ingrese el segundo valor");

                        //Llamada al servicio
                        response = callService(num1, num2, "Methods.addition", client);
                        System.out.println("El resultado es: " + response);

                        break;
                    case 2:

                        num1 = getNumber("Ingrese el primer valor");
                        num2 = getNumber("Ingrese el segundo valor");

                        //Llamada al servicio
                        response = callService(num1, num2, "Methods.subtraction", client);
                        System.out.println("El resultado es: " + response);

                        break;
                    case 3:
                        num1 = getNumber("Ingrese el primer valor");
                        num2 = getNumber("Ingrese el segundo valor");

                        //Llamada al servicio
                        response = callService(num1, num2, "Methods.multiplication", client);
                        System.out.println("El resultado es: " + response);
                        break;
                    case 4:
                        //División
                        num1 = getNumber("Ingrese el primer valor");
                        num2 = getNumber("Ingrese el segundo valor");

                        //Llamada al servicio
                        response = callService(num1, num2, "Methods.division", client);
                        System.out.println("El resultado es: " + response);
                        break;
                    case 5:
                        num1 = getNumber("Ingrese el primer valor");
                        num2 = getNumber("Ingrese el segundo valor");

                        //Llamada al servicio
                        response = callService(num1, num2, "Methods.exponent", client);
                        System.out.println("El resultado es: " + response);
                        break;
                    case 6:
                        num1 = getNumber("Ingrese el primer valor");

                        //Llamada al servicio
                        response = callService(num1, "Methods.root", client);
                        System.out.println("El resultado es: " + response);
                        break;
                    case 7:
                        System.out.println("----Registro de operaciones-----");

                        //Llamada al servicio
                        String operations = (String) client.execute("Methods.getOperations", (Object[]) null);
                        JAXBContext jaxbContext = JAXBContext.newInstance(Operations.class);
                        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                        Operations operationsList = (Operations) jaxbUnmarshaller.unmarshal(new StringReader(operations));
                        for (BeanOperation operation:
                             operationsList.getOperations()) {
                            System.out.println("ID: "+operation.getId());
                            System.out.println("Operación: "+operation.getOperation());
                            System.out.println("Numero 1: "+operation.getNumber1());
                            System.out.println("Numero 2: "+operation.getNumber2());
                            System.out.println("Resultado: "+operation.getResult());
                            System.out.println("Creado el: "+operation.getCreatedAt());
                            System.out.println("");
                        }

                        break;
                    case 8:
                        System.out.println("Hasta luego");
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                        break;
                }

                System.out.println("");
            } else {
                System.out.println("Ingresa un valor válido");
            }
            System.out.println("Presione enter para continuar.....");
            sc.nextLine();
            sc.nextLine();

        } while (!option.equals("8"));

    }

    public static boolean isNumber(String number) {
        try {
            double num = Double.parseDouble(number);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static double getNumber(String message) {
        String num1 = "";

        do {
            System.out.println(message);
            num1 = sc.next();

            if (!isNumber(num1)) {
                System.out.println("Error, ingrese un valor numérico");
            }
        } while (!isNumber(num1));

        return Double.parseDouble(num1);
    }

    public static double callService(double num1, double num2, String method, XmlRpcClient client) throws XmlRpcException {
        Object[] numbers = {num1, num2};
        return (Double) client.execute(method, numbers);
    }

    public static double callService(double num1, String method, XmlRpcClient client) throws XmlRpcException {
        Object[] numbers = {num1};
        return (Double) client.execute(method, numbers);
    }

}
