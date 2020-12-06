package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PARAMETER")
public class Parameter extends BaseEntity {
    @Column(name = "PARAMETER_TYPE")
    @Enumerated(EnumType.STRING)
    private ParameterType parameterType;

    public ParameterType getParameterType() {
        return parameterType;
    }

    public void setParameterType(ParameterType parameterType) {
        this.parameterType = parameterType;
    }
}