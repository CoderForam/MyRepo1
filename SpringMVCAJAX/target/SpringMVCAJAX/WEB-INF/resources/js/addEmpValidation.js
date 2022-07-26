
//function doAjaxPost() {
/* attach a submit handler to the form */
//$("#addform").submit(function(event) {
	
$(function () {
	debugger

	$('#submitButton').click(function (event) {
		debugger
  /* stop form from submitting normally */
  event.preventDefault();

	// get the form values
	var name = $('#name').val();
	var designation = $('#designation').val();
	var totalExperience = $('#totalExperience').val();
	// var data1 = "name='" + name + "',designation='" + designation +
	// "',totalExperience=" + totalExperience;
	var search = {}
		search["name"] = name;
		search["designation"] = designation;
		search["totalExperience"]= totalExperience;
	$.ajax({
		type: "POST",
		contentType : "application/json",
		url: "validateEmployee",
		data: JSON.stringify(search),
		dataType : 'json',
		success: function(response) {
			 if(response.status == "SUCCESS"){
			 	$('#info').html("User has been added to the list successfully. ");
                $('#error').hide('slow');
                $('#info').show('slow');
                // return true;
			 }
			 else{
                 errorInfo = "";
                 for(i =0 ; i < response.result.length ; i++){
                     errorInfo += "<br>" + (i + 1) +". " + response.result[i].code;
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
