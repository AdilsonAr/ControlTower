package com.controltower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.controltower.model.OperationPermission;

@Repository
public interface OperationPermissionRepository extends JpaRepository<OperationPermission, Integer> {

}
