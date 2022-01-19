<html>

<head>

<title>Agenda de Tarefas - Cadastro</title>

<!-- Folha de estilos CSS do bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<jsp:include page="/WEB-INF/views/components/menu.jsp" />

	<div class="container mt-4">
		
		<h5>Cadastro de Tarefas</h5>
		<p>Preencha os campos abaixo para incluir uma tarefa.</p>
		<hr/>
		
		<form>
		
			<div class="row">
				<div class="col-md-6">
					<label>Nome da tarefa:</label>
					<input type="text" class="form-control" placeholder="Digite aqui"/>
				</div>		
				<div class="col-md-2">
					<label>Data:</label>
					<input type="date" class="form-control"/>
				</div>	
				<div class="col-md-2">
					<label>Hora:</label>
					<input type="time" class="form-control"/>
				</div>	
				<div class="col-md-2">
					<label>Prioridade:</label>
					<select class="form-select">
						<option value="">Selecione</option>
						<option value="1">Baixa</option>
						<option value="2">M�dia</option>
						<option value="3">Alta</option>
					</select>
				</div>	
			</div>
			
			<div class="row mt-3">
				<div class="col-md-12">
					<label>Descri��o da tarefa:</label>
					<textarea class="form-control"></textarea>
				</div>
			</div>
			
			<div class="mt-3">
				<div class="col-md-12">
					<input type="submit" value="Realizar Cadastro" class="btn btn-success"/>
					<a href="/projetoWeb01/tarefas-consulta" class="btn btn-light">Voltar</a>
				</div>
			</div>
		
		</form>
		
	</div>

	<!-- Arquivos javascript -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>


