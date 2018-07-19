var miapp = angular.module('miapp',['ui.router']);

miapp.config(function($stateProvider,$urlRouterProvider){

    // $urlRouterProvider.when("","/");

    $urlRouterProvider.otherwise('/home');



    $stateProvider

        .state('home',{
            url:'/home',

            templateUrl: "../webapp/views/templates/home-view.html"
        })
        .state('registro',{
            url:'/registro',

            templateUrl: "../webapp/views/templates/registro.html",
            
        })

        .state('play',{
            url:'/play',

            templateUrl: "../webapp/views/templates/play.html"
        });

    });

miapp.controller('micontrol', function($scope,conectionServerService,filterFilter){

    $scope.user={};
    $scope.ejercito={};
    $users = [];

    $scope.register = function(){
        $scope.ejercito.soldados = null;
        conectionServerService.createEjercito($scope.ejercito)
            .then(function(response){
                console.log(response);

            })
            .catch(function(err){
                console.log(err);
            });
        conectionServerService.userRegister($scope.user)
            .then(function(response){
                console.log(response);
                alert("ya se registro");

            })
            .catch(function(err){
                console.log(err);
            });
    }

    /*conectionServerService.userLogin()
        .then(function(response){
        console.log(response);
    });*/
    $scope.showUsers = function(){
        conectionServerService.userRegister($userCurrent)
            .then(function(response){
                console.log(response);
                $users = response.data;

            })
            .catch(function(err){
                console.log(err);
            });

    }




});
