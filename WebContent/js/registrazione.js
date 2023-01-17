
/* prendo l'id del form
 * evento(callback{ 
 * 						preventDefault		
 * 						post( servlet, data, callback{
 * 								stampa in registrazione.html} 
 * 						 )
 * 				}
 * )
 * */

$(document).ready(function() {
	
	$("#username").focus();
	
	$("#form-register").submit(function(e) {
		
		e.preventDefault();
		
		if( $("#pwd").val() != $("#cpwd").val()) {
			
			$("#response").html("Le password non coincidono");
		}
			
		else {
			
			$.post("Registrazione", 
					
					{
			
				/* le etichette vengono utilizzate dalla servlet da metodo getParameter */
					username : $("#username").val(),
					nome : $("#nome").val(),
					cognome : $("#cognome").val(),
					email : $("#email").val(),
					password: $("#pwd").val(),
					}, 
					function(data, status) {
						if (status == "success")
							$("#response").html(data);
					}
				);
			}
		});
	});
