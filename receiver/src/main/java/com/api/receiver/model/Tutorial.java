package com.api.receiver.model;

import jakarta.persistence.*;

// indicates the class is persistent java class
@Entity
// provides the table that maps the entity
@Table(name = "tutorials")
public class Tutorial {

	// annotation for the primary key of the table
	@Id
	// annotation used to define the generation strategy for the primary key
	// GenerationType.AUTO means Auto increment field
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	// annotates the definition of the column in database
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "published")
	private boolean published;
	
	// Constructors, Getters, and Setters
	public Tutorial() {}
	
	public Tutorial(String title, String description, boolean published) {
		this.title = title;
		this.description = description;
		this.published = published;
	}
	
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
    
}
