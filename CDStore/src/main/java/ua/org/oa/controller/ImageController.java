package ua.org.oa.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.org.oa.dao.DAO;
import ua.org.oa.model.Disc;

@Controller
public class ImageController {
	@Autowired
	private DAO dao;

	@RequestMapping(value = "/info/image/{index}", method = RequestMethod.GET)
	public void getUserImage(@PathVariable("index") String index,
			HttpServletResponse response) throws IOException {
		response.setContentType("image/jpg");
		IOUtils.copy(
				new ByteArrayInputStream(dao.getLastDisc(
						Integer.parseInt(index)).getImage()),
				response.getOutputStream());

	}

}
