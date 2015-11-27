package com.ebt.videorest.rest;

import com.ebt.common.Video;
import com.ebt.videorest.service.VideoService;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * REST сервис.
 *
 * @author East Banc Technologies (http://eastbanctech.ru/)
 */
@Path("/")
@Produces("application/json")
@Stateless
public class VideoRest {

    @Inject
    private VideoService videoService;

    @GET
    @Path("/list")
    @RolesAllowed("video-rest-user")
    public List<Video> get() {
        return videoService.list();
    }
}
