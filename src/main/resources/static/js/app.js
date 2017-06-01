var app = angular.module('crudApp',['ui.router']);

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
 
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/user.html',
                controller:'UserController'
            });
        $urlRouterProvider.otherwise('/');
    }]);