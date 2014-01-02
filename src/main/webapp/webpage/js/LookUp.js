var divingTeamManager = angular.module('divingTeamManager', ['ngResource', 'diveLookUpService']);

divingTeamManager.controller('lookUpCntrl', ['$scope', 'DiveService', function($scope, DiveService) {
	//$scope.dive = DiveService.get({diveNumber: "", height: 1});
	
	$scope.updateDive = function() {
		callServive($scope.diveNumber);
	};
	
	$scope.updateDiveComposite = function() {
		var diveNumber = $scope.twists > 0 ? 
			"5" + $scope.approach + $scope.somersaults + $scope.twists + $scope.position
			: $scope.approach + "0" + $scope.somersaults + $scope.position;
		callServive(diveNumber);
	};
	
	function callServive(diveNumber) {
		if(diveNumber.match("[1-4][0-1][1-9][A-D]|[1-5][1-4][1-9][1-9][A-D]")) {
			$scope.dive = DiveService.get({diveNumber: diveNumber, height: 1});
		} else {
			$scope.dive = {description: "Invalid Dive", number: "N/A", degreeOfDifficulty: "N/A"};
		}
	}
	
}]);


var diveLookUpService = angular.module('diveLookUpService', ['ngResource']);

diveLookUpService.factory('DiveService', ['$resource', function($resource) {
	return $resource('/DiveTeamManagerServices/rest/lookup/:diveNumber/:height', {diveNumber: '@diveNumber', height: '@height'});
}]);