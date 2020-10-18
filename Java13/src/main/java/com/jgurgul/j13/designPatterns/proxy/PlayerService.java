package com.jgurgul.j13.designPatterns.proxy;


import com.jgurgul.j13.designPatterns.proxy.annotations.MyCustomTransaction;
import com.jgurgul.j13.designPatterns.proxy.annotations.TransactionalService;

import java.io.File;

@TransactionalService
public class PlayerService implements Playable, Seekable {
    @Override
    @MyCustomTransaction
    public String play(String filePath) {
        return this.play(new File(filePath));
    }

    @Override
    @MyCustomTransaction
    public String play(File song) {
        // Increment in DB number of plays for this song
        return "Playing song " + song.getName();
    }

    @Override
    @MyCustomTransaction
    public String play(File song, int start) {
        // Increment in DB number of plays for this song
        return "Playing song " + song.getName() + " starting at " + start;
    }

    @Override
    @MyCustomTransaction
    public String play(File song, int start, int finish) {
        // Increment in DB number of plays for this song
        return "Playing song " + song.getName() + " starting at " + start + " till " + finish;
    }

    @Override
    public String seekTo(int position) {
        return "Seek to " + position;
    }
}
