package com.api.planeje.annotation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "annotation")
public class Annotation {

    @Id
    private Integer id;

    private String title;

    private String text;

    @Column(name = "date_text")
    private String dateText;
    
    @Column(name = "id_revision")
    private Integer idRevision;

    private Integer disable;
}
