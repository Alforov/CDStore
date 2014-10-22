<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
      <script src="<c:url value="/resources/js/search.js"/>"></script>
     

     
  </head>
<body>
 <button type="submit" id="go" style="float:left" >RESULT</button>
 <button type="submit" id="add" style="float:left">ADD</button>
 <button type="submit" id="delete">DELETE</button>

 <div id="wrapper"> 
    
    <select  id="type" style="float:left;" > </select>
    
    
    <select id="genre" style="float:left" ><option value=0>-Disc Genre-</option> </select>
      <div  id="searchbox">
    
           <form method="post" action="" autocomplete="off"  style="margin: 0 0 -16px 0;">
             <input type="text" id="search" size="90"  placeholder="Search">
              </form>
           <div id="display" ></div>     
       </div>
   
  
 </div>
 
 </br>
 </br>
 </br>
<div id="deleteresult"></div>
<h3>Result:</h3>
       
       <ul>
         <li style="list-style-type: none"> 
            <div  id="innertable" >
            
            </div>
        </li>
</body>
</html>