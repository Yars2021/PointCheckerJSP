package ru.itmo.p3214.s312198.web.model;

public class PointCheckerResponse {
    private Float x;
    private Float y;
    private Integer r;
    private Boolean result;
    private Integer errorCode;
    private String errorMessage;

    public PointCheckerResponse() {
    }

    public PointCheckerResponse(Float x, Float y, Integer r, Boolean result, Integer errorCode, String errorMessage) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.result = result;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
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

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
