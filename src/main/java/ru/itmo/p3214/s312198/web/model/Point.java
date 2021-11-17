package ru.itmo.p3214.s312198.web.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Point implements Serializable {
    private Float x;
    private Float y;
    private Integer r;
    private Boolean hit;
    private Date date;

    private Point() {
    }

    public Point(Float x, Float y, Integer r, Boolean hit, Date date) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.date = date;
    }

    public float getX() {
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

    public Boolean getHit() {
        return hit;
    }

    public void setHit(Boolean hit) {
        this.hit = hit;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDateAsString() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return dateFormatter.format(this.date);
    }
}
