package com.phone.book;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.phone.book.DataNotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PhoneBookService {

private final PhoneBookRepository phoneBookRepository;

public List<Usersinfo> getList(){
	return this.phoneBookRepository.findAll();
}
public Usersinfo getUsersinfo(Integer id) {
	Optional<Usersinfo> usersinfo = this.phoneBookRepository.findById(id);
	if (usersinfo.isPresent())
		return usersinfo.get();
	else
		throw new DataNotFoundException("usersinfo not found");
}
	
}
