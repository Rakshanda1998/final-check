<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie Cruiser</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
<script src="./js/script.js" type="text/javascript"></script>
</head>
<body>
	<header>
		<span> Movie Cruiser </span> <img class="img" src="./images/logo.png" />
		<a id="movie" href="ShowMovieItemListAdmin">Movies</a>
	</header>
	<div class="cont">
		<h2>Edit Movie</h2>
		<form name="mymovie" method="post" action="EditMovieItem?movieItemId=${movieItem.id }" 
			onSubmit="return validation()">
			<table>
				<tr>
					<td colspan="4"><label for="title">Title</label></td>
				</tr>

				<tr>
					<td colspan="4"><input type="text" id="title" name="txtTitle"
						value="${movieItem.title }" size="80"></td>
				</tr>

				<tr>
					<td><label for="box">Gross($)</label></td>
					<td><label for="mid">Active</label></td>
					<td><label for="launch">Date of Launch</label></td>
					<td><label for="mid">Genre</label></td>
				</tr>

				<tr>
					<td><input class="title" type="text" id="gross"
						name="txtGross" value="${movieItem.gross }" /></td>

					<td><input type="radio" id="rd1" name="active" value="Yes"
						<c:if test="${movieItem.active eq 'true' }">Checked</c:if>>Yes
						<input type="radio" id="rd2" name="active" value="No"
						<c:if test="${movieItem.active eq 'false' }">Checked</c:if>>No
					</td>

					<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value="${movieItem.dateOfLaunch }" var="formatDate" /> <input
						type="text" id="launch" name="dateOfLaunch" value="${formatDate }" /></td>
					<td><select name="genre">
							<option value="${movieItem.genre }">${movieItem.genre }</option>
							<option value="hero">Superhero</option>
							<option value="romance">Romance</option>
							<option value="cmdy">Comedy</option>
							<option value="adtr">Adventure</option>
							<option value="thlr">Thriller</option>
					</select></td>
				</tr>

				<tr>
					<td colspan="2"><input type="checkbox" name="Chbox" Checked
						<c:if test="${movieItem.hasTeaser eq 'true'}"> </c:if>
						<c:if test="${movieItem.hasTeaser eq 'false'}"></c:if>> <label
						for="chbox">Has Teaser</label></td>
				</tr>

				<tr>
					<td colspan="2"><input class="butn" type="Submit"
						name="Submit" value="Save" onClick="validate" /></td>
				</tr>
			</table>
		</form>
	</div>

	<footer>
		<span> copyright@2019 </span>
	</footer>
</body>
</html>