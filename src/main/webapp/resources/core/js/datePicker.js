$(document).ready(function() {
	$('#dateRangePicker').datepicker({
		format : 'dd/mm/yyyy',
		startDate : '01/01/' + new Date().getFullYear(),
		endDate : '31/12/' + new Date().getFullYear()
	})
	getHolidayFromServer()
});

var arrDate = [];
var arrUnique = [];
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

function updateArrayDiv(){
	if (arrUnique.length>0){
		$(".holidayDates div").remove();
		for(var i=0; i<arrUnique.length;i++ ){
			$(".holidayDates").append('<div class="input-group col-md-2">\n\
			<input type="text" class="form-control" disabled="disabled" value="'+arrUnique[i]+'">\n\
			<span class="input-group-btn"><button class="btn btn-default form-control" type="button">\n\
			<span class="glyphicon glyphicon-remove" aria-hidden="true">\n\
			</span>	</button></span></div>')
		}
		
	}
	else{
		// $(".holidayDates").html("<div>No Holiday</div")
	}
}
function getHolidayFromServer(){
	updateArrayDiv();
}