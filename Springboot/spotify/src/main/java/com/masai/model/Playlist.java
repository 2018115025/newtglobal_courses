package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Playlist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer playlistId;
	@NotNull(message = "name should not be null")
	private String name;
	@NotNull(message = "desc should not be null")
	private String description;
	@Enumerated(EnumType.STRING)
	private Privacy privacy;
	
	@ManyToOne
	User user;
	
	@OneToMany(mappedBy = "playlist",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Song> songs=new ArrayList<>();

}
//playlistId, userId, name, description, privacy (public/private), and songs (a list of songIds).