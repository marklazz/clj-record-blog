function updateViewHandlers () {
  $('#comment-form form').ajaxForm({ dataType: 'script' });
};

$(function () {
  $('.add-comment-link').click(function () {
      $('#comment-form').slideDown();
      $('.add-comment-link').hide();
      return false;
  });

  $('#logout-link').click(function () {
    $('#logout-form form').submit();
    return false;
  })

  updateViewHandlers();
});
