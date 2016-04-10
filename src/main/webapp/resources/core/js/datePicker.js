
$(document).ready(function() {
	    $('#dateRangePicker')
        .datepicker({
        	  format: 'dd/mm/yyyy',
              startDate: '01/01/'+new Date().getFullYear(),
              endDate: '31/12/'+new Date().getFullYear()
          })
});

var arrDate = [];
var arrUnique =[];
$("#midContent .glyphicon-plus").click(function() {
	var inputDate= $("#inputDate").val();
	if(inputDate.length>0 && inputDate.length<11){
	arrDate.push(inputDate);
	arrUnique = unique(arrDate);
}
})
var unique = function(origArr) {
    var newArr = [],
        origLen = origArr.length,
        found, x, y;

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