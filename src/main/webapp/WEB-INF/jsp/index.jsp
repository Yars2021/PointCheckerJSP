<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>PointChecker::JSP</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"/>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/css/graph.css" rel="stylesheet"/>
    <link id="theme-link" href="${pageContext.request.contextPath}/css/light.css" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/main.js"></script>
</head>
<body>
<div class="main-container container-xxl">
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-theme">
            <div class="container-fluid">
                <a class="navbar-brand custom-brand" href="#">PointChecker</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle bg-theme" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Theme
                            </a>
                            <ul class="dropdown-menu bg-theme-lighter" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" onclick="changeCSS('${pageContext.request.contextPath}/css/dark.css', 0); setTheme(true);" href="#">Dark</a></li>
                                <li><a class="dropdown-item" onclick="changeCSS('${pageContext.request.contextPath}/css/light.css', 0); setTheme(false);" href="#">Light</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <div class="row">
        <div class="col-5" id="img-column">
            <div id="coordinates">
                <div class="coordinate-label">&nbsp;X:&nbsp;</div>
                <div class="coordinate-value" id="coordinateX">0.0</div>
                <div class="spacer"></div>
                <div class="coordinate-label">&nbsp;Y:&nbsp;</div>
                <div class="coordinate-value" id="coordinateY">0.0</div>
            </div>
            <br/>
            <canvas id="graph-layer"></canvas>
            <canvas id="crosshair-layer"></canvas>
        </div>
        <div class="form-column col-7">
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

            <div class="row panel">
                <div class="col-sm-10 bg-theme">&nbsp;</div>
                <div class="col-sm-2 bg-theme">&nbsp;</div>
            </div>
            <div class="row panel bg-theme">
                <div class="col-sm-1 text-end font-weight-bold">
                    <label class="form-label valigned" id="labelX">X</label>
                </div>
                <div class="col-sm-8">
                    <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
                        <%
                            String[] xValues = {"-2", "-1.5", "-1", "-0.5", "0", "0.5", "1", "1.5", "2"};
                            int i = 0;
                            for (String xValue : xValues) {
                        %>
                        <input type="radio" class="btn-check" name="x" id="x<%=++i%>" autocomplete="off" value="<%=xValue%>"<%= "0".equals(xValue)?" checked": ""%>
                               onclick="updateLabelX()">
                        <label class="btn btn-outline-primary" for="x<%=i%>"><%=xValue%>
                        </label>
                        <%
                            }
                        %>
                    </div>
                </div>
                <div class="col-sm-1 text-end">
                    <span id="valueX">0</span>
                </div>
                <div class="col-sm-2 text-end bg-theme">
                    &nbsp;
                </div>
            </div>
            <div class="row panel bg-theme">
                <div class="col-sm-1 text-end font-weight-bold">
                    <label for="y" class="form-label valigned with-padding" id="labelY">Y</label>
                </div>
                <div class="col-sm-8">
                    <div class="input-group mb-3 with-padding">
                        <input type="text" id="y" name="y" value="0" class="form-control" placeholder="Number between -3 and 5" onchange="updateLabelY()"/>
                    </div>
                </div>
                <div class="col-sm-1 text-end">
                    <div class="with-padding">
                        <span id="valueY">0.0</span>
                    </div>
                </div>
                <div class="col-sm-2 text-center bg-theme">
                    <button type="button" class="btn btn-primary btn-sm" onclick="sendForm('${pageContext.request.contextPath}')">Check</button>
                </div>
            </div>
            <div class="row panel bg-theme">
                <div class="col-sm-1 text-end">
                    <label for="valR" class="form-label valigned" id="labelR">R</label>
                </div>
                <div class="col-sm-8">
                    <input type="hidden" name="valR" id="valR" value="0"/>
                    <button type="button" class="btn btn-primary" onclick="updateR(1)">1</button>
                    <button type="button" class="btn btn-primary" onclick="updateR(2)">2</button>
                    <button type="button" class="btn btn-primary" onclick="updateR(3)">3</button>
                    <button type="button" class="btn btn-primary" onclick="updateR(4)">4</button>
                    <button type="button" class="btn btn-primary" onclick="updateR(5)">5</button>
                </div>
                <div class="col-sm-1 text-end">
                    <span id="valueR">0</span>
                </div>
                <div class="col-sm-2 text-end bg-theme">
                    &nbsp;
                </div>
            </div>
            <div class="row panel bg-theme">
                <div class="col-sm-10">&nbsp;</div>
                <div class="col-sm-2 bg-theme">&nbsp;</div>
            </div>
            <div class="row bg-theme">
                <div class="col-sm-12">&nbsp;</div>
            </div>
            <div class="row bg-theme">
                <div class="col-sm-12">
                    <%--<button type="button" class="btn btn-primary btn-sm" onclick="reloadResults('${pageContext.request.contextPath}')">Reload</button>--%>
                    <button type="button" class="btn btn-primary btn-sm" onclick="clearResults('${pageContext.request.contextPath}')">Reset</button>
                </div>
            </div>
            <div class="row bg-theme">
                &nbsp;
            </div>
            <div class="row bg-theme">
                <div id="resultsTable">
                    <jsp:include page="result_table.jsp"/>
                </div>
            </div>
            <div class="row bg-theme">
                &nbsp;
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath}/scripts/graph.js"></script>
<script type="text/ecmascript">
    updateR(PARAMETER_R);
    PARAMETER_WEB_CONTEXT = '${pageContext.request.contextPath}';
</script>
</body>
</html>
