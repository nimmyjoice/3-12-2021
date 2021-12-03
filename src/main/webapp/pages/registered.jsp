<%@page import="emspack1.UserDao"%>  
<jsp:useBean id="obj" class="emspack1.User">  
</jsp:useBean>  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
int i=UserDao.register(obj);  
if(i>0)  
out.print("You are successfully registered");  
  
%> 