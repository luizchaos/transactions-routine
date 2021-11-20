package org.lhtc.repository;

import org.lhtc.entity.OperationsTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTypesRepository  extends
        JpaRepository<OperationsTypes, Long>{
}
