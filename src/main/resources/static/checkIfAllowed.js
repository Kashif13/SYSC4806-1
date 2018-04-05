jQuery(document).ready(function($) {
    if($("#user").text()!="admin"){
        $("#addLo").prop('disabled', true);
    }
});