package org.core.repositories;

import org.core.DAO.TransactionDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository()
public interface TransactionRepository extends JpaRepository<TransactionDAO, Long> {
}
