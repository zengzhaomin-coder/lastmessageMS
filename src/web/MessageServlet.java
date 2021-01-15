package web;

import dao.MessageDao;
import entity.MessageBean;
import util.FastJsonUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class MessageServlet extends HttpServlet {
    // 显示所有信息
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<MessageBean> messageBeans = new MessageDao().getMessages();
            resp.getWriter().write(FastJsonUtils.ok(messageBeans).toJSON());
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write(FastJsonUtils.err(222, e.getMessage()).toJSON());
        }
    }
}
