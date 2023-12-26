package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.masai.model.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer>,PagingAndSortingRepository<Album, Integer>{

}
