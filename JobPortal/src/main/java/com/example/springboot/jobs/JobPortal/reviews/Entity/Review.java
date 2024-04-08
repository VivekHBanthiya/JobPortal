package com.example.springboot.jobs.JobPortal.reviews.Entity;

import com.example.springboot.jobs.JobPortal.Company.Entity.Company;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String tittle;
    private String description;
    private double rating;

    @JsonIgnore
    @ManyToOne
    private Company company;
}
