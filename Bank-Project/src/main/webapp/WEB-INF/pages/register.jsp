<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <body bgcolor="#B19E9A"><br/>
      
    
      <h1 style="color:red;border-radius: 25px;">Customer Registration(CIF) Form</h1><br/>
    <div style="color:blue;border-radius: 20px;">
     <form:form action="save" method="post" modelAttribute="customer">
     <table>
        <tr>
         <td><b>Customer Name  ::</b></td><td><form:input path="customerName" /></td>
         </tr>
          <tr>
           <td><b>Date Of Birth ::</b></td><td><form:input path="dob"/></td>
           </tr>
           <tr>
          <td> <b>Pan No        ::</b></td><td><form:input path="panNo"/></td>
          </tr>
          <tr>
          <td><b>Aadhar No     ::</b></td><td><form:input path="aadharNo"/></td>
          </tr>
           <tr>
           <td></td><td> <input type="submit" value="Register"></td>
           </tr>
            </table>
     </form:form>
     </div>
     <br/>
     <div>
       <h2 style="color:#9C8A43;text-align: center;">${result}</h2>
     </div>
     </body>