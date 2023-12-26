package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Song;

public interface SongRepository extends JpaRepository<Song, Integer>,PagingAndSortingRepository<Song, Integer>{
	
//	@Query("select s from Song s innerjoin Artist a on s.songId=a.artistId where a.genre=?1")
	@Query("select s from Song s")
	public List<Song> songsByGenre(String genre);

}
