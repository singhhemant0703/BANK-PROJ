<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <head>
      <title>Pop Up Form Show</title>
     <style type="text/css">
	  #pan{
	   display: none;
       position: fixed;
       color:blue;
       top:35px;
       size:20px;
       align-items:center; 
       border: 3px solid #f1f1f1;
       z-index: 0;
       background-color:#313131;
	  }
	  #aadhar{
	   
	   display: none;
       position: fixed ;
       color:blue;
        top:35px;
        size:20px;
       align-items:center;
       border: 3px solid #f1f1f1;
       z-index: 20;
       background-color:#313131;
	  }
	</style>
     
	 <script type="text/javascript">
	   function div_showPan(){
	     document.getElementById('pan').style.display = "block";
	   }
	   function div_showAadhar(){
		     document.getElementById('aadhar').style.display = "block";
		   }
	 </script>
    </head>
  <body bgcolor="gray">
     <h1 style="color:black;text-align: center;">SHOW_CUSTOMER</h1><br/><br/>
      <div>
        <button id="pan_popup" onclick="div_showPan()">PAN_NO</button>
        <button id="pan_popup" onclick="div_showAadhar()">AADHAR_NO</button>
      </div>
        <div id="pan">
          <form:form action="show_customer" modelAttribute="customer">
           <b>Input Pan_No : </b> <form:input path="panNo" /><input type="submit" value="SEARCH"><input type="reset" value="CANCLE">
          </form:form>
        </div>
        <div id="aadhar">
          <form:form action="show_customer" modelAttribute="customer">
            <b>Input Aadhar_No : </b><form:input path="aadharNo"/><input type="submit" value="SEARCH"><input type="reset" value="CANCLE">
          </form:form>
        </div>
       <a href="home" style="color: blue;text-align: left"><h3>Back</h3></a> 
  </body>
