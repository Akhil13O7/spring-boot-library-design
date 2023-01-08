package com.greatlearning.library.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.library.entity.Library;
import com.greatlearning.library.repository.LibraryRepository;

@Service
public class LibraryReadServiceImpl {

	@Autowired
	LibraryRepository readRepsitory;

	public List<Library> getallLibrary() {
		return readRepsitory.findAll();
	}

	public List<Library> getAllLibrariesWithNoBooks() {

		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSeperatedBooknames("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);
		return readRepsitory.findAll(example);
	}

	public Page<Library> getLibrariesPaged() {
		Pageable first3records = PageRequest.of(1, 3);
		return readRepsitory.findAll(first3records);
	}

	public Page<Library> getLibrariesCustomPaged(int pageNumber, int numberOfRecordsOnAPage) {
		Pageable first3records = PageRequest.of(pageNumber, numberOfRecordsOnAPage);
		return readRepsitory.findAll(first3records);
	}

	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readRepsitory.findAll(Sort.by(Direction.DESC, "id"));
	}

	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readRepsitory.findAll(Sort.by(direction, "id"));
	}

	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readRepsitory.findAll(Sort.by(direction, "name"));
	}

	public Page<Library> getLibrariesPagedAndSortedByNameAndWithThereBooks(String commaSeperatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeperatedBooknames(commaSeperatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeperatedBooknames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable first3records = PageRequest.of(0, 2, Sort.by("name"));
		return readRepsitory.findAll(example, first3records);
	}

}
