<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>等比缩略图Demo 上传文件</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container" style="margin-top: 50px;">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">上传图片</h3>
        </div>
        <div class="panel-body">
            <form action="/thumbnail/upload" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label>图片上传</label>
                    <input type="file" name="image">
                    <p class="help-block">请选择.jpg .png .jpeg 等类型的图片文件</p>
                </div>
                <button type="submit" class="btn btn-default">上传</button>
            </form>
        </div>
    </div>
</div>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
