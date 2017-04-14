$(".comment_open").click(function() {
    var parent = $(this).parents()[5];
    $(".comments", parent).slideToggle( "slow" );
});

$(".new_comment_open").click(function() {
    var parent = $(this).parents()[4];
    $(".new_comment", parent).slideToggle( "slow" );
});