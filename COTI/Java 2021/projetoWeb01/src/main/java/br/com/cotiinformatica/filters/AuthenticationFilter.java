package br.com.cotiinformatica.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter implements Filter {

	public AuthenticationFilter() {
	}

	public void destroy() {
	}

	//M�todo utilizado para criar a regra de acesso �s p�ginas restritas
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//Criar objetos para manipular a navega��o das p�ginas
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//lista das p�ginas que n�o precisam de autentica��o do usu�rio
		List<String> urlsPermitidas = new ArrayList<String>();
		
		urlsPermitidas.add("/"); //p�gina de login
		urlsPermitidas.add("/post-login"); //submit do formul�rio de autentica��o
		urlsPermitidas.add("/register"); //p�gina de cria��o de conta de usu�rio
		urlsPermitidas.add("/post-register"); //submit do formul�rio de cria��o de conta
		urlsPermitidas.add("/esqueci-minha-senha"); //p�gina de esqueci minha senha
		urlsPermitidas.add("/post-esqueci-minha-senha"); //submit do formul�rio de lembrete de senha
		
		//Capturando o endere�o da p�gina que o usu�rio est� acessando
		String paginaAtual = req.getServletPath();
		
		//verificando se o usu�rio est� tentando acessar
		//alguma p�gina de acesso restrito
		if(!urlsPermitidas.contains(paginaAtual)) {
			
			//verificar se o usu�rio N�O est� autenticado (gravado em sess�o)
			if(req.getSession().getAttribute("usuario") == null) {
				//redirecionar o usu�rio de volta para a p�gina de login
				resp.sendRedirect("/projetoWeb01/");
			}			
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}




