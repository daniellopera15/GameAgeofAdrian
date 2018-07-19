var app = angular.module('miapp', ['conectionServerService']);
app.controller('micontrol', function($scope,conectionServerService,filterFilter){

    $scope.user={};
    $users = [];

    $scope.register = function(){
        conectionServerService.userRegister($userCurrent)
            .then(function(response){
                console.log(response);

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