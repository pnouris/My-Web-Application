'use strict';

appControllers.controller('MainController', ['$rootScope', '$scope', '$http', 'authorization',
    function($rootScope, $scope, $http, authorization) {
        $scope.status = 'running...';
        $scope.user = {};
        $scope.profile = authorization.profile;
        $scope.isAdmin = authorization.hasRealmRole('admin')
        $scope.isManager = authorization.hasRealmRole('manager')
        
        $scope.getWorkers = function() {
        	$http.get("http://localhost:8000/api/workers").success(function(data) {
            	$scope.workers = data._embedded.workers;
            });
        }
        
        $scope.getShiftWorkers = function(url) {
        	$http.get(url).success(function(data) {
            	$scope.shiftWorkers = data._embedded.workers;
            });
        }
        
        $scope.addWorker = function() {

        	$http.post('http://localhost:8000/api/workers', $scope.user).
            success(function(data, status, headers, config) {
                // this callback will be called asynchronously
                // when the response is available
                console.log(data);
              }).
              error(function(data, status, headers, config) {
                // called asynchronously if an error occurs
                // or server returns response with an error status.
              });

        }
        
        $scope.getShifts = function() {
        	$http.get("http://localhost:8000/api/shifts").success(function(data) {
            	$scope.shifts = data._embedded.shifts;
            });
        }
        
        $scope.logout = function() {
        	authorization.logout();
        }
    }
]);