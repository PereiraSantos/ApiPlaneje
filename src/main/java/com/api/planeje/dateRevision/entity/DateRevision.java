package com.api.planeje.dateRevision.entity;

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
@Table(name = "date_revision")
public class DateRevision {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String date;
    @Column(name = "id_revision")
    private Integer idRevision;




}
