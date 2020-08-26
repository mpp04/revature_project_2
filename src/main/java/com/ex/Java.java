package com.ex;

import com.ex.Frames.Albums;
import com.ex.Services.AlbumService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
