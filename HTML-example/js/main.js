function myFunction(){
	if (document.getElementById("video2").style.backgroundColor=="yellow"){
		document.getElementById("video2").style.backgroundColor = "red";
	}else{
		document.getElementById("video2").style.backgroundColor = "yellow";
	}
}

function myClick(){
	let firstname = document.getElementById("fname").value;
	let lastname = document.getElementById("lname").value;
//	console.log(firstname);
//	console.log(lastname);
	let oldHTML = document.getElementById("outputtext").innerHTML;
	document.getElementById("outputtext").innerHTML = oldHTML+"<h2> Hi, "+firstname+" "+lastname+"</h2>";
}