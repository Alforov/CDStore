package ua.org.oa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ua.org.oa.dao.DAO;
import ua.org.oa.model.Disc;
import ua.org.oa.model.Genre;
import ua.org.oa.model.ShoppingCart;
import ua.org.oa.model.Type;

@Controller
public class SearchController {
	@Autowired
	private DAO dao;


	@RequestMapping(value = "/catalog", method = RequestMethod.GET)
	public ModelAndView catalog() {
		return new ModelAndView("catalog");
	}
	
	@RequestMapping(value = "/search/type", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String type() {

		StringBuilder sb = new StringBuilder();
		List<Type> listType = dao.getAll(Type.class);
		sb.append("<option value=\"0\">Disc type</option>");
		for (Type type : listType) {
			sb.append("<option value=" + type.getId() + ">"
					+ type.getTypeName() + "</option>");
		}
		return sb.toString();
	}

	@RequestMapping(value = "/search/genre/{typeID}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String genre(@PathVariable("typeID") String typeID) {

		List<Genre> listType = dao.findByTypeID(typeID);
		StringBuilder sb = new StringBuilder();
		sb.append("<option value=\"0\">Genre</option>");
		for (Genre genre : listType) {
			sb.append("<option value=" + genre.getId() + ">"
					+ genre.getGenreName() + "</option>");
		}
		System.out.println("search/genre");

		return sb.toString();
	}

	@RequestMapping(value = "/search/{name}/{typeID}/{genreID}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String searchFinal(@PathVariable("name") String name,
			@PathVariable("typeID") String typeID,
			@PathVariable("genreID") String genreID) {
		name = name.replaceAll("%20", " ");
		List<Disc> list = dao.search(name, typeID, genreID);
		StringBuilder sb = new StringBuilder();
		sb.append("<ul>");
		int i = 0;
		for (Disc disc : list) {
			i++;
			String inner = null;
			if (disc.getName().length() > 65) {
				inner = disc.getName().substring(0, 64) + "...";
			} else {
				inner = disc.getName();
			}
			sb.append(" <li  onclick=\'fill(\"" + disc.getName() + "\")\'>"
					+ inner + "</li>");
			if (i == 3)
				break;
		}
		sb.append("</ul>");
		return sb.toString();
	}

	@RequestMapping(value = "/search/result/{name}/{typeID}/{genreID}", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public @ResponseBody String result(@PathVariable("name") String name,
			@PathVariable("typeID") String typeID,
			@PathVariable("genreID") String genreID) {

		if (name.equals("||")) {
			name = " ";
		}
		List<Disc> list = dao.search(name, typeID, genreID);
		StringBuilder sb = new StringBuilder();
		sb.append("{\"films\": [");
		Integer count = 0;

		for (Disc disc : list) {

			sb.append("{\"oder\":" + "\"" + disc.getId() + "\"" + ",\"type\":"
					+ "\"" + disc.getType().getTypeName() + "\""
					+ ",\"genre\":" + "\"" + disc.getGenre().getGenreName()
					+ "\"" + ",\"name\":" + "\"" + disc.getName() + "\"" + "},");
			count++;
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]}");
		sb.append("||" + count);
		return sb.toString();
	}

}
