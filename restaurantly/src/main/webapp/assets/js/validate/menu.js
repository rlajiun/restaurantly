/**
* PHP Join Form Validation - v2.0
* URL: https://bootstrapmade.com/menu-add/
* Author: BootstrapMade.com
*/
$(function(){
  var plus_form = $('.plus-form').clone();
  var num = $('.plus-group').length;
  console.log(num);
  if(num<2){
    if(num<1){
      console.log("폼도 하나 추가해줘야겠다!!");
      var source = plus_form.clone();
      source.removeClass('plus-form');
      source.addClass('plus-group');
      $('#plus-list').append(source.hide().fadeIn());
    }
    $('button.minus').hide();
    console.log("버튼 숨기기!!!");
  }

    $('button#plus').click(function(){
      $('.validate').html('').slideUp();
      $('form').find('.error-message').slideUp();
      console.log('추가버튼 눌림');
      var num = $('.plus-group').length;
      if(num<2){
        $('button.minus').show();
        console.log("버튼 보이기!!!")
      }
      var source = plus_form.clone();
      source.removeClass('plus-form');
      source.addClass('plus-group');
      $('#plus-list').append(source.hide().fadeIn());
    });
    
    $('form.add').submit(function(e) {
      console.log("시작");
      e.preventDefault();

      var f = $(this).find('.plus-group .form-group'),
      ferror = false;
  
      f.children('input, select').each(function() { // run all inputs
       
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
  
            case 'selected':
              if (i.children('option:selected').val() === '') {
                ferror = ierror = true;
              }
              console.log( i.children('option:selected').val());
              break;
          }
          i.next('.validate').html((ierror ? i.attr('data-msg') : '')).slideDown();
        }
      });
      
      if (ferror) return false;

      var list = $(this).find('.plus-group');
      var name_head = $('form').attr('name') + '[';
      var index = 0;

      list.each(function(){
        $(this).find('input:not(input[type=file]), select, textarea').each(function(){
          var i = $(this); // current input
          console.log(i.val());
          console.log(!isNaN(i.val()));
          var name_tail = '].' + i.attr('name');
          var name = name_head + index + name_tail;

          i.attr('name', name);
          console.log(name);
        });
        index++;
      });
  
      var this_form = $(this);
      var action = $(this).attr('action');
      var formData = new FormData($("form")[0]); 
      
      this_form.find('.error-message').slideUp();
      this_form.find('.loading').slideDown();
  
      console.log(formData);
  
      plus_form_submit(this_form,action,formData);
      
      return true;
    });
  
    function plus_form_submit(this_form, action, formData) {
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
  