$(document).ready(function() {
	
	$(document).on('click', 'i.fa-cart-plus', function () {
		
		var r = confirm("Vuoi prenotare l'ombrellone selezionato?");
		if (r == true) {
			
			var id = $(this).attr('id');
			var datap = $("input").val();
			$.post("../../ConfermaPrenotazione", 
				
				{
				idOmbr : id,
				dataPren : datap
				
				}, 
				function(data, status) {
					if (status == "success"){
						if( data ==="SUCCESS" )
							window.location.href="../utente/pagamento.jsp";
						else{
							$("#response").html(data);
						}
					}
				}
			);
		}
	})
})