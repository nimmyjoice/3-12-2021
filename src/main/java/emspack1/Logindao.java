package emspack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import emspack1.Login;

public class Logindao {
	

    public Login validate(Login login) throws ClassNotFoundException {
        Login l=new Login();
        Class.forName("com.mysql.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java159testdb","root","");
            PreparedStatement preparedStatement = con
            .prepareStatement("select * from users where username = ? and password = ? ")) {
            preparedStatement.setString(1, login.getUsername());
            preparedStatement.setString(2, login.getPassword());
       
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()) {
        	l.setUsername(rs.getString("username"));
        	l.setPassword(rs.getString("password"));
        	l.setRole(rs.getString("role"));
        	l.setDesignation(rs.getString("designation"));
        	l.setCity(rs.getString("city"));
        	l.setCountry(rs.getString("country"));
            return l;
            }
        } catch (SQLException e) {
          
            printSQLException(e);
        }
        return l;
    }
    public int add(Login login) throws SQLException,ClassNotFoundException {
    	Class.forName("com.mysql.jdbc.Driver");
    	try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java159testdb","root","");
                PreparedStatement preparedStatement =connection.prepareStatement("insert into users(username,password,role,designation,city,country) values(?,?,?,?,?,?)")){
		preparedStatement.setString(1,login.getUsername());
		preparedStatement.setString(2, login.getPassword());
		preparedStatement.setString(3, login.getRole());
		preparedStatement.setString(4, login.getDesignation());
		preparedStatement.setString(5, login.getCity());
		preparedStatement.setString(6, login.getCountry());
    	
		int result =preparedStatement.executeUpdate();
		preparedStatement.close();
		return result;
    	}
	}
  


    
    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
