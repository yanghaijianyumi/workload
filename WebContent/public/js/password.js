$(function() {

	$('#password-form').submit(function(e) {

		$("#password-submit").attr("disabled", true);
		$('#password-form').ajaxSubmit({
			url : '/api/user/1234567890/password',
			type : 'PUT',
			dataType : 'json',
			success : function(data) {
				$("#password-submit").attr("disabled", false);
				alert(data.message)
			},
			error : function() {
				$("password-submit").attr("disabled", false);
				alert('修改失败！服务器异常!');
			},
		});
		e.preventDefault();
		return false;
	});
});