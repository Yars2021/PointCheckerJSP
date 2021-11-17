package ru.itmo.p3214.s312198.web.util;

import ru.itmo.p3214.s312198.web.model.PointCheckerRequest;

public class PointChecker {
    public PointCheckerRequest validateInput(String x, String y, String r) {
        try {
            Float xValue = Float.parseFloat(x);
            Float yValue = Float.parseFloat(y);
            Integer rValue = Integer.parseInt(r);
            return new PointCheckerRequest(xValue, yValue, rValue);
        } catch (NumberFormatException numberFormatException) {
            return new PointCheckerRequest(-999999f, -999999f, -999999);
        }
    }

    public Boolean checkPoint(PointCheckerRequest pointCheckerRequest) {
        Float x = pointCheckerRequest.getX(), y = pointCheckerRequest.getY();
        Integer r = pointCheckerRequest.getR();
        float hr = (float) r / 2;
        return (x >= 0 && y >= 0 && x <= hr && y <= r && (x + y) < r)
                || (x < 0 && y > 0 && x >= -r && y <= r)
                || (x > 0 && y < 0 && (x * x + y * y <= hr * hr));
    }
}
