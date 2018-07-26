    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    <html>  
    <head>  
    <title>Being Java Guys | Spring DI Hello World</title>  
    <style>  
    body {  
     font-size: 20px;  
     color: teal;  
     font-family: Calibri;  
    }  
      
    td {  
     font-size: 15px;  
     color: black;  
     width: 100px;  
     height: 22px;  
     text-align: left;  
    }  
      
    .heading {  
     font-size: 18px;  
     color: white;  
     font: bold;  
     background-color: orange;  
     border: thick;  
    }  
    </style>  
    </head>  
    <body>  
  
      <br /> <br /> <br /> <b>Being Java Guys | Registration Form </b> <br />  
      <br />  
      <div>  
       <form:form method="post" action="/insert" modelAttribute="emp">  
        <table>  
         <tr>  
          <td> Name :</td>  
          <td><form:input path="name" /></td>  
         </tr>  
         <tr>  
          <td> Salary :</td>  
          <td><form:input path="salary" /></td>  
         </tr> 
         <tr>  
          <td> Designation :</td>  
          <td><form:select path="designation" /></td>  
         </tr>  
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
         
         <tr>  
            
          <td colspan="2"><a href="getList">Click Here to See User List</a></td>  
         </tr>  
        
        </table>  
       </form:form>  
      </div>    
    </body>  
    </html>  