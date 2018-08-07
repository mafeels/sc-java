function validateAnswer(resp){
	if (resp == "d" || resp== "D"){
		document.getElementById("valid").innerHTML = "CORRETO";
	}else{
		document.getElementById("valid").innerHTML = "INCORRETO";
	}
}

function blankPassword(email, senha){
	if(email === "" || senha === ""){
		document.getElementById("valid").innerHTML = "<strong><i>Preencha todos os campos!</i></strong>";
	}else{
		window.location="dash.html";
	}
}
function blankLabels(nome, lnome, senha){
	if(nome === ""|| lnome ==="" || senha === ""){
		document.getElementById("valid").innerHTML = "<strong><i>Preencha todos os campos!</i></strong>";
	}else{
		window.location="dash.html";
	}
}

var myIndex = 0;
carousel();

function carousel() {
    var i;
    var x = document.getElementsByClassName("mySlides");
    for (i = 0; i < x.length; i++) {
       x[i].style.display = "none";  
    }
    myIndex++;
    if (myIndex > x.length) {myIndex = 1;}    
    x[myIndex-1].style.display = "block";  
    setTimeout(carousel, 9000);    
}