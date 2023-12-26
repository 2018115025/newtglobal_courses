package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Artist;

public interface ArtistRepository extends JpaRepository<Artist, Integer>,PagingAndSortingRepository<Artist, Integer>{

}
