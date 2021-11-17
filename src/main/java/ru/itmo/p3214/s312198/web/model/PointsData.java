package ru.itmo.p3214.s312198.web.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PointsData implements Serializable {
    private String sessionId;
    private final ConcurrentHashMap<String, Point> points = new ConcurrentHashMap<>();

    public PointsData(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void clear() {
        this.points.clear();
    }

    public Boolean add(Point point) {
        if (point == null) {
            return Boolean.FALSE;
        } else {
            if (point.getDate() == null) {
                point.setDate(new Date());
            }
            this.points.put(UUID.randomUUID().toString(), point);
            return Boolean.TRUE;
        }
    }

    public List<Point> getAll() {
        ArrayList <Point> list = new ArrayList<>(this.points.values());
        list.sort(Comparator.comparing(Point::getDate).reversed());
        return list;
    }
}
