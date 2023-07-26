let index = {
  init: function() {
    $("#btn-save").on("click", ()=>{
      this.save();
    });
  },

  save: function() {
    let data = {
      username : $('#username').val(),
      password : $('#password').val(),
      email : $('#email').val()
    }
    
    $.ajax({
      type : 'POST',
      url : '/blog/api/user',
      data : JSON.stringify(data),
      contentType : 'application/json; charset=utf-8',
      // dataType : 'json'  // 응답받을시 javascript obj 변환
    }).done(function(res) {
      if (res.status == 200) {
        console.log(res);
        alert('회원가입이 완료되었습니다.');
        location.href = '/blog/user/loginForm';
      } else {
        if (res.msg == '아이디중복') {
          console.log(res);
          alert('아이디가 중복되었습니다.');
        } else {
          console.log(res);
          alert('회원가입 실패');
        }
      }
    }).fail(function(res) {
      var message = JSON.parse(res.responseText);
      console.log((message));
      alert('서버 오류');
    });
  }
}

index.init();