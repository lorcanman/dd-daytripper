(function() {
  angular.module('dayTripperApp', ['ui.calendar', 'ui.bootstrap'])
         .constant('serverURL', 'http://localhost:8080/leaves')
         .controller('calendarController', ['serverURL', '$http', calendarController])
         .controller('bookingController', [bookingController]);
  function calendarController(serverURL, $http){
    this.today = function() {
      this.dt = new Date();
    };

    this.callServer = function() {
    	console.log(serverURL);
        $http.get(serverURL).success(function(data){
            console.log(data);
        });
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
    // var date = new Date();
    // var d = date.getDate();
    // var m = date.getMonth();
    // var y = date.getFullYear();
    // this.eventSource = {};
    // this.uiConfig = {
    //   calendar: {
    //     height: 250,
    //     editable: true,
    //     header:{
    //       left: 'month basicWeek basicDay agendaWeek agendaDay',
    //       center: 'title',
    //       right: 'today prev,next'
    //     }
    //   }
    // };
  };
  function bookingController(){};
})();
