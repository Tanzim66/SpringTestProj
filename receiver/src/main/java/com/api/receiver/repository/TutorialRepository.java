package com.api.receiver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.receiver.model.Tutorial;


// Repository interface extending JpaRepository
// Spring Data JPA will provide basic CRUD operations.

// JpaRepository<ObjectType, IDtype>
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	// jpaRepository provides the methods: save(), findOne(), findById(),
	// findAll(), count(), delete(), deleteById()… without implementing these methods.
	// Provides methods related to id
	
	// create custom finder methods:
	// the implementation of these methods are plugged in automatically by Spring Data JPA
	List<Tutorial> findByTitleContaining(String title);
	List<Tutorial> findByPublished(boolean published);
	
	//Custom queries:
	@Query("SELECT t FROM Tutorial t")
	@Override
	List<Tutorial> findAll();
}
