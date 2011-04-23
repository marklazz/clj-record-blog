$(function () {
  $('.add-comment-link').click(function () {
      $('#comment-form').slideDown();
      $('.add-comment-link').hide();
      return false;
  });

  $('#comment-form form').ajaxForm({
    dataType: 'json',
    success: function (responseText, statusText, xhr, $form) {
      if (responseText.status == 'ok') {
        console.log('ok');
      } else {
        console.log('error');
      }
    }
  });
});
