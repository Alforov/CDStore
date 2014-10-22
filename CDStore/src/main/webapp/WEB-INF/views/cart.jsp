<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>   
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
     <script src="<c:url value="/resources/js/search.js"/>"></script>     
  </head>
  <body>
    <table id="cartTable">
       <thead>
         <tr>          
            <th>Name</th>
            <th>Amount</th>
            <th>Summa</th>
        </tr>
       </thead>
       <tbody>  
         <c:forEach items="${shoppingCart.listDisc}" var="disc">
           <tr>
             <td>${disc.name}</td>
             <td class="amounttd" >      
               <button class="minus" onclick="minus('cart-amount${disc.id}','totalprice${disc.id}','${disc.price}')" href="#" >minus</button>       
               <input  id="cart-amount${disc.id}"  type="text"  size="2" value="1">       
               <button class="plus" onclick="plus('cart-amount${disc.id}','totalprice${disc.id}','${disc.price}')" href="#" >plus</button>
             </td>
             <td class="amount" id="totalprice${disc.id}">${disc.price}</td>
          </tr>
         </c:forEach>
       </tbody>
    </table>   
     <div id="summa" ><h5 style="margin-bottom:5px;">Total :</h5> <span  id="total"></span></div>    
     <button style="background:red; font-weight:900;" id=oder>Оформить заказ</button>   
     <br/><br/><br/>
       <script type="text/javascript"> summa();</script>
  </body>
</html>