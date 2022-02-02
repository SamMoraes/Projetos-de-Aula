package br.com.cotiinformatica.interfaces;

import br.com.cotiinformatica.entities.Usuario;

public interface IUsuarioRepository {

	void create(Usuario usuario) throws Exception;

	void updateSenha(Integer idUsuario, String novaSenha) throws Exception;

	Usuario findByEmail(String email) throws Exception;

	Usuario findByEmailAndSenha(String email, String senha) throws Exception;
}



