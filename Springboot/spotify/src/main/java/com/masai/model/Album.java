package com.masai.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer albumId;
	@NotNull(message ="name should not be null")
	private String name;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate releasedate;
	
	@ManyToOne
	Artist artist;
	
	@OneToMany(mappedBy = "album",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Song> songs=new ArrayList<>();

}
//albumId, name, artistId, and release date.