package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer artistId;
	@NotNull(message ="name should not be null")
	private String name;
	private String genre;
	
	@OneToMany(mappedBy = "artist",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Album> albumlist=new ArrayList<>();
	
	@OneToMany(mappedBy = "artist1",cascade = CascadeType.ALL)
	@JsonIgnore
	List<Song> songlist=new ArrayList<>();

}
//artistId, name, and genre