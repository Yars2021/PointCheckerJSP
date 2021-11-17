function updateLabelX() {
    $("#valueX").text($("input[type='radio'][name='x']:checked").val());
}

function updateLabelY() {
    $("#valueY").text($("#y").val());
}

function updateR(_r) {
    $("#valR").val(_r);
    $("#valueR").text(_r);
    PARAMETER_R = _r;
}

function isValidY(y) {
    if (!y.match(/^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$/)) {
        return false;
    } else {
        // Check range (-3..5)
        return !((y < -3) || (y > 5));
    }
}

function sendForm(src) {
    _x = $("input[type='radio'][name='x']:checked").val();
    _y = $("#y").val();
    _r = $("#valR").val();
    if (isValidY(_y)) {
        checkPoint(src, _x, _y, _r);
        drawDot(_x, _y, metrics, true);
    } else {
        $("#valueY").text("#");
        $("#y").val("Invalid input");
    }
}

function checkPoint(src, _x, _y, _r) {
    $.ajax({
        url: src,
        method: "POST",
        data: {
            "action": "check",
            "x": _x,
            "y": _y,
            "r": _r
        },
        success: function (result) {
            reloadResults(src);
        }
    });
}

function reloadResults(src) {
    $.ajax({
        url: src,
        method: "POST",
        data: {
            "action": "results"
        },
        success: function (result) {
            $("#resultsTable").html(result);
        }
    });
}

function clearResults(src) {
    document.location = src + '?action=clear';
}

function changeCSS(cssFile, cssLinkIndex) {

    var newlink = document.createElement("link");
    newlink.setAttribute("id", "theme-link")
    newlink.setAttribute("rel", "stylesheet");
    newlink.setAttribute("type", "text/css");
    newlink.setAttribute("href", cssFile);

    document.getElementById("theme-link").replaceWith(newlink)
}