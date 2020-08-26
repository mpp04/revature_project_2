package com.ex.Services;

import com.ex.Frames.Albums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;


public class Java {
    AlbumService albumService;


    public Java(AlbumService albumService) {
        this.albumService = albumService;
    }

    public static void main(String[] args) {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("WEB-INF/application-context.xml");
        Java m = ac.getBean("java", Java.class);
        List<Albums> foundAlbums= m.albumService.getAllAlbums();
        System.out.println(foundAlbums.get(0).getAlbum_Id());
        ac.close();
    }
}
