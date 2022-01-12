package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.models.HomeModel;

@Controller
public class HomeController {

	// m�todo para abrir a p�gina home.jsp (p�gina inicial)
	@RequestMapping(value = "/")
	public ModelAndView home() {

		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("model", new HomeModel());

		return modelAndView;
	}
}





