<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Movie cruiser</title>
<link rel="stylesheet" type="text/css" href="./style/style.css" />
</head>
<body>
	<header>
		<span>Movie Cruiser</span> <img class="img" src="./images/logo.png" />
		<a id="movie" href="ShowMovieItemListAdmin">Movies</a>
	</header>
	<div class="cont">
		<h2>Movies</h2>
		<table class="table">
			<tr>
				<th class="title">Title</th>
				<th class="box">Gross($)</th>
				<th class="mid">Active</th>
				<th class="mid">Date of Launch</th>
				<th class="mid">Genre</th>
				<th class="mid">Has Teaser</th>
				<th class="mid">Action</th>
			</tr>

			<c:forEach items="${movieItemList }" var="movie">
				<tr>

					<td class="title">${movie.title }</td>
					<td class="box">${movie.gross }</td>
					<td class="mid"><c:if test="${movie.active }">Yes</c:if> <c:if
							test="${!movie.active }">No</c:if></td>
					<td class="mid"><fmt:formatDate pattern="dd/MM/yyyy"
							value="${movie.dateOfLaunch}" /></td>
					<td class="mid">${movie.genre }</td>
					<td class="mid"><c:if test="${movie.hasTeaser }"> Yes</c:if>
						<c:if test="${!movie.hasTeaser }">No</c:if></td>
					<td class="mid"><a
						href="ShowEditMovieItem?movieItemId=${movie.id }" target="_blank">Edit</a></td>
				</tr>
			</c:forEach>

		</table>
	</div>

	<footer>
		<span> copyright@2019 </span>
	</footer>
</body>
</html>