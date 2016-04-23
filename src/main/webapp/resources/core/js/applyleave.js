$(document).ready(function() {
	$('#dateRangePickerFrom, #dateRangePickerTo').datepicker({
		format : 'dd/mm/yyyy',
		startDate : '01/01/' + new Date().getFullYear(),
		endDate : '31/12/' + new Date().getFullYear()
	})
	initializeHolidayArray();
	updateHolidayDiv();
});
function initializeHolidayArray(){
	if ($("#leavePolicyHoliday").text().length > 1) {
		var hl = $("#leavePolicyHoliday").text().split(',');
		for (var i = 0; i < hl.length; i++) {
			array1.push(hl[i]);
		}
	}
}
$('#getBetween').on('click', function() {
	var start = $("#from").val();
	end = $("#to").val();
	start = new Date(reformatDate(start));
	end = new Date(reformatDate(end));
	currentDate = new Date(start);
	between = [];
	if (currentDate <= end) {
		while (currentDate <= end) {
			// between.push(new Date(currentDate));
			var dd = currentDate.getDate();
			var mm = currentDate.getMonth() + 1; // January is 0!

			var yyyy = currentDate.getFullYear();
			if (dd < 10) {
				dd = '0' + dd
			}
			if (mm < 10) {
				mm = '0' + mm
			}
			var today = dd + '/' + mm + '/' + yyyy;
			between.push(today);
			currentDate.setDate(currentDate.getDate() + 1);
		}
		if (between.length > 0) {
			checkCmpnyHoliday(between)
		}
	} else {
		alert("Please select proper date");
	}

});
function reformatDate(dateStr) {
	dArr = dateStr.split("/"); // ex input "2010-01-18"
	return dArr[1] + "/" + dArr[0] + "/" + dArr[2]; // ex out: "18/01/10"
}
var difference;
var array1=[];
function checkCmpnyHoliday(between) {
	
	
	var array2 = between;
	difference = [];

	jQuery.grep(array2, function(el) {
		if (jQuery.inArray(el, array1) == -1)
			difference.push(el);
	});
	if ($("#toFul").val() == "half" && $("#frmFul").val() == "half") {
		$("#noOfLeaves .badge").html(difference.length-1);
	} else if ($("#toFul").val() == "half" || $("#frmFul").val() == "half") {
		$("#noOfLeaves .badge").html(difference.length-0.5);
	} else {
		$("#noOfLeaves .badge").html(difference.length);
	}
}

function updateHolidayDiv() {
	if (array1.length > 0) {
		$(".holidayDates div").remove();
		for (var i = 0; i < array1.length; i++) {
			$(".holidayDates")
					.append(
							'<div class="input-group col-md-2">\n\
			<input type="text" class="form-control" disabled="disabled" value="'+ array1[i]	+ '">')
		}

	} else {
		$(".holidayDates")
				.html(
						'<div class="alert alert-warning" role="alert" >No Holiday</div');
	}
	
	$(".availableLeaves")
	.append('<button class="btn btn-default" type="button"> Sick Leave <span class="badge">'+$("#leavePolicySl").text()+'</span> </button>')
$(".availableLeaves")
.append('<button class="btn btn-default" type="button"> Earn Leave <span class="badge">'+$("#leavePolicyEl").text()+'</span> </button>')
$(".availableLeaves")
.append('<button class="btn btn-default" type="button"> Casual Leave <span class="badge">'+$("#leavePolicyCl").text()+'</span> </button>')

}
