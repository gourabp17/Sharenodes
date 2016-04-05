function displayUserPurpose1() {
	$("#userPurpose1").css("display", "block");
	$("#userPurpose2").css("display", "none");
	$("#userPurpose3").css("display", "none");
}
function displayUserPurpose2() {
	$("#userPurpose1").css("display", "none");
	$("#userPurpose2").css("display", "block");
	$("#userPurpose3").css("display", "none");
}
function displayUserPurpose3() {
	$("#userPurpose1").css("display", "none");
	$("#userPurpose2").css("display", "none");
	$("#userPurpose3").css("display", "block");
	calculateNoOfEmployees();
	$('#userPurpose3 .pagination li:nth-child(2) a').trigger('click');
}
var totalEmployee;
var totalEmpCal;
function calculateNoOfEmployees() {
	$.post("superUser/noOfEmployees", {

	}, function(data) {
		totalEmployee = data;// display 10 user at a time
		totalEmpCal = data / 10;
		if (data % 10 > 0) {
			totalEmpCal = totalEmpCal + 1;
		}
		$("#paginationCounter .badge").html(totalEmployee);
		if (data == 0) {
			$("#paginationCounter .btn-default").html("0");
		} else if (data > 0) {
			$("#paginationCounter .btn-default").html("0-10");

		}
		if (totalEmpCal > 4) {
			chngePreNavContent(1);

		} else {
			chngeNextNavContent(0);
		}
	});

}
function chngeNextNavContent(no) {
	if ((no + 5) < 100 && (no + 5) <= totalEmpCal) {
		$("#paginationCounter #prevno").attr("onclick",
				"chngePreNavContent(" + (no + 1) + ")");
		for (var i = 0; i <= 5; i++) {
			$(".pagination li:nth-child(" + (i + 1) + ") a").html(no + i);
			$(".pagination li:nth-child(" + (i + 1) + ")").show();
		}
		$("#paginationCounter #nextno").attr("onclick",
				"chngeNextNavContent(" + (no + 5) + ")");
	} else if ((totalEmpCal - no) > 0) {
		$("#paginationCounter #prevno").attr("onclick",
				"chngePreNavContent(" + (no + 1) + ")");
		var i;
		for (i = 0; i <= (totalEmpCal - no); i++) {
			$(".pagination li:nth-child(" + (i + 1) + ") a").html(no + i);
			$(".pagination li:nth-child(" + (i + 1) + ")").show();
		}
		for (i; i <= 5; i++) {
			$(".pagination li:nth-child(" + (i + 1) + ")").hide();
		}
		$("#paginationCounter #nextno").attr("onclick",
				"chngeNextNavContent(" + (no + 5) + ")");
	}
}
function chngePreNavContent(no) {
	if ((no - 5) > 0) {
		$("#paginationCounter #prevno").attr("onclick",
				"chngePreNavContent(" + (no - 5) + ")");
		for (var i = 0; i <= 5; i++) {
			$(".pagination li:nth-child(" + (i + 1) + ") a").html((no - 6) + i);
			$(".pagination li:nth-child(" + (i + 1) + ")").show();
		}
		$("#paginationCounter #nextno").attr("onclick",
				"chngeNextNavContent(" + (no - 1) + ")");
	}
}
function setPaginationNav(event) {
	var currentNo = ($(event.target).text());
	var end = currentNo * 10;
	var start = end - 9;
	$.get("superUser/listOfUser", {
		start : start,
		end : end
	}, function(data) {
		if (data != "not found") {
			var json = JSON.parse(data);
			var totalMessages = Object.keys(json);// change data to object
													// from
			// string
			$('#userPurpose3 .table tbody tr').remove();
			if (totalMessages.length > 0) {

				for (var i = 1; i <= totalMessages.length; i++) {
					var name = json[i].Name;
					var email = json[i].Email;
					var manager = json[i].Manager;
					var role = json[i].Role;
					var desgn = json[i].Designation;
					var status = json[i].Status;
					$('#userPurpose3 .table').append(
							'<tr>\n\
	                <td>' + name
									+ '</td>\n\
	                <td>' + email
									+ '</td>\n\
	                <td>'
									+ manager
									+ '</td>\n\
	                <td>' + role
									+ '</td>\n\
	                <td>' + desgn
									+ '</td>\n\
	                <td>' + status
									+ '</td>\n\
	              </tr>');

				}
			}
		} else {
			alert("No data available")
		}
	});
	$("#paginationCounter .btn-default").html(start + "-" + end);

}
function getSuperEdit() {
	emailid = $("#toEditPersonEmail").val().trim();
	if (emailid.length > 3) {
		$.post("superUser/editBySuperUser", {
			email : emailid
		}, function(data) {
			if (data != "not found") {
				var json = JSON.parse(data);
				var totalMessages = Object.keys(json);
				if (totalMessages.length > 0) {

					var name = json.Name;
					var manager = json.Manager;
					var role = json.Role;
					var desgn = json.Designation;
					$('#userPurpose2 #personName').attr("placeholder", name);
					$('#userPurpose2 #personManager').attr("placeholder",
							manager);
					$('#userPurpose2 #personRole').attr("placeholder", role);
					$('#userPurpose2 #personDesignation').val(desgn.toUpperCase());
				}
			} else {
				alert("No data available")
			}
		});

	} else {
		alert("Invalid emailID")
	}

}
$('#editSuperName').keyup("keypress", function(e) {
	if (e.keyCode == 13) {
		getSuperEdit();
		return false; // prevent the button click from happening
	}
});

$('#addNewUser').submit(function(event) {
	event.preventDefault();
	$.ajax({
		url : "superUser/addNewUser",
		type : 'POST',
		data : $(this).serialize(),
		success : function(data) {

			if (data == "success") {
				alert("Successfully added");

			} else {
				alert("Some error occured. Try Later");
			}
		}
	});
});

function deleteUser() {
	emailid = $("#toEditPersonEmail").val().trim();
	if (emailid.length > 3 && confirm("Press OK to delete")) {
		$.post("superUser/deleteBySuperUser", {
			email : emailid
		}, function(data) {
			alert(data);
		});

	}
}

$('#sendToUpdate').submit(function(event) {
	emailid = $("#toEditPersonEmail").val().trim();
	$("#sendToUpdate #personEmail").val(emailid);
	event.preventDefault();
	$.ajax({
		url : "superUser/sendToUpdate",
		type : 'POST',
		data : $(this).serialize(),
		success : function(data) {

			if (data == "success") {
				alert("Successfully updated");

			} else {
				alert("Some error occured. Try Later");
			}
		}
	});
});
$(window).load(function() {
	
	$('#sendToUpdate, #addNewUser').trigger("reset");

});

$(".nav-stacked li").click(function() {
	$(this).children().children().toggle();
});
$("#menu-toggle").click(function(e) {
    e.preventDefault();
    alert()
    $("#wrapper").toggleClass("toggled");
});