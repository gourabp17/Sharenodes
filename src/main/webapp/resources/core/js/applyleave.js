$(document).ready(function() {
	$('#dateRangePickerFrom, #dateRangePickerTo').datepicker({
		format : 'dd/mm/yyyy',
		startDate : '01/01/' + new Date().getFullYear(),
		endDate : '31/12/' + new Date().getFullYear()
	})

});

$('#getBetween')
		.on(
				'click',
				function() {
					var start = $("#from").val();
					end = $("#to").val();
					start = new Date(reformatDate(start));
					end = new Date(reformatDate(end));
					currentDate = new Date(start);
					between = [];
					if (currentDate <= end) {
						while (currentDate <= end) {
							//between.push(new Date(currentDate));
							var dd = currentDate.getDate();
						    var mm = currentDate.getMonth()+1; //January is 0!

						    var yyyy = currentDate.getFullYear();
						    if(dd<10){
						        dd='0'+dd
						    } 
						    if(mm<10){
						        mm='0'+mm
						    } 
						    var today = dd+'/'+mm+'/'+yyyy;
							between.push(today);
							currentDate.setDate(currentDate.getDate() + 1);
						}
						if(between.length>0){
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

function checkCmpnyHoliday(between){
	var array1 = ["05/04/2016","07/04/2016"];
	var array2 = between;
	var difference = [];

	jQuery.grep(array2, function(el) {
	        if (jQuery.inArray(el, array1) == -1) difference.push(el);
	});

	alert("the difference is"+difference)
	}