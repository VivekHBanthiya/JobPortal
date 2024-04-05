package com.example.springboot.jobs.JobPortal.Company.Entity;

import com.example.springboot.jobs.JobPortal.jobs.Entity.Jobs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    private String companyDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Jobs> jobs;
    // private List<Reviews> reviews;
}
