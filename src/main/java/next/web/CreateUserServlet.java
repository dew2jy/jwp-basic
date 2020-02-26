package next.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.db.DataBase;

@WebServlet("/user/create")
public class CreateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CreateUserServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = User.builder()
        		.userId(req.getParameter("userId"))
        		.password(req.getParameter("password"))
        		.name(req.getParameter("name"))
        		.email(req.getParameter("email"))
        		.build();
        log.debug("user : {}", user);
        DataBase.addUser(user);
        resp.sendRedirect("/user/list");
    }
}
