<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>채팅예제</title>
    <link rel='stylesheet' href='/webjars/bootstrap/4.3.0/css/bootstrap.min.css'>
</head>
<body>
<%--채팅 화면--%>
<div class="container mt-5 overflow-auto border border-primary" id="board" style="height: 500px;">
    <div class="row">
        <div class="col-2 text-center">id</div>
        <div class="col-10 float-left">내용</div>
    </div>
</div>
<%--채팅 입력 요소--%>
<div class="container mt-2">
    <div class="row">
        <div class="col-2">
            <input type="text" class="form-control" id="id" placeholder="id">
        </div>
        <div class="col-8">
            <input type="text" class="form-control" id="message" placeholder="내용">
        </div>
        <div class="col-2">
            <button class="btn btn-primary" onclick="echo()">전송</button>
        </div>
    </div>
</div>

<script type="text/javascript" src="/webjars/jquery/3.0.0/jquery.js/"></script>
<script type="text/javascript" src="/resources/scripts/app.js"></script>
</body>
</html>
