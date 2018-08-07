
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
function sair(){
    var conf = confirm("Você deseja mesmo sair da sessão?");
    if (conf === true) {
        window.open("index.html","_self");
    }
}
$(document).ready(function(){
    $("button").click(function(){
        $("#div1").fadeToggle();
        $("#div2").fadeToggle("slow");
        $("#div3").fadeToggle(3000);
    });
});