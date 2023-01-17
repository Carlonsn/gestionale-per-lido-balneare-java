$(document).ready(function() {
	
	$.post("../../Menu", 
			
			function(data, status) {
				if (status == "success")
					$("#menu").html(data);
			}
		);
	
	$(document).on('click', 'i.fa-plus-square', function(){
		
			var id = $(this).attr('id');
			$.post("../../AggiuntaCarrello", 
			
				{
					idProd : id
				}, 
					function(data, status) {
						if (status == "success"){
							$("#response").html(data);
						}
					}	
			)
		
	})
});
