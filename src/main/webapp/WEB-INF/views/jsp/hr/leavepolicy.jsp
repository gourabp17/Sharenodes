<link href="${baseurl}/resources/core/css/home.css" rel="stylesheet" />
<link href="${baseurl}/resources/core/css/datePicker.css"
	rel="stylesheet" />
<%@include file="../header.jsp"%>
<div style="display: none" id="leavePolicyHoliday">${leavePolicyHoliday}</div>
<div style="display: none" id="leavePolicyUnit">${leavePolicyUnit}</div>
<div style="display: none" id="leavePolicySl">${leavePolicySl}</div>
<div style="display: none" id="leavePolicyCl">${leavePolicyCl}</div>
<div style="display: none" id="leavePolicyEl">${leavePolicyEl}</div>
<div class="container" id="allBody">
	<div class="row">

		<div class="col-md-2" style="padding-right: 0px">
			<%@include file="../general/allhome.jsp"%>
		</div>


		<div class="col-md-8" id="midContent"
			style="border-left: 1px solid #CFCFCF; border-right: 1px solid #CFCFCF; text-align: center;">



			<div class="row">
				<div class="form-group form-horizontal"
					style="display: -webkit-inline-box; margin-top: 50px">
					<label class="col-sm-3 control-label">Holiday</label>

					<div class="input-group input-append date col-sm-5"
						id="dateRangePicker">
						<span class="input-group-addon"> <span
							class="glyphicon glyphicon-calendar"></span>
						</span> <input type="text" class="form-control" name="date"
							id="inputDate" />

					</div>
					<label class="col-sm-1" style="margin-top: 3;"> <span
						class="glyphicon glyphicon-plus" aria-hidden="true"></span>

					</label>
				</div>
				<form class="form-horizontal" style="margin-left: 8px">

					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">Seak
							Leaves</label>
						<div class="col-sm-2" style="margin-left: -12px">
							<input type="text" class="form-control" id="sleave"
								placeholder="1 hr/day">
						</div>
						<div class="btn-group" data-toggle="buttons" style="float: left;"
							id="radioUnit">
							<label class="btn btn-primary active"  id="Hourly"> <input
								type="radio" name="options" autocomplete="off" checked
								value="Hourly"> Hourly
							</label> <label class="btn btn-primary"  id="Monthly"> <input
								type="radio" name="options" autocomplete="off" value="Monthly">
								Monthly
							</label> <label class="btn btn-primary" id="Yearly"> <input
								type="radio" name="options" autocomplete="off" value="Yearly">
								Yearly
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">Earned
							Leaves</label>
						<div class="col-sm-2" style="margin-left: -12px">
							<input type="text" class="form-control" id="eleave"
								placeholder="1.5 hr/day">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-3 control-label">Casual
							Leaves</label>
						<div class="col-sm-2" style="margin-left: -12px">
							<input type="text" class="form-control" id="cleave"
								placeholder="5 hr/day">
						</div>
					</div>
				</form>
			</div>
			<div class="row">
				<div class="holidayDates"></div>
			</div>

			<button type="button" class="btn btn-primary" onclick="saveHoliday()">Save</button>
		</div>
		<div class="col-md-2" id="individualDiv" style="padding-left: 0px;">

			<jsp:include page="../${userRole}/rightNav.jsp" />

		</div>
	</div>

</div>


<%@include file="../footer.jsp"%>

<script src="${baseurl}/resources/core/js/datePicker.js"></script>
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" />
<link rel="stylesheet"
	href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" />

<script
	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>