$(document).ready(function() {
	
	var data = new Date();
	var gg, mm, aaaa;
	gg = data.getDate();
	mm = data.getMonth()+1;
	aaaa = data.getFullYear();
	
	var data = aaaa + "-" + mm + "-" + gg;
	
	$("#pagamento").submit(function(e) {
		
		e.preventDefault();
			
			$.post("../../Pagamento", 
			 
					{
					dataToday : data
					}, 
					function(data, status) {
						if (status == "success")
							$("#response").html(data);
					}
				);
		})

});