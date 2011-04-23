$(function () {
  $('.add-comment-link').click(function () {
      $('#comment-form').slideDown();
      $('.add-comment-link').hide();
      return false;
  });
});
