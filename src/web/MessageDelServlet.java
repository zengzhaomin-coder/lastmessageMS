package web;

import dao.MessageDao;
import util.FastJsonUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class MessageDelServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mids = req.getParameter("mids");
        try {
            new MessageDao().delete(mids.split(","));
            resp.getWriter().write(FastJsonUtils.ok(1).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write(FastJsonUtils.err(2, e.getMessage()).toJSON());
        }
    }
}
