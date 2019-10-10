'use strict';

app.factory('UserService', ['$http', '$q', function ($http, $q) {

    var baseUrl = 'http://localhost:8081';

    return {
        send: sendMessage
    };

    function sendMessage(endpoint) {
        var deferred = $q.defer();
        $http.get(baseUrl + "" + endpoint)
            .then(
                function (response) {
                    deferred.resolve(response.data);
                },
                function (errResponse) {
                    console.error('Error while fetching Users');
                    deferred.reject(errResponse);
                }
            );
        return deferred.promise;
    }
}]);
