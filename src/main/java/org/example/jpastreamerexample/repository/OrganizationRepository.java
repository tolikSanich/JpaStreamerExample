package org.example.jpastreamerexample.repository;

import org.example.jpastreamerexample.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
}