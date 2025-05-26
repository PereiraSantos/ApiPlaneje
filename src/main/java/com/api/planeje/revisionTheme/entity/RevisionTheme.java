package com.api.planeje.revisionTheme.entity;

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
@Table(name = "revision_theme")
public class RevisionTheme {
    
    @Id
    private Integer id;

    private String description;

    private Integer disable;
}
