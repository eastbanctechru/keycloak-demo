package com.ebt.videoapp.service;

import com.ebt.common.Video;
import com.ebt.common.VideoCategory;
import com.ebt.videoapp.model.VideoImpl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Сервис для управления объектами Видео.
 *
 * @author East Banc Technologies (http://eastbanctech.ru/)
 */
public class VideoService {

    private List<Video> list = new LinkedList<>();

    public VideoService() {

        VideoImpl video = new VideoImpl();
        video.setTitle("Красная Феррари");
        video.setUrl("http://www.youtube.com/watch?v=YJDz2-tT8b4");
        video.setCategory(VideoCategory.CARS);
        video.setRating(0.75);
        video.setSource("VIDEO-APP");
        list.add(video);

        video = new VideoImpl();
        video.setTitle("Lamborghini Aventador LP700-4");
        video.setUrl("http://www.youtube.com/watch?v=ujn7jEQ4ib4");
        video.setCategory(VideoCategory.CARS);
        video.setRating(0.65);
        video.setSource("VIDEO-APP");
        list.add(video);

        video = new VideoImpl();
        video.setTitle("Lady Gaga - Bad Romance");
        video.setUrl("http://www.youtube.com/watch?v=qrO4YZeyl0I");
        video.setCategory(VideoCategory.MUSIC);
        video.setRating(0.89);
        video.setSource("VIDEO-APP");
        list.add(video);

        video = new VideoImpl();
        video.setTitle("Shakira - La La La");
        video.setUrl("http://www.youtube.com/watch?v=7-7knsP2n5w");
        video.setCategory(VideoCategory.MUSIC);
        video.setRating(0.88);
        video.setSource("VIDEO-APP");
        list.add(video);

        video = new VideoImpl();
        video.setTitle("Zlatan Ibrahimovic Goals & Skills");
        video.setUrl("http://www.youtube.com/watch?v=ijAuwXZnxXc");
        video.setCategory(VideoCategory.SPORT);
        video.setRating(0.74);
        video.setSource("VIDEO-APP");
        list.add(video);

        video = new VideoImpl();
        video.setTitle("Goodbye Steven Gerrard - You're Irreplaceable");
        video.setUrl("http://www.youtube.com/watch?v=bADTiAUWygA");
        video.setCategory(VideoCategory.SPORT);
        video.setRating(0.90);
        video.setSource("VIDEO-APP");
        list.add(video);

        Collections.sort(list, (o1, o2) -> Double.compare(o1.getRating(), o2.getRating()));

    }

    public List<Video> list() {
        return list;
    }
}
