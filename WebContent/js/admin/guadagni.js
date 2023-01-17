$(document).ready(function() {
	
	var data = new Date();
	var gg, mm, aaaa;
	gg = data.getDate();
	mm = data.getMonth()+1;
	aaaa = data.getFullYear();
	
	var data = aaaa + "-" + mm + "-" + gg;
	
	$.post("../../GuadagnoTotale",  
			{
				dataToday : data,
			},
				function(data, status) {
			
					if (status == "success"){
						
						$("#totale").html(data);
					}	
				}
			)
	
	$("#response").css("display","none");
	$(".button").click(function () {
		
		var id = $(this).attr("id");
		$("#periodoguadagni").css("display","");
		$("#response").css("display","none");
		$("#inviadata").submit( function( e ){
			
			e.preventDefault();
			var datai = $("#dataInizio").val();
			var dataf = $("#dataFine").val();
			
			$("#periodoguadagni").css("display","none");
			$.post("../../Guadagni",  
				{
					dataInizio : datai,
					dataFine : dataf,
					idButton : id
				},
					function(data, status) {
				
						if (status == "success"){
					
							$("#response").css("display","");
							$("#response").html(data);
							$("#inviadata").trigger("reset");
						}	
					}
				)
		})
	})
})