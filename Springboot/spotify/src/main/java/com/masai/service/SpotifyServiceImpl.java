package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.masai.exception.NotFoundException;
import com.masai.exception.SpotifyException;
import com.masai.model.Album;
import com.masai.model.Artist;
import com.masai.model.Playlist;
import com.masai.model.Song;
import com.masai.model.User;
import com.masai.repository.AlbumRepository;
import com.masai.repository.ArtistRepository;
import com.masai.repository.PlaylistRepository;
import com.masai.repository.SongRepository;
import com.masai.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class SpotifyServiceImpl implements SpotifyService{
	
	@Autowired
	private ArtistRepository artistrepo;
	
	@Autowired
	private AlbumRepository albumrepo;
	
	@Autowired
	private PlaylistRepository playlistrepo;
	
	@Autowired
	private SongRepository songrepo;
	
	@Autowired
	private UserRepository userrepo;

	@Override
	public Artist addNewArtist(Artist artist) {
		log.info("add artist started");
		if(artist==null) throw new SpotifyException("artist should not be null");
		Optional<Artist> a= artistrepo.findById(artist.getArtistId());
		if(a.isPresent()) {
			throw new SpotifyException("object already present");
		}
		return artistrepo.save(artist);
	}

	@Override
	public Album addNewAlbum(Album album) throws SpotifyException {
		log.info("add album started");
		if(album==null) throw new SpotifyException("album should not be null");
		Optional<Album> a= albumrepo.findById(album.getAlbumId());
		if(a.isPresent()) {
			throw new SpotifyException("object already present");
		}
		return albumrepo.save(album);
	}

	@Override
	public Playlist addNewPlaylist(Playlist playlist) throws SpotifyException {
		log.info("add playlist started");
		if(playlist==null) throw new SpotifyException("playlist should not be null");
		Optional<Playlist> a= playlistrepo.findById(playlist.getPlaylistId());
		if(a.isPresent()) {
			throw new SpotifyException("object already present");
		}
		return playlistrepo.save(playlist);
	}

	@Override
	public User addNewUser(User user) throws SpotifyException {
		log.info("add user started");
		if(user==null) throw new SpotifyException("user should not be null");
		Optional<User> a=userrepo.findById(user.getUserId());
		if(a.isPresent()) {
			throw new SpotifyException("object already present");
		}
		return userrepo.save(user);
	}

	@Override
	public Song addNewSong(Song song) throws SpotifyException {
		log.info("add song started");
		if(song==null) throw new SpotifyException("song should not be null");
		Optional<Song> a=songrepo.findById(song.getSongId());
		if(a.isPresent()) {
			throw new SpotifyException("object already present");
		}
		return songrepo.save(song);
	}

	@Override
	public Playlist addPlaylistByUserid(Playlist playlist, Integer userId) {
		log.info("add playlist by userid");
		if(playlist==null)throw new SpotifyException("playlist is null");
		User u= userrepo.findById(userId).orElseThrow(()-> new NotFoundException("user is not there"));
		u.getPlaylists().add(playlist);
		playlist.setUser(u);
		return playlistrepo.save(playlist);
	}

	@Override
	public Song addSongByPlaylistId(Song song, Integer playlistId) {
		log.info("add song by playlistid");
		if(song==null)throw new SpotifyException("song is null");
		Playlist p= playlistrepo.findById(playlistId).orElseThrow(()-> new NotFoundException("playlist is not there"));
		p.getSongs().add(song);
		song.setPlaylist(p);
		return songrepo.save(song);
	}

	@Override
	public Playlist updatePlaylist(Playlist playlist, Integer playlistId) {
		log.info("update playlist by playlistid");
		if(playlist==null)throw new SpotifyException("playlist is null");
		Playlist p= playlistrepo.findById(playlistId).orElseThrow(()-> new NotFoundException("playlist is not there"));
		p.setName(playlist.getName());
		p.setDescription(playlist.getDescription());
		p.setPrivacy(playlist.getPrivacy());
		return playlistrepo.save(p);
	}

	@Override
	public List<Playlist> userPlaylistHistory(Integer userId) {
		log.info("user playlist history started");
		User u= userrepo.findById(userId).orElseThrow(()-> new NotFoundException("user is not there"));
		return u.getPlaylists();
	}

	@Override
	public List<Song> recommandSongsByGenre(Integer userId,String genre) {
		log.info("recommand Songs By Genre");
		User u= userrepo.findById(userId).orElseThrow(()-> new NotFoundException("user is not there"));
		List<Playlist> p=u.getPlaylists();
		if(p.isEmpty()) {
			throw new NotFoundException("playlist is not there "+userId);
		}
		List<Song> list=songrepo.songsByGenre(genre);
		return list;
	}

	@Override
	public List<User> allUser(String field,String direction){
		return userrepo.findAll(direction.equals("asc")?Sort.by(field).ascending():Sort.by(field).descending());
		
	}
	
	

}
