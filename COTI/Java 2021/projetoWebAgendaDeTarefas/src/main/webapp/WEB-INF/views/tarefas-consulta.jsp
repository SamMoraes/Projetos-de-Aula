<html>

<head>

<title>Agenda de Tarefas - Consulta</title>

<!-- Folha de estilos CSS do bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>

	<jsp:include page="/WEB-INF/views/components/menu.jsp" />

	<div class="container mt-4">
		
		<h5>Seja bem vindo à Agenda de tarefas!</h5>
		<hr/>
		
		<form>
		
			<div class="row">
				<div class="col-md-3">
					<label>Data de início:</label>
					<input type="date" class="form-control"/>
				</div>
				<div class="col-md-3">
					<label>Data de término:</label>
					<input type="date" class="form-control"/>
				</div>
				<div class="col-md-6">
					<input type="submit" value="Pesquisar Tarefas" class="btn btn-success mt-4"/>
				</div>
			</div>
		
		</form>
		
		<table class="table table-sm table-hover mt-3">
			<thead>
				<tr>
					<th>Nome da tarefa</th>
					<th>Data</th>
					<th>Hora</th>
					<th>Descrição</th>
					<th>Prioridade</th>
					<th>Operações</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<a href="/projetoWebAgendaDeTarefas/tarefas-edicao" class="btn btn-primary btn-sm">Alterar</a>
						<a href="#" class="btn btn-danger btn-sm">Excluir</a>
					</td>
				</tr>				
			</tbody>
			<tfoot>
				<tr>
					<td colspan="6">Quantidade de tarefas: 0</td>
				</tr>
			</tfoot>
		</table>
		
	</div>

	<!-- Arquivos javascript -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>




