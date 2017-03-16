<%@ page import="fr.polytech.business.Post" %>
<%@ page import="java.util.List" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Starter Template for Bootstrap</title>

    <link href="/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="/assets/css/main.css" rel="stylesheet">

</head>

<body>

<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Polytech Net</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="container">

    <div class="starter-template">
        <div class="row publisher">
            <form method="post" action="share">
                <div class="form-group">
                    <div class="col-md-12">
                     <textarea name="content" class="form-control"
                               placeholder="what in your mind ?"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-1 pull-right">
                        <button type="submit" class="btn btn-primary">Share</button>
                    </div>
                </div>
            </form>
        </div>
        <%
            List<Post> postList = (List<Post>) request.getAttribute("posts");
        %>
        <%
            for (Post post : postList) {
        %>
        <div class="row feed">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <%=post.getContent()%>
                    </div>
                </div>
            </div>
        </div>
        <%}%>
    </div>

</div>
<script src="/assets/js/jquery.min.js"></script>
<script src="/assets/js/bootstrap.min.js"></script>
</body>
</html>
