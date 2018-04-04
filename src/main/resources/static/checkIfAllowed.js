jQuery(document).ready(function($) {
    console.log($("#user").text());
    if($("#user").text()!="admin"){
        $("#addLo").prop('disabled', true);
    }
});