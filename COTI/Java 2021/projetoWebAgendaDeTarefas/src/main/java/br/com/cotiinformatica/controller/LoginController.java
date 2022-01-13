package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.models.LoginModel;

@Controller
public class LoginController {

	// método para abrir a página login.jsp (página inicial)
	@RequestMapping(value = "/")
	public ModelAndView login() {

		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("model", new LoginModel());

		return modelAndView;
	}

	// método para capturar o SUBMIT POST do formulário
	@RequestMapping(value = "post-login", method = RequestMethod.POST)
	public ModelAndView postLogin(LoginModel model) {
		
		ModelAndView modelAndView = new ModelAndView("login");
		
		//validar o campo 'email' como obrigatório
		if(model.getEmail().trim().length() == 0) {
			modelAndView.addObject("erro_email", "Por favor, informe seu email de acesso.");
		}

		//validar o campo 'senha' como obrigatório
		if(model.getSenha().trim().length() == 0) {
			modelAndView.addObject("erro_senha", "Por favor, informe sua senha de acesso.");
		}
		
		modelAndView.addObject("model", model);

		return modelAndView;
	}
}
