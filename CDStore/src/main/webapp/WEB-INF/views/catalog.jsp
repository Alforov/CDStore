<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
      <script src="<c:url value="/resources/js/search.js"/>"></script>
       <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
     

     
  </head>
<body>
  <div id="wrapper">   
   <div class="section">  <select class="chosen-select" id="type" > </select></div>    
   <div class="section"> <select class="chosen-select" id="genre" ><option value=0>Genre</option> </select></div>
   <div class="section" id="searchbox">
      <form autocomplete="off"  style="margin: 0 0 -16px 0;"><input type="text" id="search" placeholder="Search" ></form>
       <div id="display" ></div>     
   </div>
   <button  class="section" type="submit" style="background:red;font-weight:900;" id="go">GO</button>
  </div>
  <div id="resultlable">RESULT</div>
  <div id="triangle"></div>     
  <ul style="margin-top: 0px;">
    <li> 
       <div  id="innertable" ></div>
    </li>     
    <li>
       <div id="bottomlable"></div>
    </li>
    <li>   
       <div id="paginator"> 
       <button class="pag" type="submit" id="first">FIRST</button>
       <button class="pag" type="submit" id="prev"><</button>
       <span id="pagepag">0 FROM 0 PAGES</span> 
       <button class="pag" type="submit" id="next">></button>    
       <button class="pag" type="submit" id="last">LAST</button>         
       <button id="basket">Shopping Cart</button>
       </div>
     </li>
  </ul> 
  <div id="ok"></div>
 </body>
</html>