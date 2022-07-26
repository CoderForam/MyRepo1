
$(function() {

  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
 
  $("#addform").validate({
    // Specify validation rules
     rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      name: "required",
      designation: "required",
      totalExperience: "required"
      /* email: {
        required: true,
        // Specify that email should be validated
        // by the built-in "email" rule
        email: true
      },
      password: {
        required: true,
        minlength: 5
      } */
    },  
    // Specify validation error messages
    messages: {
      name: "Please enter your firstname",
      designation: "Please enter your designation",
      totalExperience: "Please provide some value"
      /*salary: "Please enter salary" */
   } 
  })
});