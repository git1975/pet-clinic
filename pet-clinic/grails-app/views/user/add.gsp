<html>
	<head>
		<meta name="layout" content="main">
		<title>Add User</title>
	</head>

	<body id="add">
		<h2><g:if test="${!userBean.id}">New </g:if>User:</h2>

		<g:form action="${ userBean.id ? 'edit' : 'add'}" id="${userBean?.id}">
			<table>
				<tr>
					<th>
						<g:render template="/common/formField"
						          model="[name:'user', bean:userBean, field:'username', label:'User Name']" />
					</th>
				</tr>
				<tr>
					<th>
						<g:render template="/common/formField"
						          model="[name:'user', bean:userBean, field:'password', label:'Password']" />
					</th>
				</tr>
				<tr>
					<td>
						<p class="submit"><input type="submit" value="${ userBean.id ? 'Update' : 'Add'} User"/></p>
					</td>
				</tr>
			</table>
		</g:form>
	</body>
</html>
