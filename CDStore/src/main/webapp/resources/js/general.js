
$(document).ready(function(){
	
  $('#content').load('http://localhost:8080/CDStore/info');
    
     // handle menu click
	
	$('#menu button').click(function(){
		
	    var page = $(this).attr('href');	   
	   
	    		     $('#menu .button_fixed').removeClass('button_fixed').addClass('button_no_fixed')
	    		   
	    $(this).removeClass('button_no_fixed').addClass('button_fixed')
	 
	   
	    
	  $('#content').load(page);
	 
	  
	    
	  return false;	  
	});
});