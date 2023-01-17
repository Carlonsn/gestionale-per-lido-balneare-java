$(document).ready(function() {
	
	var data = new Date();
	var gg, mm, aaaa;
	gg = data.getDate();
	mm = data.getMonth()+1;
	aaaa = data.getFullYear();
	
	data = aaaa + "-" + mm + "-" + gg;
	
			$.post("../../ViewOmbrelloni", 
				
				{
				dataToday : data,
				
				}, 
				function(data, status) {
					if (status == "success")
						$("#response").html(data);
				}
			)
})