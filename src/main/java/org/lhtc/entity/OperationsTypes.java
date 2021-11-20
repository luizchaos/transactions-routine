package org.lhtc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OperationsTypes {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long operationTypeId;

    @Column(name="description", nullable=false, unique=true)
    private String description;

    public Long getOperationTypeId() {
        return operationTypeId;
    }

    public void setOperationTypeId(Long operationTypeId) {
        this.operationTypeId = operationTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OperationsTypes(Long operationTypeId, String description) {
        this.operationTypeId = operationTypeId;
        this.description = description;
    }

    public OperationsTypes() {
    }
}
