$(document).ready(function() {
	
	var data = new Date();
	var gg, mm, aaaa;
	gg = data.getDate();
	mm = data.getMonth()+1;
	aaaa = data.getFullYear();
	
	var dataToday = aaaa + "-" + mm + "-" + gg;
	
	$("#data").prop("min", dataToday );
	
	$("#annullapren").submit(function(e) {
		
		e.preventDefault();
			
		$.post("../../AnnullaPrenotazione", 
					
					{
			
				/* le etichette vengono utilizzate dalla servlet da metodo getParameter */
					idOmbr: $("#id").val(),
					data: $("#data").val()
					}, 
					function(data, status) {
						if (status == "success")
							$("#response").html(data);
					});
		});
	
	$("#listaprenotazioni").click(function(e) {
		
		e.preventDefault();
			
			$.post("../../ListaPrenotazioni", 
			 
				function(data, status) {
					if (status == "success")
						$("#response").html(data);
					
				});
	});	
	
});