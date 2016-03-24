<link href="resources/core/css/home.css" rel="stylesheet" />
<%@include file="header.jsp"%>
<div class="superuserBase">
	<img src="resources/core/images/add_user.png" alt="Add User"
		onclick="window.location.href = '#userPurpose1'; displayUserPurpose1()" />
	<img src="resources/core/images/edit_user.png" alt="Add User"
		onclick="window.location.href = '#userPurpose2'; displayUserPurpose2()" />
	<img src="resources/core/images/list-user.png" alt="Add User"
		onclick="window.location.href = '#userPurpose3'; displayUserPurpose3()" />
	<div id="userPurpose1" class="container">
		<form action="addNewUser" method="post" commandName="adduser"
			id="addNewUser">
			<div class="form-group">

				<div class="input-group">
					<span class="input-group-addon">Name</span> <input type="text"
						class="form-control" id="personName" name="personName"
						placeholder="John Paul" maxlength="25" required>
				</div>

			</div>
			<div class="form-group">

				<div class="input-group">
					<span class="input-group-addon">Email Address</span> <input
						type="email" class="form-control" id="personEmail"
						name="personEmail" placeholder="person@company.com" maxlength="50"
						required>
				</div>
			</div>
			<div class="form-group">

				<div class="input-group">
					<span class="input-group-addon">Password</span> <input
						type="password" class="form-control" id="personPassword"
						name="personPassword" placeholder="*******" maxlength="25"
						required>
				</div>
			</div>
			<div class="form-group">

				<div class="input-group">
					<span class="input-group-addon">Manager EmailId</span> <input
						type="email" class="form-control" id="personManager"
						name="personManager" placeholder="xyz@company.com" maxlength="50">
				</div>
			</div>



			<div class="form-group">
				<div class="row">
					<div class="col-lg-6">

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Role</span> <input type="text"
									class="form-control" id="personRole" name="personRole"
									placeholder="Tester,Developer,Business Analyst" maxlength="50"
									required>
							</div>
						</div>
					</div>
					<div class="col-lg-6">

						<div class="form-group">
							<select class="form-control" id="personDesignation"
								name="personDesignation">
								<option value="General">General</option>
								<option value="HR">HR</option>
								<option value="Accountant">Accountant</option>
								<option value="Founder|CEO">Founder|CEO</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">

					<div class="input-group pull-right">
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-user"> </span> Create
						</button>
					</div>
				</div>

			</div>
		</form>
	</div>
	<div id="userPurpose2" style="display: none;" class="container">

		<div class="input-group  has-warning" style="margin-bottom: 35px">
			<span class="input-group-addon">Enter EmailId</span> <input
				type="text" class="form-control" id="toEditPersonEmail"
				name="toEditPersonEmail" placeholder="John Smith" maxlength="25"
				required> <span class="input-group-btn">
				<button class="btn btn-default" type="button"
					onclick="getSuperEdit()">Search</button>
			</span>
		</div>
		<form action="sendToUpdate" method="post" commandName="sendToUpdate"
			id="sendToUpdate">
			<input type="hidden" class="form-control" id="personEmail"
				name="personEmail">
			<div class="form-group">
				<div class="input-group">
					<span class="input-group-addon">Name</span> <input type="text"
						class="form-control" id="personName" name="personName"
						placeholder="John Paul" maxlength="25">
				</div>
			</div>
			<div class="form-group">

				<div class="input-group">
					<span class="input-group-addon">Reset Password</span> <input
						type="password" class="form-control" id="personPassword"
						name="personPassword" placeholder="*******" maxlength="25">
				</div>
			</div>
			<div class="form-group">

				<div class="input-group">
					<span class="input-group-addon">Manager EmailId</span> <input
						type="email" class="form-control" id="personManager"
						name="personManager" placeholder="xyz@company.com" maxlength="50">
				</div>
			</div>



			<div class="form-group">
				<div class="row">
					<div class="col-lg-6">

						<div class="form-group">
							<div class="input-group">
								<span class="input-group-addon">Role</span> <input type="text"
									class="form-control" id="personRole" name="personRole"
									placeholder="Tester,Developer,Business Analyst" maxlength="50">
							</div>
						</div>
					</div>
					<div class="col-lg-6">

						<div class="form-group">
							<select class="form-control" id="personDesignation"
								name="personDesignation">
								<option value="General">General</option>
								<option value="HR">HR</option>
								<option value="Accountant">Accountant</option>
								<option value="Founder|CEO">Founder|CEO</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="input-group pull-right">
						<button type="button" class="btn btn-danger"
							style="margin-right: 30px" onclick="deleteUser()">
							<span class="glyphicon glyphicon-remove-sign"> </span> Remove
						</button>
						<button type="submit" class="btn btn-primary">
							<span class="glyphicon glyphicon-cloud-upload"> </span> Update
						</button>
					</div>
				</div>

			</div>
		</form>
	</div>
	<div id="userPurpose3" style="display: none;" class="container">
		<nav id="paginationCounter">
			<button class="btn btn-primary pull-left" type="button">
				Total Employees <span class="badge"></span>
			</button>
			<ul class="pagination">
				<li><span id="prevno" aria-hidden="true"
					onclick="chngePreNavContent(1)">&laquo;</span></li>
				<li><a href="#paginationCounter"
					onclick="setPaginationNav(event)">1</a></li>
				<li><a href="#paginationCounter"
					onclick="setPaginationNav(event)">2</a></li>
				<li><a href="#paginationCounter"
					onclick="setPaginationNav(event)">3</a></li>
				<li><a href="#paginationCounter"
					onclick="setPaginationNav(event)">4</a></li>
				<li><a href="#paginationCounter"
					onclick="setPaginationNav(event)">5</a></li>
				<li><span id="nextno" aria-hidden="true"
					onclick="chngeNextNavContent(5)">&raquo;</span></li>
			</ul>
			<button class="btn btn-default pull-right" type="button"></button>
		</nav>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Manager Email</th>
						<th>Role</th>
						<th>Designation</th>
						<th>Status</th>

					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>
<script src="resources/core/js/home.js"></script>