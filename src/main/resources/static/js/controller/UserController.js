angular.module('crudApp').controller('UserController',
    ['UserService', '$scope',  function( UserService, $scope) {
    	$scope.user={};
    	$scope.submitForm = function(isValidate){
    		if(isValidate){
    			$scope.saveUser();
    		}
    	}
    	$scope.getUsers = function(){
    		UserService.getUsers().then(function mySuccess(response) {
   		        $scope.departments = response.data;
   		    }, function myError(response) {
   		        $scope.error = response.statusText;
   		    });
    	}
    	
    	$scope.deleteUser = function(id){
    		UserService.deleteUser(id).then(function mySuccess(response) {
   		        $scope.departments = response.data;
   		     $scope.getUsers();
   		    }, function myError(response) {
   		        $scope.error = response.statusText;
   		    });
    	}
    	
    	$scope.saveUser = function(){
    		UserService.saveUser($scope.user).then(function mySuccess(response) {
   		        $scope.success = response.data;
   		        $scope.user={};
   		     $scope.getUsers();
   		    }, function myError(response) {
   		        $scope.error = response.statusText;
   		    });
    	}
    	
    	
    	$scope.editUser = function(id){
    		UserService.getUser(id).then(function mySuccess(response) {
   		        $scope.user = response.data;
   		     $scope.getUsers();
   		    }, function myError(response) {
   		        $scope.error = response.statusText;
   		    });
    	}
    	$scope.getUsers();
    	
    }]);