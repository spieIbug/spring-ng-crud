/**
 * Define your controllers here
 */
(function() {
	var employeController = angular.module('employeController', []);
	employeController.controller('NewEmployeCtrl', function($scope, $http, $templateCache) {
						this.employeId = "";
						this.firstName = "";
						this.lastName = "";
						this.experience = "";
						this.SubmitFormIfValid = function() {
							alert('I\'m your new employe angular controller');
							$('#msg')
									.html(
											"<div class=\"alert alert-warning alert-dissimible\" role=\"alert\">"
													+ "<button type=\"button\" class=\"close\" data-dismiss=\"alert\"><span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>"
													+ "<strong>In progress!</strong> adding employe!."
													+ "</div>");
							$http(
									{
										headers : {
											'Content-Type' : 'application/x-www-form-urlencoded'
										},
										method : 'POST',
										url : '../insert.employe',
										data : '&employeId='
												+ this.employeId
												+ '&firstName='
												+ this.firstName
												+ '&lastName='
												+ this.lastName
												+ '&experience='
												+ this.experience
									})
									.success(
											function(response) {
												$('#msg')
														.html(
																"<div class=\"alert alert-success alert-dissimible\" role=\"alert\">"
																		+ "<button type=\"button\" class=\"close\" data-dismiss=\"alert\"><span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>"
																		+ "<strong>Succ&egrave;s!</strong> Employe added!."
																		+ "</div>");
												refreshEmployeTable(response);
											}).error(function(response) {
										alert('erreur insertion');
									});

						};
					});
	employeController.controller('EditEmployeCtrl', function($scope, $http, $templateCache) {
		this.employeId = "";
		this.firstName = "";
		this.lastName = "";
		this.experience = "";
		this.SubmitFormIfValid = function() {
			this.employeId = $('#employeId').val();
			this.firstName = $('#firstName').val();
			this.lastName = $('#lastName').val();
			this.experience = $('#experience').val();
			alert('I\'m your edit employe angular controller');
			$http(
					{
						headers : {
							'Content-Type' : 'application/x-www-form-urlencoded'
						},
						method : 'POST',
						url : '../update.employe',
						data : '&employeId='
								+ this.employeId
								+ '&firstName='
								+ this.firstName 
								+ '&lastName='
								+ this.lastName
								+ '&experience='
								+ this.experience
					})
					.success(
							function(response) {
								refreshEmployeTable(response);
							}).error(function(response) {
						alert('erreur insertion');
					});

		};
	});
})();