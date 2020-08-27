package com.ex.web;

import com.ex.web.models.Albums;
import com.ex.web.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Main {
    AlbumService albumService;

    @Autowired
    public Main(AlbumService albumService) {
        this.albumService = albumService;
    }

    public static void main(String[] args) {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("application-context.xml");
        Main m = ac.getBean("main", Main.class);
        List<Albums> cards =  m.albumService.getAllAlbums();
        for(Albums a : cards) {
            System.out.println(a);
        }
        ac.close();
    }
}
