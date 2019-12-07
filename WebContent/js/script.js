function validation() {
	var a = document.forms["mymovie"]["txtTitle"].value;
	if(a == "") {
		alert("Title is required");
		return false;
	}
	if((a.length < 2) || (a.length > 65)) {
		alert("Title should have 2 to 100 characters");
		document.forms["mymovie"]["txtTitle"].select();
		return false;
	}
	var b = document.forms["mymovie"]["txtGross"].value;
	if(b == "") {
		alert("Gross is Required");
		document.forms["mymovie"]["txtGross"].focus();
		return false;
	}
	if(/[^0-9]/.test(b)) {
		alert("Gross has to be a number");
		return false;
	}
	
	var c = document.forms["mymovie"]["txtLaunch"].value;
	if(c == "") {
		alert("Date of Launch is required");
		document.forms["mymovie"]["txtLaunch"].focus();
		return false;
	}
	
	var d = document.forms["mymovie"]["genre"].vlaue;
	if(d == "") {
		alert("Select one genre");
		return false;
	}
	alert("Details submitted successfully");
}