package de.muenchen.aigner.math_tool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NumberRepository extends JpaRepository<Number, Long> {
    List<Number> findByIsPrimTrue(); // für GET /numbers?isPrim=true
}

