//dummy

$(document).ready(function () {
  $(".loginButtonDiv").click(function(e){
    var el = $(e.currentTarget);
    if(!el.hasClass("active")){
      el.siblings().removeClass("active")
      el.addClass("active");
      if($(".signUpFormDiv").hasClass("hide")){
        $(".signUpFormDiv").removeClass("hide");
        $(".loginFormDiv").addClass("hide");
      }else{
        $(".signUpFormDiv").addClass("hide");
        $(".loginFormDiv").removeClass("hide");
      }
    }
  });
  $("#signUpBtn").click(function(e){
    var el = $(e.currentTarget);
    signUpUser(el);
  });
  $("#loginBtn").click(function(e){
    var el = $(e.currentTarget);
    loginUser(el);
  });
});

function signUpUser(el) {
  var formId = "#signUpForm";
    var url = "/rest/user/add";

    var params = $(formId).serialize();

    if(!$(formId)[0].reportValidity()){
        return;
    }
    $.post(url, params)
    .done(function(resp){
      console.log("asdasd");
    })
    .fail(function (jqXHR, textStatus, errorThrown) {
      console.log("asdasd");
    })

//     $.ajax({
//   url: "/rest/user/add",
//   type: "POST",
//   dataType: "xml/html/script/json", // expected format for response
//   contentType: "application/x-www-form-urlencoded", // send as JSON
//   data: params,
//
//   complete: function() {
//     console.log("asdasd");
//   },
//
//   success: function() {
//     console.log("asdasd");
//  },
//
//   error: function() {
//     console.log("asdasd");
//   },
// });
}
function loginUser(el) {

}
