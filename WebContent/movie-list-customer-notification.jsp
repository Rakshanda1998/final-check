<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie Cruiser</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
</head>
<body>
	<header> <span> Movie Cruiser </span> <img class="img"
		src="./images/logo.png" /> <a id="movie" href="ShowFavorite">Favorites</a>
	<a id="movie" href="ShowMovieItemListCustomer">Movies</a> </header>
	<div class="cont">
		<form>
			<table class="table">
				<tr>
					<h3>
						<p id="p">Movie added to Favorite Successfully</p>
					</h3>
				</tr>

				<tr>
					<th class="title">Title</th>
					<th class="box">Gross</th>
					<th class="mid">Genre</th>
					<th class="mid">Has Teaser</th>
					<th class="mid">Action</th>
				</tr>

				<c:forEach items="${movieItemList }" var="movie">
				<tr>
					<td class="title"><c:out value="${movie.title }"></c:out></td>
					<td class="gross"><c:out value="${movie.gross }"></c:out></td>
					<td class="mid"><c:out value="${movie.genre }"></c:out></td>
					<td class="mid"><c:if test="${movie.hasTeaser }"> Yes</c:if>
						<c:if test="${!movie.hasTeaser }">No</c:if></td>
					<td class="mid"><a href="AddToFavorite?movieItemId=${movie.id }">Add to Favorite</a></td>

				</tr>
			</c:forEach>
			</table>
		</form>
	</div>

	<footer> <span> copyright@2019 </span> </span>
</body>
</html>