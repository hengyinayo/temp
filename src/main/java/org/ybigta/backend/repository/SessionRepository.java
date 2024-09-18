package org.ybigta.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.ybigta.backend.domain.Session;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Double> {

    Optional<Session> findById(Long id);
}
