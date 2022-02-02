package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;
import br.com.cotiinformatica.models.LoginModel;

@Controller
public class LoginController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	// m�todo para abrir a p�gina login.jsp (p�gina inicial)
	@RequestMapping(value = "/")
	public ModelAndView login() {

		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("model", new LoginModel());

		return modelAndView;
	}

	// m�todo para capturar o SUBMIT POST do formul�rio
	@RequestMapping(value = "post-login", method = RequestMethod.POST)
	public ModelAndView postLogin(LoginModel model, HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("login");
		
		try {
			
			boolean isValid = true;
			
			//validar o campo 'email' como obrigat�rio
			if(model.getEmail().trim().length() == 0) {
				modelAndView.addObject("erro_email", "Por favor, informe seu email de acesso.");
				isValid = false;
			}

			//validar o campo 'senha' como obrigat�rio
			if(model.getSenha().trim().length() == 0) {
				modelAndView.addObject("erro_senha", "Por favor, informe sua senha de acesso.");
				isValid = false;
			}
			
			if(isValid) {
				
				//consultar o usuario no banco de dados, baseado no email e na senha
				Usuario usuario = usuarioRepository.findByEmailAndSenha(model.getEmail(), model.getSenha());
				
				//verificar se o usuario foi encontrado
				if(usuario != null) {
					
					//gravar os dados do usu�rio em uma sess�o
					request.getSession().setAttribute("usuario", usuario);
					
					//redirecionar para a p�gina de consulta de tarefas..
					modelAndView.setViewName("redirect:tarefas-consulta");
				}
				else {
					modelAndView.addObject("mensagem_erro", "Acesso negado. Usu�rio inv�lido.");
				}
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Ocorreu um erro: " + e.getMessage());
		}
		
		modelAndView.addObject("model", model);
		return modelAndView;
	}
	
	// m�todo para abrir a p�gina login.jsp (p�gina inicial)
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {

		//apagando os dados do usu�rio gravado em sess�o
		request.getSession().removeAttribute("usuario");
		
		//redirecionar para a p�gina de login
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/");
		
		return modelAndView;
	}	
}



