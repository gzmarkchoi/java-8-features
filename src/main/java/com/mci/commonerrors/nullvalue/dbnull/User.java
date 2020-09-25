package com.mci.commonerrors.nullvalue.dbnull;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long score;

    public User(Long id, Long score) {
        this.id = id;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public Long getScore() {
        return score;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
