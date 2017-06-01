angular.module('crudApp').service('UserService',
    ['$http',  function($http) {
    	this.getUsers = function(){
    		 return $http({
    		        method : "GET",
    		        url : "http://localhost:8080/department"
    		    });
    	};
    	
    	this.saveUser = function(user){
	   		 return $http({
	   		        method : "POST",
	   		        url : "http://localhost:8080/department",
	   		        data: user
	   		    });
    	};
	   		 
	   	this.deleteUser = function(id){
		   		 return $http({
		   		        method : "DELETE",
		   		        url : "http://localhost:8080/department/"+id
		   		    });
	   	};
   		this.getUser = function(id){
	   		 return $http({
	   		        method : "GET",
	   		        url : "http://localhost:8080/department/"+id
	   		    });
   	};
    }]);