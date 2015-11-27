package com.ebt.videoapp.servlet;

import com.ebt.common.Video;
import com.ebt.videoapp.model.VideoImpl;
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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервлет, который получает список видео через защищенный REST ресурс.
 * После получения отображаем список.
 *
 * @author East Banc Technologies (http://eastbanctech.ru/)
 */
@WebServlet("/video-aggregate-list-servlet")
@DeclareRoles({"video-app-user", "video-rest-user"})
@ServletSecurity(@HttpConstraint(rolesAllowed = {"video-app-user", "video-rest-user"}))
public class VideoAggregateListServlet extends HttpServlet {

    @Inject
    private VideoService videoService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target("http://localhost:8080/video-rest/list");
        GenericType<List<VideoImpl>> listGenericType = new GenericType<List<VideoImpl>>() {
        };
        KeycloakSecurityContext ksc = (KeycloakSecurityContext) req.getAttribute(KeycloakSecurityContext.class.getName());
        List<VideoImpl> list = target.request().header("Authorization", "Bearer " + ksc.getTokenString()).get(listGenericType);

        // merge lists
        List<Video> mergeList = new ArrayList<>();
        mergeList.addAll(list);
        mergeList.addAll(videoService.list());

        req.setAttribute("list", mergeList);
        req.setAttribute("ksc", ksc);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(req, resp);
    }
}