
$(function () {
	
	$('#submitButton').click(function (event) {
		
  /* stop form from submitting normally */
  event.preventDefault();

	// get the form values
	var name = $('#name').val();
	var designation = $('#designation').val();
	var totalExperience = $('#totalExperience').val();
	
	$.ajax({
		type: "POST",
		url: "validateEmployee",
		data: $("#addform").serialize(),
		//data: JSON.stringify(search),
		dataType : 'json',
		success: function(response) {
			 if(response.status == "SUCCESS"){
			 	$('#info').html("User has been added to the list successfully. ");
                $('#error').hide('slow');
                $('#info').show('slow');
                $('#addform').attr('validated',true);
                $('#addform').submit();
               // return true;
			 }
			 else{
                 errorInfo = "";
                 for(i =0 ; i < response.result.length ; i++){
                     errorInfo += "<br>" + (i + 1) +". " + response.result[i].defaultMessage;
                 }
                 $('#error').html("Please correct following errors: " + errorInfo);
                 $('#info').hide('slow');
                 $('#error').show('slow');
                 return false;
             }
		},
		error: function(e){
             alert('Error: ' + e);
             return false;
        }
	});
});
});
