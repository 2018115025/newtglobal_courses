package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer songId;
	@NotNull(message = "name should not be null")
	private String name;
	@Min(value = 0)
	private Integer duration;
	
	@ManyToOne
	Album album;
	
	@ManyToOne
	Artist artist1;
	
	@ManyToOne
	Playlist playlist;

}
//songId, name, artistId, albumId, and duration.