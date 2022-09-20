package server;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Methods {

    public double addition(double num1, double num2){

        double result = num1 + num2;

        DaoMethods daoMethods = new DaoMethods();
        daoMethods.saveOperation(num1,num2, result, "Suma");

        return result;
    }

    public double subtraction(double num1, double num2){
        double result = num1 - num2;

        DaoMethods daoMethods = new DaoMethods();
        daoMethods.saveOperation(num1,num2, result, "Resta");

        return result;
    }

    public double division(double num1, double num2){

        if (num2 == 0) {
            System.out.println("No se puede divir entre 0");
            return 0;
        }

        double result = num1 / num2;

        DaoMethods daoMethods = new DaoMethods();
        daoMethods.saveOperation(num1,num2, result,"División");

        return result;
    }

    public double multiplication(double num1, double num2){
        double result = num1*num2;

        DaoMethods daoMethods = new DaoMethods();
        daoMethods.saveOperation(num1,num2, result, "Multiplicación");

        return result;
    }

    public double exponent(double num1, double num2){
        double result = Math.pow(num1,num2);

        DaoMethods daoMethods = new DaoMethods();
        daoMethods.saveOperation(num1,num2, result,"Exponente");

        return result;
    }

    public double root(double num1){

        if (num1<0){
            System.out.println("No se puede sacar raíz cuadrada de un número negativo");
            return 0;
        }

        double result = Math.sqrt(num1);

        DaoMethods daoMethods = new DaoMethods();
        daoMethods.saveOperation(num1,0, result,"Raíz");

        return result;
    }

    public List<BeanOperation> getOperations() throws JAXBException {
        List<BeanOperation> operations;
        DaoMethods daoMethods = new DaoMethods();
        operations = daoMethods.getOperations();
//        BeanOperation operation = operations.get(0);

//        String xmlString =  jaxbObjectToXML(operation);
//        System.out.println("met"+xmlString);
//
//        return xmlString;

        return operations;
    }

//    private static String jaxbObjectToXML(BeanOperation operation)
//    {
//        String xmlContent = "";
//
//        try
//        {
//            //Create JAXB Context
//            JAXBContext jaxbContext = JAXBContext.newInstance(BeanOperation.class);
//
//            //Create Marshaller
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            //Required formatting??
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//            //Print XML String to Console
//            StringWriter sw = new StringWriter();
//
//            //Write XML to StringWriter
////            jaxbMarshaller.marshal(operation, sw);
//            jaxbMarshaller.marshal( new JAXBElement<BeanOperation>(new QName("uri","local"), BeanOperation.class, operation), System.out );
//
//            //Verify XML Content
//            xmlContent = sw.toString();
//            System.out.println( xmlContent );
//
//            return xmlContent;
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        System.out.println("xml "+xmlContent);
//        return xmlContent;
//    }

}
