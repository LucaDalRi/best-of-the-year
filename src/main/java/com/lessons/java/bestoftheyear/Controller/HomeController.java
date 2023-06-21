package com.lessons.java.bestoftheyear.Controller;

import com.lessons.java.bestoftheyear.model.Movie;
import com.lessons.java.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        model.addAttribute("movie", getBestMovie());
        return "movie";
    }

    @GetMapping("movie/{id}")
    public String movieDetail(@PathVariable String id, Model model) {
        Movie currentMovie = null;
        for (Movie movie : getBestMovie()) {
            if (Objects.equals(movie.getId(), id)) {
                currentMovie = movie;
            }
        }
        model.addAttribute("movie", currentMovie);
        return "movieDetails";
    }


    @GetMapping("/song")
    public String song(Model model) {
        model.addAttribute("song", getBestSong());
        return "song";
    }

    @GetMapping("song/{id}")
    public String songDetail(@PathVariable String id, Model model) {
        Song currentSong = null;
        for (Song song : getBestSong()) {
            if (Objects.equals(song.getId(), id)) {
                currentSong = song;
            }
        }
        model.addAttribute("song", currentSong);
        return "songDetails";
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

//    private String listToStringMovie(List<Movie> list) {
//        String listString = "";
//        for (int i = 0; i < list.size(); i++) {
//            listString += list.get(i).getTitolo() + ", ";
//        }
//        return listString;
//    }
//
//    private String listToStringSong(List<Song> list) {
//        String listString = "";
//        for (int i = 0; i < list.size(); i++) {
//            listString += list.get(i).getTitolo() + ", ";
//        }
//        return listString;
//    }

}
