package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.models.RegisterModel;

@Controller
public class RegisterController {

	// Método executado para abrir a página
	@RequestMapping(value = "register")
	public ModelAndView register() {

		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("model", new RegisterModel());

		return modelAndView;
	}

	// Método para receber os dados enviados pelo formulário (POST)
	@RequestMapping(value = "post-register", method = RequestMethod.POST)
	public ModelAndView postRegister(RegisterModel model) {

		ModelAndView modelAndView = new ModelAndView("register");

		if (model.getNome().trim().length() == 0) {
			modelAndView.addObject("erro_nome", "Por favor, informe seu nome de usuário.");
		}

		if (model.getEmail().trim().length() == 0) {
			modelAndView.addObject("erro_email", "Por favor, informe seu email de acesso.");
		}

		if (model.getSenha().trim().length() == 0) {
			modelAndView.addObject("erro_senha", "Por favor, informe sua senha de acesso.");
		}

		if (!model.getSenha().equals(model.getSenhaConfirmacao())) {
			modelAndView.addObject("erro_senhaConfirmacao", "Senhas não conferem, por favor verifique.");
		}

		modelAndView.addObject("model", model);

		return modelAndView;
	}
}
