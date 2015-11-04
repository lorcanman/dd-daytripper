var restApp = angular.module('coursesApp', []);

restApp.constant('baseURL','/courses/');

restApp.controller('UsersController', function (baseURL, $scope,$http) {
    fetchUsers();
    $scope.noSelected = true;
    $scope.userBeingUpdated = false;
    
    function fetchUsers() {
        function storeUsers(data) {
            $scope.users = data;
        }
        $http.get(baseURL).success(storeUsers);
    }
    $scope.fetchUsers = fetchUsers;
    
    $scope.beginUpdateOfUser = function(user) {
        $scope.userBeingUpdated = angular.copy(user);
    };
    $scope.updateUser = function() {
        function resetForm() {
            $scope.userBeingUpdated = false;
            fetchUsers();
        }
        var user = $scope.userBeingUpdated;
        $http.put(baseURL + user.id, user).success(resetForm);
    };
    $scope.selectUser = function(user) {
        $scope.noUserSelected = false;
        $scope.selectedUser = user;
    };
    $scope.deleteUser = function(user) {
      $http.delete(baseURL + user.id ); 
      $scope.noUserSelected = true;
      fetchUsers();
    };
});