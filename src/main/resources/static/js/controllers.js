'use strict';

app.controller('UserController', ['$scope', 'UserService', function ($scope, UserService) {
    $scope.user = {};
    $scope.user.name = "";
    $scope.user.message = "";
    $scope.messages = [];

    $scope.sendMessage = function () {
        UserService.send("/kafka/user/" + $scope.user.name +"?m=" + $scope.user.message).then(function (value) {
            $scope.messages.push(value);
        });
    };
}]);