package ru.itmo.p3214.s312198.web.model;

public class PointCheckerResponse {
    private Integer x;
    private Float y;
    private Integer r;
    private Integer exitCode;
    private String exitMsg;

    public PointCheckerResponse() {
    }

    public PointCheckerResponse(Integer x, Float y, Integer r, Integer exitCode, String exitMsg) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.exitCode = exitCode;
        this.exitMsg = exitMsg;
    }

    public PointCheckerResponse(PointCheckerRequest request) {
        this(request.getX(), request.getY(), request.getR(), 0, "");
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

    public Integer getExitCode() {
        return exitCode;
    }

    public void setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
    }

    public String getExitMsg() {
        return exitMsg;
    }

    public void setExitMsg(String exitMsg) {
        this.exitMsg = exitMsg;
    }
}
