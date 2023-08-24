let index = {
  init: function() {
    $("#btn-save").on("click", () => {
      this.save();
    });
    $("#btn-delete").on("click", () => {
      this.delete();
    });
    $("#btn-update").on("click", () => {
      this.update();
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

  delete: function() {
    let id = $('#id').text();
    
    $.ajax({
      type : 'DELETE',
      url : '/api/board/' + id,
      dataType : 'json'
    }).done(function(res) {
      alert('삭제가 완료되었습니다.');
      location.href = '/';
    }).fail(function(res) {
      var message = JSON.parse(res.responseText);
      console.log((message));
      alert('서버 오류');
    });
  },

  update: function() {
    let id = $('#id').val();

    let data = {
      title : $('#title').val(),
      content : $('#content').val(),
    }
    
    $.ajax({
      type : 'PUT',
      url : '/api/board/' + id,
      data : JSON.stringify(data),
      contentType : 'application/json; charset=utf-8',
      dataType : 'json'
    }).done(function(res) {
      alert('수정이 완료되었습니다.');
      location.href = '/';
    }).fail(function(res) {
      var message = JSON.parse(res.responseText);
      console.log((message));
      alert('서버 오류');
    });
  },
}

index.init();