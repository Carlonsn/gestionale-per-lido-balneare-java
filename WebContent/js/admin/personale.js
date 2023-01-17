$(document).ready(function() {

	$("#username").focus();
	$("#addpersonale").submit(function(e) {
		
		e.preventDefault();
		
		if( $("#pwd").val() != $("#cpwd").val()) {
			
			$("#response").html("Le password non coincidono");
		}
			
		else {
			
			$.post("../../AggiungiPersonale", 
					
					{
			
				/* le etichette vengono utilizzate dalla servlet da metodo getParameter */
					username : $("#username").val(),
					nome : $("#nome").val(),
					cognome : $("#cognome").val(),
					email : $("#email").val(),
					password: $("#pwd").val(),
					ruolo: $("[name=ruolo]:checked").val()

					}, 
					function(data, status) {
						if (status == "success")
							$("#response").html(data);
					}
				);
			}
		});
	
		$("#rempersonale").submit(function(e) {
		
		e.preventDefault();
			
		$.post("../../RimuoviPersonale", 
					
					{
			
				/* le etichette vengono utilizzate dalla servlet da metodo getParameter */
					username: $("#user").val(),
					ruolo: $("[name=ruolo1]:checked").val()
					}, 
					function(data, status) {
						if (status == "success")
							$("#response1").html(data);
					});
		});
		
		$("#listapersonale").click(function(e) {
			
			e.preventDefault();
				
				$.post("../../ListaPersonale", 
				 
					function(data, status) {
						if (status == "success")
							$("#response1").html(data);
						
						});
		});		
});