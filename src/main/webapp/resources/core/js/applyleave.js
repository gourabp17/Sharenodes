$(document).ready(function() {
	$('#dateRangePickerFrom, #dateRangePickerTo').datepicker({
		format : 'dd/mm/yyyy',
		startDate : '01/01/' + new Date().getFullYear(),
		endDate : '31/12/' + new Date().getFullYear()
	})
	
});

$('#getBetween').on('click', function () {
    var start = $("#from").val();
        end = $("#to").val();
        start=new Date(reformatDate(start));
        end=new Date(reformatDate(end));
        currentDate = new Date(start);
        between = [];
    alert(currentDate+"--"+currentDate.getDate()+"-"+currentDate.getMonth()+"-"+currentDate.getFullYear())
    ;

    while (currentDate <= end) {
        between.push(new Date(currentDate));
        currentDate.setDate(currentDate.getDate() + 1);
    }
    
    $('#results').html(between.join('<br> '));
});
function reformatDate(dateStr)
{
  dArr = dateStr.split("/");  // ex input "2010-01-18"
  return dArr[1]+ "/" +dArr[0]+ "/" +dArr[2]; //ex out: "18/01/10"
}