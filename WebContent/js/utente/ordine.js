$(document).ready(function() {
	
	var data = new Date();
	var gg, mm, aaaa, sec, min, hh;
	gg = data.getDate();
	mm = data.getMonth()+1;
	aaaa = data.getFullYear();
	sec = data.getSeconds();
	min = data.getMinutes();
	hh = data.getHours();
	
	data = aaaa + "-" + mm + "-" + gg;
	
	if(min < 10) min="0"+min;
	if(sec < 10) sec="0"+sec;
	if(hh <10) hh="0"+hh;
	
	var ora = hh + ":" + min + ":" + sec;
	
	$.post("../../MostraCarrello", 
			  
			function(data, status) {
				if (status == "success")
					$("#response").html(data);
			}
		);
	
	$("#pagamento").submit(function(e) {
		
		e.preventDefault();
			
			$.post("../../Ordine", 
					{
						dataToday : data,
						oraToday : ora
					},
					function(data, status) {
						if (status == "success")
							$("#response").html(data);
							$("#ordina").hide();
							
					}
				)
		})
		
	$(document).on('click', 'i.fa-minus-square', function(){
		
			var id = $(this).attr('id');
			$.post("../../RimuoviCarrello", 
			
				{
					idProd : id
				}, 
					function(data, status) {
						if (status == "success"){
							$.post("../../MostraCarrello", 
									  
									function(data, status) {
										if (status == "success")
											$("#response").html(data);
									}
								);
							$("#response2").html(data);
						}
					}	
			)
		}
	)

});