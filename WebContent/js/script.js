function validation() {
	var a = document.forms["mymovies"]["txtTitle"].value;
	if(a == "") {
		alert("Title is required");
		return false;
	}
	if((a.length < 2) || (a.length > 65)) {
		alert("Title should have 2 to 100 characters");
		document.forms["mymovies"]["txtTitle"].select();
		return false;
	}
	