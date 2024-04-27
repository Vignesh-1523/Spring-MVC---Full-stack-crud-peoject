<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.hadrian.model.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display</title>
<script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap');
*{
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}
body{
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	background: url('https://www.pixel4k.com/wp-content/uploads/2020/10/peaceful-lake-minimal-4k_1603396138.jpg.webp');
	background-size: cover;
	background-position: center;
}
.scrollable{
    width: 70%;
    height: 500px;
    overflow-y: auto;
    box-shadow: 0 0 50px rgb(0, 0, 0);
    border-radius: 30px;
}
.scrollable::-webkit-scrollbar{
    display: none;
}
table {
    width: 100%;
    border-collapse: collapse;
    font-size: 0.8em;
    min-width: 400px;
    backdrop-filter: blur(50px);
}
tr th{
    position: sticky;
    top: 0;
    padding: 15px;
    text-align: left;
    font-size: 1.2em;
    font-weight: 400;
}
tr td{
    padding: 10px 15px;
}
tr td a{
    display: inline-block;
    padding: 5px 15px;
    margin-inline: 5px;
    color: black;
    text-decoration: none;
    border-radius: 15px;
    cursor: pointer;
}
tr:nth-child(even) {
    background-color: #f3f3f3;
}
tr:nth-child(odd) {
    background-color: #fff;
    border-bottom: 2px solid #3acacf;
}
tr:hover{
  /*  background-color: #3acacf20; */
     background-color: rgba(0,0,0,0.6);
    color: #3acacf;
}
tr th{
   background-color:#3acacf;
    color: black;
}
thead tr:hover{
    background-color:#3acacf; 
    color: black;
}
ion-icon{
   font-size: 20px;
}
tr:hover td a ion-icon{
    color: #FB9AD1;
}
</style>
</head>
<body>
<div class="scrollable">
	<table class="content-table">
	<thead>
		<tr>
			<th>S.no</th>
			<th>Name</th>
			<th>Email ID</th>
			<th>Password</th>
			<th>Mobile</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<!-- Only the java codes are written and not HTML tags inside the below tag -->
		<% ArrayList<Student> s = (ArrayList<Student>) request.getAttribute("listValues");
		for(Student x : s) {
		%>
		
		<tr>
		<!-- variable declaration or other java line code we have to give semicolon";" -->
		<!-- For direct values no need to give semicolon but have to give = at first -->
			<td><%= x.getId() %></td>
			<td><%= x.getName() %></td>
			<td><%= x.getEmail() %></td>
			<td><%= x.getPassword() %></td>
			<td><%= x.getMobile() %></td>
			<td>
			    <a href="edit?id=<%= x.getId() %>"><ion-icon name="create-outline"></ion-icon></a>
			    <a href="delete?id=<%= x.getId() %>"><ion-icon name="trash-outline"></ion-icon></a>
			</td>
		</tr>
		
		<% } %>
		</tbody>
		<!-- the above tag is known as Script let tag -->
	</table>
	</div>
</body>
</html>