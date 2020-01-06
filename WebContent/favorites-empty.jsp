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
					<td><h1>Favorites</h1></td>
				</tr>

				<tr>
					<td>
						<h3>
							<p id="gry">
								No items in Favorites. Use 'Add to Favorite' option in<a
									id="clor" href="ShowMovieItemListCustomer"> Movie List</a>
							</p>
						</h3>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<footer> <span> copyright@2019 </span> </footer>
</body>
</html>
