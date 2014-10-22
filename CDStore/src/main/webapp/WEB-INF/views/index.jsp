<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>   
     <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
     <script src="<c:url value="/resources/js/general.js"/>"></script>
     <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/styles.css"/>" /> 
    <title>CD Store</title>     
  </head>
  <body> 
    <div id="header">
      <div style="float: right; margin-right:10px;" id="lang">
     	<a href="?language=en">en</a> 	 
    	<a href="?language=ru">ru</a>
      </div>
      <img id="header-image" src=<c:url value="/resources/images/va3.jpeg"/> > 
      <div id="phrase"> Web Store</div>
    </div>
    <div id="menu">  
	    <button class='button_fixed'  href="info"><spring:message code="label.mainpage" /></button>
	    <button class='button_no_fixed' href="catalog"><spring:message code="label.catalog" /></button>
	    <button  class='button_no_fixed' href="cart"><spring:message code="label.cart" /></button>     
	</div>	
    <div id="container">          
	   <div  id="content"></div>	
	   <div id = footer></br></br><h5 style="float:right; color:white; margin-right:10px; ">2014 Alforov Mykhailo </h5></div>
	</div>	
  </body> 
<html>