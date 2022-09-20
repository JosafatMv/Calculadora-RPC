package server;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoMethods {


    public void saveOperation(double num1, double num2, double result, String operation) {
        boolean resultSave = false;

        try
                (Connection con = MySQLConnection.getConnection();
                 PreparedStatement pstm = con.prepareStatement(
                         "INSERT INTO operations (operation,number1,number2, result) values (?,?,?,?)"
                 );

                ) {
            pstm.setString(1, operation);
            pstm.setDouble(2, num1);
            pstm.setDouble(3, num2);
            pstm.setDouble(4, result);

            resultSave = pstm.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<BeanOperation> getOperations() {
        List<BeanOperation> operations = new ArrayList<>();

        try(
                Connection con = MySQLConnection.getConnection();
                PreparedStatement pstm = con.prepareStatement("SELECT * FROM operations;");
                ) {

            ResultSet rs = pstm.executeQuery();

            while (rs.next()){
                BeanOperation operation = new BeanOperation();
                operation.setId(rs.getInt("id_operation"));
                operation.setOperation(rs.getString("operation"));
                operation.setNumber1(rs.getDouble("number1"));
                operation.setNumber2(rs.getDouble("number2"));
                operation.setResult(rs.getDouble("result"));
                operation.setCreatedAt(rs.getDate("created_at"));

                operations.add(operation);
            }


        } catch (Exception e){
            e.printStackTrace();
        }

        return operations;
    }
}
