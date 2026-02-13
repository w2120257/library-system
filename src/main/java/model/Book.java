package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity // Tells Spring Boot to make a table out of this class
@Data   // Lombok: auto-generates Getters, Setters, and toString
public class Book {

    @Id // The Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    private String title;
    private String author;
    private String isbn;
    private int totalCopies;
    private int availableCopies;
}