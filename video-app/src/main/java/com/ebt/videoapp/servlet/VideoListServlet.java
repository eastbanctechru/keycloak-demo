package com.ebt.videoapp.servlet;

import com.ebt.videoapp.service.VideoService;
import org.keycloak.KeycloakSecurityContext;

import javax.annotation.security.DeclareRoles;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет показывает список видео, используя в качестве данных внутренний сервис.
 *
 * @author East Banc Technologies (http://eastbanctech.ru/)
 */
@WebServlet("/video-list-servlet")
@DeclareRoles("video-app-user")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"video-app-user"}))
public class VideoListServlet extends HttpServlet {

    @Inject
    private VideoService videoService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        KeycloakSecurityContext ksc = (KeycloakSecurityContext) req.getAttribute(KeycloakSecurityContext.class.getName());

        req.setAttribute("list", videoService.list());
        req.setAttribute("ksc", ksc);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
    }
}
