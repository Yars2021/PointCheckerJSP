<%--
  Created by IntelliJ IDEA.
  User: yaros
  Date: 04.11.2021
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Point checker 2.0</title>
    <link href="styles/main.css" type="text/css" rel="stylesheet">
    <link href="styles/themes/light.css" type="text/css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<div class="container-xxl">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">PointChecker</a>
            <button
                    class="navbar-toggler"
                    type="button"
                    data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent"
                    aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Theme
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#">Light</a></li>
                            <li><a class="dropdown-item" href="#">Dark</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class = "custom-header-container">
        <header class="header">
            <div class="collapse" id="collapseAuthorInfo">
                <div class="custom-author-card">
                    <div class="row row-cols-2">
                        <div class="col">Author</div>
                        <div class="col">Sukhovey Yaroslav</div>
                        <div class="col">Group</div>
                        <div class="col">P3214</div>
                        <div class="col">Variant</div>
                        <div class="col">20666</div>
                        <div class="col"><a href="https://github.com/Yars2021/PointCheckerJSP" target="_blank">Github</a></div>
                    </div>
                </div>
            </div>
            <div class = "custom-collapse-container">
                <button
                        class="custom-collapse-button"
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target="#collapseAuthorInfo"
                        aria-expanded="false"
                        aria-controls="collapseAuthorInfo">
                </button>
            </div>
        </header>
    </div>

    <div class = "main-container bg-light">
        <div class="container">
            <div class = "row">
                <div class="col">
                    <canvas></canvas>
                </div>
                <div class="col">Form</div>
            </div>
        </div>
    </div>

</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
        integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
</body>
</html>
