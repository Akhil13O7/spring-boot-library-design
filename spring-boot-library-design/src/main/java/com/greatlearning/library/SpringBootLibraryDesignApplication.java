package com.greatlearning.library;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.serviceImpl.LibraryReadServiceImpl;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	@Autowired
	LibraryReadServiceImpl libraryReadServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("Spring boot library");
		System.out.println("Hello Dev-Tools");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Fetch all libraries ->{}", libraryReadServiceImpl.getallLibrary());
		log.info("Fetch all libraries with no books -> {}", libraryReadServiceImpl.getAllLibrariesWithNoBooks());
		log.info("Fetch libraries with page format -> {}",
				libraryReadServiceImpl.getLibrariesPaged().get().collect(Collectors.toList()));
		log.info("Fetch libraries in custom base format ->{}",
				libraryReadServiceImpl.getLibrariesCustomPaged(2, 2).get().collect(Collectors.toList()));
		log.info("Fetch Libraries with latest added order ->{}",
				libraryReadServiceImpl.getLibrariesWithLatestAddedOrder());
		log.info("Fetch Libraries custom sorted by id ->{}",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.DESC));
		log.info("Fetch libraries custom sorted by name ->{}",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.ASC));
		log.info("Fetch libraries default paged, sorted and with these books -> {}", libraryReadServiceImpl
				.getLibrariesPagedAndSortedByNameAndWithThereBooks("XYZ, ABC, EFG").get().collect(Collectors.toList()));
	}

}
