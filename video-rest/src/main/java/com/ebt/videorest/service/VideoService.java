/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ebt.videorest.service;

import com.ebt.common.Video;
import com.ebt.common.VideoCategory;
import com.ebt.videorest.model.VideoImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * Видео сервис.
 *
 * @author EastBanc Technologies (http://eastbanctech.ru/)
 */
public class VideoService {

    private LinkedList<Video> list = new LinkedList<>();

    public VideoService() {

        VideoImpl video = new VideoImpl();
        video.setTitle("Leo Messi scores a fantastic goal");
        video.setUrl("http://www.youtube.com/watch?v=3KLrasBtsCQ");
        video.setCategory(VideoCategory.SPORT);
        video.setRating(0.55);
        video.setSource("VIDEO-REST");
        list.add(video);

        video = new VideoImpl();
        video.setTitle("Linkin Park - Final Masquerade");
        video.setUrl("http://www.youtube.com/watch?v=i8q8fFs3kTM");
        video.setCategory(VideoCategory.MUSIC);
        video.setRating(0.73);
        video.setSource("VIDEO-REST");
        list.add(video);
    }


    public List<Video> list() {
        return list;
    }

}
