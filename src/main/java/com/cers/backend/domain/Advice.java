package com.cers.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Advice {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(name = "title", length = 200, nullable = false)
    private String title;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @Column(name = "dtPublication", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtPublication;

    @Column(name = "dtVisualization", nullable = true)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtVisualization;
}