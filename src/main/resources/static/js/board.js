let index = {
  init: function() {
    $("#btn-save").on("click", () => {
      this.save();
    });
  },

  save: function() {
    let data = {
      title : $('#title').val(),
      content : $('#content').val(),
    }
    
    $.ajax({
      type : 'POST',
      url : '/api/board',
      data : JSON.stringify(data),
      contentType : 'application/json; charset=utf-8',
      dataType : 'json'
    }).done(function(res) {
      if (res.status == 200) {
        console.log(res);
        alert('글쓰기가 완료되었습니다.');
        location.href = '/';
      } else {
        console.log(res);
        alert('글쓰기 실패');
      }
    }).fail(function(res) {
      var message = JSON.parse(res.responseText);
      console.log((message));
      alert('서버 오류');
    });
  },
}

index.init();