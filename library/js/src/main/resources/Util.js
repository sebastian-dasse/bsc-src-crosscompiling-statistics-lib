(function() {
  "use strict";

  var stat = platform.StatLib();

  var op = "";

  window.onload = function(argument) {

    var form = document.getElementById("form");
    form.onsubmit = function(evt) {
      evt.preventDefault();
    };

    var input = document.getElementById("input");
    input.onkeyup = function(evt) {
      switch (evt.keyCode) {
        case 13:
          var tmp = input.value
          input.value = "";
          updateOutput(tmp);
          break;
        case 27:
          input.value = "";
          break;
      }
    };

    var ops = document.getElementById("ops");
    ops.onchange = function(evt) {
      op = ops.options[ops.selectedIndex].value;
      console.log("changed")
    };
    ops.options[0].selected = true;
    ops.onchange();
  };

  var stringToNumberArray = function(str) {
    var strArr = str.match(/[-+]?[0-9]+(\.[0-9]+)?/g) || [];
    var arr = [];
    for (var i = 0, len = strArr.length; i < len; i++) {
      arr.push(parseFloat(strArr[i]));
    }
    return arr;
  };

  var updateOutput = function(str) {
    var output = document.getElementById("output");
    var numArr = stringToNumberArray(str);

    var res = stat[op](numArr);

    output.textContent = res + " is the " + op + " of [" + numArr + "]";
  };
}());