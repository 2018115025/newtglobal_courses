package com.masai.service;

import java.util.List;

import com.masai.exception.SpotifyException;
import com.masai.model.Album;
import com.masai.model.Artist;
import com.masai.model.Playlist;
import com.masai.model.Song;
import com.masai.model.User;

public interface SpotifyService {
	public Artist addNewArtist(Artist artist) throws SpotifyException;
	
	public Album addNewAlbum(Album album) throws SpotifyException;
	
	public Playlist addNewPlaylist(Playlist playlist) throws SpotifyException;
	
	public User addNewUser(User user) throws SpotifyException;
	
	public Song addNewSong(Song song) throws SpotifyException;
	
	public Playlist addPlaylistByUserid(Playlist playlist,Integer userId);
	
	public Song addSongByPlaylistId(Song song,Integer playlistId);
	
	public Playlist updatePlaylist(Playlist playlist,Integer playlistId);
	
	public List<Playlist> userPlaylistHistory(Integer userId);
	
	public List<Song> recommandSongsByGenre(Integer userId,String genre);
	
	public List<User> allUser(String field,String direction);
 
}
