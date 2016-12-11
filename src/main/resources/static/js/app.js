var taskManagerModule = angular.module('taskManagerApp', ['ngAnimate']);

taskManagerModule.controller('taskManagerController', function($scope,$http) {
  var urlBase = "";
  $scope.toggle = true;
  $scope.selection = [];
  $scope.statuses = ['ACTIVE','COMPLETED'];
  $scope.priorities = ['HIGH','LOW','MEDIUM'];
  $http.defaults.headers.post["Content-Type"] = "application/json";

  function findAllTasks() {
    // get all tasks and display initially
    $http.get(urlBase + '/tasks/search/findByTaskArchived?archivedfalse=0').success(function (data) {
      if(data._embedded != undefined) {
        $scope.tasks = data._embedded.tasks;
      } else {
        $scope.tasks = [];
      }
      for(var i=0; i<$scope.tasks.length; i++) {
        if($scope.tasks[i].taskStatus == 'COMPLETED') {
          $scope.selection.push($scope.tasks[i].taskId);
        }
      }
      $scope.taskName="";
      $scope.taskDesc="";
      $scope.taskPriority="";
      $scope.taskStatus="";
      $scope.toggle='!toggle';
    });
  }
  findAllTasks();

  // add a new task
  $scope.addTask = function addTask() {
    if($scope.taskName=="" || $scope.taskDesc=="" || $scope.taskPriority==""||$scope.taskStatus=="") {
      alert("Insufficient Data! Please provide values for task name, description, priority and status");
    }
  }
});