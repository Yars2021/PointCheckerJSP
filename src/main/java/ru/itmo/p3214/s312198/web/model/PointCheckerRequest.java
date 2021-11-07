package ru.itmo.p3214.s312198.web.model;

public class PointCheckerRequest {
    private Integer x;
    private Float y;
    private Integer r;

    public PointCheckerRequest() {
    }

    public PointCheckerRequest(Integer x, Float y, Integer r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
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
