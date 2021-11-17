package ru.itmo.p3214.s312198.web.servlet;

import ru.itmo.p3214.s312198.web.model.PointsData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DispatcherServlet extends HttpServlet {
    public static final String ACTION_PARAMETER_NAME = "action";
    public static final String ACTION_CHECK = "check";
    public static final String ACTION_RESULTS = "results";
    public static final String ACTION_CLEAR = "clear";

    private static final String URL_INDEX_JSP = "app";
    private static final String URL_CHECK = "check";
    private static final String URL_RESULTS = "results";

    public static final String ATTRIBUTE_RESULTS_BEAN = "points";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(ACTION_PARAMETER_NAME);
        ServletContext servletContext = req.getServletContext();
        if (servletContext.getAttribute(ATTRIBUTE_RESULTS_BEAN) == null) {
            PointsData pointsData = new PointsData(req.getSession().getId());
            servletContext.setAttribute(ATTRIBUTE_RESULTS_BEAN, pointsData);
        }

        String forwardTo = URL_INDEX_JSP;
        if (ACTION_CHECK.equals(action)) {
            forwardTo = URL_CHECK;
        } else if (ACTION_RESULTS.equals(action)) {
            forwardTo = URL_RESULTS;
        } else if (ACTION_CLEAR.equals(action)) {
            PointsData points = (PointsData)servletContext.getAttribute(ATTRIBUTE_RESULTS_BEAN);
            points.clear();
            resp.sendRedirect(getServletContext().getContextPath());
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forwardTo);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
