package ua.org.oa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ua.org.oa.dao.DAO;
import ua.org.oa.model.Disc;
import ua.org.oa.model.Genre;
import ua.org.oa.model.ShoppingCart;
import ua.org.oa.model.Type;


@Controller
public class CartController {
	@Autowired
    private DAO dao;
	
	
	@RequestMapping(value="/cart", method = RequestMethod.GET)
    public ModelAndView cartpage() {

        ModelAndView model = new ModelAndView("cart");
       
        return model;
    }
	
	
	
	@RequestMapping(value = "/cart/{cart}", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public @ResponseBody String cart(@PathVariable("cart") String cart, HttpSession session) {
	if(cart.equals("0")){return "";}
	cart=cart.substring(0, cart.length()-5);
		String[] arrayDisc = cart.split("split");
    for (int i = 0; i < arrayDisc.length; i++) {
		System.out.println(arrayDisc[i]);
	}
    int count=0;
    ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
    for (int i = 0; i < arrayDisc.length; i++) {
    	Disc disc = dao.get(Disc.class, Integer.parseInt(arrayDisc[i]));
    	
    	System.out.println(disc);
    	
    	
    	if(!shoppingCart.getListDisc().contains(disc)){
    		count++;
		shoppingCart.addDisc(disc);}
	}
    
        return count+" ADD";
}
}
