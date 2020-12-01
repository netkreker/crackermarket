package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PARAMETER")
public class Parameter extends BaseEntity {

    @Column(name = "NAME", unique = true)
    private String name;

    @Column(name = "PARAMETER_TYPE")
    private ParameterType parameterType;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public ParameterType getParameterType() {
        return parameterType;
    }

    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
    }

}
