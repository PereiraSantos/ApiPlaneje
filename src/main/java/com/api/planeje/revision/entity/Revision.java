package com.api.planeje.revision.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "revision")
public class Revision {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String title;

    private String description;

    @Column(name = "date_creational")
    private String dateCreational;

    @Column(name = "id_revision_theme")
    private Integer idRevisionTheme;
}
