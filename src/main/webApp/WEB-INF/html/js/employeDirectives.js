(function(){
	var app = angular.module('employeDirectives', []);
	// directive pour la liste des clubs
	app.directive('allEmployes', function(){
		return {
			restrict: 'E',
			require: 'ngModel',
			templateUrl: './all-employes.html',
			controller:function($scope,$http){
				var allEmployes = this;
				allEmployes.list = [];
				$scope.method = 'GET';
			    $scope.url = "../list.employes";
			    $scope.data = "";
			    $http(
		        		{
				            method: $scope.method, 
				            url: $scope.url,
				            headers: {'Content-Type': 'application/json'}
		        		}).
		        success(
		        		function(response) 
		        		{
		        			allEmployes.list = response;				        			
		        		}			        		
        		).error(function(response) {$scope.data = response || "Request failed";});
			},
			controllerAs: 'allEmployesCtrl'
		};
	});
})();