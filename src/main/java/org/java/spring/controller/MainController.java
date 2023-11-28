package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.Movie;
import org.java.spring.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String firstPage(Model model) {
		String name = "Alex";
		
		model.addAttribute("name", name);
		
		return "first-page";
	}
	
	
	private List<Movie> getBestMovie() {
		
		List<Movie> movies = new ArrayList<>();
		
		Movie movie1 = new Movie(1, "Shutter Island");
		movies.add(movie1);
		
		Movie movie2 = new Movie(2, "Sherlock Holmes");
		movies.add(movie2);
		
		Movie movie3 = new Movie(3, "L'ultimo dominatore dell'aria");
		movies.add(movie3);
		
		return movies;	
	}
	
	private List<Song> getBestSongs() {
		
		List<Song> songs = new ArrayList<>();
		
		Song song1 = new Song(1, "Linking Park Numb");
		songs.add(song1);
		
		Song song2 = new Song(2, "Thousand Foot Krutch: Courtesy Call");
		songs.add(song2);
		
		Song song3 = new Song(3, "Thousand Foot Krutch: War of Change");
		songs.add(song3);
		
		return songs;
	}
	
	@GetMapping("/movies")
	public String moviesPage(Model model) {
		
		List<Movie> listMovies = getBestMovie();
		
		String movies = "";
		for(Movie movie: listMovies) {
			movies += movie.getTitle() + ", ";
		}
		
		model.addAttribute("movies", movies);
		
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String songsPage(Model model) {
		
		List<Song> listSongs = getBestSongs();
		
		String songs = "";
		for(Song song: listSongs) {
			songs += song.getTitle() + ", ";
		}
		
		model.addAttribute("songs", songs);
		
		return "songs";
	}
	
	@GetMapping("/movies/{id}")
	public String movieDetailPage(Model model, @PathVariable int id) {
		
		List<Movie> listMovies = getBestMovie();
		
		String movieIdTitle = null;
		for(Movie movie: listMovies) {
			if(movie.getId() == id) {
				movieIdTitle = movie.getTitle();
			}
		}
	
		model.addAttribute("movieTitle", movieIdTitle);
		model.addAttribute("id", id);
		return "movie-detail";
	}
	
	@GetMapping("/songs/{id}")
	public String songDetailPage(Model model, @PathVariable int id) {
		
		List<Song> listSongs = getBestSongs();
		
		String songIdTitle = null;
		for(Song song: listSongs) {
			if(song.getId() == id) {
				songIdTitle = song.getTitle();
			}
		}
	
		model.addAttribute("songTitle", songIdTitle);
		model.addAttribute("id", id);
		return "song-detail";
	}
	
	
}
