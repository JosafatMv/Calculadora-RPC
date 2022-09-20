package server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
@XmlRootElement(name="BeanOperation")
@XmlAccessorType(XmlAccessType.FIELD)

public class BeanOperation {
    private int id;
    private String operation;
    private double number1;
    private double number2;
    private double result;
    private Date createdAt;

    public BeanOperation() {
    }

    public BeanOperation(int id, String operation, double number1, double number2, double result, Date createdAt) {
        this.id = id;
        this.operation = operation;
        this.number1 = number1;
        this.number2 = number2;
        this.result = result;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
