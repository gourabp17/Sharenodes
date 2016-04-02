function loginModal() {
	document.getElementById("regForm").reset();
	document.getElementById("loginForm").reset();
	$('#myModal .modal-title').empty();
	$('#myModal .modal-title').html("LOGIN TO CPortal");
	$('#createUserModal').modal('hide');
	$('#forgetpwdModal').modal('hide');
	$('#myModal').modal('show');

}

function registerModal() {
	document.getElementById("loginForm").reset();
	document.getElementById("regForm").reset();
	$('#myModal').modal('hide');
	$('#forgetpwdModal').modal('hide');
	$('#createUserModal').modal('show');

	$("#regEmail").popover();
}

function regUser() {
	$('#createUserModal .btn-primary').removeClass('disabled');
}

function captchaRefresh() {
	var d = new Date();
	$("#captchaImage").attr("src", "loginform/generate_captcha?" + d.getTime());

}

$('#loginForm').submit(function(event) {
					event.preventDefault();
					$.ajax({
								url : "loginform",
								type : 'POST',
								data : $(this).serialize(),
								success : function(data) {
									if (data == "success") {
										window.location.replace("home");
									} else {
										document.getElementById("formAlert").style.display = "block";
										document.getElementById("formAlert").className = "alert alert-danger"
										document.getElementById("formAlert").innerHTML = data;
										$("#myModal .alert-danger").fadeIn(
												'normal',
												function() {
													$('#myModal .alert-danger')
															.fadeOut(2500);
												});
									}
								}
							});
				});

$('#regForm')
		.submit(
				function(event) {
					event.preventDefault();
					$.ajax({
								url : "registercomp",
								type : 'POST',
								data : $(this).serialize(),
								success : function(data) {
									if (data == "success") {

										$('#createUserModal').modal('hide');
										$('#myModal').modal('show');
										document.getElementById("formAlert").style.display = "block";
										document.getElementById("formAlert").className = "alert alert-success"
										document.getElementById("formAlert").innerHTML = "Verification link has been send to your email address";
										$("#myModal .alert-success")
												.fadeIn(
														'normal',
														function() {
															$('#myModal .alert-success').fadeOut(8000);
														});
									} else {
										document.getElementById("regformAlert").style.display = "block";
										document.getElementById("regformAlert").className = "alert alert-danger"
										document.getElementById("regformAlert").innerHTML = data;
										$("#createUserModal .alert-danger").fadeIn('normal',function() {
															$('#createUserModal .alert-danger').fadeOut(2500);
														});
									}
								}
							});
				});

function forgetpwdModal() {
	$('#myModal').modal('hide');
	$('#createUserModal').modal('hide');
	$('#forgetpwdModal').modal('show');
	$('#forgetpwdModal .modal-body div').empty();
	$('#forgetpwdModal .modal-body div').removeAttr('class');
	$('#forgetpwdModal .modal-dialog').css({
		"width" : "335px"
	});
	$('#forgetpwdModal .modal-body div')
			.html(
					'<div class="input-group">\n\
        <span class="input-group-addon">Email</span>\n\
        <input type="email" class="form-control" id="registred_email" name="registered_email" placeholder="Enter registered e-mail">\n\
        </div>');
	$('#forgetpwdModal .modal-footer button:eq(1)').show();
}

function forPwd() {
	var registred_email = document.getElementById("registred_email").value;

	var valiEmail = (registred_email);
	if (valiEmail) {
		$.get("loginform/forgetpassword", {
			regemailad : registred_email.trim(),
		}, function(data) {
			var output = data.charAt(0);
			if (output == 1) {
				$('#forgetpwdModal .modal-body div').empty();
				$('#forgetpwdModal .modal-body div')
						.html("Enter a valid email");
				$('#forgetpwdModal .modal-body div').removeClass(
						'alert-success').addClass("alert alert-danger")
						.fadeOut(
								2500,
								function() {
									$('#forgetpwdModal .modal-body div')
											.fadeIn("fast");
									forgetpwdModal();
								});
			} else if (output == 2) {
				$('#forgetpwdModal .modal-body div').empty();
				$('#forgetpwdModal .modal-body div').html(
						"Email address is not registered");
				$('#forgetpwdModal .modal-body div').removeClass(
						'alert-success').addClass("alert alert-danger")
						.fadeOut(
								2500,
								function() {
									$('#forgetpwdModal .modal-body div')
											.fadeIn("fast");
									forgetpwdModal();
								});
			} else if (output == 3) {
				$('#forgetpwdModal .modal-body div').empty();
				$('#forgetpwdModal .modal-body div')
						.removeClass('alert-danger').addClass(
								"alert alert-success");
				$('#forgetpwdModal .modal-body div').html(
						"Password has been sent to your mail box "
								+ data.substring(1, data.length));
				$('#forgetpwdModal .modal-footer button:eq(1)').hide();
			} else {
				$('#forgetpwdModal .modal-body div').empty();
				$('#forgetpwdModal .modal-body div').html(
						"Something went wrong. Please try later");
				$('#forgetpwdModal .modal-body div').removeClass(
						'alert-success').addClass("alert alert-danger")
						.fadeOut(
								2500,
								function() {
									$('#forgetpwdModal .modal-body div')
											.fadeIn("fast");
									forgetpwdModal();
								});
			}
		});
	} else {
		$('#forgetpwdModal .modal-body div').empty();
		$('#forgetpwdModal .modal-body div').html("Enter a valid email id");
		$('#forgetpwdModal .modal-body div').removeClass('alert-success')
				.addClass("alert alert-danger").fadeOut(2500, function() {
					$('#forgetpwdModal .modal-body div').fadeIn("fast");
					forgetpwdModal();
				});
	}
}

function popupReg() {
	registerModal();
	$("#regEmail").val($('#ecompany').val());
}

$(window).load(function() {
	var winHeight=($(window).height())+"px";
	$('#homediv, #allBody').css({
		"min-height" : winHeight
	});
});
