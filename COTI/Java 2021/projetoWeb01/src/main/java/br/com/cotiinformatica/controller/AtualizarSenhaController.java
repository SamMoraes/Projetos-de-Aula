package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.interfaces.IUsuarioRepository;
import br.com.cotiinformatica.models.AtualizarSenhaModel;

@Controller
public class AtualizarSenhaController {

	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/atualizar-senha")
	public ModelAndView atualizarSenha() {

		ModelAndView modelAndView = new ModelAndView("atualizar-senha");
		modelAndView.addObject("model", new AtualizarSenhaModel());

		return modelAndView;
	}

	@RequestMapping(value = "post-atualizar-senha", method = RequestMethod.POST)
	public ModelAndView postAtualizarSenha(AtualizarSenhaModel model, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("atualizar-senha");
		
		boolean isValid = true;
				
		if(model.getNovaSenha() == null || model.getNovaSenha().trim().length() == 0) {
			modelAndView.addObject("erro_novaSenha", "Por favor, informe a nova senha");
			isValid = false;
		}
		
		if(model.getNovaSenhaConfirmacao() == null || model.getNovaSenhaConfirmacao().trim().length() == 0) {
			modelAndView.addObject("erro_novaSenhaConfirmacao", "Por favor, confirme a nova senha");
			isValid = false;
		}
		
		try {
			
			//obter o usuario autenticado na sess�o do sistema
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			//verificar se a senha atual n�o est� correta..
			if(usuarioRepository.findByEmailAndSenha(usuario.getEmail(), model.getSenhaAtual()) == null) {
				modelAndView.addObject("erro_senhaAtual", "A senha atual n�o confere, por favor verifique.");
				isValid = false;
			}

			if(model.getNovaSenhaConfirmacao() != null && !model.getNovaSenhaConfirmacao().equals(model.getNovaSenha())) {
				modelAndView.addObject("erro_novaSenhaConfirmacao", "Senhas n�o conferem.");
				isValid = false;
			}
			
			//verificar se n�o houve nenhum erro de valida��o
			if(isValid) {
				
				//atualizando a senha
				usuarioRepository.updateSenha(usuario.getIdUsuario(), model.getNovaSenha());
				
				modelAndView.addObject("mensagem_sucesso", "Senha atualizada com sucesso.");
				model = new AtualizarSenhaModel();
			}
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", e.getMessage());
		}
		
		modelAndView.addObject("model", model);
		return modelAndView;
	}
}



