<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>

<head>
<title>COTI Inform�tica - Projeto Agenda</title>

<!-- Referencia da folha de estilos CSS do bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body class="bg-secondary">

	<div class="card mt-5 col-md-8 offset-md-2">
		<div class="card-body">
		
			<h5 class="card-title">Crie sua Conta de Usu�rio</h5>
			<p>Preencha os campos para cadastrar sua conta de acesso.</p>
			<hr/>
			
			<form method="post" action="post-register">
			
				<div class="row">
					<div class="col-md-6">
						<label>Informe o seu nome:</label>
						<form:input path="model.nome" type="text" class="form-control" placeholder="Ex: Jo�o Pedro"/>
					</div>	
					<div class="col-md-6">
						<label>Informe o seu email:</label>
						<form:input path="model.email" type="text" class="form-control" placeholder="Ex: joaopedro@gmail.com"/>
					</div>		
				</div>
				
				<div class="row mt-3">
					<div class="col-md-6">
						<label>Entre com a sua senha:</label>
						<form:input path="model.senha" type="password" class="form-control" placeholder="Digite aqui"/>
					</div>	
					<div class="col-md-6">
						<label>Confirme a sua senha:</label>
						<form:input path="model.senhaConfirmacao" type="password" class="form-control" placeholder="Digite aqui"/>
					</div>	
				</div>
				
				<div class="row mt-3">
					<div class="col-md-12">
						<input type="submit" class="btn btn-success" value="Realizar Cadastro"/>
						&nbsp;
						<a href="/projetoWeb01/" class="btn btn-outline-primary">Voltar</a>
					</div>
				</div>
			
			</form>
		
		</div>
	</div>
	

	<!-- Referencia do arquivo JavaScript do bootstrap -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>




