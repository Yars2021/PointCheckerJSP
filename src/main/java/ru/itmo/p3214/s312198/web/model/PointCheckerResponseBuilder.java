package ru.itmo.p3214.s312198.web.model;

public class PointCheckerResponseBuilder {
    private PointCheckerResponse pointCheckerResponse = null;

    public PointCheckerResponseBuilder() {
        this.pointCheckerResponse = new PointCheckerResponse();
    }

    public PointCheckerResponseBuilder addX(Float x) {
        this.pointCheckerResponse.setX(x);
        return this;
    }

    public PointCheckerResponseBuilder addY(Float y) {
        this.pointCheckerResponse.setY(y);
        return this;
    }

    public PointCheckerResponseBuilder addR(Integer r) {
        this.pointCheckerResponse.setR(r);
        return this;
    }

    public PointCheckerResponseBuilder addResult(boolean result) {
        this.pointCheckerResponse.setResult(result);
        return this;
    }

    public PointCheckerResponseBuilder addErrorCode(Integer errorCode) {
        this.pointCheckerResponse.setErrorCode(errorCode);
        return this;
    }

    public PointCheckerResponseBuilder addErrorMessage(String errorMessage) {
        this.pointCheckerResponse.setErrorMessage(errorMessage);
        return this;
    }

    public PointCheckerResponse build() {
        return this.pointCheckerResponse;
    }
}
