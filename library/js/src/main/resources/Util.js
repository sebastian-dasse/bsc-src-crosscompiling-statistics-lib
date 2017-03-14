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
        case 13: // enter
          var tmp = input.value
          updateOutput(tmp);
          break;
        case 27: // escape
          input.value = "";
          break;
      }
    };

    var sel = document.getElementById("sel");
    sel.onchange = function(evt) {
      op = sel.options[sel.selectedIndex].value;
      console.log("changed")
    };
    sel.options[0].selected = true;
    sel.onchange();
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