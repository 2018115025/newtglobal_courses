package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer>,PagingAndSortingRepository<Playlist, Integer>{

}
