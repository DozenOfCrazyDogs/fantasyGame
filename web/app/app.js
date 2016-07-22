/**
 * Created by НОЗДОРМУ on 16.07.2016.
 */
(function(angular) {
    'use strict';
    angular.module('ngIndexApp', ['ngAnimate'])
        .controller('ExampleController', ['$scope', '$http', function($scope, $http) {
            
            // DEFAULTS INIT AND GLOBAL VARIABLES
            $scope.data = {
                availableOptions: [
                    {id: '2', name: '2'},
                    {id: '3', name: '3'},
                    {id: '4', name: '4'},
                    {id: '5', name: '5'}
                ]
            };
            $scope.a={};
            for(var i = 0; i<5; i++){
                for(var j = 0; j<5;j++){
                    $scope.a[""+i+j]="";
                }
            }
            $scope.showRow = [true, false, false];
            $scope.showCol = [true, false, false];
            $scope.rows = "3";
            $scope.columns = "3";
            $scope.showBlocks = true;

            //slider variables
            var slidesCount = 2;
            $scope.$slideIndex = 0;
            var methodsCount = 2;
            $scope.$methodIndex = 0;
            
            // SELECT FUNCTION
            $scope.displayMatrix = function() {
                switch ($scope.rows) {
                    case "2":
                        $scope.showRow[0] = false;
                        $scope.showRow[1] = false;
                        $scope.showRow[2] = false;
                        $scope.myStyleRows = "90px";
                        break;
                    case "3":
                        $scope.showRow[0] = true;
                        $scope.showRow[1] = false;
                        $scope.showRow[2] = false;
                        $scope.myStyleRows = "60px";
                        break;
                    case "4":
                        $scope.showRow[0] = true;
                        $scope.showRow[1] = true;
                        $scope.showRow[2] = false;
                        $scope.myStyleRows = "45px";
                        break;
                    case "5":
                        $scope.showRow[0] = true;
                        $scope.showRow[1] = true;
                        $scope.showRow[2] = true;
                        $scope.myStyleRows = "36px";
                }
                switch ($scope.columns){
                    case "2":
                        $scope.showCol[0]=false;
                        $scope.showCol[1]=false;
                        $scope.showCol[2]=false;
                        $scope.myStyleColumns = "45px";
                        break;
                    case "3":
                        $scope.showCol[0]=true;
                        $scope.showCol[1]=false;
                        $scope.showCol[2]=false;
                        $scope.myStyleColumns = "40px";
                        break;
                    case "4":
                        $scope.showCol[0]=true;
                        $scope.showCol[1]=true;
                        $scope.showCol[2]=false;
                        $scope.myStyleColumns = "35px";
                        break;
                    case "5":
                        $scope.showCol[0]=true;
                        $scope.showCol[1]=true;
                        $scope.showCol[2]=true;
                        $scope.myStyleColumns = "30px";
                }
                $scope.myStyle = {
                    'font-size' : $scope.myStyleColumns
                    //height : $scope.myStyleRows
                };
            };

            // ### START OF POST BLOCK
            // CHECK FOR NUMERICAL VALUES AND BUILD JSON OF NUMBERS
            var collectInfo = function(){
                var matrixJSON = {};
                var trigger = true;
                for (var i=0; i < $scope.rows; i++){
                    for (var j=0; j<$scope.columns;j++){
                        var check = Number($scope.a[""+i+j]);
                        if (isNaN(check) || $scope.a[""+i+j]==""){
                            trigger = false;
                        } else {
                            matrixJSON["a" + i + j] = $scope.a[""+i+j];
                        }
                    }
                }
                if (trigger) {
                    return matrixJSON;
                } else {return trigger}
            };

            // SEND POST REQUEST FUNCTION
            var sendJSON = function(matrixJSON){
                $http({
                    method: 'POST',
                    url: 'http://77.90.246.249:8082/Deploy/normalize',
                    data: matrixJSON
                }).then(function successCallback(response) {
                    $scope.showBlocks = false;
                    $scope.fromJSON = response.data;
                }, function errorCallback(response) {
                    alert( "failure message: " + JSON.stringify({data: response}));
                });
            };
            
            // PARSE JSON OBJECT AND PRINT INTO TABLE
            var parseJSON = function(receivedJSON){
                var sortByKey = Object.keys(receivedJSON).sort();
                var lastKey = sortByKey[sortByKey.length - 1];
                var output = [];
                for (var i = 0; i < lastKey.length; i += 1) {
                    output.push(lastKey.charAt(i));
                }
                var finalArray = [];
                for (var i = 0; i < parseInt(output[1]) + 1; i++) {
                    var rowArray = [];
                    for (var j = 0; j < parseInt(output[2]) + 1; j++) {
                        rowArray.push(receivedJSON["a" + i + j]);
                    }
                    finalArray.push(rowArray);
                }
                return finalArray;
            };
            
            // SUBMIT BUTTON FUNCTION
            $scope.newSubmit = function() {
                var objectMatrix = collectInfo();
                if (objectMatrix == false) {
                    alert("Please enter numerical values!");
                } else {
                    var sendData = {};
                    sendData["matrix"] = parseJSON(objectMatrix);
                    //$scope.fromJSON = parseJSON(sendData); // change sendData -> message and uncomment line above
                    sendJSON(sendData);
                    //$scope.showBlocks = false; // remove this
                }
            };
            // ### END OF SUBMIT BLOCK

            // BACK BUTTON FUNCTION
            $scope.backButton = function(){
                $scope.showBlocks=true;
                for (var i=0; i < 5; i++){
                    for (var j=0; j<5;j++){
                        $scope.a[""+i+j] = "";
                    }
                }
            };

            // SLIDER FUNCTION
            $scope.nextSlide = function() {
                $scope.$slideIndex = ($scope.$slideIndex == slidesCount-1) ? $scope.$slideIndex=0 : $scope.$slideIndex+=1 ;
            };

            $scope.previousSlide = function() {
                $scope.$slideIndex = ($scope.$slideIndex == 0) ? $scope.$slideIndex=slidesCount-1 : $scope.$slideIndex-=1 ;
            };

            $scope.nextMethod = function() {
                $scope.$methodIndex = ($scope.$methodIndex == methodsCount-1) ? $scope.$methodIndex=0 : $scope.$methodIndex+=1 ;
            };

            $scope.previousMethod = function() {
                $scope.$methodIndex = ($scope.$methodIndex == 0) ? $scope.$methodIndex=methodsCount-1 : $scope.$methodIndex-=1 ;
            };

        }]);
})(window.angular);