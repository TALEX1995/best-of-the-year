package org.java.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.Movie;
import org.java.spring.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
		
		Movie movie1 = new Movie("Shutter Island");
		movies.add(movie1);
		
		Movie movie2 = new Movie("Sherlock Holmes");
		movies.add(movie2);
		
		Movie movie3 = new Movie("L'ultimo dominatore dell'aria");
		movies.add(movie3);
		
		return movies;	
	}
	
	private List<Song> getBestSongs() {
		
		List<Song> songs = new ArrayList<>();
		
		Song song1 = new Song("Linking Park Numb");
		songs.add(song1);
		
		Song song2 = new Song("Thousand Foot Krutch: Courtesy Call");
		songs.add(song2);
		
		Song song3 = new Song("Thousand Foot Krutch: War of Change");
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
	
	
}
