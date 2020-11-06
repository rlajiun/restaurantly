/**
* PHP Join Form Validation - v2.0
* URL: https://bootstrapmade.com/php-join-form/
* Author: BootstrapMade.com
*/
$(function(){
  $('form.join-form').submit(function(e) {
    console.log("시작");
    e.preventDefault();
    var f = $(this).find('.form-group'),
    ferror = false,
    emailExp = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i,
    phoneExp = /^[0-9]{3}[-]+[0-9]{4}[-]+[0-9]{4}$/,
    phoneExp2 = /^\d{11}$/;

    f.children('input').each(function() { // run all inputs
     
      var i = $(this); // current input
      var rule = i.attr('data-rule');

      if (rule !== undefined) {
        var ierror = false; // error flag for current input

        switch (rule) {
          case 'required':
            if (i.val() === '') {
              ferror = ierror = true;
            }
            break;

          case 'repeat':
            if (i.val() !== i.parent().prev().children('input').val()) {
              ferror = ierror = true;
            }
            break;

          case 'email':
            if (i.val() === '') {
              break;
            } else if (!emailExp.test(i.val())) {
              ferror = ierror = true;
            }
            break;

          case 'phone':
            if (i.val() === '') {
              break;
            } else if (!phoneExp.test(i.val()) && !phoneExp2.test(i.val())) {
              ferror = ierror = true;
            } else if(phoneExp2.test(i.val())) {
              var value =  i.val().substr(0, 3) + '-' + i.val().substr(3, 4) + '-' + i.val().substr(7, 4);
              i.val(value);
            }
            break;

          case 'checked':
            if (! i.is(':checked')) {
              ferror = ierror = true;
            }
            break;

          case 'regexp':
            exp = new RegExp(exp);
            if (!exp.test(i.val())) {
              ferror = ierror = true;
            }
            break;
        }
        i.next('.validate').html((ierror ? (i.attr('data-msg') !== undefined ? i.attr('data-msg') : '잘못된 입력입니다.') : '')).show('blind');
      }
    });
    
    if (ferror) return false;

    var this_form = $(this);
    var action = $(this).attr('action');
    var formData = new FormData($("form")[0]); 

    if( ! action ) {
      this_form.find('.loading').slideUp();
      this_form.find('.error-message').slideDown().html('The form action property is not set!');
      return false;
    }
    
    this_form.find('.error-message').slideUp();
    this_form.find('.loading').slideDown();

    console.log(formData);

    join_form_submit(this_form,action,formData);
    
    return true;
  });

  function join_form_submit(this_form, action, formData) {
    $.ajax({
      type: "POST",
      url: action,
      data: formData,
      contentType: false,
      processData: false
    }).done( function(data){
      console.log('data>>>>>>'+data);
      console.log('msg>>>>>>'+data.msg);
      console.log('url>>>>>>'+data.url);
      
      var msg = data.msg;
      var url = data.url;

      if (url != null) {
        this_form.find('.loading').slideUp();
        alert(msg);
        window.location.href = url;
      } else {
        this_form.find('.loading').slideUp();
        if(!msg) {
          msg = 'Form submission failed and no error message returned from: ' + action + '<br>';
        }
        this_form.find('.error-message').slideDown().html(msg);
      }
    }).fail( function(data){
      console.log(data);
      var error_msg = "Form submission failed!<br>";
      if(data.statusText || data.status) {
        error_msg += 'Status:';
        if(data.statusText) {
          error_msg += ' ' + data.statusText;
        }
        if(data.status) {
          error_msg += ' ' + data.status;
        }
        error_msg += '<br>';
      }
      if(data.responseText) {
        error_msg += data.responseText;
      }
      this_form.find('.loading').slideUp();
      this_form.find('.error-message').slideDown().html(error_msg);
    });
  }

});
