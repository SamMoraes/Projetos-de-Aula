package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.models.RegisterModel;

@Controller
public class RegisterController {

	//M�todo executado para abrir a p�gina
	@RequestMapping(value = "register")
	public ModelAndView register() {

		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("model", new RegisterModel());
		
		return modelAndView;
	}

	//M�todo para receber os dados enviados pelo formul�rio (POST)
	@RequestMapping(value = "post-register", method = RequestMethod.POST)
	public ModelAndView postRegister(RegisterModel model) {
		
		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("model", model);
		
		return modelAndView;
	}
}





