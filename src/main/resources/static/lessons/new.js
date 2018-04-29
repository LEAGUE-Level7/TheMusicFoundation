$(document).ready(function() {
  const now = new Date();
  for (let y = now.getFullYear(); y < now.getFullYear() + 5; y++) {
    $("#year").append("<option value=\"" + y + "\">" + y + "</option>");
  }
  let daysInMonth = [
      31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
  ];
  const months = ["January","February","March","April","May","June","July",
            "August","September","October","November","December"];
  months.forEach(function(month, i) {
    $("#month").append("<option value=\"" + i + "\">" + month + "</option>");
  });
  $("#year").change(updateDaysInMonth);
  $("#month").change(updateDays);
  $("#month").val(now.getMonth());
  $("#day").html("");
  const month = $("#month").val() - 1;
  for (let i = 1; i <= daysInMonth[month]; i++) {
     $("#day").append("<option value=\"" + i + "\">" + i + "</option>"); 
  }
  updateDaysInMonth();
  updateDays();
  $("#day").val(now.getDate());

  function updateDaysInMonth(e) {
    const year = $("#year").val();
    if (year % 4 == 0) {
      daysInMonth[1] = 29; 
    } else {
      daysInMonth[1] = 28;
    }
    updateDays();
  }
  
  function updateDays(e) {
    $("#day").html("");
    const month = $("#month").val() - 1;
    for (let i = 1; i <= daysInMonth[month]; i++) {
       $("#day").append("<option value=\"" + i + "\">" + i + "</option>"); 
    }
  }
});