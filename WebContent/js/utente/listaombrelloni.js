$(document).ready(function() {
	
	var data = new Date();
	var gg, mm, aaaa;
	gg = data.getDate();
	mm = data.getMonth()+1;
	aaaa = data.getFullYear();
	
	var dataToday = aaaa + "-" + mm + "-" + gg;
	
	$("#data_pren").prop("min", dataToday );
	
	$("#data").submit(function(e) {
		
		e.preventDefault();
			
			$.post("../../ListaOmbrelloni", 
					
					{
			
				/* le etichette vengono utilizzate dalla servlet da metodo getParameter */
					data_pren : $("#data_pren").val(),
					
					}, 
					function(data, status) {
						if (status == "success")
							$("#response").html(data);
					}
				);
			}
		);
	}
);