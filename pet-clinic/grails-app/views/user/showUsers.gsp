<html>
<head>
<meta name="layout" content="main">
<title>Users</title>
</head>
<body id="users">
<g:form action='delete'>
	<h2>Users:</h2>

	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Password</th>
			</tr>
		</thead>
		<g:each var="user" in="${users}">
			<tr>
				<td><g:checkBox name="users.${user.id}" value="${false}"/> </td>
				<td>
					${user.username}
				</td>
				<td>
					${user.password}
				</td>
			</tr>
		</g:each>
	</table>
	<g:link controller="user" action="add"><input type="button" value="Add"/></g:link>
	<g:actionSubmit action="delete" value="Delete" />
</g:form>
</body>
</html>
