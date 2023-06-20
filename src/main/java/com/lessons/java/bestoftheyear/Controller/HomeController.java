package com.lessons.java.bestoftheyear.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("name", "Luca Dal Rì");
        return "index";
    }

    @GetMapping("/movie")
    public String movie(Model model) {
        model.addAttribute("movie", listToStringMovie(getBestMovie()));
        return "movie";
    }

    @GetMapping("/song")
    public String song(Model model) {
        model.addAttribute("song", listToStringSong(getBestSong()));
        return "song";
    }


    public List<Movie> getBestMovie() {
        List<Movie> movie = new ArrayList<>();
        movie.add(new Movie("Film 1", "101"));
        movie.add(new Movie("Film 2", "102"));
        movie.add(new Movie("Film 3", "103"));
        movie.add(new Movie("Film 4", "104"));
        return movie;
    }

    public List<Song> getBestSong() {
        List<Song> song = new ArrayList<>();
        song.add(new Song("Song 1", "101"));
        song.add(new Song("Song 2", "102"));
        song.add(new Song("Song 3", "103"));
        song.add(new Song("Song 4", "104"));
        return song;
    }

    private String listToStringMovie(List<Movie> list) {
        String listString = "";
        for (int i = 0; i < list.size(); i++) {
            listString += list.get(i).getTitolo() + ", ";
        }
        return listString;
    }

    private String listToStringSong(List<Song> list) {
        String listString = "";
        for (int i = 0; i < list.size(); i++) {
            listString += list.get(i).getTitolo() + ", ";
        }
        return listString;
    }

}
