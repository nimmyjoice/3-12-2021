package emspack1;
import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String n=request.getParameter("name");  
String p=request.getParameter("email");  
String e=request.getParameter("dob");  
String c=request.getParameter("password");
String d=request.getParameter("gender");
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/java159testdb","root","");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into registeruser values(?,?,?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
ps.setString(4,c); 
ps.setString(5,d); 
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully registered...");  
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  
