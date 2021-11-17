package ru.itmo.p3214.s312198.web.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.itmo.p3214.s312198.web.model.Point;
import ru.itmo.p3214.s312198.web.model.PointCheckerRequest;
import ru.itmo.p3214.s312198.web.model.PointCheckerResponseBuilder;
import ru.itmo.p3214.s312198.web.model.PointsData;
import ru.itmo.p3214.s312198.web.util.PointChecker;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class PointCheckerServlet extends HttpServlet {

    public final String PARAMETER_X = "x";
    public final String PARAMETER_Y = "y";
    public final String PARAMETER_R = "r";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PointCheckerResponseBuilder responseBuilder = new PointCheckerResponseBuilder();
        try {
            PointChecker pointChecker = new PointChecker();
            PointCheckerRequest pointCheckerRequest = pointChecker.validateInput(
                    req.getParameter(PARAMETER_X),
                    req.getParameter(PARAMETER_Y),
                    req.getParameter(PARAMETER_R)
            );

            // Check it the point hits the area
            Boolean result = pointChecker.checkPoint(pointCheckerRequest);

            // If the points Bean does not exist in the application context then create it
            ServletContext servletContext = req.getServletContext();
            if (servletContext.getAttribute(DispatcherServlet.ATTRIBUTE_RESULTS_BEAN) == null) {
                PointsData pointsData = new PointsData(req.getSession().getId());
                servletContext.setAttribute(DispatcherServlet.ATTRIBUTE_RESULTS_BEAN, pointsData);
            }

            // Put verified point to the points Bean in the application context
            PointsData points = (PointsData) servletContext.getAttribute(DispatcherServlet.ATTRIBUTE_RESULTS_BEAN);
            points.add(new Point(pointCheckerRequest.getX(), pointCheckerRequest.getY(), pointCheckerRequest.getR(), result, new Date()));

            responseBuilder = new PointCheckerResponseBuilder()
                    .addX(pointCheckerRequest.getX())
                    .addY(pointCheckerRequest.getY())
                    .addR(pointCheckerRequest.getR())
                    .addResult(result)
                    .addErrorCode(HttpServletResponse.SC_OK)
                    .addErrorMessage("OK");
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (NumberFormatException nfe) {
            responseBuilder.addErrorCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).addErrorMessage(nfe.getMessage());
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        resp.getWriter().append(gson.toJson(responseBuilder.build()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
