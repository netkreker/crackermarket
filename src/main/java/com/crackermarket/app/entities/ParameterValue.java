package com.crackermarket.app.entities;

import com.crackermarket.app.core.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "PARAMETER_VALUE")
public class ParameterValue extends BaseEntity {
    @Column(name = "TYPE")
    private Object type;

}
