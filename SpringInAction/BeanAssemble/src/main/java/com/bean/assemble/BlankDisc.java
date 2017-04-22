package com.bean.assemble;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by zhuxinquan on 17-4-15.
 */
public class BlankDisc {
    String title;
    String artist;
    public BlankDisc(
            @Value("#{systemProperties['disc.title']}") String title,
            @Value("#{systemProperties['disc.artist']}") String artist
    ){
        this.title = title;
        this.artist = artist;
    }

    public BlankDisc() {
    }


    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    @Override
    public String toString() {
        return "BlankDisc{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
