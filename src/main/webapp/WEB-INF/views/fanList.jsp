<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

 	
	<h1>Dear ${owner} you're now on my fans page</h1>
	

	<a href="/add-fan"> <b>Add new Fan</b></a>
	<hr>
		
		<table class="table table-hover">
			<thead>
					<tr>
						<th scope="col">Image</b></th>
						<th scope="col">Year</b></th>
						<th scope="col">Make</b></th>
						<th scope="col">Model</b></th>
						<th scope="col">Update</b></th>
						<th scope="col">Remove Fan</b></th>
						
					</tr>
			</thead>
			<tbody>
			<c:forEach items="${fans}" var="fan">
				<tr>
					<td  ><img src = "${fan.image}" width="100" height="100" /></td>
					<td  >${fan.year}</td>
					<td  >${fan.make}</td>
					<td  >${fan.model}</td>
					<td><b>&nbsp; &nbsp;
     <a href="/update-fan?id=${fan.id}">Update</a>&nbsp;</b></td>
					<td><b>&nbsp; &nbsp;
     <a href="/delete-fan?id=${fan.id}">Delete</a></b></td>
				</tr>
			</c:forEach>	
			</tbody>
			
			
		</table>
		
<%@ include file="common/footer.jspf"%>
