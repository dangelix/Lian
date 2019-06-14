app.service('alertaService',['$http',
	'$q',
	'$location',
	'$rootScope',
	'$window',
	function($http, $q, $location,$rootScope, $window){
		
	this.consultar=function(){
			var d = $q.defer();
			$http.get("/alertas/get").then(
				function(response) {
					console.log(response);
					d.resolve(response.data);
				});
			return d.promise;
	}
	
	this.leer=function(id){
		var d = $q.defer();
		$http.get("alertas/resAlerta/"+id).then(
			function(response) {
				console.log(response);
				d.resolve(response.data);
			});
		return d.promise;
}
}]);

app.controller('alertaController',['alertaService','$scope',function(alertaService,$scope){
	$scope.load = function(){
	alertaService.consultar().then(function(data){
		$scope.alertas=data;
	})
	}
	$scope.load();
	$scope.readAlert = function(id){
		alertaService.leer(id).then(function(data){
			alert(data);
			$scope.load();
		})
	}
}])