$(document).ready(function() {
	$('#dateRangePicker').datepicker({
		format : 'dd/mm/yyyy',
		startDate : '01/01/' + new Date().getFullYear(),
		endDate : '31/12/' + new Date().getFullYear()
	});
	$('#dateRangePicker1').datepicker({
		format : 'dd/mm/yyyy',
		startDate : '01/01/' + new Date().getFullYear(),
		endDate : '31/12/' + new Date().getFullYear()
	})
	getHolidayFromServer()
	
});

var arrDate = [];
var arrUnique = [];
var leavePolicySl;
var leavePolicyEl;
var leavePolicyCl;

function getHolidayFromServer() {
	if ($("#leavePolicyHoliday").text().length > 1) {
		var hl = $("#leavePolicyHoliday").text().split(',');
		for (var i = 0; i < hl.length; i++) {
			arrDate.push(hl[i]);
			arrUnique.push(hl[i]);
			sortArray()
		}
	}
	$("#" + $("#leavePolicyUnit").text()).trigger("click");

	if ($("#leavePolicySl").text() != "0.0")
		$("#sleave").attr("value", $("#leavePolicySl").text());
	if ($("#leavePolicyEl").text() != "0.0")
		$("#eleave").attr("value", $("#leavePolicyEl").text());
	if ($("#leavePolicyCl").text() != "0.0")
		$("#cleave").attr("value", $("#leavePolicyCl").text());
	updateArrayDiv();
}
function sortArray(){
	arrUnique.sort(function(a, b){
	    var aa = a.split('/').reverse().join(),
	        bb = b.split('/').reverse().join();
	    return aa < bb ? -1 : (aa > bb ? 1 : 0);
	});
}
$("#midContent .glyphicon-plus").click(function() {
	var inputDate = $("#inputDate").val();
	if (inputDate.length > 0 && inputDate.length < 11) {
		arrDate.push(inputDate);
		arrUnique = unique(arrDate);
		updateArrayDiv();
	}
})
var unique = function(origArr) {
	var newArr = [], origLen = origArr.length, found, x, y;

	for (x = 0; x < origLen; x++) {
		found = undefined;
		for (y = 0; y < newArr.length; y++) {
			if (origArr[x] === newArr[y]) {
				found = true;
				break;
			}
		}
		if (!found) {
			newArr.push(origArr[x]);
		}
	}
	return newArr;
}

function updateArrayDiv() {
	if (arrUnique.length > 0) {
		$(".holidayDates div").remove();
		for (var i = 0; i < arrUnique.length; i++) {
			$(".holidayDates")
					.append(
							'<div class="input-group col-md-2">\n\
			<input type="text" class="form-control" disabled="disabled" value="'
									+ arrUnique[i]
									+ '">\n\
			<span class="input-group-btn"><button class="btn btn-default form-control" type="button" onclick="deleteHoliday(this)">\n\
			<span class="glyphicon glyphicon-remove" aria-hidden="true">\n\
			</span>	</button></span></div>')
		}

	} else {
		$(".holidayDates")
				.html(
						'<div class="alert alert-warning" role="alert" >No Holiday</div');
	}
}

function saveHoliday() {
	var leave_unit = ($("#radioUnit .active input").val());
	var sl = $("#sleave").val();
	var el = $("#eleave").val();
	var cl = $("#cleave").val();
	if ((arrUnique.length || el.length || sl.length || cl.length) > 0) {
		$.post("saveHoliday", {
			leave_unit : leave_unit,
			holidaylist : arrUnique.toString(),
			sl : sl,
			cl : cl,
			el : el

		}, function(data) {
			alert(data);
		});

	}
}
function deleteHoliday(el) {

	var index = arrUnique.indexOf($(el).parent().siblings("input").val());
	if (index != -1) {
		arrUnique.splice(index, 1);
	}
	updateArrayDiv();
}

$("#radioUnit #Hourly").click(function() {
	$("#sleave").attr("placeholder", "1 hr/day");
	$("#eleave").attr("placeholder", "1.5 hr/day");
	$("#cleave").attr("placeholder", "1 hr/day");
});
$("#radioUnit #Monthly").click(function() {
	$("#sleave").attr("placeholder", "2 days/month");
	$("#eleave").attr("placeholder", "3 days/month");
	$("#cleave").attr("placeholder", "5 days/month");
});
$("#radioUnit #Yearly").click(function() {
	$("#sleave").attr("placeholder", "10 days/year");
	$("#eleave").attr("placeholder", "15 days/year");
	$("#cleave").attr("placeholder", "5 days/year");
});


$( "input[type=checkbox]" ).on( "click",function() {
	  $( "input:checked" ).parent().parent().siblings(".showMax").show();
	} );