<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie Cruiser</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
<script src="./js/script.js" type="text/javascript"></script>
</head>
<body>
	<header> <span> Movie Cruiser </span> <img class="img"
		src="./images/logo.png" /> <a id="movie" href="ShowFavorite">Favorite</a>
	<a id="movie" href="ShowMovieItemListCustomer">Movies</a> </header>
	<div class="cont">
		<h1>Favorites</h1>

		<table class="table" colspan="4">
			<h3>
				<p id="p">${msg }</p>

			</h3>
			<tr>
				<th class="title">Title</th>
				<th class="box">Gross($)</th>
				<th class="mid">Genre</th>
				<th class="mid"></th>
			</tr>

			<c:forEach items="${movieItemListCustomer }" var="movie">
				<tr>
					<td class="title"><c:out value="${movie.title }"></c:out></td>
					<td class="box"><c:out value="${movie.gross }"></c:out></td>
					<td class="mid"><c:out value="${movie.genre }"></</c:out></td>

					<td class="mid"><a
						href="RemoveFavorite?movieItemId=${movie.id }">Delete</a></td>
				</tr>
			</c:forEach>

			<tr>
				<th class="title"><p>No Of Favorites:2</p></th>

			</tr>

		</table>
	</div>

	<footer> <span> Copyright@2019 </span> </footer>
</body>
</html>