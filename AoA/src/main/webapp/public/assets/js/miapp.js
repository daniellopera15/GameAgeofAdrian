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

            templateUrl: "../webapp/views/templates/registro.html"
        })

        .state('inicio_sesion',{
            url:'/inicio_sesion',


            templateUrl:"../webapp/views/templates/inicio_sesion.html"
        })
        .state('play',{
            url:'/play',

            templateUrl: "../webapp/views/templates/play.html"
        });





})