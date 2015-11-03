(function() {
  angular.module('dayTripperApp', ['ui.calendar', 'ui.bootstrap'])
         .controller('bookingController', [bookingController]);
  function bookingController(){
    // var date = new Date();
    // var d = date.getDate();
    // var m = date.getMonth();
    // var y = date.getFullYear();
    this.eventSource = {};
    this.uiConfig = {
      calendar: {
        height: 250,
        editable: true,
        header:{
          left: 'month basicWeek basicDay agendaWeek agendaDay',
          center: 'title',
          right: 'today prev,next'
        }
      }
    };
  };
})();
