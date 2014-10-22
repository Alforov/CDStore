<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
     
     
    

     
  </head>
  <body>
  <p>
  Добро пожаловать! Мы рады приветствовать Вас в Интернет-магазине по продаже дисков. Здесь Вы можете выбрать и купить CD, DVD диски из широчайшего ассортимента, а также найти массу дополнительной информации. 
  </p>
  <h3 style="color:black;"><spring:message code="label.lastUploads"/>:</h3>
  <table  id="imagetable">
  <tr >
     <td>ACTION:</td>
     <td>MELODRAMA:</td>
     <td>SCARE:</td>
     <td>DRAMA:</td>
     <td>COMEDY:</td>
  </tr>
  <tr>
     <td><img  height="250" width="170" src=<c:url value="/info/image/1"/>/></td>
     <td><img  height="250" width="170" src=<c:url value="/info/image/2"/>/></td>
     <td><img  height="250" width="170" src=<c:url value="/info/image/3"/>/></td>
     <td><img  height="250" width="170" src=<c:url value="/info/image/4"/>/></td>
     <td><img  height="250" width="170" src=<c:url value="/info/image/10"/>/></td>
     
  </tr>
  </table>
  
 
  </body>