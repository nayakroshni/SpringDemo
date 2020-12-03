<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function submitPage()
{
	window.document.forms[0].action="/savePage";
	window.document.forms[0].submit();
}
function editUser(userID)
{
	window.document.forms[0].action="/reqEdit/"+userID;
	window.document.forms[0].submit();
}
function deleteUser(userID)
{
	window.document.forms[0].action="/reqDelete/"+userID;
	window.document.forms[0].submit();
}
</script>
</head>
<body>
<h1>Registration Page</h1>
<hr>
	<form action="" method="post">
		<input type= "hidden" name="userID" value="${userModel.userID}">
		<table align="center">
			<tr>
				<td>Sur Name : </td>
				<td><input type= "text" name="surName" value="${userModel.surName}"></td>
			</tr>
			<tr>
				<td>First Name : </td>
				<td><input type= "text" name="firstName" value="${userModel.firstName}"></td>
			</tr>
			<tr>
				<td>Middle Name : </td>
				<td><input type= "text" name="middleName" value="${userModel.middleName}"></td>
			</tr>
			<tr>
				<td>Marital Status : </td>
				<td>
					<select name="maritalModel.maritalStatusID">
					<c:forEach var="list" items="${list}">
						<c:choose>
							<c:when test="${userModel.maritalModel.maritalStatusID == list.maritalStatusID}">
								<option value="${list.maritalStatusID}" selected>${list.maritalStatus}</option>
      						</c:when>	
							<c:otherwise>
								<option value="${list.maritalStatusID}">${list.maritalStatus}</option>
      						</c:otherwise>
						</c:choose>
					</c:forEach>	
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><button onclick="submitPage(); return false;"> Save </button></td>
			</tr>
		</table>
		
	</form>	
	<table align="center" border="1">
		<tr>
			<th>Sur Name</th>
			<th>First Name</th>
			<th>Middle Name</th>
			<th>Marital Status</th>
			<th>Action</th>
		</tr>
		<c:forEach var="userList" items="${userList}">	
			<tr>
				<th>${userList.surName}</th>
				<th>${userList.firstName}</th>
				<th>${userList.middleName}</th>
				<th>${userList.maritalModel.maritalStatus}</th>
				<th>
					<a href="#" onclick="editUser(${userList.userID});return false;">Edit</a>
					<a href="#" onclick="deleteUser(${userList.userID});return false;">Delete</a>
				</th>
			</tr>				
		</c:forEach>
	</table>
</body>
</html>