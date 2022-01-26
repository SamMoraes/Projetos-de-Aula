<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
		
		<form method="post" action="post-tarefas-consulta">
		
			<div class="row">
				<div class="col-md-3">
					<label>Data de início:</label>
					<form:input path="model.dataMin" type="date" class="form-control"/>
					<span class="text-danger">
						${erro_dataMin}
					</span>
				</div>
				<div class="col-md-3">
					<label>Data de término:</label>
					<form:input path="model.dataMax" type="date" class="form-control"/>
					<span class="text-danger">
						${erro_dataMax}
					</span>
				</div>
				<div class="col-md-6">
					<input type="submit" value="Pesquisar Tarefas" class="btn btn-success mt-4"/>
				</div>
			</div>
		
		</form>
		
		<c:if test="${tarefas.size() > 0}">
		
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
				
					<c:forEach items="${tarefas}" var="t">
					
						<tr>
							<td>${t.nome}</td>
							<td>
								<fmt:formatDate value="${t.data}" pattern="E dd/MM/yyyy"/>
							</td>
							<td>${t.hora}</td>
							<td>${t.descricao}</td>
							<td>
								<c:if test="${t.prioridade == 'BAIXA'}">
									<span class="badge bg-success">BAIXA</span>
								</c:if>
								<c:if test="${t.prioridade == 'MEDIA'}">
									<span class="badge bg-warning">MÉDIA</span>
								</c:if>
								<c:if test="${t.prioridade == 'ALTA'}">
									<span class="badge bg-danger">ALTA</span>
								</c:if>
							</td>
							<td>
								<a href="/projetoWebAgendaDeTarefas/tarefas-edicao" class="btn btn-primary btn-sm">Alterar</a>
								<a href="#" class="btn btn-danger btn-sm">Excluir</a>
							</td>
						</tr>			
					
					</c:forEach>				
						
				</tbody>
				<tfoot>
					<tr>
						<td colspan="6">
							Quantidade de tarefas: ${tarefas.size()}
						</td>
					</tr>
				</tfoot>
			</table>
		
		</c:if>
		
	</div>

	<!-- Arquivos javascript -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>


