package ua.org.oa.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
public class AdminController {
	@Autowired
	private DAO dao;

	@RequestMapping(value = "/admin")
	public ModelAndView cartpage() {

		ModelAndView model = new ModelAndView("admin");

		return model;
	}

	@RequestMapping(value = "/admin/delete/{delete}", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String cart(@PathVariable("delete") String cart,
			HttpSession session) {
		if (cart.equals("0")) {
			return "blank click";
		}
		cart = cart.substring(0, cart.length() - 5);
		String[] arrayDisc = cart.split("split");
		for (int i = 0; i < arrayDisc.length; i++) {
			System.out.println(arrayDisc[i]);
		}
		int count = 0;

		for (int i = 0; i < arrayDisc.length; i++) {
			count++;

			dao.delete(Disc.class, Integer.parseInt(arrayDisc[i]));

		}

		return "Success delete " + count + " element!";
	}

	@RequestMapping(value = "/admin/save/{name}/{typeID}/{genreID}", method = RequestMethod.POST)
	public @ResponseBody String save(@PathVariable("name") String name,
			@PathVariable("typeID") Integer typeID,
			@PathVariable("genreID") Integer genreID) {
		System.out.println("I am in save controller");
		System.out.println(name + "  :  " + typeID + "  :  " + genreID);
		name = name.replaceAll("%20", " ");

		Disc disc = new Disc();
		disc.setName(name);
		Genre genre = dao.get(Genre.class, genreID);
		Type type = dao.get(Type.class, typeID);

		disc.setGenre(genre);
		disc.setType(type);
		dao.saveOrUpdate(disc);
		return "Your disc was saved";
	}
}
