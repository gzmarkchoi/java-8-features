package com.mci.commonerrors.nullvalue.pojonull;

import lombok.Data;

import java.util.Optional;

@Data
public class UserDto {
    private Long id;
    private Optional<String> name;
    private Optional<Integer> age;

    public UserDto(Long id, Optional<String> name, Optional<Integer> age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public Optional<String> getName() {
        return name;
    }

    public Optional<Integer> getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(Optional<String> name) {
        this.name = name;
    }

    public void setAge(Optional<Integer> age) {
        this.age = age;
    }
}
