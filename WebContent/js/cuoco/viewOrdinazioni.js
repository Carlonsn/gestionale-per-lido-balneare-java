$(document).ready(function() {
	
	var data = new Date();
	var gg, mm, aaaa;
	gg = data.getDate();
	mm = data.getMonth()+1;
	aaaa = data.getFullYear();
	
	
	var dataToday = aaaa + "-" + mm + "-" + gg;
	
			$.post("../../ListaOrdinazioni", 
				
				{
				dataToday : dataToday,
				
				}, 
				function(data, status) {
					if (status == "success")
						$("#response").html(data);
				}
			)
})