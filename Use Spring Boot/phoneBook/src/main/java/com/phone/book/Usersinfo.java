package com.phone.book;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Usersinfo {

	@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
	
	@Column(length = 20)
private String phonename;

	@Column(length = 15)
private String phonenum;

	@Column(length = 100)
private String phoneadress;
	
}
