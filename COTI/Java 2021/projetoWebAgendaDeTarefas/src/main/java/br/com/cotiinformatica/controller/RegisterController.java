package br.com.cotiinformatica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;
import br.com.cotiinformatica.models.RegisterModel;

@Controller
public class RegisterController {
	
	//inicializando o repositorio
	@Autowired //faz a inicializa��o autom�tica do atributo
	private IUsuarioRepository usuarioRepository;

	// M�todo executado para abrir a p�gina
	@RequestMapping(value = "register")
	public ModelAndView register() {

		ModelAndView modelAndView = new ModelAndView("register");
		modelAndView.addObject("model", new RegisterModel());

		return modelAndView;
	}

	// M�todo para receber os dados enviados pelo formul�rio (POST)
	@RequestMapping(value = "post-register", method = RequestMethod.POST)
	public ModelAndView postRegister(RegisterModel model) {

		ModelAndView modelAndView = new ModelAndView("register");

		try {
			
			boolean isValid = true;
			
			if (model.getNome().trim().length() == 0) {
				modelAndView.addObject("erro_nome", "Por favor, informe seu nome de usu�rio.");
				isValid = false;
			}

			if (model.getEmail().trim().length() == 0) {
				modelAndView.addObject("erro_email", "Por favor, informe seu email de acesso.");
				isValid = false;
			}

			if (model.getSenha().trim().length() == 0) {
				modelAndView.addObject("erro_senha", "Por favor, informe sua senha de acesso.");
				isValid = false;
			}

			if (!model.getSenha().equals(model.getSenhaConfirmacao())) {
				modelAndView.addObject("erro_senhaConfirmacao", "Senhas n�o conferem, por favor verifique.");
				isValid = false;
			}
			
			//verificar se o email informado j� est� cadastrado no banco de dados
			if(usuarioRepository.findByEmail(model.getEmail()) != null) {
				modelAndView.addObject("erro_email", "O email informado j� foi cadastrado no sistema, tente outro.");
				isValid = false;
			}
			
			//verificar se n�o h� erros
			if(isValid) {
				
				Usuario usuario = new Usuario();
				
				usuario.setNome(model.getNome());
				usuario.setEmail(model.getEmail());
				usuario.setSenha(model.getSenha());
				
				usuarioRepository.create(usuario);
				
				modelAndView.addObject("mensagem_sucesso", "Parab�ns, sua conta de usu�rio foi criada com sucesso!");
				model = new RegisterModel(); //limpar os campos da p�gina
			}			
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Ocorreu um erro: " + e.getMessage());
		}

		modelAndView.addObject("model", model);
		return modelAndView;
	}
}



