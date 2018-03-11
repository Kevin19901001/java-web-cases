/**
 * To change the request params when click the search button.
 * @author Kevin
 */
$(function(){
	$("#searchAction").click(function(){
		var username = $("#searchOne").val();
		if(username == ""){
			alert("username can not be blank!");
		} else {
			var href = $("#searchAction").attr("href") + "?username=" + username;
			$("#searchAction").attr("href", href);
		}
	});
});