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
public class Aviso {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Column(name = "titulo", length = 200, nullable = false)
    private String titulo;

    @Column(name = "descricao", length = 200, nullable = false)
    private String descricao;

    @Column(name = "dtPublicacao", nullable = false)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtPublicacao;

    @Column(name = "dtVisualizacao", nullable = true)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dtVisualizacao;
}