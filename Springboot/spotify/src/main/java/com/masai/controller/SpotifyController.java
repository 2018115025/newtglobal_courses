package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Album;
import com.masai.model.Artist;
import com.masai.model.Playlist;
import com.masai.model.Song;
import com.masai.model.User;
import com.masai.service.SpotifyService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class SpotifyController {
	
	@Autowired
	private SpotifyService artistservice;
	
	@PostMapping("/Artist")
	public ResponseEntity<Artist> addNewArtistHandler(@Valid @RequestBody Artist artist){
		Artist a=artistservice.addNewArtist(artist);
		return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/Album")
	public ResponseEntity<Album> addNewAlbumHandler(@RequestBody Album album){
		Album a=artistservice.addNewAlbum(album);
		return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/Playlist")
	public ResponseEntity<Playlist> addNewPlaylistHandler(@RequestBody Playlist playlist){
		Playlist a=artistservice.addNewPlaylist(playlist);
		return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/User")
	public ResponseEntity<User> addNewUserHandler(@RequestBody User user){
		User a=artistservice.addNewUser(user);
		return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/Song")
	public ResponseEntity<Song> addNewSongHandler(@RequestBody Song song){
		Song a=artistservice.addNewSong(song);
		return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/Playlist/{userId}")
	public ResponseEntity<Playlist> addNewPlaylistHandler(@RequestBody Playlist playlist,@PathVariable Integer userId){
		Playlist a=artistservice.addPlaylistByUserid(playlist, userId);
		return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/Song/{playlistId}")
	public ResponseEntity<Song> addNewSongHandler(@RequestBody Song song,@PathVariable Integer playlistId){
		Song a=artistservice.addSongByPlaylistId(song, playlistId);
		return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/Playlist/{playlistId}")
	public ResponseEntity<Playlist> updatePlaylistHandler(@RequestBody Playlist playlist,@PathVariable Integer playlistId){
		Playlist a=artistservice.updatePlaylist(playlist, playlistId);
		return new ResponseEntity<>(a,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("User/{userId}")
	public ResponseEntity<List<Playlist>> userPlaylisthistoryHandler(@PathVariable Integer userId){
		List<Playlist> a=artistservice.userPlaylistHistory(userId);
		return new ResponseEntity<>(a,HttpStatus.OK);
	}
	
	@GetMapping("User/{userId}/{genre}")
	public ResponseEntity<List<Song>> recommandSongsForUserHandler(@PathVariable Integer userId,@PathVariable String genre){
		List<Song> a=artistservice.recommandSongsByGenre(userId, genre);
		return new ResponseEntity<>(a,HttpStatus.OK);
	}
	
	@GetMapping("users/{field}/{direction}")
	public ResponseEntity<List<User>> userallHandler(@PathVariable String field,@PathVariable String direction){
		List<User> a=artistservice.allUser(field, direction);
		return new ResponseEntity<>(a,HttpStatus.OK);
	}
	
}
