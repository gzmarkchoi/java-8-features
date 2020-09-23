package com.mci.commonerrors.nullvalue.pojonull;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String nickname;
    private Integer age;
    private Date createDate = new Date();

    public User(Long id, String name, String nickname, Integer age, Date createDate) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getAge() {
        return age;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
