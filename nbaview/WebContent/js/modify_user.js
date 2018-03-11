/**
 * To send updating info for updating controller.
 * @author Kevin 
 */
$(function(){
	$("#save").click(function(){
		var username = $("#username").val();
		var age = $("#age").val();
		var sex = $("#sex").val();
		var email = $("#email").val();
		var tel = $("#tel").val();
		var job = $("#job").val();
		var brief = $("#brief").val();
		$.ajax({
			type:'post',
			url:'/nbaview/updateUser',
			data:{ "username":username, "age":age, "sex":sex, "email":email, "tel":tel, "job":job, "brief":brief },
			dataType:'json',
			success:function(data){
				if(data['isUpdated'] == 'true'){
					alert("Your personal info has been updated!");
				} else {
					alert("Updated failed! Please check if your feild info is correct!");
				}
			}
		});
	});
});