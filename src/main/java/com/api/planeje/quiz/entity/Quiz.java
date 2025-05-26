package com.api.planeje.quiz.entity;

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
@Table(name = "quiz")
public class Quiz {

    @Id
    private Integer id;

    private String topic;
    
    private String description;

    private Integer disable;
}
