package ru.itmo.p3214.s312198.web.model;

public class PointCheckerRequest {
    private Float x;
    private Float y;
    private Integer r;

    public PointCheckerRequest() {
    }

    public PointCheckerRequest(Float x, Float y, Integer r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }
}
