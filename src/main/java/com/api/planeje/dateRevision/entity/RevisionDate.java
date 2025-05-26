package com.api.planeje.dateRevision.entity;

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
@Table(name = "revision_date")
public class RevisionDate {

    @Id
    private Integer id;

    @Column(name = "date_revision")
    private String dateRevision;
    
    @Column(name = "id_revision")
    private Integer idRevision;

    private Integer disable;
}
