(function() {
  angular.module('dayTripperApp', ['ui.calendar', 'ui.bootstrap'])
         .constant('serverURL', 'http://localhost:8080/leaves')
         .controller('leavesController', ['serverURL', '$http', leavesController])
         .controller('calendarController', [calendarController]);
  function calendarController(){
    this.today = function() {
      this.dt = new Date();
    };

    this.today();

    this.clear = function() {
      this.dt = null;
    };

    // Disable weekend selection
    this.disabled = function(date, mode) {
      return ( mode === 'day' && ( date.getDay() === 0 || date.getDay() === 6 ) );
    };

    this.toggleMin = function() {
      this.minDate = this.minDate ? null : new Date();
    };
    this.toggleMin();
    this.maxDate = new Date(2020, 5, 22);

    this.open = function($event) {
      this.status.opened = true;
    };

    this.setDate = function(year, month, day) {
      this.dt = new Date(year, month, day);
    };

    this.dateOptions = {
      formatYear: 'yy',
      startingDay: 1
    };

    this.status = {
      opened: false
    };

    var tomorrow = new Date();
    tomorrow.setDate(tomorrow.getDate() + 1);
    var afterTomorrow = new Date();
    afterTomorrow.setDate(tomorrow.getDate() + 2);
    this.events =
      [
        {
          date: tomorrow,
          status: 'full'
        },
        {
          date: afterTomorrow,
          status: 'partially'
        }
      ];

    this.getDayClass = function(date, mode) {
      if (mode === 'day') {
        var dayToCheck = new Date(date).setHours(0,0,0,0);

        for (var i=0;i<this.events.length;i++){
          var currentDay = new Date(this.events[i].date).setHours(0,0,0,0);

          if (dayToCheck === currentDay) {
            return this.events[i].status;
          }
        }
      }

      return '';
    };
  };

  function leavesController(serverURL, $http){
    var theController = this;
    function display(data) {
      theController.leaves = data;
    }
    function getPreviousLeaves(url, displayFunction) {
      function dateConversion(data) {
        function convertDateOf(leave) {
          var startDate = leave.startDate;
          var endDate = new Date().toDateString();
          
          leave.startDate = new Date(startDate).toDateString();
          leave.endDate = new Date(endDate).toDateString();
        }
        data.forEach(convertDateOf);
        displayFunction(data);
      }
      $http.get(url).success(dateConversion);
    }
    getPreviousLeaves(serverURL, display);
  }
})();
