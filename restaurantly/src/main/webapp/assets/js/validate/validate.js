/**
* PHP Join Form Validation - v2.0
* URL: https://bootstrapmade.com/php-join-form/
* Author: BootstrapMade.com
*/
$(function(){
  if($('section').hasClass('customer-login')){
    console.log("no customer login");
    alert('로그인 후 이용해주세요.');
    window.location.href = getContextPath() + '/form/loginForm.do';
  }else if($('section').hasClass('owner-login')){
    console.log("no owner login");
    alert('로그인 후 이용해주세요.');
    window.location.href = getContextPath() + '/form/loginForm.do';
  }else if($('section').hasClass('myRes-check')){
    console.log("no owner login");
    alert('등록된 식당이 없습니다.\n식당을 등록해주세요!');
    window.location.href = getContextPath() + '/owner/restaurant/addRestaurantForm.do';
  }

  $('section.mybook-list button[role=request]').click(function(e){
    e.preventDefault();
    if(!confirm('취소하시겠습니까?')) return false;
    var booking_id = $(this).attr('name');
    console.log(booking_id);
    $(this).slideUp();
    var load = $(this).closest('.loading');
    load.slideDown();
    var source = $(this).closest('.book');

    $.ajax({
      type: "POST",
      url: 'cancelTable.do',
      data: {'booking_id': booking_id}
    }).done( function(msg){
      if(msg=='OK'){
        load.slideUp();
        source.find('button.btn-detail').replaceWith('<p class="btn-detail" >취소 대기중</p>');
      }else{
        load.slideUp();
        $(this).slideDown();
        alert(msg);
      }
    }).fail( function(data){
      source.find('.loading').slideUp();
      $(this).slideDown();
      alert('fail');
    });
  });

  $('section.mybook-list button[role=write]').click(function(){
    var restaurant_license = $(this).attr('name');
    console.log(restaurant_license);
    window.location.href = getContextPath() + '/review/reviewForm.do';
  });

  $('form.join-form, form.book-a-table').submit(function(e) {
    console.log("시작");
    e.preventDefault();
    var f = $(this).find('.form-group'),
    ferror = false,
    emailExp = /^[^\s()<>@,;:\/]+@\w[\w\.-]+\.[a-z]{2,}$/i,
    phoneExp = /^[0-9]{3}[-]+[0-9]{4}[-]+[0-9]{4}$/,
    phoneExp2 = /^\d{11}$/,
    dateExp = /^\d{4}[-]+(0[1-9]|1[012])[-]+(0[1-9]|[12][0-9]|3[0-1])$/,
    timeExp = /^([01][0-9]|2[0-3])+[:]+([0-5][0-9])$/;

    f.children('input').each(function() { // run all inputs
     
      var i = $(this); // current input
      var rule = i.attr('data-rule');

      if (rule !== undefined) {
        var ierror = false; // error flag for current input
        console.log(i.val());

        switch (rule) {
          case 'login':
            console.log(i.val());
            if(i.val() === ''){
              if(confirm('로그인이 필요합니다.\n로그인 하시겠습니까?')){
                sessionStorage.setItem("action", $(location).attr('href'));
                window.location.href = getContextPath() + '/form/loginForm.do';
              }
              else {
                ferror = ierror = true;
              }
            }
            break;

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

          case 'date':
            if(!dateExp.test(i.val())){
              ferror = ierror = true;
            }else{
              var value = getToday(i.val().substr(0,4),i.val().substr(5,2),i.val().substr(8,2));
              console.log(value);
              if(!value){
                ferror = ierror = true;
              }
            }
            break;
          
          case 'time':
            if(!timeExp.test(i.val())){
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
    this_form.find('.sent-message').slideUp();

    console.log(formData);

    join_form_submit(this_form,action,formData);
    
    return true;
  });

  function getToday(y, m, d){
    console.log(!isNaN(y));
    console.log(!isNaN(m));
    console.log(!isNaN(d));

    var date = new Date();
    var year = date.getFullYear();
    var month = date.getMonth()+1;
    var day = date.getDate();

    if(y < year){
      return false;
    }else if(y == year){
      if(m < month){
        return false;
      }else if(m == month){
        if(d <= day){
          return false;
        }
      }
    }
    return true;
  }

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

      if(msg == 'OK'){
        this_form.find('.loading').slideUp();
        this_form.find('.sent-message').slideDown();
        this_form.find("input:not(input[type=submit]), textarea").val('');
      } else if (url != null) {
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

  function sessionCheck(user){
    var sessionId;
    $.ajax({
      type: "GET",
      url: '/userSessionCheck.do?user='+ user,
      datatype: 'json',
      success: function(result){
        sessionId = result;
      },
      error: function(){
        sessionId = null;
      }
    });

    return sessionId;

  }

  function getContextPath() {
    var hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
  }

});
