<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

<head>

<title>COTI Informática - Projeto Agenda</title>

<!-- folhas de estilo CSS da página -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body class="bg-secondary">

	<div class="card mt-5 col-md-4 offset-md-4">
		<div class="card-body text-center">
		
			<img src="https://www.cotiinformatica.com.br/imagens/logo-coti-informatica.png" class="img-fluid"/>
						
			<h5 class="card-title">Agenda de tarefas</h5>
			<p class="card-text">Entre com suas credenciais de acesso.</p>
			
			<hr/>
			
			<!-- formulário para preenchimento dos dados do usuário (login) -->
			<form method="post" action="post-login">
			
				<label>Email de acesso:</label>
				<form:input path="model.email" type="text" class="form-control" placeholder="Ex: joaopedro@gmail.com"/>
				<div class="text-danger">
					${erro_email}
				</div>
				<br/>
				
				<label>Senha de acesso:</label>
				<form:input path="model.senha" type="password" class="form-control" placeholder="Digite aqui"/>
				<div class="text-danger">
					${erro_senha}
				</div>
				<br/>
				
				<div class="d-grid">
					<input type="submit" value="Acessar Sistema" class="btn btn-primary"/>
				</div>
			
			</form>
			
			<div class="d-grid">
				Não possui uma conta? <a href="/projetoWebAgendaDeTarefas/register">Cadastre-se aqui!</a>
			</div>

		</div>
	</div>

	<!-- arquivos javascript da página -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>