<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>等比缩略图Demo 图片展示</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container" style="margin-top: 50px;">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">图片</h3>
        </div>
        <div class="panel-body">
            <div class="col-lg-10" style="margin-bottom: 30px;">
                <label class="col-lg-4">原图：</label>
                <img src="${imageUrl}">
            </div>
            <div class="col-lg-10">
                <label class="col-lg-4">缩略图：</label>
                <img src="${thumbImageUrl}">
            </div>
        </div>
    </div>
</div>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
