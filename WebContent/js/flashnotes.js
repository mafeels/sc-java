

function blankPassword(email, senha){
	if(email === "" || senha === ""){
		document.getElementById("valid").innerHTML = "<strong><i>Preencha todos os campos!</i></strong>";
        
        
	}else{
		window.location="dash.xhtml";
	}
}

$(function(){
    $("button").click(function(){
        $("#div1").fadeToggle();
        $("#div2").fadeToggle("slow");
        $("#div3").fadeToggle(3000);
    });
    
    $('input[id="botaoLogin"]').click(function(){
        var email = document.getElementById("email");
        var senha = document.getElementById("senha");
        
        if(email === "" || senha === ""){
		  $('div[data-dismiss="alert"]').removeClass('alerta');
        }
    })
    
    
});

function blankLabels(nome, lnome, senha){
	if(nome === ""|| lnome ==="" || senha === ""){
		document.getElementById("valid").innerHTML = "";
	}else{
		window.location="dash.xhtml";
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
        window.open("index.xhtml","_self");
    }
    
    function Deletar()
    {
     var response = confirm('Voce deseja mesmo deletar esse flashcard?');
    
    if (response){
    	
    }
    else alert('Operação abortada');
    }
}
