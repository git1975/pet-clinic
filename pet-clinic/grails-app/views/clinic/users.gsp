<html>
	<head>
		<meta name="layout" content="main">
		<title>Veterinarians</title>
	</head>
	<body id="users">
		<h2>Users:</h2>

		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Password</th>
				</tr>
			</thead>
			<g:each var="vet" in="${users}">
				<tr>
					<td>${vet.username} ${vet.password}</td>
					<td>

					</td>
				</tr>
			</g:each>
		</table>
	</body>
</html>
